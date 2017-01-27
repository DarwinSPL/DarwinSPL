
<#macro cssRGBAColor color>rgba(${color.red}, ${color.green}, ${color.blue}, ${color.alpha})</#macro>
<#macro cssStroke width>stroke="<@cssRGBAColor color=theme.lineColor />" stroke-width="${width}"</#macro>
<#macro cssFont font modifier>
	<#if font.fontData[0].style == 1>
	font-weight: bold;<#t>
	</#if>
	font-family: ${font.fontData[0].name},arial,Sans-Serif;<#t>	
	font-size: ${font.fontData[0].height*1.3*modifier}px;<#t>	
</#macro>

<#macro featureLine parent child>
	<#if child.modifier == 0 || child.modifier == 1>
		<#assign childY = child.y-theme.featureVariationTypeExtent * 0.5 - theme.lineWidth>
	<#else>
		<#assign childY = child.y>
	</#if>

	<line <#t>
		x1="${(parent.x+parent.width * 0.5)?c}" <#t>
		y1="${(parent.y+(theme.featureNameAreaHeight * (parent.attributes?size+1) + parent.versionAreaHeight))?c}" <#t>
		x2="${(child.x+child.width * 0.5)?c}" <#t>
		y2="${(childY)?c}" <#t>
		<@cssStroke theme.lineWidth /> 
	/>
</#macro>


<#macro feature data >
	<g class="feature">
		<rect id="${data.name}" x="${data.x?c}" y="${data.y?c}" width="${data.width?c}" height="${theme.featureNameAreaHeight?c}" <@cssStroke theme.lineWidth /> style="fill: url(#feature)"/> <#t>
		
		<#if data.modifier == 0>
			<circle cx="${(data.x+data.width * 0.5)?c}" cy="${(data.y-theme.lineWidth)?c}" r="${(theme.featureVariationTypeExtent * 0.5-theme.lineWidth * 0.5)}" <@cssStroke theme.lineWidth /> fill="url(#modifier_optional)" />
		<#elseif data.modifier == 1>
			<circle cx="${(data.x+data.width * 0.5)?c}" cy="${(data.y-theme.lineWidth)?c}" r="${(theme.featureVariationTypeExtent * 0.5-theme.lineWidth * 0.5)}" <@cssStroke theme.lineWidth /> fill="url(#modifier_mandatory)" />
		</#if>
		
  		<text text-anchor="middle" style="<@cssFont theme.featureFont 1/>" <#t>
  			x="${(data.x+data.width * 0.5)?c}" <#t> 
  			y="${(data.y+theme.featureNameAreaHeight * 0.5+theme.featureFont.fontData[0].height * 0.5)?c}" <#t>
  			fill="<@cssRGBAColor color=theme.featureFontColor />">${data.name} <#t>
  		</text>
  		
  		<@dataBackground data/>
  		<#list data.attributes as child>
			<@attribute child data/>
    	</#list>
    	
		<#if data.rootVersion??>
			<@version data.rootVersion data/>
		</#if>
    </g>
    
    
    <#list data.children as child>
    	<@featureLine data child />
		<@feature child />
    </#list>
</#macro>

<#macro dataBackground feature>
	<rect 
		x="${feature.x?c}" <#t>
		y="${(feature.y + theme.featureNameAreaHeight)?c}" <#t>
		width="${feature.width?c}" <#t>
		height="${(theme.featureNameAreaHeight * (feature.attributes?size) + feature.versionAreaHeight)?c}" <#t>
		<@cssStroke theme.lineWidth /> style="fill: url(#version_area)" <#t>
	/>
</#macro>

<#macro attribute data feature>	
	<#assign index=feature.attributes?seq_index_of(data) />
	
	<#if data.type == 0>
		<#assign type="Number" />
	<#elseif data.type == 1>
		<#assign type="Boolean" />
	<#elseif data.type == 2>
		<#assign type="Enum" />
	<#elseif data.type == -1>
		<#assign type="String" />
	</#if>
	

	
  	<text text-anchor="start" style="<@cssFont theme.versionFont 1.2 />" <#t>
  		x="${(feature.x+theme.primaryMargin)?c}" <#t> 
  		y="${(feature.y+feature.versionAreaHeight+theme.featureNameAreaHeight * (0.5+(index+1))+theme.featureFont.fontData[0].height * 0.5)?c}" <#t>
  		fill="<@cssRGBAColor color=theme.versionFontColor />">${type!UndefinedType} <#t>
  	</text>		
  	<text text-anchor="end" style="<@cssFont theme.versionFont 1.2 />" <#t>
  		x="${(feature.x+feature.width-theme.primaryMargin)?c}" <#t> 
  		y="${(feature.y+feature.versionAreaHeight+theme.featureNameAreaHeight * (0.5+(index+1))+theme.featureFont.fontData[0].height * 0.5)?c}" <#t>
  		fill="<@cssRGBAColor color=theme.versionFontColor />">${data.name} <#t>
  	</text>
</#macro>

<#macro versionLine parent child feature>
	<#assign length=theme.versionTriangleEdgeLength />

	<line <#t>
		x1="${(feature.x+parent.x+length+theme.secondaryMargin)?c}" <#t>
		y1="${(feature.y+parent.y+length * 0.5)?c}" <#t>
		x2="${(feature.x+child.x-theme.secondaryMargin)?c}" <#t>
		y2="${(feature.y+child.y+length * 0.5)?c}" <#t>
		<@cssStroke theme.lineWidth /> 
	/>
</#macro>
<#macro version data feature>	
	<#assign x=feature.x+data.x />
	<#assign y=feature.y+data.y-theme.featureNameAreaHeight * 0.5 />
	<#if feature.modifier == -1>
		<#assign y+=theme.featureVariationTypeExtent />
	</#if>
	
	<#assign length=theme.versionTriangleEdgeLength />
	<#assign offset=length * 0.5 />
	<polygon fill="url(#version)" <@cssStroke theme.versionLineWidth /> points="${x?c},${(y+length-offset)?c}  ${(x+length)?c},${(y+length-offset)?c} ${(x+length * 0.5)?c},${(y-offset)?c}" />
	                    
	                    
  	<text text-anchor="center" style="<@cssFont theme.versionFont 1.0 />" <#t>
  		x="${(feature.x+data.x+theme.versionLineWidth * 0.5)?c}" <#t> 
  		y="${(y+length*1.3)?c}" <#t>
  		fill="<@cssRGBAColor theme.versionFontColor />">${data.number} <#t>
  	</text>
  	
  	<line x1="${(feature.x)?c}" y1="${(feature.y+feature.versionAreaHeight+theme.featureNameAreaHeight)?c}" x2="${(feature.x+feature.width)?c}" y2="${(feature.y+feature.versionAreaHeight+theme.featureNameAreaHeight)?c}" style="stroke:<@cssRGBAColor theme.lineColor />;stroke-width:${theme.lineWidth}" />

  	<#list data.children as child>
  		<@versionLine data child feature />
		<@version child feature />
    </#list>
</#macro>

<#macro group data>	
	<#if data.modifier != 0>
		<#if data.modifier == 1>
			<#assign fillType = "#group_modifier" />
		<#else>
			<#assign fillType = "#group_modifier_alternative" />
		</#if>
		
		<path d="M${data.arc.centerX?c} 
				  ${data.arc.centerY?c} 
				 L${data.arc.startX?c} 
				  ${data.arc.startY?c} 
				 A${theme.groupSymbolRadius} 
				  ${theme.groupSymbolRadius} 0 0 1 
				  ${data.arc.endX?c} 
				  ${data.arc.endY?c} Z" 
				  fill="url(${fillType})" 
				  <@cssStroke theme.lineWidth />  
		/>
	</#if>
</#macro>
<#macro enum enums>
	<#assign left=520 />
	<#assign width=150-theme.lineWidth / 2 />
	<#assign y=20 />
	<#list enums as child>	
		<rect x="${left?c}" y=${y?c} width="${width?c}" height="${(theme.featureNameAreaHeight*(child.literals?size+1))?c}" fill="transparent" <@cssStroke theme.lineWidth /> />	
	  	
	  	
		<#assign index=enums?seq_index_of(data)+0.75 />
		
		<#assign y+=theme.featureNameAreaHeight*(index+1) />
		
		
		
		<text text-anchor="center" style="<@cssFont theme.versionFont 1.2 />" <#t>
	  		x="${(left+10)?c}" <#t> 
	  		y="${y?c}" <#t>
	  		fill="<@cssRGBAColor color=theme.versionFontColor />">${child.name} <#t>
	  	</text>	
	  	
	  	<#list child.literals as literal>
	  		<#assign y+=theme.featureNameAreaHeight />
		  	<text text-anchor="center" style="<@cssFont theme.versionFont 1.2 />" <#t>
		  		x="${(left+10)?c}" <#t> 
		  		y="${y?c}" <#t>
		  		fill="<@cssRGBAColor color=theme.versionFontColor />">${literal} <#t>
		  	</text>	
	    </#list>
	    <#assign y+=theme.featureNameAreaHeight * 0.5 />
    </#list>
    
    

</#macro>

<svg width="${editorAreaWidth?c}" height="${editorAreaHeight?c}" version="1.1" xmlns="http://www.w3.org/2000/svg">
  	<defs>
    	<linearGradient id="feature" x1="0" x2="0" y1="0" y2="1">
        	<stop offset="0%" stop-color="<@cssRGBAColor color=theme.featureNameAreaPrimaryColor />"/>
        	<stop offset="100%" stop-color="<@cssRGBAColor color=theme.featureNameAreaSecondaryColor />"/>
      	</linearGradient>
      	
      	<linearGradient id="version" x1="0" x2="0" y1="0" y2="1">
        	<stop offset="0%" stop-color="<@cssRGBAColor color=theme.versionTrianglePrimaryColor />"/>
        	<stop offset="100%" stop-color="<@cssRGBAColor color=theme.versionTriangleSecondaryColor />"/>
      	</linearGradient>
      	
      	<linearGradient id="version_area" x1="0" x2="0" y1="0" y2="1">
        	<stop offset="0%" stop-color="<@cssRGBAColor color=theme.featureVersionAreaPrimaryColor />"/>
        	<stop offset="100%" stop-color="<@cssRGBAColor color=theme.featureVersionAreaSecondaryColor />"/>
      	</linearGradient>
      	
      	<linearGradient id="modifier_optional" x1="0" x2="0" y1="0" y2="1">
        	<stop offset="0%" stop-color="<@cssRGBAColor color=theme.featureOptionalPrimaryColor />"/>
        	<stop offset="100%" stop-color="<@cssRGBAColor color=theme.featureOptionalSecondaryColor />"/>
      	</linearGradient>
      	
      	<linearGradient id="modifier_mandatory" x1="0" x2="0" y1="0" y2="1">
        	<stop offset="0%" stop-color="<@cssRGBAColor color=theme.featureMandatoryPrimaryColor />"/>
        	<stop offset="100%" stop-color="<@cssRGBAColor color=theme.featureMandatorySecondaryColor />"/>
      	</linearGradient>

      	<linearGradient id="group_modifier" x1="0" x2="0" y1="0" y2="1">
        	<stop offset="0%" stop-color="<@cssRGBAColor color=theme.groupOrPrimaryColor />"/>
        	<stop offset="100%" stop-color="<@cssRGBAColor color=theme.groupOrSecondaryColor />"/>
      	</linearGradient>
      	
      	<linearGradient id="group_modifier_alternative" x1="0" x2="0" y1="0" y2="1">
        	<stop offset="0%" stop-color="<@cssRGBAColor color=theme.groupAlternativePrimaryColor />"/>
        	<stop offset="100%" stop-color="<@cssRGBAColor color=theme.groupAlternativeSecondaryColor />"/>
      	</linearGradient>
 	</defs>
  
	
	<@feature rootFeature />
	<#list groups as child>
    	<@group child />
    </#list>

	<@enum enums />
</svg>

