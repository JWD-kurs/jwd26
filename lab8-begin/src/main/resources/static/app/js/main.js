var app = angular.module("wafepa", ['ngRoute']);

app.controller("ctrl", function ($scope){
	
	$scope.appName = "Wafepa";

});

app.controller("activitiesCtrl", function($scope, $http, $location){
	
	var baseUrl = "/api/activities";
	
	$scope.activities = [];
	
	var getActivities = function(){
		
		var promise = $http.get(baseUrl);
		promise.then(
			function uspeh(odg){
				$scope.activities = odg.data;
				//console.log($scope.activities);
			},
			function neuspeh(odg){
				alert("Nesto je poslo po zlu.");
			}
		);
	}
	
	getActivities();
	
	$scope.goToAdd = function(){
		$location.path('/activities/add');
	}
	
	$scope.goToEdit = function(id){
		$location.path("/activities/edit/" + id);
	}
	
});

app.controller("addActivityCtrl", function($scope, $http, $location){
	
	var baseUrl = "/api/activities";
	
	$scope.newActivity = {};
	$scope.newActivity.name = "";
	
	$scope.add = function(){
		
		$http.post(baseUrl, $scope.newActivity).then(
			function success(res){
				$location.path("/activities");
			},
			function error(res){
				alert("Something went wrong!");
			}
		);
	}
	
});

app.controller("editActivityCtrl", function($scope, $http, $routeParams, $location){
	
	var id = $routeParams.aid;
	var baseUrl = "/api/activities/";
	
	$scope.oldActivity = {};
	$scope.oldActivity.name = "";
	
	var getActivity = function(){
		
		var promise = $http.get(baseUrl + id);
		promise.then(
			function success(res){
				$scope.oldActivity = res.data;
				console.log(res);
			},
			function error(res){
				alert("Something went wrong.");
			}
		);
	}
	
	getActivity();
	
	$scope.edit = function(){
		
		$http.put(baseUrl + id, $scope.oldActivity).then(
			function success(res){
				$location.path("/activities");
			},
			function error(res){
				alert("Something went wrong!");
			}
		);
	}
	
});

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/partial/home.html',
			controller: 'ctrl'
		})
		.when('/activities', {
			templateUrl : '/app/html/partial/activities.html'
		})
		.when('/activities/add', {
			templateUrl : '/app/html/partial/add-activity.html'
		})
		.when('/activities/edit/:aid', {
			templateUrl : '/app/html/partial/edit-activity.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);
