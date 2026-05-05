# Uranzu Transporte Logístico — Entrega Sprint 3

## ¿Qué se ha hecho?

Se ha integrado consumo dinámico de datos en la web del Sprint anterior (Sprint 2) mediante `fetch()` en JavaScript puro. Se ha añadido una nueva sección **"Destinos Internacionales"** que consume una API pública y gratuita en tiempo real.

---

## Integrante y API asignada

| Integrante | API utilizada | Tipo de operación |
|---|---|---|
| Erik | REST Countries (`restcountries.com`) | GET (búsqueda y filtro) |

---

## API utilizada

**REST Countries**
- Web oficial: https://restcountries.com
- Sin registro, sin API key, completamente gratuita
- Formato de respuesta: JSON

### Endpoints utilizados

| Endpoint | Descripción |
|---|---|
| `GET /v3.1/name/{nombre}` | Busca países por nombre (parcial o completo) |
| `GET /v3.1/region/{region}` | Filtra todos los países de una región geográfica |

Parámetro `?fields=` utilizado para reducir el payload a los campos necesarios:
```
name, flags, capital, region, subregion, currencies, languages, population
```

---

## Funcionalidades implementadas

- **Búsqueda por nombre**: el usuario escribe un nombre de país (en inglés) y pulsa Buscar o Enter.
- **Filtro por región**: desplegable con Europa, América, Asia, África y Oceanía.
- **Carga automática**: al abrir la página se cargan los países de Europa por defecto.
- **Estado de carga**: spinner animado + texto "Cargando destinos…" mientras se hace el fetch.
- **Gestión de errores**:
  - `response.ok` comprobado antes de parsear el JSON.
  - Error 404 → mensaje claro al usuario ("No se encontró ningún país").
  - Error de red / servidor → mensaje genérico sin romper la página.
- **Resultados**: cards con bandera (emoji), nombre, capital, moneda, idioma, población y región. Ordenados alfabéticamente. Máximo 48 resultados mostrados.

---

## Capturas / evidencias

> Sección visible en `sprint3_final.html` → sección `#destinos`.

- Carga inicial → Europa (47 países)
- Búsqueda "Spain" → 1 resultado con bandera 🇪🇸, capital Madrid, EUR
- Filtro "América" → lista de países americanos
- Búsqueda inválida "xxxxxyyy" → mensaje de error, página no se rompe

---

## Código relevante

**Archivo principal:** `sprint3_final.html`
- Sección HTML: etiqueta `<section id="destinos">`
- JavaScript: bloque `<script>` al final del body

**Funciones principales del JS:**

```js
buscarPaises()      // lógica fetch + response.ok + parseo JSON
renderizarPaises()  // pinta el grid de cards
crearCardPais()     // construye el HTML de una card
mostrarCargando()   // muestra spinner
mostrarError()      // muestra error sin romper la página
ocultarEstado()     // oculta el estado tras recibir resultados
```

---

## Problemas encontrados y solución

| Problema | Solución |
|---|---|
| `currencies` y `languages` tienen claves dinámicas en el JSON (no son arrays) | `Object.values(pais.currencies)` para iterar sin conocer la clave |
| La API devuelve 404 cuando no hay resultados (en vez de array vacío) | Se comprueba `respuesta.status === 404` dentro del bloque `if (!respuesta.ok)` |
| Cargar todos los países (`/all`) satura la UI con 250 entradas | Se usa `/region/Europe` como carga inicial y se limita el render a 48 |
| El campo `capital` puede ser `undefined` en algunos territorios | Uso de optional chaining `pais.capital?.[0] ?? 'Sin capital'` |

---

## Estructura de archivos

```
/
├── sprint3_final.html       ← Web principal con la sección de API (este sprint)
├── sprint2_final.html       ← Web base del sprint anterior
├── login_final.html
├── registro_final.html
├── exito_inicio_final.html
├── stylesprint.css
├── validar.js
├── uranzu.xml
├── validacion.xsd
├── transformacion.xsl
├── uranzu_transformado.html
├── camion.jpg
├── uranzu_flota.jpg
└── README.md
```
