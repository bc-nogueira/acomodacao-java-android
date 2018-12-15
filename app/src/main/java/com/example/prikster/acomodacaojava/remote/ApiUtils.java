package com.example.prikster.acomodacaojava.remote;

public class ApiUtils {
    private ApiUtils() {
    }

    public static final String API_URL = "http://acomodacao-tcc.herokuapp.com/api/v1/";

    public static AcomodacaoService getAcomodacaoService() {
        return RetrofitClient.getClient(API_URL).create(AcomodacaoService.class);
    }
}
