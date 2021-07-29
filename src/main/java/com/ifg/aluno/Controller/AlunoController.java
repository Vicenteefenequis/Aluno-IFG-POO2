package com.ifg.aluno.Controller;

import com.ifg.aluno.Model.Aluno;
import com.ifg.aluno.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;


    @PostMapping
    public ResponseEntity<Aluno> createAlumn(@RequestBody Aluno aluno){
       Aluno _aluno = this.alunoService.inserir(aluno);
       return new ResponseEntity(Map.of("data",_aluno,"timestamp",new Date()),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAlumn(@PathVariable Long id,@RequestBody Aluno aluno){
        Aluno _aluno = this.alunoService.atualizar(id,aluno);
        return new ResponseEntity(Map.of("data",_aluno,"timestamp",new Date()),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listAllAlumns(){
        List<Aluno> _aluno = this.alunoService.findAll();
        return new ResponseEntity(Map.of("data",_aluno,"timestamp",new Date()),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> listById(@PathVariable Long id){
        Aluno _aluno = this.alunoService.findOneById(id);
        return new ResponseEntity(Map.of("data",_aluno,"timestamp",new Date()),HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> deleteAlumn(@PathVariable Long id){
        this.alunoService.delete(id);
         return new ResponseEntity(Map.of("message","Aluno excluido com sucesso","timestamp",new Date()),HttpStatus.CREATED);
    }

}
