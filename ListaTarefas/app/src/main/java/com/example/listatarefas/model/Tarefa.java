package com.example.listatarefas.model;

import java.io.Serializable;

public class Tarefa implements Serializable { // Para enviar elementos entre activits (telas)

    private Long id;
    private String nomeTarefa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }
}
