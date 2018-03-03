var app = angular.module("wafepa", ['ngRoute']);

app.controller("ctrl", function ($scope){
	
	$scope.appName = "Wafepa";

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
		.otherwise({
			redirectTo: '/'
		});
}]);
