# Inventario de evidencias auténticas

Revisión del **12 de octubre de 2026**. Se encontraron **11 imágenes PNG**, además de este README y `.gitkeep` (0 bytes). Todas se decodificaron y visualizaron; sus nombres originales se conservan. No se crearon, reconstruyeron ni retocaron capturas.

**Resultado: nueve imágenes integradas en el [README principal](../../README.md), dos excluidas de publicación por datos privados y una captura solicitada ausente (`azure-health-200.png`).** La imagen existente de Swagger es un recorte de respuesta y no sustituye las vistas completas pendientes de health y Swagger en Azure.

## Inventario y alcance

Los tamaños se expresan en bytes exactos. Los enlaces de las imágenes aprobadas permiten abrirlas desde GitHub; las imágenes rechazadas se mencionan sin enlace.

| ID | Archivo real | Tamaño | Dimensiones | Integración / contenido verificable |
|---|---|---:|---|---|
| E01 | [maven-build-success.png](maven-build-success.png) | 135158 | 847 × 645 | README §8: BUILD SUCCESS, siete pruebas sin fallos y JAR. Captura: 21,323 s, 12/10/2026 23:26:28 -05:00; distinta de la validación actual |
| E02 | [jacoco-cobertura.png](jacoco-cobertura.png) | 29248 | 956 × 255 | README §8: 2 líneas sin cubrir de 19; 89,47 % de líneas. El 94 % visible es instrucciones |
| E03 | [docker-container-running.png](docker-container-running.png) | 116561 | 1012 × 783 | README §9: contenedor activo con prefijo dosw-parcial-wi y 8081:8080. Parcial: nombres/tag truncados, sin build ni health HTTP |
| E04 | [dockerhub-image.png](dockerhub-image.png) | 100383 | 911 × 952 | README §10: danielvalero09/dosw-parcial-t2 y cuatro tags, incluido develop. Etiquetas únicas truncadas; API pública aporta valor completo/digest |
| E05 | [github-actions-success.png](github-actions-success.png) | 49659 | 913 × 527 | README §10: Success, develop, SHA 80cc2b1, intento 4; test/docker/deploy_develop verdes y deploy_main omitido |
| E06 | `azure-health-200.png` | — | — | **Ausente**. Falta captura completa con dominio Azure, GET /api/v1/health, 200 y JSON visibles |
| E07 | [azure-swagger.png](azure-swagger.png) | 9783 | 857 × 143 | README §3, una sola vez: 200 y JSON status=UP/service=DOSW-ParcialT2. Sin dominio, endpoint ni UI completa; no verifica origen Azure o Swagger cargado |
| E08 | [mongodb-atlas-cluster.png](mongodb-atlas-cluster.png) | 79563 | 925 × 937 | README §3: DOSW-ParcialT2, Azure California (westus), Free, primario y dos secundarios visibles |
| E09 | [azure-mongodb-connection.png](azure-mongodb-connection.png) | 213551 | 940 × 983 | README §3: monitor del driver conectado al primario y dos secundarios desde App Service; **no prueba lectura/escritura ni ping autenticado** |
| E10 | [uml-herramienta.png](uml-herramienta.png) | 166963 | 1916 × 1192 | README §11: editor app.diagrams.net disponible, lienzo vacío. No acredita cuenta autenticada ni UML terminado |
| E11 | `figma-cuenta.png` | 208768 | 932 × 990 | **Excluida:** correo personal visible. Sesión de Daniel Valero y archivos recientes observados; sin prototipo terminado del parcial |
| E12 | `azure-app-service.png` | 118662 | 945 × 936 | **Excluida:** identificador privado de suscripción visible. App Service Linux, West US y contenedor observados; falta versión publicable |

Total: **1228299 bytes (1,17 MiB)**; nueve imágenes aprobadas: **900869 bytes (0,86 MiB)**. Máximo: **213551 bytes (208,55 KiB)**. Ninguna requiere reducción por tamaño. Los 11 SHA256 son distintos: no hay duplicados exactos; la inspección visual no encontró capturas redundantes.

## Privacidad y protección local

Se revisó cada captura visualmente. No se observaron contraseñas, tokens, claves ni URI MongoDB con credenciales en las nueve imágenes aprobadas. Los logs muestran hostnames y metadatos de topología de Atlas, sin usuario o contraseña; esos datos técnicos no se interpretan como credenciales. Las capturas Maven/Docker también contienen contexto local necesario para identificar el proyecto.

`azure-app-service.png` y `figma-cuenta.png` **ya estaban preparadas en el índice al comenzar**. Se retiraron únicamente esas dos rutas con `git restore --staged -- ...`, sin borrar ni alterar las imágenes. Se añadieron exclusiones locales exactas en `.git/info/exclude` para impedir su incorporación ordinaria accidental. Este archivo no se versiona ni protege otros clones; no forzar la incorporación de los originales.

No se enlazan ni se recomiendan para commit. Requieren saneamiento y autorización antes de publicar; se conservaron los originales locales. No se copian a los documentos los valores privados detectados.

## Trazabilidad remota comprobada

Consultas públicas de solo lectura, sin autenticación ni cambios externos:

- [Actions: ejecución 38341584719](https://github.com/DanielValero09/DOSW_ParcialT2_DanielValero/actions/runs/38341584719). La [API del intento 4](https://api.github.com/repos/DanielValero09/DOSW_ParcialT2_DanielValero/actions/runs/38341584719/attempts/4) confirma SHA `80cc2b1036b5e18819a37b54c3f711c75b6bf651`, evento push y Success; inicio 12/10/2026 **22:49:48 -05:00**. La [API de jobs](https://api.github.com/repos/DanielValero09/DOSW_ParcialT2_DanielValero/actions/runs/38341584719/attempts/4/jobs) confirma test/docker/deploy_develop success y deploy_main skipped. No corresponde al HEAD documental `173b6b8`.
- [Docker Hub: danielvalero09/dosw-parcial-t2](https://hub.docker.com/r/danielvalero09/dosw-parcial-t2). La [API pública de tags](https://hub.docker.com/v2/repositories/danielvalero09/dosw-parcial-t2/tags?page_size=10) confirma Linux AMD64, etiqueta `develop-80cc2b1036b5e18819a37b54c3f711c75b6bf651-38341584719-4` y digest `sha256:09923bf86f29d7656421d2bbab91f0dee254dc1cf6857b5dd1cf88e27c5ab573`. Publicación: 12/10/2026 **22:50:54 -05:00**; alias develop con el mismo digest al consultar. La captura por sí sola no muestra los identificadores completos. No se verificó el digest activo en Azure.

El acceso web inicial a las páginas HTML no estuvo disponible mediante la herramienta de consulta; los datos anteriores se obtuvieron de las APIs públicas. No se dedujeron URLs de run ni etiquetas únicas a partir de recortes.

## Pendientes de evidencia

1. Captura App Service publicable, sin identificador privado; captura Figma publicable, sin correo personal, con saneamiento y autorización.
2. Health Azure con dominio, ruta, código 200 y JSON; Swagger UI completa con URL pública y endpoint visibles.
3. Docker local con nombre e imagen completos, estado activo, puertos y health HTTP; log del build local si se exige su resultado separado.
4. Operación autenticada contra Atlas desde Azure: evidencia independiente de ping o lectura no destructiva, sin revelar credenciales. Monitoreo del driver y health no sustituyen esta comprobación.
5. Confirmación de cuenta UML si el profesor la requiere; Draw.io accesible no implica una cuenta autenticada.

El acceso del profesor sigue **pendiente**. Consultar el [reporte de auditoría](../reporte-final-prerrequisitos.md) para los demás pendientes manuales y la lista exacta del commit recomendado.
