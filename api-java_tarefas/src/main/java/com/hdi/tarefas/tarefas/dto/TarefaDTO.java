/*
Este é um código em Java que define uma classe chamada TarefaDTO.
DTO significa Data Transfer Object, que é um padrão de design usado para transferir dados entre camadas de software.
Essa classe tem três variáveis de instância: id, titulo e descricao.
Elas são privadas, o que significa que só podem ser acessadas dentro da própria classe.
Para acessar e modificar essas variáveis fora da classe, são usados métodos getters e setters.
Esses métodos são públicos e permitem que outras classes obtenham e definam os valores dessas variáveis de maneira controlada.
 */

package com.hdi.tarefas.tarefas.dto;

public class TarefaDTO {
    private Long id;
    private String titulo;
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
