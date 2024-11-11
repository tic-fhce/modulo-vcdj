package com.sgd.sgdfback.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgd.sgdfback.model.DesignacionTribunal;
import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.object.ListarCYRequest;
import com.sgd.sgdfback.service.DesignacionTribunalService;

@RestController
@RequestMapping("/designacionTribunal")
public class DesignacionTribunalController {

    private final DesignacionTribunalService designacionService;
    private final ObjectMapper objectMapper;

    public DesignacionTribunalController(DesignacionTribunalService designacionTribunalService,
            ObjectMapper objectMapper) {
        this.designacionService = designacionTribunalService;
        this.objectMapper = objectMapper;
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Map<String, String> data) {
        try {
            String columna = data.get("colum");
            String param = data.get("param");
            String nroTramite = data.get("nrotramite");

            designacionService.actualizarColumna(columna, param, nroTramite);
            return ResponseEntity.ok("Actualizado");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/obtener")
    public ResponseEntity<String> obtener(@RequestBody Map<String, String> data) {
        try {
            String nroTramite = data.get("nrotramite");
            String columna = data.get("columna");

            String valor = designacionService.obtenerColumna(nroTramite, columna);
            return ResponseEntity.ok(valor);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/aprobacionPerfil")
    public ResponseEntity<String> obtenerAprobacionPerfil(@AuthenticationPrincipal Usuario user,
            @RequestBody(required = false) Map<String, String> data) {
        Integer authUserId = user.getId();
        List<DesignacionTribunal> perfil = designacionService.obtenerAprobacionPerfilPorUsuario(authUserId);

        // Si el resultado está vacío, intenta buscar por el userId proporcionado en el
        // request
        if (perfil.isEmpty() && data != null && data.containsKey("idPerfil")) {
            Integer idPerfil = Integer.parseInt(data.get("idPerfil"));
            Optional<DesignacionTribunal> perfilOpcional = designacionService.obtenerDesignacionPorId(idPerfil);
            perfilOpcional.ifPresent(value -> perfil.add(value));
        }

        return ResponseEntity.ok(convertToJsonResponse(perfil));
    }

    @PostMapping("/listar-carrera-year")
    public List<DesignacionTribunal> getListarCarreraYear(@RequestBody ListarCYRequest request) {
        return designacionService.obtenerAprobacionPerfilsCarreraYear(request.getCarrera(), request.getYear());
    }

    @PostMapping("/crear")
    public ResponseEntity<DesignacionTribunal> crearDesignacionTribunal(@AuthenticationPrincipal Usuario user,
            @RequestBody Map<String, String> data) {
        String nroTramite = data.get("nrotramite");
        return new ResponseEntity<>(designacionService.crearDesignacionTribunal(user, nroTramite), HttpStatus.CREATED);
    }

    @PostMapping("/obtenerDT")
    public ResponseEntity<DesignacionTribunal> obtenerDesignacionTribunalIdTramite(
            @RequestBody Map<String, String> data) {
        try {
            String nroTramite = data.get("nrotramite");
            Optional<DesignacionTribunal> dt = designacionService.obtenerDesignacionPorTramite(nroTramite);

            // Si el valor existe, lo devuelve, de lo contrario, responde con OK y un cuerpo
            // vacío
            return dt.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.OK).body(null));

        } catch (Exception e) {
            // Si hay una excepción inesperada, devuelve un cuerpo vacío con un status 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private String convertToJsonResponse(List<DesignacionTribunal> list) {
        try {
            return objectMapper.writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de errores
            return "Error al convertir a JSON";
        }
    }

    // Endpoints para el CRUD
    @PostMapping
    public ResponseEntity<DesignacionTribunal> crearDesignacion(@RequestBody DesignacionTribunal designacionTribunal) {
        return new ResponseEntity<>(designacionService.crearDesignacion(designacionTribunal), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesignacionTribunal> obtenerDesignacionPorId(@PathVariable Integer id) {
        Optional<DesignacionTribunal> designacion = designacionService.obtenerDesignacionPorId(id);
        return designacion.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<DesignacionTribunal> obtenerTodasLasDesignaciones() {
        return designacionService.obtenerTodasLasDesignaciones();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesignacionTribunal> actualizarDesignacion(@PathVariable Integer id,
            @RequestBody DesignacionTribunal designacionTribunal) {
        DesignacionTribunal designacionActualizada = designacionService.actualizarDesignacion(id, designacionTribunal);
        if (designacionActualizada != null) {
            return ResponseEntity.ok(designacionActualizada);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDesignacion(@PathVariable Integer id) {
        try {
            designacionService.eliminarDesignacion(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
