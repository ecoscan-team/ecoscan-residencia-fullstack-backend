
package br.com.ecoscan.ecoscan.service;

import br.com.ecoscan.ecoscan.model.Denuncia;
import br.com.ecoscan.ecoscan.model.Usuario;
import br.com.ecoscan.ecoscan.repository.DenunciaRepository;
import br.com.ecoscan.ecoscan.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DenunciaService {

    private final DenunciaRepository denunciaRepository;
    private final UsuarioRepository usuarioRepository;

    public DenunciaService(
            DenunciaRepository denunciaRepository,
            UsuarioRepository usuarioRepository) {

        this.denunciaRepository = denunciaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Denuncia cadastrar(
            String descricao,
            String localizacao,
            Long usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        Denuncia denuncia = new Denuncia(
                descricao,
                localizacao,
                LocalDate.now(),
                usuario
        );

        return denunciaRepository.save(denuncia);
    }

    public List<Denuncia> listarTodas() {
        return denunciaRepository.findAll();
    }

    public Optional<Denuncia> buscarPorId(Long id) {
        return denunciaRepository.findById(id);
    }

    public Optional<Denuncia> atualizar(
            Long id,
            Denuncia dadosAtualizados) {

        return denunciaRepository.findById(id)
                .map(denuncia -> {

                    denuncia.setDescricao(
                            dadosAtualizados.getDescricao());

                    denuncia.setLocalização(
                            dadosAtualizados.getLocalizacao());

                    return denunciaRepository.save(denuncia);
                });
    }

    public boolean excluir(Long id) {

        if (denunciaRepository.existsById(id)) {

            denunciaRepository.deleteById(id);

            return true;
        }

        return false;
    }
}
