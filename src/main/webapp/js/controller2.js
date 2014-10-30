var phonecatControllers = angular.module('phonecatControllers', []);

phonecatControllers.controller('PhoneListCtrl', function($http, $scope){
	$scope.orderProp = "age";
	$http.get('phoneList').success(function(data) {
		$scope.phones = data;
	});
});

phonecatControllers.controller('PhoneDetailCtrl', function($scope, $routeParams, $http){
	$http.get("phoneDetail?phoneId="+$routeParams.phoneId).success(function(data) {
		console.log(data);
		$scope.phone = data;
		$scope.sayHello = function(sth) {
			alert("Hello " + sth);
		}
	});
});