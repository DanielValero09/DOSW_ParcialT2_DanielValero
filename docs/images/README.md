# Inventario de evidencias auténticas

Auditoría del 12 de octubre de 2026. Antes de esta revisión, `docs/images/` contenía únicamente `.gitkeep` (0 bytes). No se encontraron capturas en este repositorio, incluidas las rutas no versionadas fuera de los generados. Los iconos del reporte JaCoCo en `target/` son recursos del reporte, no capturas de ejecución. No se importaron imágenes de otros repositorios ni se generaron imágenes, archivos PNG vacíos o simulaciones.

Se conserva una estructura plana en `docs/images/`, con prefijo numérico y nombres descriptivos en minúsculas separados por guiones. **Todos los nombres siguientes son sugerencias de archivos pendientes; no son enlaces a imágenes existentes.**

| ID | Nombre sugerido | Estado de captura | Contenido auténtico requerido |
|---|---|---|---|
| E01 | `01-maven-build-success.png` | Pendiente | Terminal con `mvn clean verify`, 7 pruebas sin fallos y BUILD SUCCESS; contexto del proyecto visible |
| E02 | `02-jacoco-reporte.png` | Pendiente | Reporte real del proyecto y líneas 17/19; distinguir 89,47 % LINE del 94 % de instrucciones mostrado en el HTML |
| E03 | `03-docker-contenedor.png` | Pendiente | Contenedor del parcial activo, imagen y mapeo de puertos; health local HTTP 200 si cabe en la captura |
| E04 | `04-dockerhub-imagen-publicada.png` | Pendiente | Repositorio real de Docker Hub, propietario, etiqueta y digest de la imagen publicada por Actions |
| E05 | `05-github-actions-develop.png` | Pendiente | Ejecución de `develop`, SHA y jobs `test`, `docker`, `deploy_develop` exitosos; `deploy_main` omitido |
| E06 | `06-azure-health-http-200.png` | Pendiente | URL pública completa, GET `/api/v1/health`, HTTP 200 y JSON `status=UP`, `service=DOSW-ParcialT2` |
| E07 | `07-azure-swagger-ui.png` | Pendiente | Barra de URL del dominio Azure y Swagger cargado con el endpoint health |
| E08 | `08-mongodb-atlas-cluster.png` | Pendiente | Clúster DOSW-ParcialT2 real y su estado; sin URI autenticada ni credenciales visibles |
| E09 | `09-azure-mongodb-conexiones.png` | Pendiente | Logs auténticos del driver desde App Service que muestran conexiones al primario y dos secundarios; no presentarlos como ping autenticado |
| E10 | `10-cuenta-uml.png` | Pendiente | Acceso real a la herramienta seleccionada: Lucidchart, Draw.io o Miro |
| E11 | `11-cuenta-figma.png` | Pendiente | Acceso real a Figma con la cuenta del estudiante |

Maven y JaCoCo fueron comprobados localmente en esta auditoría. Docker, Actions, Docker Hub, Azure y los logs Atlas tienen resultados confirmados por el estudiante, pero sus capturas no se encuentran aquí. La selección/acceso UML y el acceso a Figma no están verificados. Consultar la [tabla de cumplimiento](../reporte-final-prerrequisitos.md#tabla-de-cumplimiento).

Para incorporar cada evidencia, el estudiante debe obtener una captura auténtica, comprobar que corresponde a este proyecto y ocultar secretos antes de guardarla. Conservar el contexto que permite verificar el resultado. No mostrar contraseñas, tokens, JSON del Service Principal, URIs MongoDB autenticadas ni identificadores privados de suscripción o tenant. Solo entonces insertar la referencia Markdown a la imagen existente en la sección correspondiente del [README](../../README.md) y actualizar este inventario.

Registrar junto a las capturas de Actions y Docker Hub el enlace de ejecución, fecha, SHA, etiqueta y digest. No se conoce todavía el usuario Docker Hub ni la etiqueta/digest publicados; no deducirlos del usuario GitHub. Mantener por separado una futura evidencia de ping o lectura autenticada contra Atlas desde Azure, todavía pendiente de verificación. La conexión de monitoreo y el health público no sustituyen esa comprobación.
