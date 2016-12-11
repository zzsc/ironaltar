$(document).ready(function() {  
  		 $("#carousel-example-generic").swiperight(function() {  
    		  $(this).carousel('prev');  
	    		});  
		   $("#carousel-example-generic").swipeleft(function() {  
		      $(this).carousel('next');  
	   });  
	}); 