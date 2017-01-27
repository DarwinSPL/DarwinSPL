<html>
<head>
  	<title>${title}</title>
  	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="material.min.css">
	<script defer src="material.min.js"></script>
	<script>

    	var startIndex = 0;
    	var endIndex = 0;
    	
    	function hideDates(){
			var dates = document.body.getElementsByTagName("h2"); 
			var changes = document.body.getElementsByClassName("changeList");
			

			
			for(var i=0; i<dates.length; i++){				
				if(i >= startIndex && i <= endIndex){
					dates[i].style.visibility = "visible";
					dates[i].style.display = "block";
					changes[i].style.visibility = "visible";
					changes[i].style.display = "block";
				}else{
					dates[i].style.visibility = "collapse";
					dates[i].style.display = "none";
					changes[i].style.visibility = "collapse";
					changes[i].style.display = "none";
				}
			}    	    	
    	}
    	
    	function changeDate(type, value){
    		var dates = document.body.getElementsByTagName("h2");
    		
    		if(type.localeCompare("end") == 0){	
		      	for(var i=0; i<dates.length; i++){
		      		if(dates[i].textContent.localeCompare(value) == 0){
		      			endIndex = i;
		      		}
		      	}
		      	
		      	document.getElementById("end-date-button").textContent = dates[endIndex].textContent;
	   
	   			hideDates();
		    }else{
		      	for(var i=0; i<dates.length; i++){
		      		if(dates[i].textContent.localeCompare(value) == 0){
		      			startIndex = i;
		      		}
		      	}
		      	
		      	document.getElementById("start-date-button").textContent = dates[endIndex].textContent;
		    	
		    	hideDates();
		    }   
    	}
    	
    	function extractDates(){	
			var dates = document.body.getElementsByTagName("h2");
			changeDate("start", dates[0].textContent);
			changeDate("end", dates[dates.length-1].textContent);
			
			console.log(dates[dates.length-1].textContent);
    	}
  </script>
</head>
<body onload="extractDates()">
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
  <header class="mdl-layout__header">
    <div class="mdl-layout__header-row">
      <span class="mdl-layout-title">${title}</span>
      <!-- Add spacer, to align navigation to the right -->
      <div class="mdl-layout-spacer"></div>

      <nav class="mdl-navigation mdl-layout--large-screen-only">
      	<span class="mdl-navigation__link" href="">Start Date:
	     <button id="start-date-button" class="mdl-button mdl-js-button" style="color: white">
	      Select Start Date
	    </button>
	    
	    <ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
	        for="start-date-button">
		    <#list dates as date>
				<li class="mdl-menu__item" onclick="changeDate('start', this.textContent)">${date.date?string.@simple}</li>
		    </#list>        
	    </ul>
	    to     
	    	<button id="end-date-button" class="mdl-button mdl-js-button" style="color: white">
	      		Select End Date
	    	</button>
	    
		    <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect"
		        for="end-date-button">
			    <#list dates as date>
					<li class="mdl-menu__item" onclick="changeDate('end', this.textContent)">${date.date?string.@simple}</li>
			    </#list>        
		    </ul>	
      	</span>
      </nav>
    </div>
  </header>
  <main>
  <ul>
    <#list dates as date>
    	<h2>${date.date?string.@simple}</h2>
    	<ul class="changeList">
    	<#list date.changes as change>
    		<li>    			
				<b>${change.type}${change.name}</b> ${change.action}
			</li>
    	</#list>
		</ul>
    </#list>
  </ul>  
  </main>

</div>



	
  


</body>
</html>