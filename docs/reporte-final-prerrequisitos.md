# Reporte final de prerrequisitos — DOSW Parcial T2

Revisión de evidencias: **12 de octubre de 2026**, America/Bogota. Estudiante: **Daniel Valero Quiroga**, **Grupo 1**. Profesor como colaborador: **pendiente de agregar y confirmar acceso**.

## Alcance y antecedentes

Esta revisión integra exclusivamente capturas auténticas existentes en `docs/images/`. Conserva la matriz de requisitos de la auditoría documental previa, actualizando los estados solo cuando hay respaldo verificable. Su fuente académica registrada es el HTML del profesor `parcial-t2-prerequisitos.html`, Parte 1.1, secciones 1–10; SHA256 registrado: `CE02C8C93842896C5C71557AFC052C79F99EACC5AA8B03CDB7573F4493F2D381`. No se volvió a inspeccionar ni se modificó esa fuente externa en esta revisión.

Se inspeccionaron Git, los tres documentos, las 11 imágenes y los reportes Maven actuales. Además se consultaron las APIs públicas de GitHub Actions y Docker Hub en modo de solo lectura. Las capturas muestran el estado al recopilarlas, no una comprobación continua de recursos externos. No se accedió a configuración privada de Azure ni se hicieron despliegues, publicaciones Docker o cambios remotos.

Los antecedentes de Docker local y acceso público a health/Swagger fueron aportados por el estudiante y figuran en la [auditoría histórica](auditoria-primer-commit.md). La nueva inspección distingue esos antecedentes del contenido realmente visible. Los logs de Atlas solo acreditan conexión exitosa de monitoreo del driver; **no demuestran una operación autenticada de lectura/escritura ni ping autenticado**. JWT completo y negocio siguen fuera del alcance y no se declaran implementados.

## Rama, HEAD y estado Git

| Dato | Inicial / final |
|---|---|
| Rama | `develop` / `develop` |
| HEAD | `173b6b82c104c2bbb6a7da68c9a34a15bb921c44` / mismo SHA |
| Commit documental requerido | `173b6b8 docs: update prerequisites and deployment evidence`, existente y HEAD inicial |
| Tres últimos commits iniciales | `173b6b8`, `80cc2b1`, `d408383` |
| `main` local | `f5a52cb8cf4ab7f54e09e8e2b2aa312312c9c1ac`, sin cambios |
| Relación con origin/develop | develop adelantada un commit según referencias locales; sin fetch |
| Estado inicial | 11 PNG nuevos ya preparados en índice; documentos sin cambios |
| Estado final | Tres Markdown modificados sin preparar; nueve PNG permanecen preparados; dos PNG privados fuera del índice y excluidos localmente |
| SHA256 índice inicial | `E6609138095E11586AB4AA70532761C2EFB08AF2DA2B1BBA4B68BD670ED1B742` |
| SHA256 índice tras exclusiones | `F75CC669C0B7BAF25697CC9C565E0BB3A99124979A144FD83C77721A2535D157` |

No se preservó el índice íntegro: se retiraron **únicamente** `docs/images/azure-app-service.png` y `docs/images/figma-cuenta.png` mediante `git restore --staged -- ...` para impedir que datos privados entren al siguiente commit. Los originales siguen locales e intactos, con exclusiones exactas en `.git/info/exclude`. Las otras nueve imágenes ya estaban preparadas antes de esta intervención; no se ejecutó `git add`.

Estado final comprobado mediante `git status --short --untracked-files=all`:

```text
 M README.md
 M docs/images/README.md
A  docs/images/azure-mongodb-connection.png
A  docs/images/azure-swagger.png
A  docs/images/docker-container-running.png
A  docs/images/dockerhub-image.png
A  docs/images/github-actions-success.png
A  docs/images/jacoco-cobertura.png
A  docs/images/maven-build-success.png
A  docs/images/mongodb-atlas-cluster.png
A  docs/images/uml-herramienta.png
 M docs/reporte-final-prerrequisitos.md
```

Los PNG excluidos se muestran como `!!` al solicitar `git status --short --ignored`; no aparecerán en el estado ordinario. Las referencias locales origin no acreditan el acceso del profesor ni el estado remoto actual de la documentación.

## Documentos actualizados

| Archivo | Resultado |
|---|---|
| [README.md](../README.md) | Conserva índice y exactamente 11 secciones principales. Nueve imágenes, cada una una sola vez, en §§3, 8, 9, 10 y 11; MongoDB como subsección de §3; exclusiones y límites explícitos |
| [docs/images/README.md](images/README.md) | Inventario real, dimensiones, tamaños, privacidad, trazabilidad y pendientes |
| `docs/reporte-final-prerrequisitos.md` | Auditoría actualizada, clasificación respaldada, validaciones y lista exacta recomendada para commit |

Cambio adicional local: `.git/info/exclude`, con dos rutas privadas; no se versiona. Ninguna imagen se alteró, renombró o generó. Java, tests, POM, Dockerfile, workflow, configuración Azure y archivos de otros proyectos no fueron modificados. Maven regeneró únicamente artefactos ignorados en `target/`.

## Evidencias integradas, parciales y excluidas

**11 PNG válidos y visualizables; nueve aprobados para integración y dos excluidos por privacidad.** Hay además `.gitkeep` y el inventario, que no cuentan como imágenes. Se conserva una estructura plana y los nombres auténticos.

| ID | Evidencia real | README / alcance |
|---|---|---|
| E01 | [Maven BUILD SUCCESS](images/maven-build-success.png) | §8; siete pruebas sin fallos, generación JaCoCo y JAR; captura de 23:26:28 -05:00, 21,323 s |
| E02 | [JaCoCo](images/jacoco-cobertura.png) | §8; 17/19 líneas (89,47 %), 82/87 instrucciones (94,25 %; HTML 94 %) |
| E03 | [Docker local](images/docker-container-running.png) | §9; activo y 8081:8080; nombres e imagen truncados, sin build ni health HTTP local |
| E04 | [Docker Hub](images/dockerhub-image.png) | §10; repositorio danielvalero09/dosw-parcial-t2 y cuatro tags; API completa etiqueta/digest |
| E05 | [GitHub Actions](images/github-actions-success.png) | §10; pipeline develop Success, SHA 80cc2b1, intento 4; tres jobs verdes, producción omitida |
| E06 | `azure-health-200.png` | **Ausente**; no enlazada. Falta dominio, endpoint y 200/JSON en una captura completa |
| E07 | [Recorte de respuesta Swagger](images/azure-swagger.png) | §3; 200 y JSON esperado, sin URL ni endpoint ni UI completa. No demuestra por sí solo health público Azure o Swagger cargado |
| E08 | [Clúster Atlas](images/mongodb-atlas-cluster.png) | §3; DOSW-ParcialT2, Free, Azure westus, primario y secundarios |
| E09 | [Monitoreo del driver desde Azure](images/azure-mongodb-connection.png) | §3; conexión al primario y dos secundarios; sin acreditar operación autenticada |
| E10 | [Herramienta UML](images/uml-herramienta.png) | §11; app.diagrams.net abierto, lienzo vacío. No verifica cuenta ni UML terminado |
| E11 | `figma-cuenta.png` | **Excluida**, correo personal visible. Sesión de Daniel Valero observada; falta evidencia publicable |
| E12 | `azure-app-service.png` | **Excluida**, identificador privado de suscripción. Linux, West US y contenedor observados; falta evidencia publicable |

Tamaños exactos y dimensiones: [inventario](images/README.md). Total **1228299 bytes (1,17 MiB)**; aprobadas **900869 bytes (0,86 MiB)**. Máximo **213551 bytes**, sin tamaños desproporcionados. Los 11 hashes SHA256 son distintos y la revisión visual no encontró duplicados innecesarios.

## Enlaces y trazabilidad comprobados

- [Actions: run 38341584719](https://github.com/DanielValero09/DOSW_ParcialT2_DanielValero/actions/runs/38341584719). [API del intento 4](https://api.github.com/repos/DanielValero09/DOSW_ParcialT2_DanielValero/actions/runs/38341584719/attempts/4): SHA `80cc2b1036b5e18819a37b54c3f711c75b6bf651`, push, success; inicio **12/10/2026 22:49:48 -05:00**. La [API de jobs](https://api.github.com/repos/DanielValero09/DOSW_ParcialT2_DanielValero/actions/runs/38341584719/attempts/4/jobs) verifica test/docker/deploy_develop success y deploy_main skipped, coincidentes con E05. Es un commit anterior al HEAD documental actual.
- [Docker Hub: danielvalero09/dosw-parcial-t2](https://hub.docker.com/r/danielvalero09/dosw-parcial-t2). La [API pública de tags](https://hub.docker.com/v2/repositories/danielvalero09/dosw-parcial-t2/tags?page_size=10) verificó imagen Linux AMD64, etiqueta `develop-80cc2b1036b5e18819a37b54c3f711c75b6bf651-38341584719-4` y digest `sha256:09923bf86f29d7656421d2bbab91f0dee254dc1cf6857b5dd1cf88e27c5ab573`. Publicación **12/10/2026 22:50:54 -05:00**. El alias develop compartía el digest al consultar. La etiqueta coincide con SHA/run/intento; no se inspeccionó el digest activo en Azure.
- [Health público declarado](https://dosw-parcialt2-daniel-dev-hge6d7ghd4eab8ar.westus-01.azurewebsites.net/api/v1/health) y [Swagger público declarado](https://dosw-parcialt2-daniel-dev-hge6d7ghd4eab8ar.westus-01.azurewebsites.net/swagger-ui/index.html): dominio aportado por el estudiante, conservado literalmente. En esta tarea no se repitió su comprobación HTTP; faltan las capturas completas.

Las páginas HTML de GitHub/Docker Hub no estuvieron disponibles mediante la consulta web inicial; se verificaron identificadores y resultados por las APIs públicas. Los enlaces relativos se resuelven respecto del documento que los contiene. Se retiraron enlaces a reportes ignorados bajo `target/` para evitar enlaces rotos en GitHub: sus rutas se documentan como código y se regeneran con Maven.

## Resultado técnico local y validación

`mvn clean verify`: **salida 0**, **BUILD SUCCESS**, **30,329 s**, finalizado el **12/10/2026 a las 23:43:46 -05:00**; Java **21.0.10**, Spring Boot **3.5.16**. La captura E01 documenta otra ejecución auténtica y no se reemplazó por una captura generada.

| Suite Surefire | Pruebas | Fallos | Errores | Omitidas |
|---|---:|---:|---:|---:|
| SecurityConfigurationTest | 5 | 0 | 0 | 0 |
| HealthControllerTest | 1 | 0 | 0 | 0 |
| HealthControllerWebTest | 1 | 0 | 0 | 0 |
| **Total** | **7** | **0** | **0** | **0** |

| Métrica JaCoCo | Cubierto | No cubierto | Total | Cobertura |
|---|---:|---:|---:|---:|
| LINE | 17 | 2 | 19 | **89,47 %** |
| INSTRUCTION | 82 | 5 | 87 | 94,25 % |
| METHOD | 10 | 1 | 11 | 90,91 % |
| CLASS | 4 | 0 | 4 | 100 % |

Se inspeccionaron `target/site/jacoco/jacoco.xml` y los tres XML Surefire actuales. Los totales coinciden con E02. No hay cobertura de ramas ni umbral mínimo configurado. Las pruebas no ejecutan consultas Atlas ni verifican JWT completo o negocio. Los avisos Mockito/Byte Buddy y Springdoc no causaron fallos.

**Validación documental final:** controles completados sin errores:

- **72 referencias locales** comprobadas: README 31, inventario 11 y reporte 30. Se verificaron existencia, seguimiento en Git y anclas de destino; ningún enlace local roto, ninguna ruta a imágenes excluidas ni a artefactos ignorados. Las imágenes y documentos estarán disponibles en GitHub después de la incorporación y publicación manual autorizada por el estudiante.
- **20 referencias HTTP(S)** documentadas: README 8, inventario 5 y reporte 7. APIs públicas de Actions/Docker Hub consultadas exitosamente; URLs Azure conservadas del contexto del estudiante, sin afirmar comprobación HTTP actual de cada enlace remoto.
- README con **11 secciones principales en orden**, índice válido y **nueve imágenes distintas**, cada una insertada una sola vez. Las nueve rutas corresponden a imágenes existentes y preparadas desde antes de esta tarea.
- **11 PNG íntegros:** firmas, dimensiones y CRC de todos los chunks correctos; sin bytes extra tras IEND, sin metadatos textuales/EXIF y sin hashes duplicados. Tamaño máximo 213551 bytes; total 1228299 bytes. Todos se visualizaron y sus bytes originales se conservaron.
- Escaneo de patrones de secretos en los tres documentos: sin coincidencias de URI MongoDB autenticada, claves privadas o tokens reconocibles; revisión visual de las nueve imágenes aprobadas sin credenciales visibles. Los dos originales privados están fuera del índice y `git check-ignore -v` confirma sus exclusiones locales.
- `git diff --check` y `git diff --cached --check`: **salida 0**, sin errores de whitespace. Solo avisos informativos de conversión futura LF/CRLF.
- `git status`: tres documentos modificados sin preparar y nueve PNG ya preparados. `git diff --stat`: únicamente los tres Markdown; `git diff HEAD --stat`: esos documentos y las nueve imágenes. Diff de implementación respecto de HEAD vacío; develop, HEAD y main preservados. SHA256 del índice coincide con el registrado tras retirar las dos imágenes privadas.

El validador temporal se ejecutó con Node y se eliminó; Python no está instalado en este equipo. No se añadieron herramientas ni dependencias al proyecto.

## Tabla de cumplimiento

Se mantienen las 65 entradas de la auditoría previa. Las comprobaciones de archivos y estructura se conservan como antecedentes cuando no requieren una nueva ejecución. Los cambios de clasificación provienen de E04/E05/E08/E09/E11 y las APIs públicas. Ningún estado implica JWT/negocio implementados ni operaciones autenticadas Atlas.

- **Cumplido y verificado:** respaldo verificable en archivos, ejecución local, captura inspeccionada o API pública, dentro del alcance expresamente indicado.
- **Implementado pero pendiente de evidencia:** resultado aportado o parcial, sin evidencia publicable suficiente para el requisito completo.
- **Pendiente de intervención manual:** acción necesaria del estudiante; no se presenta como realizada.
- **No verificado:** no hay respaldo suficiente para afirmar cumplimiento.

E01–E12 remiten al inventario actual; pueden representar imágenes integradas, parciales, excluidas o ausentes.

Resumen de **65 entradas**: **45 Cumplido y verificado**, **8 Implementado pero pendiente de evidencia**, **6 Pendiente de intervención manual**, **6 No verificado**. No constituye nota ni porcentaje de aprobación.

| HTML | Requisito | Clasificación | Evidencia / límite / pendiente |
|---|---|---|---|
| 1 | Repositorio individual con nombre `DOSW_ParcialT2_DanielValero` | Cumplido y verificado | Carpeta, título README y URL pública de `origin` local coinciden; trabajo individual confirmado |
| 1 | README y `.gitignore` presentes desde el inicio | Cumplido y verificado | Archivos actuales y commit inicial `f5a52cb`; ignores de Java/Maven presentes |
| 1 | Ramas `main` y `develop`, esta última desde `main` | Cumplido y verificado | `git show-ref --heads` y comprobación de ancestro, salida 0; referencias remotas solo locales |
| 1 | Nombre completo y grupo en README | Cumplido y verificado | [README §1](../README.md#1-datos-del-estudiante); Daniel Valero Quiroga, Grupo 1, confirmados |
| 1 | Profesor agregado como colaborador | Pendiente de intervención manual | Estudiante confirmó que está pendiente; invitar y confirmar acceso efectivo |
| 1 | Maven `groupId=edu.dosw.parcial`, `artifactId=DOSW-ParcialT2` | Cumplido y verificado | [pom.xml](../pom.xml) y coordenadas mostradas por Maven |
| 1, 10 | `.env`, `*.p12`, `target/` ignorados, sin secretos versionados detectados | Cumplido y verificado | [.gitignore](../.gitignore), `git check-ignore` y revisión de archivos; límites del escaneo abajo |
| 2, 10 | `docs/uml/` y `docs/images/` presentes | Cumplido y verificado | `.gitkeep` versionados; inventario creado en images |
| 2 | Controller, DTO request/response, mappers y handlers | Cumplido y verificado | [controller](../src/main/java/edu/dosw/parcial/controller/); subpaquetes vacíos con `.gitkeep` |
| 2 | Core: services, models, validators, utils | Cumplido y verificado | [core](../src/main/java/edu/dosw/parcial/core/); `.gitkeep` en subpaquetes vacíos |
| 2 | Persistence: entities, repositories, mappers | Cumplido y verificado | [persistence](../src/main/java/edu/dosw/parcial/persistence/); `.gitkeep` en subpaquetes vacíos |
| 2 | Config, main, resources y estructura de test | Cumplido y verificado | Paquetes y pruebas presentes; vacíos conservados, solo `application.yaml` |
| 2 | Mapper IN/OUT, separación DTO/dominio/documento y uso futuro de `@Document` | Cumplido y verificado | Scaffolding y responsabilidades [README §4](../README.md#4-estructura-del-proyecto); no hay implementaciones de negocio para evaluar aún |
| 3 | Spring Boot Web | Cumplido y verificado | Starter en POM; health y MVC pasan pruebas |
| 3 | MongoDB sustituyendo JPA | Cumplido y verificado | Starter MongoDB en POM; no hay starter JPA |
| 3 | Validation | Cumplido y verificado | `spring-boot-starter-validation` en POM |
| 3 | Security y JJWT API/impl/Jackson | Cumplido y verificado | Dependencias en POM; impl/Jackson runtime. Se verifica preparación, no login JWT |
| 3 | Swagger / springdoc | Cumplido y verificado | Dependencia, [SwaggerConfig](../src/main/java/edu/dosw/parcial/config/SwaggerConfig.java) y pruebas Swagger/OpenAPI |
| 3 | Lombok optional y annotation processor | Cumplido y verificado | POM con versión administrada por Spring Boot |
| 3 | MapStruct, processor y binding en orden correcto | Cumplido y verificado | POM: Lombok → binding → MapStruct; compilación exitosa, sin mappers de negocio aún |
| 3 | Soporte SLF4J y `@Slf4j` | Cumplido y verificado | Logging de Spring Boot y Lombok disponibles; no se afirma uso de `@Slf4j` en clases de negocio |
| 3 | JUnit, Mockito y security-test | Cumplido y verificado | Dependencias de test y 7 pruebas ejecutadas |
| 3 | Plugin Spring Boot y compilador Java 21 | Cumplido y verificado | POM, compilación release 21 y JAR ejecutable generado |
| 3 | JaCoCo prepare-agent/report | Cumplido y verificado | POM, Maven actual, HTML/XML y captura E02 integrada; 89,47 % LINE, 94,25 % INSTRUCTION |
| 3 | SonarScanner y propiedades `sonar.*` | Cumplido y verificado | POM. El HTML exige preparación; no hay evidencia de análisis SonarQube ejecutado |
| 3 | Verificar en Maven Central la versión estable más reciente compatible | No verificado | Build confirma compatibilidad actual; no se contrastó la última versión publicada de cada dependencia/plugin |
| 4 | Único archivo YAML/properties, nombre y puerto por variable | Cumplido y verificado | [application.yaml](../src/main/resources/application.yaml): nombre DOSW-ParcialT2, `PORT` con default 8080 |
| 4, 10 | MongoDB leído de `MONGODB_URI`, default local, sin credenciales | Cumplido y verificado | `application.yaml` y [.env.example](../.env.example) |
| 4 | JWT secret por variable y expiración 3600000 | Cumplido y verificado | YAML; base preparada. No valida todavía formato/longitud mediante una implementación JWT |
| 4 | Clase principal en main con escaneo explícito y EnableMongoRepositories | Cumplido y verificado | [ParcialApplication](../src/main/java/edu/dosw/parcial/main/ParcialApplication.java), contexto inicia |
| 4 | Health mínimo público con JSON esperado | Cumplido y verificado | [HealthController](../src/main/java/edu/dosw/parcial/controller/HealthController.java), pruebas unitarias/MVC |
| 4 | Security base, CSRF deshabilitado, STATELESS, otras rutas protegidas | Cumplido y verificado | [SecurityConfig](../src/main/java/edu/dosw/parcial/config/SecurityConfig.java); prueba de HTTP 403 y única cadena |
| 4 | Swagger/OpenAPI públicos con seguridad activa | Cumplido y verificado | Pruebas HTTP 200 de UI y OpenAPI JSON/YAML |
| 4 | Login JWT, roles y negocio | Pendiente de intervención manual | Trabajo del laboratorio posterior, expresamente fuera de estos prerrequisitos y de esta auditoría |
| 5 | Dockerfile multietapa Java 21, JRE final y puerto 8080 | Cumplido y verificado | [Dockerfile](../Dockerfile), builder ejecuta verify sin omitir pruebas |
| 5 | `.dockerignore` excluye Git, target, docs, entornos y claves | Cumplido y verificado | [.dockerignore](../.dockerignore) |
| 5, 10 | `docker build` termina sin errores | Implementado pero pendiente de evidencia | Confirmación del estudiante y auditoría histórica; E03/captura o log del build pendiente; no se reconstruyó aquí |
| 5, 10 | Contenedor arranca y health local responde HTTP 200 | Implementado pero pendiente de evidencia | E03 integrada: contenedor activo y 8081:8080, nombres/tag truncados. Health local 200 solo en antecedente; falta captura HTTP completa |
| 6 | Workflow main/develop con test → docker → deploy condicionado | Cumplido y verificado | [ci-cd.yml](../.github/workflows/ci-cd.yml), dependencias `needs`, condiciones y etapas activas |
| 6 | Publicación Docker Hub y despliegue de la etiqueta entregada por docker | Cumplido y verificado | Pasos del workflow, output `image_tag`, alias por rama; verificación de implementación |
| 6 | Pipeline completo verde en develop | Cumplido y verificado | E05 y API del run 38341584719, intento 4: test/docker/deploy_develop success, deploy_main skipped; SHA 80cc2b1, anterior al HEAD documental |
| 6 | Imagen efectivamente publicada en Docker Hub | Cumplido y verificado | E04, repositorio público danielvalero09/dosw-parcial-t2 y API: etiqueta única del run/intento 4 y digest completos registrados |
| 6 | Secrets de Docker Hub/Azure y destino configurados | Implementado pero pendiente de evidencia | Jobs docker/deploy_develop exitosos verificados por API; implican credenciales operativas en esa ejecución, pero ubicación, permisos y settings no inspeccionados |
| 6 | Pruebas CI no dependen de operaciones MongoDB ni secretos productivos JWT | Cumplido y verificado | Pruebas usan URI local de test y marcador de JWT; no consultan la base, workflow ejecuta todas |
| 6 | Restricciones de entornos y permisos mínimos de Service Principal | No verificado | Se declaran staging/production; no se inspeccionaron branch rules ni asignaciones de permisos remotos |
| 7 | App Service Linux por contenedor en Azure | Implementado pero pendiente de evidencia | E12 revisada: Linux, West US y contenedor. Captura excluida por identificador privado de suscripción; falta evidencia publicable |
| 7 | Imagen consumida por Azure | Implementado pero pendiente de evidencia | deploy_develop success por API y etiqueta publicada corroborada; digest del contenedor activo Azure no inspeccionado |
| 7 | Variables Azure MONGODB_URI, JWT_SECRET, WEBSITES_PORT=8080 | No verificado | No se inspeccionaron settings reales, longitud de JWT ni modelo de enrutamiento; app responde pero no prueba los tres valores |
| 7 | Service Principal y secret AZURE_CREDENTIALS operativo | Implementado pero pendiente de evidencia | deploy_develop success en captura/API; no se inspeccionaron login detallado ni permisos del Service Principal |
| 7 | Base gestionada accesible desde Azure | Cumplido y verificado | E08/E09 integradas: Atlas y conexiones del monitor al primario y dos secundarios. Verificado solo el alcance de monitoreo, no lectura/escritura autenticada |
| 7 | Ping o lectura autenticada de Atlas desde Azure | No verificado | Aún no se comprobó; los logs del driver y health no acreditan esta operación |
| 7 | Push previo a develop con ejecución verde | Cumplido y verificado | E05/API: evento push, rama develop, SHA 80cc2b1036b5e18819a37b54c3f711c75b6bf651, run 38341584719, intento 4; enlace y fecha registrados |
| 7 | Health público Azure HTTP 200 | Implementado pero pendiente de evidencia | Dominio y resultado aportados por el estudiante. E06 ausente; E07 muestra 200/JSON sin dominio ni endpoint: respaldo parcial, no origen Azure verificable |
| 7 | Swagger público Azure cargado | Implementado pero pendiente de evidencia | URL aportada por el estudiante. E07 es solo un recorte de respuesta; falta UI completa con dominio y endpoint visibles |
| 7 | Suscripción, costos y cuotas suficientes | No verificado | Servicio confirmado operativo; no se revisaron plan, saldo, vigencia ni cuotas |
| 7 | Despliegue y configuración remota de main/production | No verificado | Workflow implementado; deploy_main se omitió correctamente en develop. No se ejecutó ni se exige como nueva operación aquí |
| 8 | README con índice y exactamente 11 secciones numeradas | Cumplido y verificado | [README](../README.md), secciones preservadas, enlaces y contenido revisados |
| 8 | Datos, descripción, URLs reales, estructura y tecnologías | Cumplido y verificado | README §§1–5; grupo confirmado, profesor marcado pendiente |
| 8 | Variables sin valores reales y comandos Maven/Docker/Mongo | Cumplido y verificado | README §§6–9; `mvn test`, `clean verify`, build/run y Mongo local documentados |
| 8 | Pipeline y nombres de secrets documentados | Cumplido y verificado | README §10; sin afirmar éxito de main o comprobar valores privados |
| 8, 10 | Capturas Maven, JaCoCo, Docker, Actions, health y Swagger en README | Pendiente de intervención manual | E01/E02/E03/E04/E05/E07 integradas; E03/E07 parciales, E06 ausente. Faltan vistas completas de health/Swagger y Docker local |
| 9 | Seleccionar UML y garantizar cuenta requerida | Pendiente de intervención manual | E10 integrada: Draw.io/app.diagrams.net abierto. Selección y acceso al editor verificados; cuenta autenticada no demostrada si se exige |
| 9 | Cuenta y acceso Figma disponibles | Cumplido y verificado | E11 revisada: sesión de Daniel Valero y archivos recientes. Acceso observado; captura excluida por correo personal y evidencia publicable pendiente |
| 9, 10 | Evidencias de acceso UML/Figma enlazadas en README | Pendiente de intervención manual | UML E10 enlazada; Figma E11 excluida de publicación por correo personal. Requiere saneamiento y autorización |
| 10 | Entrega completa con profesor y evidencias | Pendiente de intervención manual | Nueve capturas integradas; dos excluidas, health/Swagger completos y profesor como colaborador pendientes; límites técnicos indicados |

La conexión de monitoreo del driver y el health fijo no acreditan una operación autenticada contra Atlas. El ping histórico fue contra MongoDB local. Producción/main y JWT/negocio siguen fuera del trabajo actual.

## Revisión de privacidad y secretos

Se visualizaron las 11 imágenes. No se observaron contraseñas, tokens, claves privadas o URI MongoDB con credenciales. Se encontraron datos privados en **dos**: identificador de suscripción en E12 y correo personal en E11. No se reproducen sus valores en la documentación ni se enlazan los originales. Ambas rutas están fuera del índice y excluidas localmente; los bytes originales se conservaron.

Las nueve imágenes aprobadas incluyen contexto técnico (rutas del proyecto, nombres de contenedores, hostnames de Atlas, metadatos de topología) sin credenciales visibles. Se comprobaron además los chunks PNG: no contienen metadatos textuales ni EXIF. El escaneo de documentos no detectó patrones de secretos; no se volcaron variables de entorno o configuración privada remota. Estas comprobaciones no demuestran ausencia absoluta de secretos arbitrarios.

La auditoría anterior registró revisión de configuración e ignores sin detectar credenciales reales; ese antecedente no se presenta como un nuevo escaneo de toda la historia Git. No se rotaron credenciales ni se inspeccionaron objetos Git inaccesibles.

## Acciones manuales pendientes

1. **Invitar al profesor y confirmar aceptación/acceso efectivo**. Su estado permanece pendiente.
2. Sanear las capturas App Service/Figma y autorizar su publicación antes de incorporar versiones sin datos privados. Mantener los originales excluidos y no forzar su incorporación a Git.
3. Aportar captura completa del health Azure (dominio, GET /api/v1/health, 200 y JSON) y de Swagger UI (URL y endpoint). El recorte E07 no completa estos requisitos.
4. Ampliar Docker local: nombre e imagen completos, puertos, estado activo, health HTTP 200 y evidencia del build local. La captura E03 sí existe, pero su alcance es parcial.
5. Verificar una operación autenticada no destructiva contra Atlas desde Azure con evidencia independiente y sin revelar la URI. No se ejecutó aquí.
6. Confirmar variables Azure, formato/longitud JWT, puertos, permisos y restricciones de staging sin copiar valores privados. El acceso observado a Figma no demuestra un prototipo terminado; Draw.io no acredita cuenta autenticada si el profesor la exige.
7. Conservar los pendientes anteriores de contraste de versiones estables compatibles en Maven Central y revisión de suscripción/costos/cuotas. No se actualizan dependencias ni recursos durante esta tarea.

El grupo **ya está confirmado: Grupo 1**. Enlace/fecha/SHA de Actions y propietario/URL/etiqueta/digest Docker Hub quedaron registrados con certeza; no permanecen como pendientes. JWT completo y negocio corresponden al laboratorio posterior, sin implementarse en esta intervención.

## Archivos exactos recomendados para el siguiente commit

Únicamente estos **12 archivos**, después de revisar la documentación; esta lista no ejecuta incorporación al índice ni commit:

```text
README.md
docs/images/README.md
docs/reporte-final-prerrequisitos.md
docs/images/azure-mongodb-connection.png
docs/images/azure-swagger.png
docs/images/docker-container-running.png
docs/images/dockerhub-image.png
docs/images/github-actions-success.png
docs/images/jacoco-cobertura.png
docs/images/maven-build-success.png
docs/images/mongodb-atlas-cluster.png
docs/images/uml-herramienta.png
```

Excluir `docs/images/azure-app-service.png` y `docs/images/figma-cuenta.png` hasta saneamiento y autorización. `.git/info/exclude` es protección local y no forma parte del commit; `target/` contiene generados ignorados. `.gitkeep` ya existe y no cambió.

## Restricciones respetadas

**No se ejecutó git add, git commit, git push ni git merge.** No se cambió de rama o HEAD, no se modificó main, no se desplegó, no se publicó Docker ni se alteraron recursos externos u otros proyectos. Se actualizaron tres documentos y dos exclusiones locales; se retiraron las dos capturas privadas del índice sin alterar las imágenes. Ningún archivo de implementación cambió. No se inventó, simuló o generó ninguna captura.
