package co.sena.seleccion;

import java.util.Map;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    ResponseEntity<?> conflicto(DataIntegrityViolationException e){return ResponseEntity.status(409).body(Map.of("message","El documento o la postulación ya existen, o una referencia no es válida."));}
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<?> validar(MethodArgumentNotValidException e){return ResponseEntity.badRequest().body(Map.of("message","Revisa los campos obligatorios, longitudes y formatos."));}
    @ExceptionHandler(ResponseStatusException.class)
    ResponseEntity<?> negocio(ResponseStatusException e){return ResponseEntity.status(e.getStatusCode()).body(Map.of("message",e.getReason()==null?"No se pudo completar la operación.":e.getReason()));}
}
