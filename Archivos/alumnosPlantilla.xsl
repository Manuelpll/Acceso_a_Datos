<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    
    <xsl:template match='/'>
        <html>
            <head>
                <title>LISTADO DE ALUMNOS</title>
            </head>
            <body>
                <h1>LISTA DE ALUMNOS</h1>
                <table border='1'>
                    <tr>
                        <th>Nombre</th>
                        <th>Edad</th>
                    </tr>
                    <xsl:apply-templates select='listadealumnos/alumno' />
                </table>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match='alumno'>
        <tr>
            <xsl:apply-templates select='nombre | edad'/>
        </tr>
    </xsl:template>
    
    <xsl:template match='nombre | edad'>
        <td><xsl:value-of select='.'/></td>
    </xsl:template>

</xsl:stylesheet>
