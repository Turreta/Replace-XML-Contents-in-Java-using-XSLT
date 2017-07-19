<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="xml" indent="yes"/>

  <xsl:param name="headingPrefix"/>
  <xsl:param name="bodyDisclaimer"/>

  <xsl:template match="@* | node()">
    <xsl:copy>
      <xsl:apply-templates select="@* | node()"/>
    </xsl:copy>
  </xsl:template>

  <xsl:template match="*[local-name()='heading']">
    <xsl:copy>
      <xsl:value-of select="concat($headingPrefix, ':', text())"/>
    </xsl:copy>

  </xsl:template>

  <xsl:template match="*[local-name()='body']">
    <xsl:copy>
      <xsl:value-of select="concat(text(), ' ', $bodyDisclaimer)"/>
    </xsl:copy>
  </xsl:template>

</xsl:stylesheet>