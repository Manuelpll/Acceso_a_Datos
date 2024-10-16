<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    
    <!-- Plantilla de salida en formato HTML -->
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>
    
    <!-- Plantilla principal que transforma el XML -->
    <xsl:template match="/Canciones">
        <html>
            <head>
                <title>Lista de Canciones</title>
                <style>
                    table {
                        border: 4px solid blue;
                        border-collapse: collapse;
                        width: 100%;
                    }
                    th, td {
                        border: 1px solid black;
                        padding: 8px;
                        text-align: center;
                    }
                    th {
                        background-color: #f2f2f2;
                    }
                </style>
            </head>
            <body>
                <h2>Lista de Canciones</h2>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Año</th>
                        <th>Título</th>
                        <th>Artista</th>
                        <th>Duración</th>
                        <th>Es Española</th>
                    </tr>
                    <!-- Ciclo para cada canción en el XML -->
                    <xsl:for-each select="cancion">
                        <tr>
                            <td><xsl:value-of select="id"/></td>
                            <td><xsl:value-of select="año"/></td>
                            <td>
                                <!-- Mostrar "Sin título" si no hay título -->
                                <xsl:choose>
                                    <xsl:when test="titulo">
                                        <xsl:value-of select="titulo"/>
                                    </xsl:when>
                                    <xsl:otherwise>Sin título</xsl:otherwise>
                                </xsl:choose>
                            </td>
                            <td><xsl:value-of select="artista"/></td>
                            <td><xsl:value-of select="duracion"/></td>
                            <td>
                                <!-- Condicional para mostrar Si/No en vez de true/false -->
                                <xsl:choose>
                                    <xsl:when test="Es_Española = 'true'">Sí</xsl:when>
                                    <xsl:otherwise>No</xsl:otherwise>
                                </xsl:choose>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
