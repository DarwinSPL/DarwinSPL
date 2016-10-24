<?xml version="1.0" encoding="ASCII"?>
<feature:DEFeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://deltaecore.org/feature/1.0">
  <rootFeature minCardinality="1" maxCardinality="1" name="Car">
    <groups maxCardinality="2">
      <features maxCardinality="1" name="Assistance">
        <groups maxCardinality="2">
          <features maxCardinality="1" name="Park Assistance"/>
          <features maxCardinality="1" name="ACC"/>
        </groups>
      </features>
      <features maxCardinality="1" name="Distance Sensors">
        <groups maxCardinality="1">
          <features maxCardinality="1" name="Side Distance Sensor"/>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <features maxCardinality="1" name="Fast Front Distance Sensor"/>
          <features maxCardinality="1" name="Slow Front Distance Sensor"/>
        </groups>
      </features>
    </groups>
  </rootFeature>
</feature:DEFeatureModel>
