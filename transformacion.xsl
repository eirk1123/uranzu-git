<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

  <xsl:template match="/">
    <html lang="es">
      <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Clientes - Uranzu</title>

        <!-- Bootstrap (solo para dar estilo rápido a la tabla) -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>

        <!-- Vuestro CSS de la web para mantener coherencia visual -->
        <link rel="stylesheet" href="stylesprint.css"/>
      </head>

      <body>
        <header>
          <div class="top-bar">
            <div class="logo">
              <h1>Uranzu Transporte Logístico</h1>
              <p>Clientes (generado desde XML + XSLT)</p>
            </div>
          </div>
          <nav>
            <ul>
              <li><a href="sprint2.html" class="btn">Volver a la web</a></li>
            </ul>
          </nav>
        </header>

        <main class="container my-4">
          <section class="p-4">
            <h2>Listado de clientes</h2>
            <p class="mb-3">Este HTML se genera automáticamente aplicando <strong>transformacion.xsl</strong> sobre <strong>uranzu.xml</strong>.</p>

            <div class="table-responsive">
              <table class="table table-striped table-hover align-middle">
                <thead class="table-dark">
                  <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Teléfono</th>
                    <th>Empresa</th>
                    <th>Ciudad</th>
                    <th>Servicio</th>
                    <th>Alta</th>
                  </tr>
                </thead>
                <tbody>
                  <xsl:for-each select="uranzu/clientes/cliente">
                    <xsl:sort select="nombre"/>
                    <tr>
                      <td><xsl:value-of select="@id"/></td>
                      <td><xsl:value-of select="nombre"/></td>
                      <td><xsl:value-of select="email"/></td>
                      <td><xsl:value-of select="telefono"/></td>
                      <td><xsl:value-of select="empresa"/></td>
                      <td><xsl:value-of select="ciudad"/></td>
                      <td><xsl:value-of select="tipoServicio"/></td>
                      <td><xsl:value-of select="fechaAlta"/></td>
                    </tr>
                  </xsl:for-each>
                </tbody>
              </table>
            </div>
          </section>
        </main>

        <footer>
          <p>© 2025 Uranzu Transporte Logístico</p>
        </footer>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
