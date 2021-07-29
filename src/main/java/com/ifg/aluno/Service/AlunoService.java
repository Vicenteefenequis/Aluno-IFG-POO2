package com.ifg.aluno.Service;


import com.ifg.aluno.Exception.AlunoNotFound;
import com.ifg.aluno.Model.Aluno;
import com.ifg.aluno.Repository.AlunoRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AlunoService {
    private AlunoRepository alunoRepository;


    @Autowired
    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }


    public Aluno inserir(Aluno aluno){
        Aluno _aluno = this.alunoRepository.save(aluno);
        return _aluno;
    }

    public Aluno atualizar(Long id, Aluno aluno){
        Aluno _aluno = this.alunoRepository.findById(id).orElseThrow(() -> new AlunoNotFound());
        if(aluno.getCurso() != null) {
            _aluno.setCurso(aluno.getCurso());
        }
        if(aluno.getNome() != null){
            _aluno.setNome(aluno.getNome());
        }

        if(aluno.getSobrenome() != null){
            _aluno.setSobrenome(aluno.getSobrenome());
        }
        if(aluno.getData_nascimento() != null){
            _aluno.setData_nascimento(aluno.getData_nascimento());
        }

        final Aluno updateAluno = alunoRepository.save(_aluno);
        return updateAluno;
    }

    public List<Aluno> findAll(){
        return this.alunoRepository.findAll();
    }
    public Aluno findOneById(Long id){
        return this.alunoRepository.findById(id).orElseThrow(() -> new AlunoNotFound());
    }

    public void delete(Long id){
        Aluno _aluno = this.alunoRepository.findById(id).orElseThrow(() -> new AlunoNotFound());
        alunoRepository.delete(_aluno);
    }
}
