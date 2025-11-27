/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;
import br.com.ifba.curso.entity.Curso;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.ifba.curso.repository.CursoRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 *
 * @author ketli
 */
@Service
public class CursoService implements CursoIService{
   
    private  CursoRepository cursoRepository;
    //logger para registrar eventos no console
    private static final Logger log = LoggerFactory.getLogger(CursoService.class);
    
    //construtor para a injeçao de dependencia
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
    
   @Override
   @Transactional//garante que se ouver erro, não salva.
   public Curso save(Curso curso) {
       //regras de negócios
       if(curso == null){
           throw new RuntimeException("Dados do curso não preenchidos!");
       }else if(curso.getId() != null){
           // se tiver id já existe
           throw new RuntimeException("Curso já existente no banco de dados!");
       }else{
           log.info("Salvando objeto do curso!");//registra no log
           return cursoRepository.save(curso);
       }
   }
   @Override
   @Transactional// Garante a transação na atualização
   public Curso update(Curso curso){
       if(curso == null){
           throw new RuntimeException("Dados do curso não preenchidos!");
       }
       // O método .save() do Hibernate serve tanto para criar quanto atualizar.
        // Se o objeto tem ID, ele atualiza.
       log.info("Curso atualizado!");
       return cursoRepository.save(curso);
             
   }
   
   @Override
   @Transactional
   public void delete(Curso curso){
       if(curso == null){
             throw new RuntimeException("Curso já excluido ou não encontrado!");
       }
       log.info("Curso deletado");
       cursoRepository.delete(curso);
   }
   
   @Override
   public List<Curso> findAll(){
       // Retorna todos os registros da tabela
       return cursoRepository.findAll();
   }
   
   @Override
   public Curso findById(Long id){
       // Busca pelo ID. Se não achar, lança o erro
      return cursoRepository.findById(id).orElseThrow(() -> 
           new RuntimeException("Curso com ID " + id + " não encontrado."));
}
}