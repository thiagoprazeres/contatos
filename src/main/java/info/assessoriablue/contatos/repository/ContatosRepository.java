package info.assessoriablue.contatos.repository;

import info.assessoriablue.contatos.entity.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatosRepository extends JpaRepository<Contatos, Long> {
}
