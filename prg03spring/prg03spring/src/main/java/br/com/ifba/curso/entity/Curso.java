/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;
import br.com.ifba.infrastructure.entity.PersistenceEntity;// Importa a classe base que contém o campo ID (chave primária) e métodos básicos.


import jakarta.persistence.Entity; // Anotação obrigatória que marca esta classe como uma entidade JPA (mapeada para uma tabela).
import jakarta.persistence.Table; // Anotação para mapear a classe a uma tabela específica no banco.
import jakarta.persistence.Column; // Anotação para mapear um campo Java a uma coluna específica da tabela.

@Entity
@Table(name = "Cursos") // Informa ao JPA que esta entidade corresponde à tabela "Cursos" no banco.
public class Curso extends PersistenceEntity{ // Herda o ID, getters/setters de ID, equals e hashCode da classe mãe.
    
    
    @Column(name = "nome", nullable = false) // Mapeia para a coluna 'nome' na tabela; o campo não pode ser nulo.
    private String nome; // Armazena o nome do curso.   
    
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @Column(name = "fornecedor", nullable = false)
    private String fornecedor;

    public Curso() {// Construtor vazio (obrigatório para o JPA/Hibernate).
    }

   //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
   
    
    
}