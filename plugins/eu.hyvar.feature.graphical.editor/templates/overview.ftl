<html>
<head>
  	<title>${title}</title>
  	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://code.getmdl.io/1.2.1/material.indigo-pink.min.css">
	<script defer src="https://code.getmdl.io/1.2.1/material.min.js"></script>
</head>
<body>


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