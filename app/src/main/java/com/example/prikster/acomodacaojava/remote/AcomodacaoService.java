package com.example.prikster.acomodacaojava.remote;

import com.example.prikster.acomodacaojava.model.Acomodacao;
import com.example.prikster.acomodacaojava.model.AcomodacaoUrls;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AcomodacaoService {
    @GET("acomodacoes/")
    Call<List<Acomodacao>> getAcomodacoes();

    @GET("acomodacoes/{id}")
    Call<AcomodacaoUrls> getAcomodacaoById(@Path("id") Integer id);
}
