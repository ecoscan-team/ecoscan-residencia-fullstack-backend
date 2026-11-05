package br.com.ecoscan.ecoscan.repository;

import br.com.ecoscan.ecoscan.model.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
}
