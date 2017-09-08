<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<script type="text/javascript" src="resources/fullcalendar/lib/moment.min.js"></script>
<link rel="stylesheet" href="resources/fullcalendar/fullcalendar.min.css"/>
<link rel="stylesheet" href="resources/fullcalendar/fullcalendar.print.min.css" media="print"/>
<script type="text/javascript" src="resources/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="resources/fullcalendar/locale/ka.js"></script>
<style>


</style>
<script>
    $(document).ready(function () {
        $('#startDate').datetimepicker({
            showOn: 'both',
            dateFormat: 'dd/mm/yy HH:mm',
            yearRange: "-150:+0",
            changeMonth: true,
            changeYear: true
        });
        $('#toDate').datetimepicker({
            dateFormat: 'dd/mm/yy HH:mm',
            yearRange: "-150:+0",
            changeMonth: true,
            changeYear: true
        });
        $('.input-group').find('.from-datetimepicker').on('click', function () {
            $('#startDate').trigger('focus');
        });
        $('.input-group').find('.to-datetimepicker').on('click', function () {
            $('#toDate').trigger('focus');
        });
    });

    var app = angular.module("app", ["ui.bootstrap"]);
    app.filter('asHtml', function ($sce) {
        return function (val) {
            return $sce.trustAsHtml(val);
        };
    });
    app.controller("homeCtrl", function ($scope, $http, $filter, $location) {
        //$scope.halls = [];
        $scope.reservations = [];
        $scope.selectedReservation = {};
        $scope.reservation = {};
        $scope.currentUser = {};
        $scope.canDelete = false;
        $scope.ADMIN_GROUP = 2;
        $scope.selectedHallId = 0;
        var currentDate = new Date();


        function getHalls(res) {
            $scope.halls = res.data;
            if ($scope.halls.length > 0) {
                $scope.selectedHallId = $scope.halls[0].id;
            }
            function getReservations(res) {
                fillReservations(res);
                $('#calendar').fullCalendar({
                    header: {
                        left: 'prev,next today',
                        center: 'title',
                        right: 'month,agendaWeek,agendaDay,listMonth'
                    },
                    defaultView: 'agendaWeek',
                    defaultDate: currentDate,
                    editable: false,
                    eventLimit: true, // allow "more" link when too many events
                    events: $scope.reservations,
                    timeFormat: 'HH:mm',
                    eventClick: eventClick
                });
                $scope.reservation.hallId = $scope.selectedHallId;
            }

            ajaxCall($http, "reservation/get-reservations-by-hall?hallId=" + $scope.selectedHallId, null, getReservations);
        }

        ajaxCall($http, "hall/get-halls", null, getHalls);

        function convertDate(date1) {
            if (date1) {
                var date1 = new Date(date1);
                return moment(date1).format("DD-MM-YYYY HH:mm");
            }
            return "";
        }

        function getUser(res) {
            $scope.currentUser = res.data.userData;
        }

        ajaxCall($http, "get-user", {}, getUser);

        function eventClick(event) {
            var selected = $filter('filter')($scope.reservations, {id: event.id}, true);
            $scope.selectedReservation = selected[0];
            $('#titleId').html($scope.selectedReservation.title);
            $('#description').html($scope.selectedReservation.description);
            $('#hallFullName').html($scope.selectedReservation.hallName + " " + $scope.selectedReservation.hallDescription);
            $('#userName').html($scope.selectedReservation.userFirstName + " " + $scope.selectedReservation.userLastName);
            $('#duration').html(getDifferenceHoursAndMinutes($scope.selectedReservation.start, $scope.selectedReservation.end));
            $('#start').html(convertDate($scope.selectedReservation.start));
            $('#end').html(convertDate($scope.selectedReservation.end));

            if ($scope.currentUser.id == event.userId || $scope.currentUser.groupId == $scope.ADMIN_GROUP) {
                $scope.canDelete = true;
                $('#deleteReservation').show();
            } else {
                $('#deleteReservation').hide();
            }

            $('#detailModal').modal();
        }

        $scope.deleteReservation = function () {
            if (confirm("დარწმუნებული ხართ რომ გსურთ წაშლა?")) {
                if ($scope.selectedReservation.id) {
                    ajaxCall($http, "reservation/delete-reservation?itemId=" + $scope.selectedReservation.id, null, reload());
                }
            }
        };

        function getDateTimeFromString(dateTimeString) {
            if (dateTimeString) {
                var datetimes = dateTimeString.split(" ");
                var date = datetimes[0].split("/");
                var time = datetimes[1].split(":");
                var dateTime = new Date(date[2] + "-" + date[1] + "-" + date[0] + " " + time[0] + ":" + time[1] + ":00");
                //dateTime = moment(dateTime).format("YYYY-MM-DD HH:mm:ss");
                return dateTime;
            }
        }

        function getHoursDifferenceTwoDate(date1, date2) {
            if (date1 && date2) {
                var hours = Math.abs(date1 - date2) / (60 * 60 * 1000);
                return hours;
            }
        };
        function getDifferenceHoursAndMinutes(date1, date2) {
            if (date1 && date2) {
                var allMin = Math.abs(date1 - date2) / (60 * 1000);
                var difHour = parseInt(allMin / 60);
                var difMin = allMin - (difHour * 60);
                var difString = difHour + " სთ " + difMin + " წთ";
                return difString;
            }
            return "";
        };

        function fillReservations(res) {
            $scope.reservations = res.data;
            angular.forEach($scope.reservations, function (value, key) {
                value.start = getDateTimeFromString(value.start);
                value.end = getDateTimeFromString(value.end);
            });
        }


        $scope.saveReservation = function () {
            var reserve = $scope.reservation;
            if ($scope.reservation.startDate == "") {
                alert("შეიყვანეთ დაწყების თარიღი");
                return;
            }
            if ($scope.reservation.endDate == "") {
                alert("შეიყვანეთ დამთავრების თარიღი");
                return;
            }
            if ($scope.reservation.name == "") {
                alert("შეიყვანეთ შეხვედრის დეტალები");
                return;
            }
            ajaxCall($http, "reservation/save-reservation", angular.toJson($scope.reservation), reload);

        };
        $scope.showReservation = function () {

        };
        $scope.changeHall = function (hallId) {
            function updateReservations(res) {
                fillReservations(res);
                $('#calendar').fullCalendar('removeEventSources');
                $('#calendar').fullCalendar('addEventSource', $scope.reservations);
            }

            ajaxCall($http, "reservation/get-reservations-by-hall?hallId=" + hallId, null, updateReservations);
        };

    });
</script>

<div class="col-md-12" ng-controller="homeCtrl">

    <br/>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">დაჯავშნა</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="control-label">აირჩიეთ დარბაზი</label>
                            <select class="form-control " ng-model="reservation.hallId">
                                <option ng-repeat="h in halls" value="{{h.id}}">{{h.name}}</option>
                            </select>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="control-label">საწყისი დრო</label>
                            <div class='input-group date' id='datetimepicker2'>
                                <input type="text" id="startDate" ng-model="reservation.startDate"
                                       class="form-control form_datetime" data-date-format="dd/mm/yyyy hh:ii">
                                <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar from-datetimepicker"></span>
                                </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="control-label">დასრულების დრო</label>
                            <div class='input-group date' id='datetimepicker1'>
                                <input type="text" id="toDate" ng-model="reservation.endDate"
                                       class="form-control form_datetime" data-date-format="dd/mm/yyyy hh:ii">
                                <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar to-datetimepicker"></span>
                                </span>
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="control-label">დასახელება</label>
                            <input type="text" id="name" ng-model="reservation.name" class="form-control">
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="control-label">აღწერა</label>
                            <input type="text" id="desc" ng-model="reservation.description" class="form-control">
                        </div>

                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">დახურვა</button>
                    <button type="button" class="btn btn-primary btn-sm" ng-click="saveReservation()">შენახვა</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="detailModal" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="detailModalLabel">დაჯავშნის დეტალები</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <table class="table table-striped">
                            <tr>
                                <th class="col-md-4 text-right">დასახელება :</th>
                                <td><span id="titleId"></span>{{$scope.selectedReservation.title}}</td>
                            </tr>
                            <tr>
                                <th class="col-md-4 text-right">აღწერა :</th>
                                <td><span id="description"></span></td>
                            </tr>
                            <tr>
                                <th class="col-md-4 text-right">ოთახი :</th>
                                <td><span id="hallFullName"></span></td>
                            </tr>
                            <tr>
                                <th class="col-md-4 text-right">დაწყების დრო :</th>
                                <td><span id="start"></span></td>
                            </tr>
                            <tr>
                                <th class="col-md-4 text-right">დასრულების დრო :</th>
                                <td><span id="end"></span></td>
                            </tr>
                            <tr>
                                <th class="col-md-4 text-right">ხანგრძლივობა :</th>
                                <td><span id="duration"></span></td>
                            </tr>
                            <tr>
                                <th class="col-md-4 text-right">მომხმარებელი :</th>
                                <td><span id="userName"></span></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">დახურვა</button>
                    <button type="button" id="deleteReservation" class="btn btn-primary btn-sm"
                            ng-click="deleteReservation()">წაშლა
                    </button>
                </div>
            </div>
        </div>
    </div>

    <div id="hallList">
        <form name="reervationForm">
            <div class="form-group col-md-4">
                <label class="control-label">აირჩიეთ დარბაზი</label>
                <select class="form-control" id="reservationHallId" ng-model="reservation.hallId"
                        ng-change="changeHall(reservation.hallId)">
                    <option ng-repeat="h in halls" value="{{h.id}}">{{h.name}}</option>
                </select>
            </div>
            <div class="form-group col-md-4">
                <label class="control-label"></label>
                <div class="form-group">
                    <input type="button" class="btn btn-primary btn-sm" style="margin-top: 6px;" value="დაჯავშნა"
                           data-toggle="modal"
                           data-target="#myModal" ng-click="showReservation();">
                </div>
            </div>
        </form>
        <div class="clear"></div>
    </div>
    <div id="calendar" class="fc fc-unthemed fc-ltr"></div>
    <br/><br/>


</div>
<%@include file="footer.jsp" %>
