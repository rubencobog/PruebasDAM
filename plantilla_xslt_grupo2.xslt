<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="text" encoding="UTF-8"/>

  <xsl:template match="/">
    <xsl:text>TipoRegistro,NombreRuta,Autor,EnlaceWikiloc,FechaCreacionGPX&#10;</xsl:text>
  
    <xsl:for-each select="metadata">
      <xsl:text>InfoGeneral,</xsl:text>
      <xsl:value-of select="name"/><xsl:text>;</xsl:text>
      <xsl:value-of select="author"/><xsl:text>;</xsl:text>
      <xsl:value-of select="link"/><xsl:text>;</xsl:text>
      <xsl:value-of select="time"/><xsl:text>&#10;</xsl:text>

      <xsl:text>TipoRegistro,Latitud,Longitud,Elevacion,Timestamp&#10;</xsl:text>
      <xsl:for-each select="gpx/wpt[type='interes']">
        <xsl:text>Trackpoint;</xsl:text>
        <xsl:value-of select="@lat"/><xsl:text>;</xsl:text>
        <xsl:value-of select="@lon"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ele"/><xsl:text>;</xsl:text>
        <xsl:value-of select="time"/><xsl:text>&#10;</xsl:text>
        </xsl:for-each>
      

      <xsl:text>TipoRegistro,Latitud,Longitud,Elevacion,Timestamp,Nombre,Descripcion&#10;</xsl:text>
      <xsl:for-each select="gpx/wpt[type='peligro']">
        <xsl:text>Waypoint,</xsl:text>
        <xsl:value-of select="@lat"/><xsl:text>;</xsl:text>
        <xsl:value-of select="@lon"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ele"/><xsl:text>;</xsl:text>
        <xsl:value-of select="time"/><xsl:text>;</xsl:text>
        <xsl:value-of select="name"/><xsl:text>;</xsl:text>
        <xsl:value-of select="desc"/><xsl:text>&#10;</xsl:text>
      </xsl:for-each>
      
    </xsl:for-each>
  </xsl:template>

</xsl:stylesheet>