/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.dao.CursoIDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ketli
 */
@Service
public class CursoService implements CursoIService{
    @Autowired
    private  CursoIDao cursoDao;
    
    public CursoService(CursoIDao cursoIDao) {
        this.cursoDao = cursoIDao;
    }
    
   @Override
   @Transactional
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
   @Transactional
   public Curso update(Curso curso){
       if(curso == null){
           throw new RuntimeException("Dados do curso não preenchidos!");
       }
       return cursoDao.save(curso);
             
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
      return cursoDao.findById(id).orElseThrow(() -> 
           new RuntimeException("Curso com ID " + id + " não encontrado."));
}
}