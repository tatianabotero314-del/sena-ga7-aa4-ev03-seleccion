# Demostración de versionamiento para GA7-AA1-EV05

Este archivo documenta un cambio de ejemplo en el sistema de selección de personal. Git conserva el historial de forma local; GitHub recibe la rama publicada para compartir el cambio y revisarlo.

## Cambio de demostración

Se agrega documentación sobre el flujo local/remoto. El cambio no modifica la aplicación ni sus datos.

## Secuencia aplicada

1. Crear la rama `evidence/ga7-aa1-ev05-versionamiento` desde `origin/main`.
2. Revisar el estado y los cambios preparados con `git status` y `git diff --cached`.
3. Crear el commit `docs: document git local and remote demo`.
4. Publicar la rama con `git push -u origin evidence/ga7-aa1-ev05-versionamiento`.
5. Confirmar que el commit aparece en el remoto con `git ls-remote` o consultando la rama en GitHub.

La rama se presenta como ejemplo de la evidencia; no se integra automáticamente en `main`.
