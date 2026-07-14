package br.com.supermercado.api.models;


public class User {


    private int id;

    private String nome;

    private String role;


    public int getId() {

        return id;

    }


    public void setId(int id) {

        this.id = id;

    }


    public String getNome() {

        return nome;

    }


    public void setNome(String nome) {

        this.nome = nome;

    }


    public String getRole() {

        return role;

    }


    public void setRole(String role) {

        this.role = role;

    }

}