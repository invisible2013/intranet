<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>

<script>
    var app = angular.module("app", []);
    app.controller("hallCtrl", function ($scope, $http, $filter) {
        $scope.hall = {};
        $scope.halls = [];
        $scope.statuses = [];
        var a = {id: 1, name: "აქტიური"};
        var b = {id: 2, name: "არა აქტიური"};
        $scope.statuses.push(a);
        $scope.statuses.push(b);


        function getHalls(res) {
            $scope.halls = res.data;
        }

        ajaxCall($http, "hall/get-halls", null, getHalls);


        $scope.addHall = function () {
            $scope.hall.isActive = $scope.hall.statusId == 1 ? true : false;
            $scope.hall.active = $scope.hall.statusId == 1 ? true : false;
            ajaxCall($http, "hall/save-hall", angular.toJson($scope.hall), reload);
        };
        $scope.editHall = function (itemId) {
            if (itemId != undefined) {
                var selected = $filter('filter')($scope.halls, {id: itemId}, true);
                $scope.hall = selected[0];
                $scope.hall.statusId = $scope.hall.active ? 1 : 2;
            }
        };
        $scope.deleteHall = function (itemId) {
            if (confirm("დარწმუნებული ხართ რომ გსურთ წაშლა??")) {
                ajaxCall($http, "hall/delete-hall?itemId=" + itemId, null, reload);
            }
        };

    });
</script>

<div class="col-md-12" ng-controller="hallCtrl">
    <br/>
    <form class="form-horizontal">
        <div class="form-group col-sm-8 ">
            <label class="control-label  col-sm-3">დარბაზის სახელი</label>
            <div class="col-sm-9">
                <input type="text" ng-model="hall.name" class="form-control input-sm">
            </div>
        </div>
        <div class="form-group col-sm-8 ">
            <label class="control-label col-sm-3">აღწერა</label>
            <div class="col-sm-9">
                <input type="text" id="" ng-model="hall.description" class="form-control input-sm">
            </div>
        </div>
        <div class="form-group col-sm-8">
            <label class="control-label col-sm-3">სტატუსი</label>
            <div class="col-sm-9">
                <select class="form-control input-sm" ng-model="hall.statusId">
                    <option ng-repeat="s in statuses" value="{{s.id}}">{{s.name}}</option>
                </select>
            </div>
        </div>
        <div class="form-group col-sm-8 text-right">
            <div class="col-sm-12">
                <input id="addPersonItemBtn" type="button" class="btn btn-primary btn-xs" value="შენახვა"
                       ng-click="addHall()">
            </div>
        </div>

    </form>
    <table class="table table-striped table-hover" id="hallList">
        <tr>
            <th>ID</th>
            <th>სახელი</th>
            <th>აღწერა</th>
            <th>სტატუსი</th>
            <th></th>
        </tr>
        <tr ng-repeat="i in halls">
            <td>{{$index + 1}}</td>
            <td>{{i.name}}</td>
            <td>{{i.description}}</td>
            <td>{{i.active?"აქტიური":"არა აქტიური"}}</td>
            <td style="width:200px;">
                <button type="button" class="btn btn-xs btn-success" ng-click="editHall(i.id)">
                    რედაქტირება
                </button>
                <button type="button" class="btn btn-xs btn-danger" ng-click="deleteHall(i.id)">
                    წაშლა
                </button>
            </td>
        </tr>
    </table>
</div>

<%@include file="footer.jsp" %>
