/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
/**
 *
 * @author ketli
 */

@MappedSuperclass
public class PersistenceEntity {
    
    // Define o gerador de sequência para o banco de dados.
  @SequenceGenerator(
    name = "SEQ_GEN",           // Nome do gerador
    sequenceName = "CURSO_SEQ", 
    allocationSize = 1
)
    @Id// Marca este campo como a CHAVE PRIMÁRIA (Primary Key) da entidade.
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    // Define como o valor do ID será gerado, usando a sequência definida acima.
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) { // Compara duas entidades para ver se são iguais.
        // Verifica se é a mesma instância na memória.
        if (this == object) return true; 
        // Verifica se o objeto não é nulo ou se não é da mesma classe.
        if (object == null || getClass() != object.getClass()) return false;
        
        // Faz o cast seguro.
        PersistenceEntity other = (PersistenceEntity) object;
        
        // A comparação principal: Duas entidades são consideradas iguais se tiverem o mesmo ID (chave primária).
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
