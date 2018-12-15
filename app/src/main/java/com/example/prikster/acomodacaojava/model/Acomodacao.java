package com.example.prikster.acomodacaojava.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Acomodacao {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("titulo")
    @Expose
    private String titulo;

    @SerializedName("descricao")
    @Expose
    private String descricao;

    @SerializedName("capacidade")
    @Expose
    private Integer capacidade;

    @SerializedName("preco")
    @Expose
    private Double preco;

    @SerializedName("tipo")
    @Expose
    private Integer tipo;

    @SerializedName("logradouro")
    @Expose
    private String logradouro;

    @SerializedName("numero")
    @Expose
    private String numero;

    @SerializedName("complemento")
    @Expose
    private String complemento;

    @SerializedName("bairro")
    @Expose
    private String bairro;

    @SerializedName("cidade")
    @Expose
    private String cidade;

    @SerializedName("estado")
    @Expose
    private String estado;

    public Acomodacao(){
    }

    public Acomodacao(Integer id, String titulo, String descricao, Integer capacidade, Double preco,
                      String logradouro, String numero, String complemento, String bairro,
                      String cidade, String estado, Integer tipo) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.preco = preco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.tipo = tipo;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getTipoEmTexto() {
        String tipo = "";
        switch (this.getTipo()) {
            case 0:
                tipo =  "Apartamento";
                break;
            case 1:
                tipo = "Casa";
                break;
            case 2:
                tipo = "Hotel";
                break;
        }
        return tipo;
    }
}
