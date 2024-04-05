package com.example.teste.model;

public class Filmes {

    private String tituloFilme;
    private String genero;
    private String ano;

    public Filmes(){

    }

    public Filmes(String tituloFilme, String genero, String ano){
        this.tituloFilme = tituloFilme;
        this.genero = genero;
        this.ano = ano;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
