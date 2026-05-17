# Gestión Académica

Sistema de gestión académica en **Java 21**, **Swing** (NetBeans GUI Builder) y **PostgreSQL**. Permite administrar carreras, asignaturas, estudiantes, profesores, cursos impartidos, inscripciones y notas.

## Estructura del proyecto

```
GESTION-ACADEMICA/
├── src/main/java/com/mycompany/gestion/academica/
│   ├── modelo/                  # Entidades (Carrera, Estudiante, Inscripcion, …)
│   ├── dao/                     # Acceso a datos (JDBC)
│   ├── servicio/                # Reglas de negocio y validaciones
│   ├── controlador/             # Puente entre vista y servicio
│   ├── util/                    # Conexión BD, sesión, utilidades UI
│   └── vista/                   # Formularios Swing (.java + .form)
├── pom.xml
└── README.md
```

### Capas

| Capa | Paquete | Responsabilidad |
|------|---------|-----------------|
| Vista | `vista` | Formularios, tablas, eventos de usuario |
| Controlador | `controlador` | Delegar operaciones al servicio |
| Servicio | `servicio` | Validaciones y orquestación |
| DAO | `dao` | Consultas SQL a PostgreSQL |
| Modelo | `modelo` | Clases de dominio |
| Util | `util` | `ConexionBD`, `Sesion`, `ComboItem` |

### Pantallas (`vista/`)

| Formulario | Tabla(s) principal(es) |
|------------|-------------------------|
| `Login` | Autenticación |
| `MenuPrincipal` | Menú según rol |
| `FrmCarrera` | `Carreras` |
| `FrmAsignatura` | `Asignaturas` |
| `FrmUsuario` | `Estudiantes`, `Profesores` |
| `FrmAsignaturaCarrera` | `Incluye` |
| `FrmRequisitoAsignatura` | `Requiere` |
| `FrmCursoImpartido` | `Imparte` |
| `FrmAsignacionCursos` | `Inscribe` |
| `FrmNotas` | `Inscribe` (notas y definitiva) |

Cada `Frm*.java` tiene su `Frm*.form` asociado para editar el diseño en NetBeans.

## Requisitos

- JDK 21+
- Maven 3.9+
- PostgreSQL 14+ (local o AWS RDS)
- NetBeans 21+ (recomendado para editar `.form`)

## Conexión a PostgreSQL

La clase `util.ConexionBD` lee la configuración desde **variables de entorno**:

| Variable | Por defecto | Descripción |
|----------|-------------|-------------|
| `DB_HOST` | `localhost` | Servidor |
| `DB_PORT` | `5432` | Puerto |
| `DB_NAME` | `postgres` | Base de datos |
| `DB_USER` | `postgres` | Usuario |
| `DB_PASSWORD` |  | Contraseña |


## Ejecutar la aplicación

```bash
mvn compile exec:java
```

## Acceso al sistema

| Tipo | Usuario | Contraseña |
|------|---------|------------|
| Administrador | `admin` | `1234` |
| Estudiante | Código `cod_e` (tabla `Estudiantes`) | `1234` |
| Profesor | ID `id_p` (tabla `Profesores`) | `1234` |

### Menú por rol

- **Administrador:** todas las opciones.
- **Estudiante:** Asignación de cursos, Registro de notas.
- **Profesor:** Cursos impartidos, Registro de notas.

La sesión activa se guarda en `util.Sesion`.

 Compilar

```bash
mvn compile
```
