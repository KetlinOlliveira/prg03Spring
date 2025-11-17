/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.service.CursoIService;
import br.com.ifba.service.CursoService;
import java.util.List;

/**
 *
 * @author ketli
 */
public class CursoController implements CursoIController{
    
    private final CursoIService cursoIService = new CursoService();
    
    @Override
   public Curso save(Curso curso){
       return cursoIService.save(curso);
   }
   
   @Override
   public Curso update(Curso curso){
       return cursoIService.update(curso);    
   }
   
   @Override
   public void delete(Curso curso){
       cursoIService.delete(curso);
   }
   
   @Override
   public List<Curso> findAll(){
       return cursoIService.findAll();
   }
   
   @Override
   public Curso findById(Long id){
       return cursoIService.findById(id);
   }
    
}
