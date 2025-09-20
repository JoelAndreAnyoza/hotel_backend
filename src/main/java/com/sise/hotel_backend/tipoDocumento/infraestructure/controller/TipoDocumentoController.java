package com.sise.hotel_backend.tipoDocumento.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.hotel_backend.tipoDocumento.application.dto.request.InsertarTipoDocumentoRequestDto;
import com.sise.hotel_backend.tipoDocumento.application.dto.response.InsertarTipoDocumentoResponseDto;
import com.sise.hotel_backend.tipoDocumento.application.service.TipoDocumentoApplicationService;
import com.sise.hotel_backend.tipoDocumento.domain.entities.TipoDocumento;

@RestController
@RequestMapping("/tiposDocumento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoApplicationService tipoDocumentoApplicationService;

    @PostMapping("")
    public ResponseEntity<InsertarTipoDocumentoResponseDto> insertarTipoDocumento(
        @RequestBody InsertarTipoDocumentoRequestDto requestDto) {
            try {
                InsertarTipoDocumentoResponseDto responseDto = tipoDocumentoApplicationService.insertarTipoDocumento(requestDto);
                return ResponseEntity.ok(responseDto);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }

    @GetMapping("")
    public ResponseEntity<List<TipoDocumento>> listarTipoDocumento() {
        return ResponseEntity.ok(tipoDocumentoApplicationService.listarTipoDocumento());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumento> obtenerTipoDocumentoPorId(@PathVariable Integer id) {
        Optional<TipoDocumento> tipoDocumento = tipoDocumentoApplicationService.obtenerTipoDocumentoPorId(id);
        return tipoDocumento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDocumento> actualizarTipoDocumento(@PathVariable Integer id, @RequestBody TipoDocumento tipoDocumento) {
        tipoDocumento.setIdTipoDocumento(id);
        TipoDocumento updated = tipoDocumentoApplicationService.actualizarTipoDocumento(tipoDocumento);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTipoDocumento(@PathVariable Integer id) {
        if (tipoDocumentoApplicationService.eliminarTipoDocumento(id)) {
            return ResponseEntity.ok("Tipo de documento eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id no existe");
    }    
}
