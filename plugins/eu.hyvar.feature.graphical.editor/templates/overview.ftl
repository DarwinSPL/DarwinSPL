<html>
<head>
  	<title>${title}</title>
  	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="material.min.css">
	<script defer src="material.min.js"></script>
	  <script>
	    function extractDates(){
	
	      var dates = document.body.getElementsByTagName("h2");
	      console.log(dates);
	      for(var i=0; i<dates.length; i++){
	        console.log(dates[i]);
	      }
    }
  </script>
</head>
<body onload="extractDates()">

	
  <h1>${title}</h1>
  
  <ul>
    <#list dates as date>
    	<h2>${date.date?date}</h2>
    	<ul>
    	<#list date.changes as change>
    		<li>    			
				<b>${change.type}${change.name}</b> ${change.action} from <u>${change.oldValue}</u> to <u>${change.newValue}</u>
			</li>
    	</#list>
		</ul>
    </#list>
  </ul>

</body>
</html>