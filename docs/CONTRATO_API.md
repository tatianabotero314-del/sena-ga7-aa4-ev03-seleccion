# API REST implementada

Base: `/api`. Sesión en cookie; el navegador usa `credentials: include`.
El proxy Vite redirige a localhost:8080. Para producción servir frontend y API en
el mismo origen mediante proxy inverso; no se habilitan orígenes CORS arbitrarios.

| Método y ruta | Propósito | Permiso |
|---|---|---|
| GET /auth/csrf | Obtener token/header CSRF | Público |
| POST /auth/login | Formulario correo/password | Público + CSRF |
| GET /auth/me | Usuario y rol, sin hash | Autenticado |
| POST /auth/logout | Cerrar sesión | Sesión + CSRF |
| GET /candidatos?busqueda= | Buscar por nombre, apellido o documento | Ambos roles |
| GET /candidatos/{id} | Detalle | Ambos roles |
| POST /candidatos | Crear | Analista |
| PUT /candidatos/{id} | Actualizar | Analista |
| GET /vacantes | Listado de cargos y cupos | Ambos roles |
| GET /candidatos/{id}/postulaciones | Procesos de una persona | Ambos roles |
| POST /postulaciones | Crear relación idCandidato/idVacante | Analista |
| PATCH /postulaciones/{id}/estado | estado y observacion | Analista |
| GET /postulaciones/{id}/historial | Cambios y responsables | Ambos roles |

Candidato: tipoDocumento, numeroDocumento, nombres, apellidos, correo y telefono.
El servidor devuelve además id. Los números de identificación y teléfono son texto.
Estados permitidos: En proceso, Seleccionado, Rechazado.
El servidor obtiene el responsable desde la sesión; no lo acepta del formulario.

Respuestas: 200 consulta/edición; 201 creación; 204 cambio/logout; 400 validación;
401 falta de sesión; 403 falta de permiso o CSRF; 404 no encontrado; 409 duplicado,
vacante cerrada o estado repetido. Los errores de negocio incluyen `message`.

Todas las mutaciones usan el token obtenido en /auth/csrf, con el header devuelto.
Se vuelve a solicitar tras login/logout. BCrypt protege las contraseñas en la BD.
SQL parametrizado evita concatenar valores del usuario. Una transacción y bloqueo
de fila mantienen coordinados estado e historial. Restricciones UNIQUE evitan
personas repetidas por documento y postulaciones duplicadas.
