<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" href="resources/css/bootstrap-yeti.min.css"/>
    <%--<link rel="stylesheet" href="resources/css/components.min.css"/>--%>
    <link rel="stylesheet" href="resources/css/jquery-ui.css"/>
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/bootstrap-datetimepicker.css">
    <link rel="shortcut icon" href="resources/imgs/favicon.ico">
    <script type="text/javascript" src="resources/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="resources/js/jquery-ui.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/angular.min.js"></script>
    <script src="resources/js/ui-bootstrap-0.14.3.js" type="text/javascript"></script>
    <script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="resources/js/global_error_handler.js"></script>
    <script type="text/javascript" src="resources/js/global_util.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap-datetimepicker.js"></script>
    <script>
        $(document).ready(function () {
            var url = window.location;
            $('.list-group a').filter(function () {
                return this.href.indexOf(url.pathname) > -1;
            }).addClass('active');
            if (url.pathname.indexOf("home") > -1) {
                $('#selected_item').text("დაჯავშნა");
            } else if (url.pathname.indexOf("halls") > -1) {
                $('#selected_item').text("შეხვედრების ოთახები");
            }else if (url.pathname.indexOf("user") > -1) {
                $('#selected_item').text("მომხმარებლები");
            }
        });
        menuCtrl = function ($scope, $http) {
            function getUser(res) {
                $scope.currentUser = res.data.userData;
            }

            ajaxCall($http, "get-user", {}, getUser);
        };
    </script>

</head>
<body ng-app="app">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="row" ng-controller="menuCtrl">
                <div class="navbar navbar-inverse">
                    <div class="navbar-header english-font">
                        <a class="navbar-brand" href="home">RESERVATION</a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a>{{currentUser.firstName}} {{currentUser.lastName}}</a></li>
                            <li><a href="logout">გასვლა</a></li>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2 left-menu">
            <div class="row border-bottom-gray">
                <div class="col-md-12">
                    <h4 class="english-font"><span class="glyphicon glyphicon-asterisk"></span> Reservation</h4>
                </div>
            </div>
            <br/>
            <br/>
            <br/>

            <div class="row">
                <div class="list-group" ng-controller="menuCtrl">
                    <a href="home" class="list-group-item"><span class="glyphicon glyphicon-registration-mark"></span> დაჯავშნა</a>
                    <a href="halls" ng-show="currentUser.groupId==2" class="list-group-item"><span class="glyphicon glyphicon-barcode"></span> დარბაზები</a>
                    <a href="users" ng-show="currentUser.groupId==2" class="list-group-item"><span class="glyphicon glyphicon-user"></span> მომხმარებლები</a>
                </div>
                <br/>
                <br/>
                <div class="col-md-12">
                    გთხოვთ დამატებითი შეკითხვების არსებობის შემთხვევაში დაუკავშირდეთ<br/>
                    <h5>ნინო მეტრეველს</h5>
                    <h5>ტელ: 1060</h5>
                </div>
            </div>
        </div>
        <div class="col-md-10">
            <div class="row border-bottom-gray">
                <div class="col-md-12">
                    <h4 id="selected_item"></h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">