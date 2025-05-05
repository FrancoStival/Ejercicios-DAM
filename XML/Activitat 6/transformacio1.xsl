<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h1>Llista de Productes</h1>
                <ul>
                    <xsl:for-each select="//producte">
                        <li>
                            <strong>Nom:</strong> <xsl:value-of select="@nom"/>,
                            <strong>Esport:</strong> <xsl:value-of select="@esport"/>,
                            <strong>Preu:</strong> <xsl:value-of select="@preu"/>
                        </li>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>