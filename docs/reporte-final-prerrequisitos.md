# Reporte final de prerrequisitos — DOSW Parcial T2

Fecha: **12 de octubre de 2026**, America/Bogota. Estudiante: **Daniel Valero Quiroga**, **Grupo 1**. Trabajo individual. Profesor como colaborador: **pendiente de agregar**, según confirmación del estudiante.

## Referencia y alcance de la evidencia

Se leyó completo el HTML del profesor: `C:/Users/Daniel/Downloads/parcial-t2-prerequisitos.html`, **Parte 1.1 · Prerrequisitos**, secciones 1–10. SHA256 de la fuente: `CE02C8C93842896C5C71557AFC052C79F99EACC5AA8B03CDB7573F4493F2D381`. La fuente está fuera del repositorio y no fue modificada ni copiada como una evidencia de ejecución.

Se revisaron los 45 archivos versionados iniciales, la estructura local, las referencias Git, POM, configuración, Java, pruebas, Dockerfile, ignores y workflow. Se ejecutó `mvn clean verify` y se inspeccionaron JaCoCo HTML/XML y Surefire. Solo se modificó documentación.

Los resultados remotos se documentan a partir del **contexto verificado aportado por el estudiante**: Docker local satisfactorio; Actions completo exitoso en `develop`; `test`, `docker` y `deploy_develop` exitosos; `deploy_main` omitido; imagen publicada; App Service Linux en West US; Swagger público y health HTTP 200; Atlas y logs de monitoreo. No se accedió a cuentas remotas ni se repitieron esas operaciones. No se atribuye esta auditoría local como autora de dichas verificaciones.

No se encontraron capturas auténticas en este repositorio. Por rigor, los requisitos remotos operativos pero sin captura o enlace de ejecución disponible se clasifican **Implementado pero pendiente de evidencia**. Eso indica ausencia de evidencia incorporada, no que el procedimiento siga sin realizarse. Las cuentas sin confirmación y las propiedades remotas no inspeccionadas permanecen **No verificado**.

## Rama, HEAD y estado Git

| Dato | Resultado |
|---|---|
| Rama inicial y final | `develop` |
| HEAD inicial y final | `80cc2b1036b5e18819a37b54c3f711c75b6bf651` |
| Rama local `main` | `f5a52cb8cf4ab7f54e09e8e2b2aa312312c9c1ac`, sin modificaciones |
| Origen local configurado | [DanielValero09/DOSW_ParcialT2_DanielValero](https://github.com/DanielValero09/DOSW_ParcialT2_DanielValero) |
| Referencias remotas guardadas | `origin/develop` coincide con HEAD; `origin/main` coincide con `main`. No hubo fetch ni comprobación del estado remoto actual |
| Relación de ramas | `git merge-base --is-ancestor main develop`: salida 0; `main` es ancestro de `develop` |
| Estado inicial | `git status --short` sin salida; árbol limpio, sin archivos en staging |
| Estado final | Un archivo rastreado modificado y dos documentos nuevos sin seguimiento; sin cambios preparados |
| SHA256 del índice inicial y final | `4A2A17D3A1D2399754DFDF8AB00DF3C100D453FF3FE0D6943B8F27E0F81DE95A`, idéntico |

Estado final comprobado mediante `git status --short --untracked-files=all`:

```text
 M README.md
?? docs/images/README.md
?? docs/reporte-final-prerrequisitos.md
```

No hubo cambio de rama ni de HEAD. La existencia de referencias `origin/*` acredita la información local guardada; no demuestra por sí sola la configuración actual en GitHub o los permisos del profesor.

## Archivos modificados y creados

| Archivo | Cambio |
|---|---|
| [README.md](../README.md) | Actualizado, conservando las 11 secciones e índice enlazado |
| [docs/images/README.md](images/README.md) | Creado: inventario de capturas auténticas pendientes y convención de nombres |
| `docs/reporte-final-prerrequisitos.md` | Creado: este reporte |

Se actualizaron las secciones del README: **1**, nombre/grupo y profesor pendiente; **2**, alcance del servicio base; **3**, URLs reales, Azure y límite de comprobación Atlas; **4**, árbol y responsabilidades; **5**, tecnologías y versiones configuradas; **6**, variables y nombres de secrets; **7**, comandos locales; **8**, Maven/JaCoCo actuales; **9**, Docker construido y ejecutado; **10**, pipeline exitoso y publicación; **11**, cuentas UML/Figma y capturas pendientes. Se eliminaron las afirmaciones de que Azure, Docker Hub y Actions todavía no se habían realizado.

No se modificaron Java, pruebas, POM, YAML, seguridad, Dockerfile, ignores ni workflow. Los generados de `target/` fueron regenerados por Maven y están ignorados.

## Evidencias encontradas y pendientes

**Evidencia local encontrada:** archivos implementados; ramas y genealogía local; siete pruebas ejecutadas; [JaCoCo HTML local](../target/site/jacoco/index.html), [JaCoCo XML local](../target/site/jacoco/jacoco.xml) y [Surefire local](../target/surefire-reports/). Estos reportes se regeneran al ejecutar Maven y no están versionados. No deben interpretarse como capturas ya anexadas al README.

**Capturas encontradas: ninguna.** Al comenzar, `docs/images/` solo contenía `.gitkeep` vacío. Se conserva y se añade el inventario. No se crearon imágenes ni enlaces Markdown a capturas inexistentes. La [auditoría del primer commit](auditoria-primer-commit.md) es un antecedente histórico del 10 de octubre, no el estado actual: sus pendientes externos y sus detalles de configuración de CI/CD deben leerse en ese contexto; el README y este reporte describen el workflow actual.

| ID | Captura sugerida en `docs/images/` | Estado |
|---|---|---|
| E01 | `01-maven-build-success.png` | Pendiente de incorporar |
| E02 | `02-jacoco-reporte.png` | Pendiente de incorporar |
| E03 | `03-docker-contenedor.png` | Pendiente de incorporar |
| E04 | `04-dockerhub-imagen-publicada.png` | Pendiente de incorporar |
| E05 | `05-github-actions-develop.png` | Pendiente de incorporar |
| E06 | `06-azure-health-http-200.png` | Pendiente de incorporar |
| E07 | `07-azure-swagger-ui.png` | Pendiente de incorporar |
| E08 | `08-mongodb-atlas-cluster.png` | Pendiente de incorporar |
| E09 | `09-azure-mongodb-conexiones.png` | Pendiente de incorporar |
| E10 | `10-cuenta-uml.png` | Pendiente; cuenta/selección no verificada |
| E11 | `11-cuenta-figma.png` | Pendiente; acceso no verificado |

El [inventario completo](images/README.md) especifica el contenido comprobable de cada captura. Faltan además enlace/fecha/SHA de Actions y URL/propietario/etiqueta/digest de Docker Hub. No se deduce el usuario Docker Hub del usuario GitHub.

## Resultado técnico local

`mvn clean verify`: salida **0**, **BUILD SUCCESS**, tiempo **30,341 s**, terminado a las **23:09:23 -05:00**, Java **21.0.10**, Spring Boot **3.5.16**. Las pruebas y el empaquetado del proyecto base siguen funcionando.

| Suite Surefire | Pruebas | Fallos | Errores | Omitidas |
|---|---:|---:|---:|---:|
| `SecurityConfigurationTest` | 5 | 0 | 0 | 0 |
| `HealthControllerTest` | 1 | 0 | 0 | 0 |
| `HealthControllerWebTest` | 1 | 0 | 0 | 0 |
| **Total** | **7** | **0** | **0** | **0** |

| Métrica JaCoCo | Cubierto | No cubierto | Total | Cobertura |
|---|---:|---:|---:|---:|
| LINE | 17 | 2 | 19 | **89,47 %** |
| INSTRUCTION | 82 | 5 | 87 | 94,25 % |
| METHOD | 10 | 1 | 11 | 90,91 % |
| CLASS | 4 | 0 | 4 | 100 % |

Los totales XML coinciden con el HTML: 2 líneas sin cubrir de 19 y 5 instrucciones sin cubrir de 87. El HTML redondea instrucciones a 94 %. No hay contador de ramas ni regla de cobertura mínima configurada. No se afirma cobertura de negocio, autenticación JWT o acceso Atlas.

Avisos observados: carga dinámica de Mockito/Byte Buddy en Java 21 y endpoints Springdoc habilitados. No causaron fallos. Swagger público corresponde al requisito del servicio inicial.

`git diff --check`: salida 0, sin errores de whitespace; solo advertencia informativa de conversión futura LF/CRLF en README. `git status` confirma únicamente los tres documentos indicados y ningún cambio en staging. Los tres documentos se revisaron también: cero espacios finales y cero enlaces locales rotos, incluidos los archivos sin seguimiento que `git diff --check` no evalúa. Se comprobaron las 11 secciones numeradas y los `.gitkeep` previstos, sin faltantes. El diff de Java, pruebas, POM, configuración, Docker y workflow respecto de HEAD está vacío: las modificaciones documentales no alteran lo validado por Maven. Los reportes locales enlazados requieren ejecutar Maven en un clon nuevo.

## Tabla de cumplimiento

Estados utilizados exactamente como solicita la auditoría:

- **Cumplido y verificado**: comprobado en archivos locales, referencias Git o ejecución técnica actual; datos del estudiante respaldados por su confirmación explícita.
- **Implementado pero pendiente de evidencia**: implementación o resultado existente y confirmado, con evidencia de entrega aún ausente.
- **Pendiente de intervención manual**: acción concreta del estudiante necesaria.
- **No verificado**: no hay comprobación suficiente para afirmar cumplimiento.

Los IDs de captura remiten al [inventario](images/README.md) y siempre representan imágenes pendientes. La columna HTML indica la sección del profesor; las filas desglosan sus requisitos y observaciones relevantes.

Resumen de las **65 entradas** de la tabla: **40 Cumplido y verificado**, **12 Implementado pero pendiente de evidencia**, **6 Pendiente de intervención manual** y **7 No verificado**. El desglose incluye comprobaciones complementarias y el alcance del laboratorio posterior; no representa una nota o porcentaje de aprobación del profesor.

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
| 3 | JaCoCo prepare-agent/report | Cumplido y verificado | POM, ejecución Maven, HTML/XML y métricas; captura E02 pendiente |
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
| 5, 10 | Contenedor arranca y health local responde HTTP 200 | Implementado pero pendiente de evidencia | Antecedente local con puerto host 8081 → 8080 y resultado confirmado; E03 pendiente |
| 6 | Workflow main/develop con test → docker → deploy condicionado | Cumplido y verificado | [ci-cd.yml](../.github/workflows/ci-cd.yml), dependencias `needs`, condiciones y etapas activas |
| 6 | Publicación Docker Hub y despliegue de la etiqueta entregada por docker | Cumplido y verificado | Pasos del workflow, output `image_tag`, alias por rama; verificación de implementación |
| 6 | Pipeline completo verde en develop | Implementado pero pendiente de evidencia | Estudiante confirmó test/docker/deploy_develop exitosos y deploy_main omitido; E05 y enlace/SHA pendientes |
| 6 | Imagen efectivamente publicada en Docker Hub | Implementado pero pendiente de evidencia | Confirmación del estudiante; E04, URL, propietario, etiqueta y digest pendientes |
| 6 | Secrets de Docker Hub/Azure y destino configurados | Implementado pero pendiente de evidencia | Pipeline exitoso aportado implica credenciales operativas para esa ejecución; ubicación, permisos y valores no inspeccionados |
| 6 | Pruebas CI no dependen de operaciones MongoDB ni secretos productivos JWT | Cumplido y verificado | Pruebas usan URI local de test y marcador de JWT; no consultan la base, workflow ejecuta todas |
| 6 | Restricciones de entornos y permisos mínimos de Service Principal | No verificado | Se declaran staging/production; no se inspeccionaron branch rules ni asignaciones de permisos remotos |
| 7 | App Service Linux por contenedor en Azure | Implementado pero pendiente de evidencia | App `dosw-parcialt2-daniel-dev`, West US, confirmada; E06/E07 y evidencia de recurso pendientes |
| 7 | Imagen consumida por Azure | Implementado pero pendiente de evidencia | Deploy develop exitoso confirmado; etiqueta única implementada. No se inspeccionó digest del contenedor activo |
| 7 | Variables Azure MONGODB_URI, JWT_SECRET, WEBSITES_PORT=8080 | No verificado | No se inspeccionaron settings reales, longitud de JWT ni modelo de enrutamiento; app responde pero no prueba los tres valores |
| 7 | Service Principal y secret AZURE_CREDENTIALS operativo | Implementado pero pendiente de evidencia | Login/deploy exitosos aportados; falta evidencia sin secretos, sin afirmar roles específicos |
| 7 | Base gestionada accesible desde Azure | Implementado pero pendiente de evidencia | Atlas DOSW-ParcialT2 y logs de conexiones al primario/2 secundarios confirmados; E08/E09 pendientes, alcance de monitoreo |
| 7 | Ping o lectura autenticada de Atlas desde Azure | No verificado | Aún no se comprobó; los logs del driver y health no acreditan esta operación |
| 7 | Push previo a develop con ejecución verde | Implementado pero pendiente de evidencia | Contexto del estudiante y origin/develop local coincidente; falta URL/evento/SHA de ejecución E05 |
| 7 | Health público Azure HTTP 200 | Implementado pero pendiente de evidencia | [Health Azure](https://dosw-parcialt2-daniel-dev-hge6d7ghd4eab8ar.westus-01.azurewebsites.net/api/v1/health), JSON confirmado; E06 pendiente |
| 7 | Swagger público Azure cargado | Implementado pero pendiente de evidencia | [Swagger Azure](https://dosw-parcialt2-daniel-dev-hge6d7ghd4eab8ar.westus-01.azurewebsites.net/swagger-ui/index.html), abierto por estudiante; E07 pendiente |
| 7 | Suscripción, costos y cuotas suficientes | No verificado | Servicio confirmado operativo; no se revisaron plan, saldo, vigencia ni cuotas |
| 7 | Despliegue y configuración remota de main/production | No verificado | Workflow implementado; deploy_main se omitió correctamente en develop. No se ejecutó ni se exige como nueva operación aquí |
| 8 | README con índice y exactamente 11 secciones numeradas | Cumplido y verificado | [README](../README.md), secciones preservadas, enlaces y contenido revisados |
| 8 | Datos, descripción, URLs reales, estructura y tecnologías | Cumplido y verificado | README §§1–5; grupo confirmado, profesor marcado pendiente |
| 8 | Variables sin valores reales y comandos Maven/Docker/Mongo | Cumplido y verificado | README §§6–9; `mvn test`, `clean verify`, build/run y Mongo local documentados |
| 8 | Pipeline y nombres de secrets documentados | Cumplido y verificado | README §10; sin afirmar éxito de main o comprobar valores privados |
| 8, 10 | Capturas Maven, JaCoCo, Docker, Actions, health y Swagger en README | Pendiente de intervención manual | No existen imágenes; incorporar E01–E07 auténticas y enlazarlas después de verificarlas |
| 9 | Seleccionar UML y garantizar cuenta requerida | Pendiente de intervención manual | Confirmar Lucidchart/Draw.io/Miro y acceso real; E10 pendiente |
| 9 | Cuenta y acceso Figma disponibles | No verificado | Figma indicada como herramienta, sin confirmación de acceso; E11 pendiente |
| 9, 10 | Evidencias de acceso UML/Figma enlazadas en README | Pendiente de intervención manual | Capturar E10/E11 reales y agregar referencias Markdown solo cuando existan |
| 10 | Entrega completa con profesor y evidencias | Pendiente de intervención manual | Base técnica funcional; faltan colaborador, capturas y comprobaciones expresamente pendientes |

La preparación de JWT/negocio y la comprobación de `main/production` se incluyen para impedir afirmaciones de completitud indebidas; no se convierten en funcionalidades nuevas del alcance actual. El health de la aplicación devuelve un mapa fijo y no prueba la base. El ping documentado en la auditoría histórica fue contra MongoDB local y tampoco acredita Atlas desde Azure.

## Revisión de secretos

Se revisó la lista de archivos versionados, la configuración y las coincidencias de patrones de URI MongoDB con usuario/contraseña, claves privadas, tokens GitHub/Docker Hub/AWS, JWT y literales de credenciales Azure. No se detectaron credenciales reales en los archivos revisados. `.env.example` contiene un marcador JWT y una URI local; los tests contienen un marcador exclusivo de pruebas.

No se versionan `.env` reales, certificados/claves ni archivos de credenciales Azure/MongoDB identificados. Se comprobó que `.env`, `.env.local`, `.env.production`, `*.p12`, `*.pem`, `*.key`, `*.jks`, `*.pfx`, `azure-credentials.json`, `service-principal.json` y el reporte bajo `target/` son ignorados. `.env.example` es la excepción intencional.

La revisión inicial produjo una coincidencia amplia en el README por un ejemplo de generación de JWT con OpenSSL, revisado como código de ejemplo, no un secreto literal. No se imprimieron valores de entorno, credenciales ni URIs autenticadas. Solo se documentan la URL pública, el nombre del App Service y el nombre del clúster proporcionados por el estudiante; no se incorporan subscriptionId, tenantId, clientId, contraseñas ni cadenas privadas.

El escaneo final de patrones conocidos sobre los 45 archivos rastreados y los dos documentos nuevos produjo cero coincidencias. Se revisaron además los tres commits accesibles mediante búsqueda de nombres de archivos con patrones de URI autenticada, claves privadas y tokens reconocibles: cero coincidencias. El único archivo local con nombre `.env*` es `.env.example`. Esta revisión no incluyó objetos Git inaccesibles ni ramas remotas no disponibles localmente.

Esta revisión por patrones y lectura no demuestra ausencia absoluta de secretos arbitrarios ni inspecciona la configuración privada remota. No se afirma que tokens o credenciales externas hayan sido rotados o revocados.

## Acciones manuales pendientes del estudiante

1. Invitar al profesor como colaborador y confirmar aceptación/acceso. Mantener el estado pendiente hasta contar con esa confirmación.
2. Incorporar las 11 capturas auténticas E01–E11 conforme al [inventario](images/README.md); ocultar secretos conservando el contexto verificable y enlazar únicamente los archivos existentes.
3. Registrar URL, fecha, evento y SHA de la ejecución verde de Actions; URL/propietario/etiqueta/digest de Docker Hub. Vincular esa imagen con la ejecución y el despliegue sin inventar identificadores.
4. Confirmar las variables requeridas en Azure sin copiar sus valores privados al repositorio: URI Atlas por entorno, JWT Base64 de mínimo 32 bytes y puerto 8080 según el modelo de App Service. Verificar permisos y restricciones de staging sin modificarlos durante esta auditoría.
5. Comprobar desde Azure un ping o lectura autenticada no destructiva usando la misma URI de entorno y registrar el resultado sin revelar credenciales. Es una comprobación pendiente; no se ejecutó aquí ni se sustituyó por health o logs de monitoreo.
6. Confirmar la herramienta UML y el acceso a su cuenta, y verificar acceso a Figma. Sus cuentas no se dan por existentes solo por figurar en el README.
7. Contrastar en Maven Central las versiones estables compatibles indicadas por el HTML; no actualizar dependencias como parte de esta tarea documental. Revisar suscripción/costos/cuotas antes del laboratorio.

El grupo académico **ya está resuelto**: Grupo 1. JWT completo y negocio quedan reservados al laboratorio posterior. La configuración de producción se documenta como no verificada, sin solicitar ahora acciones sobre `main`.

## Restricciones respetadas

**No se ejecutó `git add`, `git commit`, `git push` ni `git merge`.** No se modificó `main`, no se crearon Pull Requests, no se desplegó en Azure, no se publicaron imágenes Docker ni se modificaron recursos remotos. No se generaron capturas falsas, sintéticas o simuladas. Se conservaron HEAD y archivos de implementación; la entrega queda con cambios exclusivamente documentales para revisión del estudiante.
