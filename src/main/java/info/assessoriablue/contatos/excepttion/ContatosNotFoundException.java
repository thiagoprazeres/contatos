package info.assessoriablue.contatos.excepttion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContatosNotFoundException extends Exception {
    public ContatosNotFoundException(Long id) {
        super("Contato não encontrado com ID " + id);
    }
}