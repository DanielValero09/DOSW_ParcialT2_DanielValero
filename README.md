# DOSW_ParcialT2_DanielValero

Proyecto individual para el **Parcial Práctico del Segundo Tercio — DOSW**, basado en **Parte 1.1 · Prerrequisitos**.

> **Estado actual:** proyecto base MVC operativo localmente y desplegado en Azure. El estudiante confirmó el pipeline exitoso en `develop`, la publicación en Docker Hub y el acceso público a health y Swagger. La auditoría local del 12 de octubre de 2026 confirmó Maven y JaCoCo. La autenticación JWT completa y la lógica de negocio corresponden al laboratorio posterior. Las capturas auténticas todavía no están incorporadas al repositorio.

La [auditoría final](docs/reporte-final-prerrequisitos.md) distingue comprobaciones locales, resultados remotos aportados por el estudiante y pendientes. El [inventario de evidencias](docs/images/README.md) define los nombres sugeridos; no contiene imágenes simuladas.

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
| Grupo de DOSW | **Grupo 1**, confirmado por el estudiante |
| Institución | Escuela Colombiana de Ingeniería Julio Garavito |
| Trabajo | Individual |
| Profesor como colaborador | **Pendiente de agregar**; no existe confirmación de acceso |
| Repositorio | [DOSW_ParcialT2_DanielValero](https://github.com/DanielValero09/DOSW_ParcialT2_DanielValero) |
| Ramas | `main` y `develop` comprobadas localmente; revisión en `develop` |

## 2. Descripción del proyecto

Servicio REST base desarrollado con Java 21 y Spring Boot, separado en las capas controller, core y persistence.
Prepara el acceso configurable a MongoDB, las dependencias para JWT, Swagger y las herramientas de pruebas y cobertura.
Expone un endpoint público de salud para comprobar que el servicio responde y permitir el despliegue inicial.
La autenticación JWT completa, los roles y la lógica de negocio se implementarán durante el laboratorio posterior.

| Recurso | Ruta | Acceso |
|---|---|---|
| Estado del servicio | `GET /api/v1/health` | Público |
| Swagger UI | `/swagger-ui/index.html` | Público |
| Especificación OpenAPI | `/v3/api-docs` y `/v3/api-docs.yaml` | Público |

Spring Security usa sesiones `STATELESS` y exige autenticación en las demás rutas. Las dependencias JJWT y la configuración `JWT_SECRET` no acreditan un login JWT funcional. El health devuelve un estado fijo del servicio; no consulta MongoDB.

## 3. Despliegue

| Recurso | URL / estado |
|---|---|
| Servicio Azure | [Abrir aplicación](https://dosw-parcialt2-daniel-dev-hge6d7ghd4eab8ar.westus-01.azurewebsites.net) |
| Health público | [GET /api/v1/health](https://dosw-parcialt2-daniel-dev-hge6d7ghd4eab8ar.westus-01.azurewebsites.net/api/v1/health) |
| Swagger público | [Swagger UI](https://dosw-parcialt2-daniel-dev-hge6d7ghd4eab8ar.westus-01.azurewebsites.net/swagger-ui/index.html) |
| Docker Hub | Imagen publicada por el pipeline, confirmado por el estudiante; URL, propietario y etiqueta exacta pendientes de incorporar con evidencia |

App Service confirmado: **`dosw-parcialt2-daniel-dev`**, Linux, región **West US**. El estudiante abrió Swagger públicamente y ejecutó el health desde Swagger con **HTTP 200** y respuesta:

```json
{"status":"UP","service":"DOSW-ParcialT2"}
```

MongoDB Atlas: clúster **DOSW-ParcialT2**. Según los registros revisados por el estudiante, el driver desde Azure establece conexiones de monitoreo con el nodo primario y dos secundarios. **No se ha verificado un ping o una lectura autenticada desde Azure**. Ni esos logs ni el HTTP 200 de health prueban esa operación.

Estos resultados remotos provienen del contexto confirmado por el estudiante; no se repitieron ni se realizó un nuevo despliegue durante esta auditoría. Faltan las capturas enumeradas en el [inventario](docs/images/README.md).

## 4. Estructura del proyecto

```text
DOSW_ParcialT2_DanielValero/
├── docs/
│   ├── uml/                         Diagramas fuente (.gitkeep)
│   ├── images/                      Inventario y futuras capturas auténticas
│   ├── auditoria-primer-commit.md   Antecedente histórico del 10 de octubre
│   └── reporte-final-prerrequisitos.md
├── src/
│   ├── main/
│   │   ├── java/edu/dosw/parcial/
│   │   │   ├── controller/
│   │   │   │   ├── dtos/request/
│   │   │   │   ├── dtos/response/
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
│       │   ├── controller/           Replica DTOs, mappers y handlers
│       │   ├── core/                 Replica services, models, validators y utils
│       │   ├── persistence/          Replica entities, repositories y mappers
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

| Paquete | Responsabilidad prevista |
|---|---|
| `controller/` | Recibir HTTP y producir DTOs; contiene el health inicial |
| `controller/dtos/request/` | Entradas de la API |
| `controller/dtos/response/` | Salidas de la API |
| `controller/mappers/` | Mapper IN: DTO ↔ dominio |
| `controller/handlers/` | Tratamiento de excepciones HTTP |
| `core/models/` | Objetos de dominio |
| `core/services/` | Casos de uso |
| `core/validators/` | Reglas de negocio |
| `core/utils/` | Utilidades |
| `persistence/entities/` | Documentos MongoDB futuros con `@Document` |
| `persistence/repositories/` | Interfaces `MongoRepository` futuras |
| `persistence/mappers/` | Mapper OUT: dominio ↔ documento |
| `config/` | Seguridad inicial y OpenAPI |
| `main/` | Arranque con escaneo explícito de `edu.dosw.parcial` y repositorios |
| `src/test/` | Pruebas organizadas por capa |

Las carpetas vacías están conservadas mediante `.gitkeep`. Las responsabilidades de negocio son previstas: no existen todavía entidades, repositorios o mappers de negocio. El Controller no debe depender de documentos de persistencia y el Service no debe depender de DTOs.

## 5. Tecnologías y dependencias

| Tecnología | Versión configurada / referencia | Uso |
|---|---|---|
| Java | 21 | Lenguaje y runtime |
| Spring Boot | 3.5.16 | Aplicación web |
| Spring Web | Administrada por Spring Boot | REST HTTP |
| Spring Data MongoDB | Administrada por Spring Boot | Persistencia documental; sin JPA |
| Spring Validation | Administrada por Spring Boot | Validación de DTOs |
| Spring Security | Administrada por Spring Boot | Seguridad inicial |
| JJWT | 0.13.0 | Dependencias JWT para el laboratorio |
| springdoc | 2.8.16 | OpenAPI y Swagger |
| Lombok | Administrada por Spring Boot | Código repetitivo y soporte de `@Slf4j` |
| MapStruct | 1.6.3 | Generación de mappers |
| lombok-mapstruct-binding | 0.2.0 | Integración de procesadores de anotaciones |
| JUnit 5 y Mockito | Administradas por Spring Boot | Pruebas |
| JaCoCo | 0.8.15 | Cobertura |
| SonarScanner Maven | 5.2.0.4988 | Plugin y propiedades de análisis estático |
| Maven | 3.9.x recomendado | Construcción |
| Docker | Multietapa con Java 21 | Empaquetado |
| GitHub Actions | `ubuntu-latest` | CI/CD |
| Azure App Service | Contenedor Linux, West US | Hosting |
| MongoDB Atlas | Clúster DOSW-ParcialT2 | Base gestionada |

El POM configura los procesadores en el orden Lombok → lombok-mapstruct-binding → MapStruct, los goals JaCoCo `prepare-agent` y `report`, y las propiedades `sonar.*`. La compilación y las pruebas acreditan compatibilidad del proyecto base; esta auditoría no confirma que cada versión sea la estable más reciente ni que se haya ejecutado un análisis SonarQube.

## 6. Configuración y variables de entorno

| Variable | Descripción | Ejemplo sin secretos |
|---|---|---|
| `MONGODB_URI` | URI MongoDB, con valor local predeterminado | `mongodb://localhost:27017/dosw_parcial` |
| `JWT_SECRET` | Clave JWT Base64 de al menos 32 bytes; mínimo 44 caracteres codificados | `REEMPLAZAR` |
| `PORT` | Puerto de escucha Spring | `8080` |
| `WEBSITES_PORT` | Puerto de enrutamiento de App Service | `8080` |

`application.yaml` es el único archivo de configuración de aplicación. Lee MongoDB y JWT del entorno y define `jwt.expiration-ms=3600000`. Spring Boot no carga automáticamente `.env`; establecer las variables en la sesión o en el servicio que ejecuta la aplicación.

Los nombres usados por Actions son `DOCKERHUB_USERNAME`, `DOCKERHUB_TOKEN`, `AZURE_CREDENTIALS` y `AZURE_WEBAPP_NAME_DEVELOP`. Producción usa sus propias `AZURE_CREDENTIALS` y la variable `AZURE_WEBAPP_NAME_MAIN`. El workflow no consume `JWT_SECRET` ni `MONGODB_URI`: las pruebas usan configuración de test y las variables de ejecución se administran en Azure. La ubicación efectiva de secrets y las variables de Azure no se inspeccionó durante esta auditoría.

- `.env.example` contiene únicamente marcadores y una URI local sin credenciales.
- `.gitignore` excluye `.env` reales, certificados, claves, credenciales Azure y `target/`.
- Configurar la URI remota en Azure sin guardar usuario, contraseña o cadena de conexión en Git.
- Publicar solo los nombres de secrets, nunca sus valores o capturas que los expongan.

## 7. Cómo ejecutar

**Requisitos:** Java 21, Maven 3.9+, MongoDB local o remoto; Docker para las opciones con contenedores.

1. Reutilizar MongoDB local si ya está escuchando en 27017. Si el puerto está libre y no existe una instancia, crearla:

   ```bash
   docker run -d --name mongo-parcial -p 27017:27017 mongo:7
   ```

2. En PowerShell, generar una clave temporal y configurar las variables sin imprimir secretos:

   ```powershell
   $jwtBytes = New-Object byte[] 32
   $jwtRandom = [Security.Cryptography.RandomNumberGenerator]::Create()
   try { $jwtRandom.GetBytes($jwtBytes) } finally { $jwtRandom.Dispose() }
   $env:JWT_SECRET = [Convert]::ToBase64String($jwtBytes)
   $env:MONGODB_URI = "mongodb://localhost:27017/dosw_parcial"
   mvn spring-boot:run
   ```

3. Abrir `http://localhost:8080/api/v1/health` y `http://localhost:8080/swagger-ui/index.html`.
4. Para ejecutar la aplicación en Docker, seguir los comandos de la [sección 9](#9-docker), conservando las variables de la sesión.

En Linux/macOS, generar `JWT_SECRET` con `openssl rand -base64 32`, exportar las variables y ejecutar `mvn spring-boot:run`.

## 8. Pruebas

```bash
mvn test
mvn clean verify
```

El primer comando ejecuta las pruebas; el segundo limpia, prueba, genera cobertura y empaqueta. El **12 de octubre de 2026**, `mvn clean verify` terminó con **BUILD SUCCESS**, salida **0**, **7 pruebas, 0 failures, 0 errors y 0 skipped**, con Java **21.0.10**. Tiempo total: **30,341 s**.

| Métrica JaCoCo | Cubierto / total | Resultado |
|---|---|---|
| Líneas | 17/19 | **89,47 %** |
| Instrucciones | 82/87 | 94,25 % |
| Métodos | 10/11 | 90,91 % |
| Clases | 4/4 | 100 % |

Se revisaron los reportes [HTML local](target/site/jacoco/index.html) y [XML local](target/site/jacoco/jacoco.xml), generados por Maven y excluidos de Git. En un clon nuevo deben regenerarse. El porcentaje de 94 % mostrado en el resumen HTML corresponde a instrucciones, no a líneas. No hay contador de ramas ni umbral mínimo configurado.

Las siete pruebas comprueban el controlador de salud, su respuesta HTTP pública, Swagger, OpenAPI JSON/YAML, el rechazo de solicitudes anónimas a otras rutas y una sola cadena de seguridad. No ejecutan consultas MongoDB ni validan JWT completo. Los avisos de Mockito/Byte Buddy y Springdoc no produjeron fallos.

**Capturas pendientes:** `01-maven-build-success.png` y `02-jacoco-reporte.png`, según el [inventario](docs/images/README.md). No existen imágenes verificables que enlazar todavía.

## 9. Docker

El [Dockerfile](Dockerfile) tiene dos etapas: Maven/Temurin 21 ejecuta `mvn -B clean verify --no-transfer-progress`; la imagen final Temurin 21 JRE copia el JAR y expone el puerto 8080. [.dockerignore](.dockerignore) excluye documentación, generados, entornos y secretos.

```bash
docker build -t dosw-parcial:local .
```

Con `JWT_SECRET` generado en la sesión de PowerShell y MongoDB del host accesible:

```powershell
$env:MONGODB_URI = "mongodb://host.docker.internal:27017/dosw_parcial"
docker run --rm -p 127.0.0.1:8081:8080 -e JWT_SECRET -e MONGODB_URI dosw-parcial:local
```

En Windows/Mac, `host.docker.internal` permite alcanzar MongoDB del host; `localhost` dentro del contenedor identifica al propio contenedor. El puerto 8081 del host debe estar libre. Comprobar `http://localhost:8081/api/v1/health` y `http://localhost:8081/swagger-ui/index.html`.

**Resultados existentes:** construcción y ejecución local satisfactorias, confirmadas por el estudiante. La [auditoría histórica](docs/auditoria-primer-commit.md) registra build con pruebas y un contenedor con health/Swagger HTTP 200. La imagen también fue publicada en Docker Hub mediante Actions. No se reconstruyó, arrancó ni publicó una imagen durante esta auditoría final.

La comprobación histórica de ping contra MongoDB local no acredita una operación autenticada contra Atlas desde Azure. **Capturas pendientes:** `03-docker-contenedor.png` y `04-dockerhub-imagen-publicada.png`.

## 10. CI/CD

El [workflow](.github/workflows/ci-cd.yml) se activa con push a `main` o `develop` y permite ejecución manual en esas ramas:

1. `test`: configura Java 21, ejecuta `mvn -B clean verify --no-transfer-progress` y conserva reportes JaCoCo/Surefire como artefactos.
2. `docker`: construye la imagen Linux AMD64 con Buildx, valida los nombres de secrets requeridos, inicia sesión en Docker Hub y publica la imagen construida.
3. `deploy_develop` o `deploy_main`: según la rama, inicia sesión en Azure y despliega la etiqueta única entregada por el job `docker`.

**Ejecución remota confirmada por el estudiante en `develop`:** `test`, `docker` y `deploy_develop` exitosos; `deploy_main` omitido correctamente por su condición de rama. La imagen fue publicada en Docker Hub y la aplicación quedó accesible en Azure. Faltan el enlace de la ejecución, su SHA, la etiqueta/digest y las capturas para corroborarlo desde el repositorio. No se declara probado un despliegue desde `main`.

| Rama | Entorno declarado | Etiquetas publicadas | Destino Azure declarado |
|---|---|---|---|
| `develop` | `staging` | `develop-<SHA>-<run_id>-<run_attempt>` y alias `develop` | Secret `AZURE_WEBAPP_NAME_DEVELOP`; App Service confirmado `dosw-parcialt2-daniel-dev` |
| `main` | `production` | `main-<SHA>-<run_id>-<run_attempt>`, alias `main` y `latest` | Variable `AZURE_WEBAPP_NAME_MAIN`; configuración remota no verificada |

Azure consume la etiqueta única publicada. `develop` no publica `latest`. La separación por ramas y la entrega de la etiqueta son verificables en el workflow; el aislamiento efectivo de permisos y destinos remotos no se inspeccionó. La concurrencia por rama usa `cancel-in-progress: false`.

| Ámbito previsto | Nombres de configuración, sin valores |
|---|---|
| Publicación Docker Hub | Secrets `DOCKERHUB_USERNAME`, `DOCKERHUB_TOKEN` |
| GitHub Environment `staging` | Secrets `AZURE_CREDENTIALS`, `AZURE_WEBAPP_NAME_DEVELOP` |
| GitHub Environment `production` | Secret `AZURE_CREDENTIALS`, variable `AZURE_WEBAPP_NAME_MAIN` |
| Azure, ejecución de la aplicación | `MONGODB_URI`, `JWT_SECRET`, `WEBSITES_PORT` (puerto 8080) |

El pipeline operativo de `develop` reemplaza el estado anterior de preparación pendiente. Su éxito no acredita un ping o lectura autenticada en Atlas. Las pruebas CI no requieren credenciales reales de JWT ni operaciones sobre MongoDB. La configuración y ejecución de producción siguen sin verificarse y no se necesitan para documentar el despliegue de desarrollo.

**Evidencias pendientes de incorporar:** `05-github-actions-develop.png`, `04-dockerhub-imagen-publicada.png`, `06-azure-health-http-200.png` y `07-azure-swagger-ui.png`. Ver el [inventario](docs/images/README.md) y la [tabla de cumplimiento](docs/reporte-final-prerrequisitos.md#tabla-de-cumplimiento).

## 11. Herramientas de modelado y diseño (evidencias)

Herramienta UML: **pendiente de confirmar la selección y el acceso a la cuenta** (Lucidchart, Draw.io o Miro). `docs/uml/` conserva `.gitkeep`; no contiene diagramas del laboratorio.

Herramienta de interfaces: **Figma**; el acceso a una cuenta **no está verificado**.

- Captura UML pendiente: `10-cuenta-uml.png`.
- Captura Figma pendiente: `11-cuenta-figma.png`.

No hay capturas auténticas en el repositorio que permitan insertar referencias Markdown a imágenes existentes. Incorporarlas y enlazarlas solo después de comprobar su contenido, según el [inventario](docs/images/README.md).

Pendientes del estudiante: agregar al profesor y confirmar su acceso; aportar las capturas reales; completar enlaces de Actions y Docker Hub; verificar una operación MongoDB autenticada desde Azure y las cuentas UML/Figma. El grupo ya está registrado como **Grupo 1**. El detalle y las limitaciones de evidencia figuran en la [auditoría final](docs/reporte-final-prerrequisitos.md).
