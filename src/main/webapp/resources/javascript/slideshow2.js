var $next;

$(document).ready(function(){

	


setInterval(function(){slideSwitch();}, 5000);




});

function slideSwitch(){
	var $active = $('#slideshow IMG.active');

	if($active.is(':last-child')){
		$next = $('#slideshow IMG:first');
	}else{
		$next = $active.next();
	}
	$active.addClass('last-active');
	//$active.animate({opacity: 1.0}, 3000);
	
	$next.css({opacity: 0.0})
		 .addClass('active')
		 .animate({opacity: 1.0}, 3000,function(){
			$active.removeClass('active last-active');	 	 
		 });

}