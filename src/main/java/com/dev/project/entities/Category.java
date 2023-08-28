package com.dev.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category implements Serializable {
    //Declaração das variáveis para a Categoria
    private static final long serialVersioUID = 1L;
    private Long id;
    private String name;

    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    //Constructo vazio
    public Category(){
    }

    //Constructo padrão
    public Category(Long id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    //Métodos de acesso
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    //Hashcode Equals para a Id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
