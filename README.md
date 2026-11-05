# Selección de personal · GA7-220501096-AA4-EV03

Laura Tatiana Ciro Botero · SENA · Ficha 3235898 · 2026.

Aplicación web React + Vite conectada a una API real de Spring Boot. Los candidatos,
postulaciones y cambios de estado se guardan en una base relacional del servidor.

## Ejecución local

Requisitos: Node.js 22.12+ (o 24), Java 17+ y Maven 3.9+.

1. En una terminal: `cd backend` y `mvn spring-boot:run`.
2. En otra: `cd frontend`, `npm install` y `npm run dev`.
3. Abrir http://localhost:5173. La API escucha en el puerto 8080.

No es necesario instalar MySQL para practicar: el perfil por defecto crea H2 en
`backend/data`. Los datos se conservan al reiniciar. No borrar esa carpeta si se
quieren conservar. El ZIP no incluye datos privados, dependencias descargables ni
archivos de compilación; incluye todos los archivos fuente y configuración.

## Cuentas de práctica

- `analista@demo.local`: registra, edita, postula y cambia estados.
- `coordinador@demo.local`: solo consulta.
- Contraseña inicial de ambas cuentas: `Practica2026!`.

Estas cuentas son exclusivamente educativas. `DEMO_PASSWORD` permite definir otra
clave al inicializar una base nueva; `DEMO_ENABLED=false` desactiva la siembra.
Los usuarios se guardan con BCrypt; la sesión usa cookie HttpOnly y CSRF.

## MySQL opcional

Crear una base **nueva** llamada `seleccion_personal_ev03`. Definir DB_USER y
DB_PASSWORD en el entorno y ejecutar `mvn spring-boot:run
-Dspring-boot.run.profiles=mysql` (en una sola línea). DB_URL permite cambiar la URL.
No apuntar a la base de evidencias anteriores: este proyecto mantiene las ocho
entidades, pero tiene su propia estructura de ejecución y datos de práctica.
El perfil MySQL está configurado; las pruebas automatizadas utilizan H2.

## Comandos de verificación

Frontend: `npm run lint`, `npm test`, `npm run build`.
Backend: `mvn test` o `mvn verify`.
Con Spring Boot iniciado y una base de práctica nueva: en frontend ejecutar
`npx playwright install chromium` y `npm run test:e2e`.
Las pruebas de navegador registran EV03-001; usar una base aislada nueva para repetirlas.

## Organización

- `frontend/src/components`: componentes reutilizables en PascalCase.
- `frontend/src/pages`: pantallas y navegación.
- `frontend/src/services`: conexión API y validaciones.
- `frontend/src/context`: sesión y permisos visuales.
- `backend/src/main/java`: controlador, servicio, seguridad y validación.
- `backend/src/main/resources`: esquema SQL y configuración H2/MySQL.
- `docs`: contrato API y decisiones de diseño.

## Uso

Ingresar, abrir Candidatos, registrar o buscar, abrir Ver detalle, escoger una
vacante, crear la postulación y cambiar su estado dejando una observación.
Ver historial muestra los cambios y quién los realizó. La selección no equivale
a contratación. Cada postulación conserva su estado independiente.

## Alcance

Aplicación web adaptable; no es una aplicación nativa móvil. Se implementan las
necesidades del sistema de selección descritas en EV02. La gestión administrativa
de usuarios y vacantes y el envío de correos de recuperación quedan fuera del módulo.
La página Ayuda explica cómo solicitar soporte; no simula un correo enviado.
El prototipo GA5 aporta la paleta azul, encabezado, menú, formularios y pie; EV02
precisa los componentes del dominio que aquí se implementan.

## Versionamiento

Git registra la implementación y ajustes. GitHub Actions compila React con Vite,
ejecuta las pruebas de Spring Boot y abre Chromium para probar la navegación
contra la API real. Los resultados de cada ejecución se consultan en Actions.

Repositorio: https://github.com/tatianabotero314-del/sena-ga7-aa4-ev03-seleccion
