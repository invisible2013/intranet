<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>

<script>
    var app = angular.module("app", []);
    app.controller("userCtrl", function ($scope, $http, $filter) {
        $scope.users = [];

        function getUsers(res) {
            $scope.users = res.data;
        }

        ajaxCall($http, "users/get-users", null, getUsers);
        function getUserGroups(res) {
            $scope.groups = res.data;
        }

        ajaxCall($http, "users/get-groups", null, getUserGroups);


        $scope.saveUser = function () {
            ajaxCall($http, "users/save-user", angular.toJson($scope.user), reload);
        };
        $scope.editUser = function (userId) {
            if (userId != undefined) {
                var selected = $filter('filter')($scope.users, {id: userId}, true);
                $scope.user = selected[0];
            }
        };


    });
</script>

<div class="col-md-12" ng-controller="userCtrl">
    <br/>
    <form class="form-horizontal">
        <div class="form-group col-sm-8 ">
            <label class="control-label  col-sm-3">სახელი</label>
            <div class="col-sm-9">
                <input type="text" ng-model="user.firstName" class="form-control input-sm">
            </div>
        </div>
        <div class="form-group col-sm-8 ">
            <label class="control-label  col-sm-3">გვარი</label>
            <div class="col-sm-9">
                <input type="text" ng-model="user.lastName" class="form-control input-sm">
            </div>
        </div>
        <div class="form-group col-sm-8">
            <label class="control-label  col-sm-3">ჯგუფი</label>
            <div class="col-sm-9">
                <select class="form-control input-sm" ng-model="user.groupId">
                    <option ng-repeat="g in groups" value="{{g.id}}">{{g.name}}</option>
                </select>
            </div>
        </div>
        <div class="form-group col-sm-8 text-right">
            <div class="col-sm-12">
                <input id="addPersonItemBtn" type="button" class="btn btn-primary btn-xs" value="შენახვა"
                       ng-click="saveUser()">
            </div>
        </div>

    </form>
    <div class="form-group col-sm-8 ">
        <div class="col-sm-5">
            <input type="text" ng-model="searchFilter" placeholder="ძიება..." class="form-control input-sm">
        </div>
    </div>
    <table class="table table-striped table-hover" id="userList">
        <tr>
            <th>ID</th>
            <th>სახელი</th>
            <th>გვარი</th>
            <th>ელ-ფოსტა</th>
            <th>ჯგუფი</th>
            <th>სტატუსი</th>
            <th></th>
        </tr>
        <tr ng-repeat="i in users| filter: searchFilter">
            <td>{{$index + 1}}</td>
            <td>{{i.firstName}}</td>
            <td>{{i.lastName}}</td>
            <td>{{i.mail}}</td>
            <td>{{i.groupName}}</td>
            <td>{{i.statusName}}</td>
            <td>
                <button type="button" class="btn btn-xs btn-success" ng-click="editUser(i.id)">
                    რედაქტირება
                </button>
            </td>
        </tr>
    </table>
</div>

<%@include file="footer.jsp" %>