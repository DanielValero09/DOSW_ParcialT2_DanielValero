# Auditoría previa al primer commit de la base

Revisión CI/CD y comprobaciones locales del 10 de octubre de 2026 (America/Bogota). Rama: `develop`. Esta auditoría prepara una lista revisable; no se ejecutó `git add`, commit, push, merge, publicación en Docker Hub ni despliegue Azure. Las comprobaciones del servicio del apartado siguiente son antecedentes del 9 de octubre; no se repitieron en esta revisión.

## Resultado de esta revisión

Se contrastó el workflow con `C:/Users/Daniel/Downloads/parcial-t2-prerequisitos.html`: las secciones 6 y 7 exigen build, pruebas, imagen, publicación Docker Hub y despliegue Azure, con ejecución verde después de push a `develop`. Todas esas etapas permanecen activas para ambas ramas. No se oculta la falta de credenciales mediante jobs omitidos ni `continue-on-error`.

| Validación ejecutada | Resultado |
|---|---|
| `actionlint .github/workflows/ci-cd.yml`, versión 1.7.12 | Salida 0, sin errores. ShellCheck no está instalado localmente; no se declara validado por ShellCheck. |
| `mvn clean verify`, Maven 3.9.16, Java Oracle 21.0.10 | Salida 0, BUILD SUCCESS; 24,347 s; 7 pruebas, 0 fallos, 0 errores, 0 omitidas. |
| Surefire XML | SecurityConfigurationTest: 5; HealthControllerTest: 1; HealthControllerWebTest: 1; todos sin fallos, errores ni omisiones. |
| JaCoCo HTML y XML | Ambos existen; 4 clases analizadas. Líneas 17/19 (89,47 %), instrucciones 82/87 (94,25 %), métodos 10/11 (90,91 %), clases 4/4 (100 %). No hay contador de ramas ni umbral mínimo configurado. |
| `docker build -t dosw-parcial:cicd-validation .` | Salida 0; imagen local Linux AMD64. El builder ejecutó clean verify con Java 21.0.12.1: BUILD SUCCESS; 7 pruebas, 0 fallos, 0 errores, 0 omitidas. |
| `git diff --check`, revisión de diff y estado | Sin errores de whitespace; advertencias informativas LF/CRLF. Índice sin cambios preparados. |
| README | Conserva índice y las 11 secciones numeradas exigidas. |
| Candidatos y secretos | 45 archivos revisados, únicamente del parcial; sin coincidencias de patrones de credenciales reales y sin credenciales detectadas en la lectura del código/configuración. Esta revisión no acredita revocación ni validez de credenciales externas. |

Maven mostró avisos sobre la carga dinámica del agente Mockito/Byte Buddy en Java 21 y sobre Swagger/OpenAPI habilitados. No provocaron fallos; Swagger público es requisito del parcial. Los tests actuales no consultan MongoDB ni acreditan conexión remota.

Cambios realizados en esta tarea: `.github/workflows/ci-cd.yml`, `Dockerfile`, `.gitignore`, `.dockerignore`, `README.md` y este documento. No se modificaron `pom.xml`, `.env.example`, clases Java ni pruebas. Los demás archivos nuevos ya existían al comenzar.

Git muestra `develop...origin/develop`, con 2 archivos rastreados modificados y 43 archivos nuevos, sin staging. Ya existe el commit inicial del repositorio `f5a52cb8cf4ab7f54e09e8e2b2aa312312c9c1ac` (README/.gitignore): el commit pendiente es el primero de la implementación. HEAD y `main` apuntan a ese commit; no se modificó `main`. El hash SHA256 del índice leído durante la revisión es `3E52B57C43B4778196E71C48C4B97741AB5E39D56D577A74E3F2833A5B84EB25`.

## Antecedentes: servicio local y comprobaciones del 9 de octubre

Imagen local: `dosw-parcial:local`, Linux AMD64, Java 21. Contenedor: `dosw-parcial-win-b703a72a`. Mapeo comprobado: `127.0.0.1:8081:8080`. Spring Boot conserva el puerto interno 8080. El JWT temporal se generó con 32 bytes aleatorios y se pasó por entorno; su valor no se imprimió ni se guardó en el repositorio.

Peticiones realizadas desde PowerShell a `http://localhost:8081`, sin credenciales:

| Ruta | HTTP | Comprobación |
|---|---|---|
| `/api/v1/health` | 200 | JSON: `status=UP`, `service=DOSW-ParcialT2` |
| `/swagger-ui/index.html` | 200 | HTML de Swagger UI |
| `/v3/api-docs` | 200 | JSON OpenAPI que documenta GET health |
| `/v3/api-docs.yaml` | 200 | YAML OpenAPI que documenta GET health |
| `/api/v1/recurso-protegido` | 403 | Solicitud anónima bloqueada |

PowerShell entregó el contenido `application/vnd.oai.openapi` como `System.Byte[]`; se decodificó a UTF-8 para comprobar el YAML. La primera comprobación textual produjo un falso negativo; no requirió cambios en la aplicación.

MongoDB existente reutilizado: `american-bites-mongo`, versión 7.0.43, publicado en el puerto 27017. URI del contenedor DOSW: `mongodb://host.docker.internal:27017/dosw_parcial?serverSelectionTimeoutMS=5000&connectTimeoutMS=5000`, sin credenciales reales. Los logs del cliente Spring mostraron conexión. Una sonda temporal dentro del nuevo contenedor, con el driver MongoDB 5.5.2 de la imagen y la misma variable `MONGODB_URI`, confirmó ping `ok=1` y lectura de metadatos (`listCollections`). No se escribieron documentos ni se crearon colecciones. Esto es independiente del endpoint health.

Se conservaron los identificadores, servicios y puertos de American Bites; no se detuvieron ni eliminaron contenedores o volúmenes existentes.

## Archivos y Git

Al iniciar esta revisión: `.gitignore` y `README.md` tenían modificaciones y había 43 archivos nuevos sin seguimiento, incluida esta auditoría. Ningún archivo estaba en staging. La lista final conserva **45 archivos**, de los cuales **2 son actualizaciones de archivos rastreados y 43 son nuevos**. Los `.gitkeep` vacíos conservan el scaffolding exigido por el HTML; no se detectaron archivos innecesarios entre los candidatos.

Las exclusiones se comprobaron con `git check-ignore`: `.env`, `.env.local`, `.env.production`, certificados/claves `*.p12`, `*.pem`, `*.key`, `*.jks`, `*.pfx`, perfiles de publicación, `azure-credentials.json`, `service-principal.json`, `target/`, `.idea/`, `.vscode/`, `.azure/`, `.aws/`, `.docker/`, `.codex/` y `.agents/` están ignorados. `.env.example` es la excepción intencionada y contiene únicamente marcadores de ejemplo y valores locales. Tampoco figuran archivos de IDE o generados en la lista del commit. No se detectaron URIs MongoDB con usuario/contraseña, claves privadas, tokens GitHub/Docker Hub/AWS con formatos conocidos, JWT reales o literales Azure `clientSecret` en los 45 candidatos. No deben guardarse secretos bajo otros nombres ni dentro de archivos fuente; los patrones de ignore no sustituyen su revisión.

Se revisó `.dockerignore`, que excluye Git, workflow, IDE, `target/`, documentación, archivos de entorno y claves/certificados privados contemplados. El Dockerfile copia únicamente `pom.xml` y `src` a la etapa builder.

Maven y Docker se ejecutaron de nuevo en esta revisión, con los resultados detallados al inicio. Las capturas auténticas y la ejecución del pipeline remoto siguen pendientes. No se validaron de nuevo HTTP o MongoDB del contenedor existente, ni se arrancó la nueva imagen.

Lista exacta propuesta para el primer commit de la base:

```text
.dockerignore
.env.example
.github/workflows/ci-cd.yml
.gitignore
Dockerfile
README.md
docs/auditoria-primer-commit.md
docs/images/.gitkeep
docs/uml/.gitkeep
pom.xml
src/main/java/edu/dosw/parcial/config/SecurityConfig.java
src/main/java/edu/dosw/parcial/config/SwaggerConfig.java
src/main/java/edu/dosw/parcial/controller/HealthController.java
src/main/java/edu/dosw/parcial/controller/dtos/request/.gitkeep
src/main/java/edu/dosw/parcial/controller/dtos/response/.gitkeep
src/main/java/edu/dosw/parcial/controller/handlers/.gitkeep
src/main/java/edu/dosw/parcial/controller/mappers/.gitkeep
src/main/java/edu/dosw/parcial/core/models/.gitkeep
src/main/java/edu/dosw/parcial/core/services/.gitkeep
src/main/java/edu/dosw/parcial/core/utils/.gitkeep
src/main/java/edu/dosw/parcial/core/validators/.gitkeep
src/main/java/edu/dosw/parcial/main/ParcialApplication.java
src/main/java/edu/dosw/parcial/persistence/entities/.gitkeep
src/main/java/edu/dosw/parcial/persistence/mappers/.gitkeep
src/main/java/edu/dosw/parcial/persistence/repositories/.gitkeep
src/main/resources/application.yaml
src/test/java/edu/dosw/parcial/config/SecurityConfigurationTest.java
src/test/java/edu/dosw/parcial/controller/.gitkeep
src/test/java/edu/dosw/parcial/controller/HealthControllerTest.java
src/test/java/edu/dosw/parcial/controller/HealthControllerWebTest.java
src/test/java/edu/dosw/parcial/controller/dtos/request/.gitkeep
src/test/java/edu/dosw/parcial/controller/dtos/response/.gitkeep
src/test/java/edu/dosw/parcial/controller/handlers/.gitkeep
src/test/java/edu/dosw/parcial/controller/mappers/.gitkeep
src/test/java/edu/dosw/parcial/core/.gitkeep
src/test/java/edu/dosw/parcial/core/models/.gitkeep
src/test/java/edu/dosw/parcial/core/services/.gitkeep
src/test/java/edu/dosw/parcial/core/utils/.gitkeep
src/test/java/edu/dosw/parcial/core/validators/.gitkeep
src/test/java/edu/dosw/parcial/main/.gitkeep
src/test/java/edu/dosw/parcial/persistence/.gitkeep
src/test/java/edu/dosw/parcial/persistence/entities/.gitkeep
src/test/java/edu/dosw/parcial/persistence/mappers/.gitkeep
src/test/java/edu/dosw/parcial/persistence/repositories/.gitkeep
src/test/resources/.gitkeep
```

Las sondas Java y sus dependencias están en una carpeta temporal de Windows y en el contenedor nuevo; no forman parte del repositorio ni de esta lista. Tampoco deben incorporarse secretos reales, `target/`, archivos de IDE o datos/volúmenes Docker.

## Estrategia CI/CD aplicada a los archivos locales

El workflow anterior reutilizaba `latest` y el mismo App Service desde ambas ramas. Se corrigió para ejecutar el pipeline completo con destinos separados y la imagen exacta construida, sin reconstruirla durante la publicación. Las pruebas CI ya no necesitan el secret JWT de producción. La fase builder del Dockerfile ejecuta todas las pruebas, sin `-DskipTests`.

Estrategia resultante:

| Origen | CI | Publicación | Despliegue |
|---|---|---|---|
| Push a `develop` | Java 21, clean verify, JaCoCo/Surefire y build Docker con pruebas | `develop-<SHA>-<run_id>-<run_attempt>` y alias `develop` | `staging`, App Service `AZURE_WEBAPP_NAME_DEVELOP`, usando etiqueta única |
| Push a `main` | Mismas comprobaciones | `main-<SHA>-<run_id>-<run_attempt>`, alias `main` y `latest` | `production`, App Service `AZURE_WEBAPP_NAME_MAIN`, usando etiqueta única |
| Ejecución manual | Pipeline completo solo para main/develop | Según rama | Según rama |

El workflow valida que ambos nombres Azure están presentes y son distintos antes de publicar; repite la comprobación antes de desplegar. La concurrencia por rama usa `cancel-in-progress: false`: una ejecución activa no se interrumpe. GitHub no garantiza orden FIFO y puede reemplazar una ejecución pendiente; reejecutar un commit antiguo puede volver a desplegarlo en su entorno. Las etiquetas únicas evitan confundir la imagen con el alias mutable. Las etiquetas siguen siendo técnicamente modificables en Docker Hub por quien tenga permisos; este workflow no las reutiliza entre ejecuciones.

Configurar manualmente GitHub Environments `staging` (solo develop) y `production` (solo main), con `AZURE_CREDENTIALS` propios y Service Principals limitados a su App Service. Los secretos Docker Hub `DOCKERHUB_USERNAME`/`DOCKERHUB_TOKEN` pueden estar en el repositorio o en ambos entornos para el mismo registro. Definir las variables de repositorio `AZURE_WEBAPP_NAME_DEVELOP` y `AZURE_WEBAPP_NAME_MAIN` sin sobrescribirlas desde entornos. El secret antiguo `AZURE_WEBAPP_NAME` ya no se consume. Se requieren dos App Services Linux distintos con puerto 8080, JWT/MongoDB de entorno, conectividad MongoDB y acceso al registro (autenticación configurada en Azure si es privado).

Los requisitos completos y enlaces oficiales están en README, sección 10. Sin credenciales o recursos no se garantiza un workflow completamente verde; el fallo será visible y explicará lo que falta. No se declara validada ninguna credencial o configuración remota, y ningún paso remoto fue ejecutado en esta tarea.

## Pendientes humanos

Completar grupo académico y acceso del profesor; aportar capturas auténticas de pruebas, JaCoCo, Docker y herramientas UML/Figma; configurar cuentas, secrets, variables, entornos y recursos externos; ejecutar manualmente el primer commit de la implementación y push a develop; comprobar Actions en verde y health/Swagger públicos. Nada de esto se declara realizado aquí.

Mensaje Conventional Commits recomendado: `feat: preparar base Spring Boot y pipeline CI/CD del parcial`.

Confirmación: NO se ejecutó `git add`, `git commit`, `git push` ni `git merge`; no se creó una Pull Request, no se modificó main, no se publicaron imágenes y no se desplegó en Azure.
