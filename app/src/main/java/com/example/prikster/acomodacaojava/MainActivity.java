package com.example.prikster.acomodacaojava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prikster.acomodacaojava.model.Acomodacao;
import com.example.prikster.acomodacaojava.remote.AcomodacaoService;
import com.example.prikster.acomodacaojava.remote.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnGetAcomodacoesList;
    ListView listView;

    AcomodacaoService acomodacaoService;
    List<Acomodacao> list = new ArrayList<Acomodacao>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Acomodações");

        btnGetAcomodacoesList = (Button) findViewById(R.id.btnGetAcomodacoesList);

        listView = (ListView) findViewById(R.id.listView);
        acomodacaoService = ApiUtils.getAcomodacaoService();

        btnGetAcomodacoesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAcomodacoesList();
            }
        });
    }

    public void getAcomodacoesList() {
        long begin = System.nanoTime();
        Call<List<Acomodacao>> call = acomodacaoService.getAcomodacoes();
        call.enqueue(new Callback<List<Acomodacao>>() {
            @Override
            public void onResponse(Call<List<Acomodacao>> call, Response<List<Acomodacao>> response) {
                if(response.isSuccessful()) {
                    list = response.body();
                    listView.setAdapter(new AcomodacaoAdapter(MainActivity.this, R.layout.list_acomodacao, list));
                }
            }

            @Override
            public void onFailure(Call<List<Acomodacao>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
        long difference = (System.nanoTime() - begin)/1000000;
        btnGetAcomodacoesList.setVisibility(View.INVISIBLE);
        String message = "Finished in " + difference + "ms";
        Integer duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, message, duration);
        toast.show();
    }
}
