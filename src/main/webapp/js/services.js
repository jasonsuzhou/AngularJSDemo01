var phonecatServices = angular.module('phonecatServices', ['ngResource']);

phonecatService.factory('Phone', function($resource) {
	return $resource('phones/:phoneId.json', {}, {
		query: {method:'GET', params:{phoneId: 'phones'}, isArray: true}
	});
});