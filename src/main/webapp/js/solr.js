$(function () {

    var $add_form = $("#add_form");
    var $query_form = $("#query_form");
    var $submit_btn = $("#submit_btn");
    var $search_btn = $("#search_btn");
    var $model = $("#myModal");

    $.extend(true, $.fn.DataTable.defaults, {
        language: {
            "url": "/lang/Chinese.txt"
        },
        serverSide: true,
        processing: true,
        paging: true,
        ordering: true,
        searching: false,
        lengthChange: false,
        pageLength: 15
    });

    var $solrTable = $("#solrTable").DataTable({
        ajax: {
            url : "/solr/query",
            type : "post",
            data : function (param) {
                param.kw = $("#kw").val();
            }
        },
        columns: [
            {
                data: 'id', class: 'center', render: function (value, type, row) {
                return value;
            }
            },
            {
                data: 'title', class: 'center', render: function (value, type, row) {
                return value.join(",");
            }
            },
            {data: 'comments', class: 'center'}
        ]
    });

    //搜索按钮
    $search_btn.click(function () {
        if ($search_btn[0].isDisabled) {
            return false;
        }

        $search_btn.attr({"disabled": true});

        try{
            $solrTable.ajax.reload();
        }catch (ex){
            $model.alert('错误' , "出现异常");
            console.log(ex)
        }finally {
            $search_btn.removeAttr("disabled");
        }
    });

    $model.alert = function (title , content) {
        $("#myModalLabel").text(title);
        $model.find(".modal-body").text(content);
        $model.modal("show");
    };

    //提交按钮
    $submit_btn.click(function () {
        if ($submit_btn[0].isDisabled) {
            return false;
        }

        $submit_btn.attr({"disabled": true});

        try{

            $.ajax({
                url: '/solr/add',
                type: 'post',
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify({
                    title : $("#title").val().split(","),
                    comments : $("#comments").val()
                }),
                dataType: 'json',
                success: function (ret) {
                    if (ret.code == 0) {
                        $model.alert('成功' , "新增成功");
                        $("#title").val('');
                        $("#comments").val('');
                    }
                },
                error: function (e) {
                    $model.alert('错误' , e.statusText);
                }

            });
        }catch (ex){
            $model.alert('错误' , "出现异常");
        }finally {
            $submit_btn.removeAttr("disabled");
        }

    });

});