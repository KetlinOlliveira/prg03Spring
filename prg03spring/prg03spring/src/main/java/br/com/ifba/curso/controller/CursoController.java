/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import br.com.ifba.curso.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CursoController implements CursoIController{
   
    private final CursoIService cursoIService;
    
    @Autowired
    public CursoController(CursoIService cursoService) {
        this.cursoIService = cursoService;
    }
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
