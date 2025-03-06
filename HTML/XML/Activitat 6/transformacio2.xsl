<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h1>Vendes</h1>
                <table border="1">
                    <tr>
                        <th>ID Venda</th>
                        <th>Producte</th>
                        <th>Data Venda</th>
                        <th>Quantitat</th>
                        <th>Venedor</th>
                    </tr>
                    <xsl:for-each select="//venda">
                        <tr>
                            <td><xsl:value-of select="@id"/></td>
                            <td><xsl:value-of select="@producte_ref"/></td>
                            <td><xsl:value-of select="@data_venda"/></td>
                            <td><xsl:value-of select="@quantitat"/></td>
                            <td><xsl:value-of select="@venedor"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>