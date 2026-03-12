package br.gov.sc.sctec.empreendedorismo.backend.api.common.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
@Getter
@Setter
public class NotImplementedException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5031376579865208757L;

    public NotImplementedException() {
        super();
    }

}
