var knjizaraApp = angular.module("knjizaraApp", ['ngRoute']);

knjizaraApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/',{
        templateUrl: '/app/html/knjige.html'
    }).when('/knjige/edit/:id',{
        templateUrl: '/app/html/edit-knjiga.html'
    }).otherwise({
        redirectTo: '/'
    });
}]);

knjizaraApp.controller("knjigeCtrl", function($scope, $http, $location){

	var baseUrlIzdavaci = "/api/izdavaci";
    var baseUrlKnjige = "/api/knjige";
    

    $scope.promeniRezim = function(){
        $scope.rezimDodavanja = !$scope.rezimDodavanja;
    };
    $scope.rezimDodavanja = true;

    $scope.pageNum = 0;
    $scope.totalPages = 0;

    $scope.izdavaci = [];
    $scope.knjige = [];

    $scope.novaKnjiga = {};
    $scope.novaKnjiga.naziv = "";
    $scope.novaKnjiga.izdanje = "";
    $scope.novaKnjiga.pisac = "";
    $scope.novaKnjiga.isbn = "";
    $scope.novaKnjiga.izdavacId = "";


    $scope.trazenaKnjiga = {};
    $scope.trazenaKnjiga.naziv = "";
    $scope.trazenaKnjiga.pisac = "";
    $scope.trazenaKnjiga.minGlasova = "";

    var getKnjige = function(){

        var config = {params: {}};

        config.params.pageNum = $scope.pageNum;

        if($scope.trazenaKnjiga.naziv != ""){
            config.params.naziv = $scope.trazenaKnjiga.naziv;
        }

        if($scope.trazenaKnjiga.pisac != ""){
            config.params.pisac = $scope.trazenaKnjiga.pisac;
        }

        if($scope.trazenaKnjiga.maxKolicina != ""){
            config.params.minGlasova = $scope.trazenaKnjiga.minGlasova;
        }


        $http.get(baseUrlKnjige, config)
            .then(
            	function success(res){
            		$scope.knjige = res.data;
            		$scope.totalPages = res.headers('totalPages');
            	},
            	function error(res){
            		alert("Neuspesno dobavljanje knjiga!");
            	}
            );
    };

    var getIzdavaci = function(){

        $http.get(baseUrlIzdavaci)
            .then(
            	function success(res){
            		$scope.izdavaci = res.data;
            	},
            	function error(res){
            		alert("Neuspesno dobavljanje izdavaca!");
            	}
            );

    };

    getIzdavaci();
    getKnjige();
   

    $scope.nazad = function(){
        if($scope.pageNum > 0) {
            $scope.pageNum = $scope.pageNum - 1;
            getKnjige();
        }
    };

    $scope.napred = function(){
        if($scope.pageNum < $scope.totalPages - 1){
            $scope.pageNum = $scope.pageNum + 1;
            getKnjige();
        }
    };

    $scope.dodaj = function(){
        $http.post(baseUrlKnjige, $scope.novaKnjiga)
            .then(
            	function success(res){
	            	getKnjige();
	
	                $scope.novaKnjiga.naziv = "";
	                $scope.novaKnjiga.izdanje = "";
	                $scope.novaKnjiga.pisac = "";
	                $scope.novaKnjiga.isbn = "";
	                $scope.novaKnjiga.izdavacId = "";
            	},
            	function error(res){
            		alert("Neuspesno dodavanje!");
            	}
            );
    };

    $scope.trazi = function () {
        $scope.pageNum = 0;
        getKnjige();
    }

    $scope.izmeni = function(id){
        $location.path('/knjige/edit/' + id);
    }

    $scope.obrisi = function(id){
        $http.delete(baseUrlKnjige + "/" + id).then(
            function success(data){
            	getKnjige();
            },
            function error(data){
                alert("Neuspesno brisanje!");
            }
        );
    }
    
    $scope.glasaj = function(id){
    	$http.post(baseUrlKnjige + "/" + id + "/glasanje").then(
    		function success(data){
    			alert("Glasanje je uspesno obavljeno.");
    			getKnjige();
    		},
    		function error(data){
    			alert("Nije uspelo glasanje za knjigu.")
    		}
    	)
    }
});

knjizaraApp.controller("editKnjigaCtrl", function($scope, $http, $routeParams, $location){

    var baseUrlKnjige = "/api/knjige";

    $scope.staraKnjiga = null;

    var getStaraKnjiga = function(){

        $http.get(baseUrlKnjige + "/" + $routeParams.id)
            .then(
            	function success(data){
            		$scope.staraKnjiga = data.data;
            	},
            	function error(data){
            		alert("Neušpesno dobavljanje knjige.");
            	}
            );

    }
    getStaraKnjiga();
    
    $scope.izmeni = function(){
        $http.put(baseUrlKnjige + "/" + $scope.staraKnjiga.id, $scope.staraKnjiga)
            .then(
        		function success(data){
        			alert("Uspešno izmenjen objekat!");
        			$location.path("/");
        		},
        		function error(data){
        			alert("Neuspešna izmena knjige.");
        		}
            );
    }
});












