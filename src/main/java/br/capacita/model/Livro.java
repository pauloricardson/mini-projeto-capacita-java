package br.capacita.model;

import java.util.UUID;

public class Livro {

    private String titulo;
    private String autor;
    private long id;
    private int exemplares;
    private boolean disponivel;

    public Livro(String titulo, String autor) {
        setTitulo(titulo);
        setAutor(autor);
        setDisponivel(true);
        this.id = gerarId();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public long getId() {
        return id;
    }

    public int getExemplares() {
        return exemplares;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo não pode ser nulo ou vazio");
        }
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("Autor não pode ser nulo ou vazio");
        }
        this.autor = autor;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public static long gerarId() {
        return System.currentTimeMillis();
    }
}
