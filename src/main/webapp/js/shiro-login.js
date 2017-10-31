$(function () {

    //提交按钮
    $("#login").click(function () {

        try{

            $.ajax({
                url: '/login/submit',
                type: 'post',
                contentType: 'application/json;charset=utf-8',
                success: function (ret) {
                    alert("登录成功")
                },
                error: function (e) {

                }

            });
        }catch (ex){
        }finally {
        }

    });

    //提交按钮
    $("#logout").click(function () {

        try{

            $.ajax({
                url: '/logout',
                type: 'post',
                contentType: 'application/json;charset=utf-8',
                success: function (ret) {
                    alert("登出成功")
                },
                error: function (e) {

                }

            });
        }catch (ex){
        }finally {
        }

    });

});