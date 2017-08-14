// EdneyRoldao - 19/07/17
function UploadFile() {
	var directive = {};
	directive.restrict = "A";

	directive.scope = {
		uploadFile: "="
	};

	directive.link = function(scope, element) {
		element.bind("change", function(changeEvent) {
			var reader = new FileReader();

			reader.onload = function(LoadEvent) {
				scope.$apply(function() {
					scope.uploadFile = LoadEvent.target.result;
				});
			};
			
			reader.readAsDataURL(changeEvent.target.files[0]);
		});
	};

	return directive;
}

angular.module("meuControleHorasApp").directive("uploadFile", UploadFile);
