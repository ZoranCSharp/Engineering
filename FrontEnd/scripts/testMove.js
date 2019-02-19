$(document).ready(function(){
      
    $("button").click(function(){




$("#right").click(function(){
      $("#div1").animate({left:'750px'});  

 });

 $("#left").click(function(){
      $("#div1").animate({left:'250px'});  

 });

 $("#down").click(function(){
      $("#div1").animate({top:'300px'});  

 });

 $("#start").click(function(){
      $("#div1").animate({top:'0px',left:'0px',right:'0px'}); 
      $("#right").prop('disabled', false);
      $("#left").prop('disabled', false);
      $("#down").prop('disabled', false);
      $("#reset").prop('disabled', false);           
 });
 $("#reset").click(function(){
      $("#div1").animate({top:'0px',left:'0px',right:'0px'}); 
      $("#right").prop('disabled', true);
      $("#left").prop('disabled', true);
      $("#down").prop('disabled', true);
      $("#reset").prop('disabled', true);
     
 });

 
});


});


$(function(){			
               $("#resizable2").resizable({ghost:true});
                    
		});

