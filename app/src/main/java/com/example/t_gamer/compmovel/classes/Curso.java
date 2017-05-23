package com.example.t_gamer.compmovel.classes;

import java.io.Serializable;

public class Curso implements Serializable{

    int iId;
    String sTitulo;
    String sDescricao;

    public Curso(int id, String titulo, String descricao){
        iId = id;
        sTitulo = titulo;
        sDescricao = descricao;
    }

    public String getTitulo() {
        return sTitulo;
    }

    public void setTitulo(String sTitulo) {
        this.sTitulo = sTitulo;
    }

    public String getDescricao() {
        return sDescricao;
    }

    public int getId() {
        return iId;
    }

    public void setId(int iId) {
        this.iId = iId;
    }

    public void setDescricao(String sDescricao) {
        this.sDescricao = sDescricao;
    }
}
