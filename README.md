# Uranzu Transporte Logístico — Entrega Sprint 3

## Integrantes y APIs

| Integrante | API | Endpoint principal |
|---|---|---|
| Erik | REST Countries | `https://restcountries.com/v3.1/` |
| Arturo | Open-Meteo | `https://api.open-meteo.com/v1/forecast` |
| Unai | ExchangeRate API | `https://open.er-api.com/v6/latest/{moneda}` |

Las tres APIs son **públicas, gratuitas y sin API key**.

---

## Secciones implementadas

### Erik — Destinos Internacionales (REST Countries)
- Búsqueda de países por nombre (en inglés)
- Filtro por región: Europa, América, Asia, África, Oceanía
- Cards con: bandera, capital, moneda, idioma, población
- Carga inicial automática con países de Europa
- Endpoints: `/name/{nombre}` y `/region/{region}`

### Arturo — Clima en Destinos (Open-Meteo)
- Búsqueda de clima por nombre de ciudad
- Geocoding automático para obtener coordenadas (Open-Meteo Geocoding API)
- Muestra: temperatura, condición, viento, sensación térmica
- Botones de acceso rápido (Madrid, París, Berlín, Londres, Lisboa, Roma)
- Carga inicial automática con Madrid
- Endpoints: `/v1/search` (geocoding) + `/v1/forecast` (clima)

### Unai — Divisas Internacionales (ExchangeRate API)
- Selector de moneda base (EUR, USD, GBP, CHF, JPY, CNY)
- Tabla con 14 monedas principales y sus tasas
- Conversor interactivo entre cualquier par de monedas
- Muestra fecha de última actualización
- Carga inicial automática con EUR como base
- Endpoint: `/v6/latest/{moneda}`

---

## Requisitos cumplidos

- ✅ `fetch()` con `async/await` en las tres secciones
- ✅ `response.ok` comprobado antes de parsear JSON
- ✅ Estado "Cargando…" con spinner animado
- ✅ Mensajes de error claros sin romper la página
- ✅ Interacción del usuario (búsqueda, filtros, conversión, botones rápidos)
- ✅ Código organizado en funciones con nombres claros y comentarios
- ✅ Diseño integrado en el estilo de la web (rojo/azul, mismo CSS)

---

## Problemas encontrados y solución

| Problema | Solución |
|---|---|
| `currencies` y `languages` en REST Countries tienen claves dinámicas | `Object.values()` para iterar sin conocer el nombre de la clave |
| REST Countries devuelve 404 cuando no hay resultados | Comprobar `res.status === 404` dentro del bloque `if (!res.ok)` |
| Open-Meteo necesita coordenadas, no nombre de ciudad | Petición previa a la Geocoding API para obtener lat/lon |
| Códigos WMO del clima no son legibles directamente | Mapa estático de código → emoji + descripción en español |
| ExchangeRate no devuelve tasas relativas entre dos monedas | Conversión manual: `cantidad / tasaOrigen * tasaDestino` |
| GitHub Pages daba 404 porque los archivos estaban en subcarpeta | Mover todos los archivos a la raíz del repositorio |

---

## Estructura del proyecto

```
/
├── index.html               ← Web completa con las tres secciones API
├── stylesprint.css          ← Estilos globales
├── login_final.html
├── registro_final.html
├── exito_inicio_final.html
├── uranzu.xml
├── validacion.xsd
├── transformacion.xsl
├── uranzu_transformado.html
├── validar.js
├── camion.jpg
├── uranzu_flota.jpg
└── README.md
```

---

## URLs

- **Repositorio:** https://github.com/eirk1123/uranzu-git
- **Web en vivo:** https://eirk1123.github.io/uranzu-git/
