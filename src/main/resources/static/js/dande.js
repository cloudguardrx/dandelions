var dande = angular.module('dande', ['ngSanitize','angular-lightweight-markdown-editor','angularMoment'])

dande.directive('markdown', function() {
  var converter = new showdown.Converter();
  return {
    restrict: 'E',
    link: function(scope, element, attrs) {
        var htmlText = converter.makeHtml(element.text());
        element.html(htmlText);
    }
  }
});

dande.controller("home", function($http) {
    var self = this;
    $http.get("/user").success(function(data) {
      self.user = data.userAuthentication.details.name;
      self.authenticated = true;
    }).error(function() {
      self.user = "N/A";
      self.authenticated = false;
    });
});

dande.controller('WorkoutController', ['$scope', '$http', 'moment', function($scope, $http, moment) {
    $http.get('/workout?date=' + moment().format('YYYY-MM-DD')+'T00:00:00Z')
      .then(function(response) {
        var converter = new showdown.Converter();
        
        $scope.date = response.data.date;
        $scope.details = converter.makeHtml(response.data.details);
        $scope.movements = response.data.movements;
        $scope.results = response.data.results;
      }
    );
    
}]);