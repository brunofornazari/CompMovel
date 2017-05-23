package com.example.t_gamer.compmovel.classes;

import java.io.Serializable;

public class Materia implements Serializable{
    private int _id;
    private String _titulo, _descricao;

    public Materia(int id, String titulo, String descricao){
        _id = id;
        _titulo = titulo;
        _descricao = descricao;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return _titulo;
    }

    public void setTitulo(String _titulo) {
        this._titulo = _titulo;
    }

    public String getDescricao() {
        return _descricao;
    }

    public void setDescricao(String _descricao) {
        this._descricao = _descricao;
    }
}
