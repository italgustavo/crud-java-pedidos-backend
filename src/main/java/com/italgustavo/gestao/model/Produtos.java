package com.italgustavo.gestao.model;

import javax.persistence.*;

@Entity
@Table(name = "produtos")
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Float price;

    public Produtos(){

    }

    public Produtos(String name, String description, Float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public long getId() {
        return id;
    }


    public Produtos(long id, String name, String description, Float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "id=" + id +
                ", nomeProduto='" + name + '\'' +
                ", description='" + description + '\'' +
                ", preco=" + price +
                '}';
    }
}

