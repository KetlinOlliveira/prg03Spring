/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;


import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import org.springframework.stereotype.Repository;// Importa a anotação para marcar a classe como um repositório Spring.
import jakarta.persistence.PersistenceContext;// Importa a anotação para injetar o EntityManager.

import java.util.List;

/**
 *
 * @author ketli
 */

@Repository
// Classe DAO genérica que implementa a interface GenericIDao.
// O tipo Entity deve estender PersistenceEntity (entidade com ID).
public class GenericDao <Entity extends PersistenceEntity> implements GenericIDao<Entity> {
    // Classe genérica que lida com qualquer entidade (Entity) que herde de PersistenceEntity (que tem o ID).
    @PersistenceContext
    // O EntityManager é a interface principal para interagir com o contexto de persistência (JPA).
    private EntityManager entityManager;
    

    @Override
    // Método para salvar (persistir) uma nova entidade no banco de dados
    public Entity save(Entity entity){
        try{       
            // Persiste a entidade no contexto, preparando-a para ser inserida.
        entityManager.persist(entity);
        return entity;
        }catch(Exception e){
           // Lança uma exceção em caso de erro na persistência.
            throw new RuntimeException("Erro ao salvar" + e.getMessage(), e);
        }
    }
    
    @Override
    // Método para atualizar uma entidade existente no banco de dados.
    public Entity update(Entity entity){
        try{     
            // O 'merge' atualiza a entidade no contexto de persistência.
       entityManager.merge(entity);     
        return entity;
        }catch(Exception e){       
            throw new RuntimeException("Erro ao fazer update" + e.getMessage(), e);       
        }
    }
    @Override
    // Método para deletar uma entidade.
    public void delete(Entity entity){      
        try{
            // Garante que a entidade esteja no estado gerenciado antes de tentar remover.
        entity = findById(entity.getId());      
        entityManager.remove(entity);     
        }catch(Exception e){
            throw new RuntimeException("Erro ao deletar" + e.getMessage(), e);           
        }
    }
    
    @Override
    // Método para buscar todas as entidades do tipo Entity.
    public List<Entity> findAll(){
        
        // Cria uma query JPQL dinâmica, ex: "from Usuario".
        // O getTypeClass() obtém o nome da classe da Entidade para a consulta.
        return entityManager.createQuery(("from " + getTypeClass().getName())).getResultList();       
    }
    
    @Override
    // Método para buscar uma entidade pelo seu ID
    public Entity findById(Long id){
        // Usa o método find do EntityManager para buscar pelo tipo da classe e ID.
        return (Entity) entityManager.find(getTypeClass(), id);
    }
    // Método auxiliar (protected) para obter a classe genérica real em tempo de execução (Reflection).
    protected Class<Entity> getTypeClass(){
        // Usa Reflection para descobrir o tipo 'Entity' que está sendo usado pela subclasse.
      return (Class<Entity>) ((ParameterizedType) getClass()
              .getGenericSuperclass())
              .getActualTypeArguments()[0];
    }
}