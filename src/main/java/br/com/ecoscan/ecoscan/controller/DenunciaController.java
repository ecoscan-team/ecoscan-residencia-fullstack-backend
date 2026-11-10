
package br.com.ecoscan.ecoscan.controller;

import br.com.ecoscan.ecoscan.model.Denuncia;
import br.com.ecoscan.ecoscan.service.DenunciaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    private final DenunciaService denunciaService;

    public DenunciaController(DenunciaService denunciaService) {
        this.denunciaService = denunciaService;
    }

    @PostMapping
    public ResponseEntity<Denuncia> cadastrar(
            @RequestBody Denuncia denuncia) {

        Denuncia novaDenuncia = denunciaService.cadastrar(
                denuncia.getDescricao(),
                denuncia.getLocalizacao(),
                denuncia.getUsuario().getId()
        );

        return ResponseEntity.ok(novaDenuncia);
    }

    @GetMapping
    public ResponseEntity<List<Denuncia>> listarTodas() {

        return ResponseEntity.ok(
                denunciaService.listarTodas()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Denuncia> buscarPorId(
            @PathVariable Long id) {

        Optional<Denuncia> denuncia =
                denunciaService.buscarPorId(id);

        return denuncia.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Denuncia> atualizar(
            @PathVariable Long id,
            @RequestBody Denuncia dadosAtualizados) {

        Optional<Denuncia> denuncia =
                denunciaService.atualizar(id, dadosAtualizados);

        return denuncia.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id) {

        boolean excluida = denunciaService.excluir(id);

        if (excluida) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
