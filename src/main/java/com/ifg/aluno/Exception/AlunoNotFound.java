package com.ifg.aluno.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AlunoNotFound extends RuntimeException {
    public AlunoNotFound() {
        super("Aluno não encontrado",null,false,false);
    }
}
