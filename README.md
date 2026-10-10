# DOSW_ParcialT2_DanielValero

Proyecto individual para el **Parcial Práctico del Segundo Tercio – DOSW**, basado en el documento **Parte 1.1 · Prerrequisitos**.

> **Estado actual:** scaffolding MVC, dependencias, configuración y automatización preparadas. La autenticación JWT y la lógica de negocio se implementarán en el laboratorio. El despliegue, la ejecución del pipeline y las evidencias deben verificarse en cuentas reales; no se declaran completados sin pruebas.

## Índice
1. [Datos del estudiante](#1-datos-del-estudiante)
2. [Descripción del proyecto](#2-descripción-del-proyecto)
3. [Despliegue](#3-despliegue)
4. [Estructura del proyecto](#4-estructura-del-proyecto)
5. [Tecnologías y dependencias](#5-tecnologías-y-dependencias)
6. [Configuración y variables de entorno](#6-configuración-y-variables-de-entorno)
7. [Cómo ejecutar](#7-cómo-ejecutar)
8. [Pruebas](#8-pruebas)
9. [Docker](#9-docker)
10. [CI/CD](#10-cicd)
11. [Herramientas de modelado y diseño (evidencias)](#11-herramientas-de-modelado-y-diseño-evidencias)

## 1. Datos del estudiante

| Campo | Información |
|---|---|
| Nombre completo | Daniel Valero Quiroga |
| Grupo de DOSW | **PENDIENTE: registrar el grupo real** |
| Institución | Escuela Colombiana de Ingeniería Julio Garavito |
| Trabajo | Individual |
| Profesor como colaborador | **PENDIENTE: agregar desde Settings → Collaborators** |
| Repositorio | `DOSW_ParcialT2_DanielValero` |
| Ramas | `main` y `develop` existentes; trabajo local en `develop` |

## 2. Descripción del proyecto

Servicio REST base desarrollado con Java 21 y Spring Boot, organizado siguiendo la separación MVC por capas de controller, core y persistence. Prepara el acceso configurable a MongoDB, dependencias para seguridad con JWT, documentación Swagger y calidad con JUnit, Mockito, JaCoCo y SonarQube. La aplicación expone únicamente un endpoint de salud para comprobar el arranque y permitir un despliegue inicial verificable. La lógica de negocio del parcial se construirá posteriormente.

**Endpoints iniciales:**

| Recurso | Ruta | Acceso |
|---|---|---|
| Estado de servicio | `GET /api/v1/health` | Público |
| Swagger UI | `/swagger-ui/index.html` | Público |
| Especificación OpenAPI | `/v3/api-docs` | Público |

La presencia de JJWT y Spring Security **no implica que exista un login JWT funcional**: se implementará en el laboratorio. Cualquier otra ruta requiere autenticación, pero aún no existe un mecanismo JWT de autenticación.

## 3. Despliegue

| Recurso | URL / estado |
|---|---|
| App Service de Azure | **PENDIENTE: pegar URL real** |
| Health público | **PENDIENTE: registrar URL real y comprobar HTTP 200** |
| Swagger público | **PENDIENTE: registrar URL real y comprobar acceso público** |
| Docker Hub | **PENDIENTE: registrar URL real de la imagen publicada** |

La publicación depende de disponer de suscripción Azure, registro de imágenes y credenciales externas. No se ha realizado durante la preparación de esta plantilla.

## 4. Estructura del proyecto

```text
DOSW_ParcialT2_DanielValero/
├── docs/
│   ├── uml/                      Diagramas fuente
│   └── images/                   Capturas, exportes y evidencias
├── src/
│   ├── main/
│   │   ├── java/edu/dosw/parcial/
│   │   │   ├── controller/
│   │   │   │   ├── dtos/
│   │   │   │   │   ├── request/
│   │   │   │   │   └── response/
│   │   │   │   ├── mappers/
│   │   │   │   └── handlers/
│   │   │   ├── core/
│   │   │   │   ├── services/
│   │   │   │   ├── models/
│   │   │   │   ├── validators/
│   │   │   │   └── utils/
│   │   │   ├── persistence/
│   │   │   │   ├── entities/
│   │   │   │   ├── repositories/
│   │   │   │   └── mappers/
│   │   │   ├── config/
│   │   │   └── main/
│   │   └── resources/application.yaml
│   └── test/
│       ├── java/edu/dosw/parcial/
│       │   ├── controller/
│       │   ├── core/
│       │   ├── persistence/
│       │   ├── config/
│       │   └── main/
│       └── resources/
├── .github/workflows/ci-cd.yml
├── Dockerfile
├── .dockerignore
├── .gitignore
├── .env.example
├── pom.xml
└── README.md
```

**Responsabilidades:** `controller/` recibe solicitudes HTTP y produce DTOs; `controller/dtos/request/` define entradas; `controller/dtos/response/` define salidas; `controller/mappers/` traduce entre DTOs y dominio (Mapper IN); `controller/handlers/` maneja excepciones HTTP. `core/models/` contiene objetos de dominio; `core/services/` contiene casos de uso; `core/validators/` agrupa reglas de negocio y `core/utils/` utilidades. `persistence/entities/` contiene documentos anotados `@Document`; `persistence/repositories/` contiene interfaces `MongoRepository`; `persistence/mappers/` traduce dominio y documento (Mapper OUT). `config/` aloja configuración de seguridad y Swagger; `main/` contiene el arranque con escaneo desde `edu.dosw.parcial`. La estructura de `src/test/` permite pruebas separadas por capa.

> Las carpetas sin código tienen `.gitkeep`, porque Git no guarda directorios vacíos. No crear entidades del dominio antes de conocer el enunciado del laboratorio.

Los paquetes de pruebas replican los subpaquetes de `controller`, `core` y `persistence`, además de `config` y `main`.

## 5. Tecnologías y dependencias

| Tecnología | Versión de referencia | Uso |
|---|---|---|
| Java | 21 | Lenguaje y runtime |
| Spring Boot | 3.5.16 | Aplicación web |
| Spring Web | Administrada por Spring Boot | REST HTTP |
| Spring Data MongoDB | Administrada por Spring Boot | Persistencia documental |
| Spring Validation | Administrada por Spring Boot | Validación de DTOs |
| Spring Security | Administrada por Spring Boot | Seguridad base |
| JJWT | 0.13.0 | JWT en el laboratorio |
| springdoc | 2.8.16 | OpenAPI y Swagger |
| Lombok | Administrada por Spring Boot | Código repetitivo y `@Slf4j` |
| MapStruct | 1.6.3 | Generación de mappers |
| JUnit 5 y Mockito | Administradas por Spring Boot | Pruebas unitarias |
| JaCoCo | 0.8.15 | Cobertura |
| SonarScanner Maven | 5.2.0.4988 | Análisis estático |
| Maven | 3.9.x recomendado | Construcción |
| Docker | Compatible con multietapa | Empaquetado |
| GitHub Actions | `ubuntu-latest` | CI/CD |
| Azure App Service | Contenedor Linux | Hosting |

## 6. Configuración y variables de entorno

| Variable | Descripción | Ejemplo NO secreto |
|---|---|---|
| `MONGODB_URI` | URI de MongoDB; predeterminado local | `mongodb://localhost:27017/dosw_parcial` |
| `JWT_SECRET` | Clave JWT Base64 aleatoria de 32 bytes o más | `REEMPLAZAR` |
| `PORT` | Puerto de escucha en Spring | `8080` |
| `WEBSITES_PORT` | Puerto expuesto a Azure App Service | `8080` |

Secrets de GitHub usados por Actions: `DOCKERHUB_USERNAME`, `DOCKERHUB_TOKEN` y `AZURE_CREDENTIALS`. Variables del repositorio: `AZURE_WEBAPP_NAME_DEVELOP` y `AZURE_WEBAPP_NAME_MAIN`. Los destinos y la configuración de los entornos se explican en la sección 10. `JWT_SECRET` se configura en Azure; las pruebas usan un marcador exclusivo de test y no necesitan secretos reales.

- No versionar secretos en `.env`, `.p12` o archivos de configuración.
- `.env.example` es un ejemplo de nombres, **sin valores auténticos**.
- La URL MongoDB remota se configura en **Azure App Service → Environment variables** (o Configuration), nunca en Git.
- La clave `JWT_SECRET` debe ser Base64. El ejemplo de ejecución siguiente genera 32 bytes aleatorios en la sesión, sin imprimirlos. No pegar su resultado en un commit.
- El archivo de configuración es exclusivamente `application.yaml`.

## 7. Cómo ejecutar

**Requisitos:** Java 21, Maven 3.9+, Docker (opcional) y MongoDB local o remoto.

1. Si ya existe MongoDB local en el puerto 27017, reutilizar esa instancia mediante `MONGODB_URI`. Si no existe y el puerto está libre, crear una instancia (terminal):
   ```bash
   docker run -d --name mongo-parcial -p 27017:27017 mongo:7
   ```
2. En PowerShell, establecer JWT antes de arrancar (solo en la sesión):
   ```powershell
   $jwtBytes = New-Object byte[] 32
   $jwtRandom = [Security.Cryptography.RandomNumberGenerator]::Create()
   try { $jwtRandom.GetBytes($jwtBytes) } finally { $jwtRandom.Dispose() }
   $env:JWT_SECRET = [Convert]::ToBase64String($jwtBytes)
   $env:MONGODB_URI="mongodb://localhost:27017/dosw_parcial"
   mvn spring-boot:run
   ```
3. Verificar `http://localhost:8080/api/v1/health` y `http://localhost:8080/swagger-ui/index.html`.

En Linux/macOS se puede usar `export JWT_SECRET="$(openssl rand -base64 32)"` y `mvn spring-boot:run`.

## 8. Pruebas

```bash
mvn clean verify
```

Incluye una prueba JUnit + Mockito del controlador de salud, una prueba MVC para validar la respuesta HTTP pública y pruebas del contexto completo para comprobar Swagger UI, OpenAPI JSON/YAML, rechazo de rutas protegidas sin autenticación y una única cadena de seguridad. Estas pruebas no consultan MongoDB ni verifican conectividad remota. JaCoCo genera reportes HTML y XML en `target/site/jacoco/`.

Verificación local repetida el 10 de octubre de 2026, con Java 21.0.10 y Maven 3.9.16: `mvn clean verify` terminó en **BUILD SUCCESS**, con **7 pruebas, 0 failures, 0 errors y 0 skipped**. Se comprobaron `target/site/jacoco/index.html` y `target/site/jacoco/jacoco.xml`: cobertura de líneas **17/19 (89,47 %)** y de instrucciones **82/87 (94,25 %)**. Son resultados del proyecto base, sin funcionalidades de negocio.

**Evidencias a capturar al ejecutar:**
- [ ] `mvn clean verify` con `BUILD SUCCESS` (guardar captura en `docs/images/`).
- [ ] Vista del reporte JaCoCo real (guardar captura en `docs/images/`).

No presentar capturas simuladas como evidencia de una ejecución.

## 9. Docker

```bash
docker build -t dosw-parcial:local .
```

Verificación local del 9 de octubre de 2026: las imágenes base se descargaron y `docker build -t dosw-parcial:local .` terminó correctamente. El error anterior `lookup auth.docker.io: no such host` no se reprodujo; no se modificaron configuraciones globales de DNS, proxy o TLS. También se ejecutó `mvn clean verify` en la etapa builder Linux con Java 21: **BUILD SUCCESS, 7 pruebas, 0 failures, 0 errors y 0 skipped**.

El 10 de octubre se modificó el Dockerfile para ejecutar `mvn -B clean verify --no-transfer-progress` durante cada construcción, sin `-DskipTests`. Se ejecutó `docker build -t dosw-parcial:cicd-validation .`: salida 0, **BUILD SUCCESS** en el builder Linux con Java 21.0.12.1 y **7 pruebas, 0 failures, 0 errors y 0 skipped**. Esta imagen es local; no se publicó, desplegó ni arrancó un contenedor nuevo en esta revisión.

Para ejecutarlo desde PowerShell, con `JWT_SECRET` y `MONGODB_URI` establecidos:

```powershell
$env:MONGODB_URI = "mongodb://host.docker.internal:27017/dosw_parcial"
docker run --rm -p 127.0.0.1:8081:8080 -e JWT_SECRET -e MONGODB_URI dosw-parcial:local
```

En Windows/Mac, la URI MongoDB `localhost` dentro del contenedor apunta al propio contenedor. Para MongoDB en el host o publicado en su puerto 27017, usar `host.docker.internal` como en el ejemplo, o una red Docker compartida. El puerto 8081 del host debe estar libre; Spring Boot conserva su puerto interno 8080.

En este equipo, `american-bites-api` conserva el puerto 8080 de Windows. Se creó `dosw-parcial-win-b703a72a` con el mapeo **127.0.0.1:8081:8080**, sin alterar los servicios existentes. Las peticiones desde PowerShell a `http://localhost:8081` verificaron:

| Ruta | Resultado real |
|---|---|
| `/api/v1/health` | HTTP 200; `status=UP`, `service=DOSW-ParcialT2` |
| `/swagger-ui/index.html` | HTTP 200; Swagger UI |
| `/v3/api-docs` | HTTP 200; OpenAPI JSON con GET health |
| `/v3/api-docs.yaml` | HTTP 200; OpenAPI YAML con GET health |
| `/api/v1/recurso-protegido`, sin credenciales | HTTP 403 |

La conectividad MongoDB se comprobó por separado desde el nuevo contenedor, usando su URI de entorno y el driver de la imagen: **ping `ok=1` y lectura de metadatos de `dosw_parcial` satisfactoria**, sin escribir datos. El health solo informa que el servicio responde. Las capturas auténticas en `docs/images/` siguen pendientes.

La auditoría previa al primer commit y su lista exacta de archivos están en [docs/auditoria-primer-commit.md](docs/auditoria-primer-commit.md).

## 10. CI/CD

`.github/workflows/ci-cd.yml` conserva el pipeline completo del HTML del parcial (secciones 6 y 7) tras un `push` a `main` o `develop`. También permite ejecución manual exclusivamente en esas ramas:

1. `test`: Java 21 (Temurin), `mvn -B clean verify --no-transfer-progress` y artefactos JaCoCo y Surefire. La ausencia de reportes es un error. Las siete pruebas actuales no consultan MongoDB; no se omiten pruebas ni se requiere `JWT_SECRET` real para CI.
2. `docker`: Buildx construye y carga la imagen Linux AMD64 sin credenciales. El Dockerfile también ejecuta `clean verify`. Después se comprueban los requisitos, se autentica en Docker Hub y se publica exactamente la imagen construida.
3. `deploy`: valida los requisitos, inicia sesión con `azure/login@v2` y despliega mediante `azure/webapps-deploy@v3` la etiqueta única publicada por esa ejecución.

| Rama | Entorno GitHub | Etiquetas publicadas | Destino Azure |
|---|---|---|---|
| `develop` | `staging` | `develop-<SHA completo>-<run_id>-<run_attempt>` y alias `develop` | `vars.AZURE_WEBAPP_NAME_DEVELOP` |
| `main` | `production` | `main-<SHA completo>-<run_id>-<run_attempt>`, alias `main` y `latest` | `vars.AZURE_WEBAPP_NAME_MAIN` |

Azure consume la etiqueta única, nunca los alias. Cada reejecución tiene una etiqueta diferente; `develop` no publica `latest`. Ambos nombres de App Service deben estar definidos y ser distintos, incluso sin distinguir mayúsculas. El workflow falla antes de publicar si ambos destinos coinciden. La concurrencia por rama permite una ejecución activa sin cancelarla durante la publicación o el despliegue. GitHub puede reemplazar una ejecución pendiente por otra más reciente y no garantiza orden FIFO; no usar la reejecución de un commit antiguo como si fuera una promoción nueva.

Preparación manual requerida **antes del push a `develop`**:

- Crear el repositorio Docker Hub `usuario/dosw-parcial-t2`. Guardar `DOCKERHUB_USERNAME` y `DOCKERHUB_TOKEN` como secrets de Actions; el token debe permitir publicar en ese repositorio.
- Crear los entornos GitHub `staging` y `production`, limitados respectivamente a `develop` y `main`. Guardar en cada entorno su propio `AZURE_CREDENTIALS` (JSON de Service Principal con `clientId`, `clientSecret`, `subscriptionId` y `tenantId`), con permisos limitados al App Service correspondiente. Si los secrets de Docker Hub son de entorno, deben existir en ambos y apuntar al mismo repositorio Docker Hub. No copiar valores a archivos.
- Configurar en **Settings → Secrets and variables → Actions → Variables**, a nivel repositorio, `AZURE_WEBAPP_NAME_DEVELOP` y `AZURE_WEBAPP_NAME_MAIN`, con nombres reales de dos App Services distintos. No sobrescribir estas variables desde los entornos. El antiguo secret único `AZURE_WEBAPP_NAME` ya no se usa: esta separación evita compartir accidentalmente el destino.
- Crear ambos App Services Linux para un único contenedor; no se usa intercambio de slots. Configurar en cada uno `MONGODB_URI` remota, `JWT_SECRET` Base64 aleatoria de al menos 32 bytes y `WEBSITES_PORT=8080` (puerto de destino 8080 si se utiliza el modelo con sidecar). Para un registro privado, configurar además la autenticación de Docker Hub en Azure. La autenticación del runner no configura la descarga de imágenes en App Service.
- Verificar que Azure puede alcanzar MongoDB y descargar la imagen. Para una ejecución inmediata en `develop`, `staging` no debe exigir una aprobación manual pendiente. Producción puede tener revisores si el plan de GitHub lo permite.

**Sin estos requisitos no se garantiza una ejecución verde completa.** La falta de credenciales produce un error explícito; no se omiten publicación o despliegue para simular éxito. `JWT_SECRET` y `MONGODB_URI` de ejecución permanecen en Azure: el workflow no las configura ni las valida remotamente. Un job de despliegue exitoso tampoco demuestra por sí solo HTTP 200; comprobar health y Swagger públicamente después.

El 10 de octubre de 2026 se validó localmente el workflow corregido con **actionlint 1.7.12**, sin errores (salida 0). Esta comprobación no ejecuta Actions ni valida credenciales, publicación o despliegue. Los entornos y su aislamiento se basan en la [documentación de GitHub](https://docs.github.com/en/actions/concepts/workflows-and-actions/deployment-environments); la serialización se explica en [concurrencia de Actions](https://docs.github.com/en/actions/concepts/workflows-and-actions/concurrency), y la acción de despliegue está documentada en [Azure/webapps-deploy](https://github.com/Azure/webapps-deploy).

**Evidencias pendientes:**
- [ ] Captura real de Actions en verde (`docs/images/`).
- [ ] Captura de Docker Hub con imagen publicada (`docs/images/`).
- [ ] URL Azure /health con respuesta 200 (`docs/images/`).
- [ ] URL Swagger cargando (`docs/images/`).

La revisión local, los requisitos pendientes y la lista exacta del commit están en [docs/auditoria-primer-commit.md](docs/auditoria-primer-commit.md). La estrategia está aplicada a los archivos locales; la configuración remota y sus evidencias siguen pendientes.

## 11. Herramientas de modelado y diseño (evidencias)

Herramienta elegida para UML: **PENDIENTE (Draw.io, Lucidchart o Miro)**.

Herramienta para UI: **Figma**.

- [ ] Captura **real** de acceso a la herramienta de UML guardada en `docs/images/` y enlazada aquí.
- [ ] Captura **real** de acceso a Figma guardada en `docs/images/` y enlazada aquí.

Una vez agregadas las imágenes, insertar sus enlaces de Markdown en esta sección, por ejemplo `![Cuenta de Figma](docs/images/figma-cuenta.png)`.

---

**Prerrequisitos externos pendientes de comprobación:** invitar al profesor, configurar Docker Hub y Azure, comprobar Actions en verde, y adjuntar capturas auténticas y URL del despliegue. El repositorio y las ramas `main` y `develop` ya existen.
