package com.italgustavo.gestao.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;
    @OneToMany
    @JoinColumn(name = "id_produtos_pedidos", foreignKey = @ForeignKey( name = "fk_produtos" ) )
    private List<Produtos> produtosPedidos = new ArrayList<>();

    public Pedidos() {

    }

    public Pedidos(long id, String title, String description, boolean published) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public Pedidos(String title, String description, boolean b, List<Produtos> produtos) {
        this.title = title;
        this.description = description;
        this.published = b;
        this.produtosPedidos = produtos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public List<Produtos> getProdutosPedidos() {
        return produtosPedidos;
    }

    public void setProdutosPedidos(List<Produtos> produtosPedidos) {
        this.produtosPedidos = produtosPedidos;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                ", produtosPedidos=" + produtosPedidos +
                '}';
    }
}
