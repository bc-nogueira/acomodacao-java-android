package com.example.prikster.acomodacaojava.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AcomodacaoUrls {
    @SerializedName("acomodacao")
    @Expose
    private Acomodacao acomodacao;

    @SerializedName("urls")
    @Expose
    private List<String> urls;

    public AcomodacaoUrls() {
    }

    public AcomodacaoUrls(Acomodacao acomodacao, List<String> urls) {
        this.acomodacao = acomodacao;
        this.urls = urls;
    }

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Acomodacao acomodacao) {
        this.acomodacao = acomodacao;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
