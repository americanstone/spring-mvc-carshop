var totalSlides = 0;
var currentSlide = 1;
var contentSlides = "";

$(document).ready(function(){
 // $("#slideshow-content img").corner();
  $("#slideshow-previous").click(showPreviousSlide);
  $("#slideshow-next").click(showNextSlide);
  
  var totalWidth = 0;
  contentSlides = $(".slideshow-content");
  contentSlides.each(function(i){
    totalWidth += this.clientWidth;
    totalSlides++;
  });
  $("#slideshow-holder").width(totalWidth);
  $("#slideshow-scroller").attr({scrollLeft: 0});
	var leftarrow = document.getElementById('slideshow-previous');
	var rightarrow = document.getElementById('slideshow-next');
	var photoArea = document.getElementById('slideshow-area');
	
	//leftarrow.onmouseout= function(){leftarrow.style.background="none";}
	photoArea.onmouseout= function(){rightarrow.style.background="none";
									 leftarrow.style.background="none";}
	//leftarrow.onmouseover = function(){leftarrow.style.background="url('http://localhost/myJSP/images/leftarrow.png')";}
	photoArea.onmouseover = function(){rightarrow.style.background="transparent url('http://localhost:8088/myJSP/images/rightarrow.png') no-repeat 50% 50%";
									   leftarrow.style.background="transparent url('http://localhost:8088/myJSP/images/leftarrow.png') no-repeat 50% 50%";}
  updateButtons();

	//setInterval(function(){scroll();}, 5000);
});


function scroll(){
	
$("#slideshow-next").trigger('click', [true]);

}



function showPreviousSlide()
{
  currentSlide--;
  updateContentHolder();
  updateButtons();
}

function showNextSlide()
{
  currentSlide++;
  updateContentHolder();
  updateButtons();
}

function updateContentHolder()
{
  var scrollAmount = 0;
  contentSlides.each(function(i){
    if(currentSlide - 1 > i) {
      scrollAmount += this.clientWidth;
    }
  });
  $("#slideshow-scroller").animate({scrollLeft: scrollAmount}, 200);
}

function updateButtons()
{
  if(currentSlide < totalSlides) {
    $("#slideshow-next").show();
  } else {
    $("#slideshow-next").hide();
  }
  if(currentSlide > 1) {
    $("#slideshow-previous").show();
  } else {
    $("#slideshow-previous").hide();
  }
}