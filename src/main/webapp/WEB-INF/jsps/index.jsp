<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>solr - index</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/jquery.dataTables.min.css"/>
    <link rel="stylesheet" href="/css/table.css"/>

    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/jquery.dataTables.min.js"></script>

    <script type="text/javascript" src="/js/solr.js"></script>

</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="page-header">
            <div class="col-lg-offset-2">
                <h1> Solr 搜索测试 <small>&nbsp;&nbsp;新增数据&nbsp;&nbsp;&&nbsp;&nbsp;数据检索&nbsp;&nbsp;</small></h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
            <div class="panel panel-primary">
                <div class="panel-heading">新增数据</div>
                <div class="panel-body">
                    <form id="add_form" class="form-group-lg">
                        <div class="form-group">
                            <label for="title">Title</label>
                            <input type="text" id="title" name="title" class="form-control" placeholder="title">
                        </div>
                        <div class="form-group">
                            <label for="comments">Comments</label>
                            <textarea name="comments" id="comments" class="form-control" placeholder="comments"></textarea>
                        </div>
                        <button type="button" id="submit_btn" class="btn btn-primary btn-lg">&nbsp;&nbsp;&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;&nbsp;&nbsp;</button>
                        <button type="reset" class="btn btn-default btn-lg">&nbsp;&nbsp;&nbsp;&nbsp;清&nbsp;&nbsp;除&nbsp;&nbsp;&nbsp;&nbsp;</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
            <div class="panel panel-primary">
                <div class="panel-heading">数据查询</div>
                <div class="panel-body">
                    <form id="query_form" class="navbar-form navbar-right form-group-lg" role="search">
                        <div class="form-group">
                            <input type="text" id="kw" name="kw" class="form-control" placeholder="关键字">
                        </div>
                        <button type="button" id="search_btn" class="btn btn-primary btn-lg">&nbsp;&nbsp;&nbsp;&nbsp;搜&nbsp;&nbsp;索&nbsp;&nbsp;&nbsp;&nbsp;</button>
                    </form>
                </div>
                <table id="solrTable" class="table">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>title</th>
                        <th>comments</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>

    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <!--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>-->
                <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
