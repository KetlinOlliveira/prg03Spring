/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.dao;
import java.util.List;
import br.com.ifba.infrastructure.entity.PersistenceEntity;

/**
 *
 * @author ketli
 */
public interface GenericIDao<Entity extends PersistenceEntity> {
 
    
    public abstract Entity save (Entity obj);
    
    public abstract Entity update(Entity obj);
    
    public abstract void delete (Entity obj);
    
    public abstract List<Entity> findAll();
    
    public abstract Entity findById(Long id);
    
}
