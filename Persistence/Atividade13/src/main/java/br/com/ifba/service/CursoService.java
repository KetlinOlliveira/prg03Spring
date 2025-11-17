/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.service;
import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.dao.CursoIDao;
import java.util.List;

/**
 *
 * @author ketli
 */
public class CursoService implements CursoIService{
    
    private final CursoIDao cursoDao = new CursoDao();
    
   @Override
   public Curso save(Curso curso) {
       
       if(curso == null){
           throw new RuntimeException("Dados do curso não preenchidos!");
       }else if(curso.getId() != null){
           throw new RuntimeException("Curso já existente no banco de dados!");
       }else{
           return cursoDao.save(curso);
       }
   }
   
   @Override
   public Curso update(Curso curso){
       if(curso == null){
           throw new RuntimeException("Dados do curso não preenchidos!");
       }
       return cursoDao.update(curso);
             
   }
   
   @Override
   public void delete(Curso curso){
       if(curso == null){
             throw new RuntimeException("Curso já excluido ou não encontrado!");
       }
       cursoDao.delete(curso);
   }
   
   @Override
   public List<Curso> findAll(){
       return cursoDao.findAll();
   }
   
   @Override
   public Curso findById(Long id){
       Curso curso = cursoDao.findById(id);
       if(curso == null){
            throw new RuntimeException("curso nao encontrado");
       }
       return cursoDao.findById(id);
   }  
}
