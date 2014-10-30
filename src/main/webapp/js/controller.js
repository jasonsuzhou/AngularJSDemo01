var phonecatApp = angular.module('phonecatApp', []);
//hard code sample
/*
phonecatApp.controller('PhoneListCtrl', function($scope){
	$scope.name = "Hello World";
	$scope.phones = [
	                 {'name': 'Nexus S',
	                  'snippet': 'Fast just got faster with Nexus S.',
	                  'age': 1},
	                 {'name': 'Motorola XOOMª with Wi-Fi',
	                  'snippet': 'The Next, Next Generation tablet.',
	                  'age': 2},
	                 {'name': 'MOTOROLA XOOMª',
	                  'snippet': 'The Next, Next Generation tablet.',
	                  'age': 3}
	               ];
	//select the default sort by
	$scope.orderProp = 'age';
});
*/
//invoke server side to get phone list sample
phonecatApp.controller('PhoneListCtrl', function($http, $scope){
	$scope.name = "Phone list from server side";
	$scope.orderProp = "age";
	$http.get('phoneList').success(function(data) {
		$scope.phones = data;
	});
});