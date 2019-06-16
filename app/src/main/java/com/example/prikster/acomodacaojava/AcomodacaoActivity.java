package com.example.prikster.acomodacaojava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prikster.acomodacaojava.model.Acomodacao;
import com.example.prikster.acomodacaojava.model.AcomodacaoUrls;
import com.example.prikster.acomodacaojava.remote.AcomodacaoService;
import com.example.prikster.acomodacaojava.remote.ApiUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AcomodacaoActivity extends AppCompatActivity implements OnMapReadyCallback {
    Button btnVoltar;

    AcomodacaoService acomodacaoService;
    Acomodacao acomodacao;
    List<String> urls = new ArrayList<String>();
    long begin;

    ListView imageListView;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acomodacao);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        acomodacaoService = ApiUtils.getAcomodacaoService();
        imageListView = (ListView) findViewById(R.id.imageListView);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcomodacaoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        begin = System.nanoTime();

        Bundle extras = getIntent().getExtras();
        final Integer acomodacaoId = Integer.parseInt(extras.getString("acomodacao_id"));

        getAcomodacaoById(acomodacaoId);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    public void getAcomodacaoById(Integer id) {
      Call<AcomodacaoUrls> call = acomodacaoService.getAcomodacaoById(id);
        call.enqueue(new Callback<AcomodacaoUrls>() {
            @Override
            public void onResponse(Call<AcomodacaoUrls> call, Response<AcomodacaoUrls> response) {
                if(response.isSuccessful()) {
                    acomodacao = new Acomodacao();
                    acomodacao = response.body().getAcomodacao();
                    urls = response.body().getUrls();

                    TextView txtAcomodacaoTituloDetail = (TextView) findViewById(R.id.txtAcomodacaoTituloDetail);
                    TextView txtAcomodacaoTipoDetail = (TextView) findViewById(R.id.txtAcomodacaoTipoDetail);
                    TextView txtAcomodacaoCapacidadeDetail = (TextView) findViewById(R.id.txtAcomodacaoCapacidadeDetail);
                    TextView txtAcomodacaoPrecoDetail = (TextView) findViewById(R.id.txtAcomodacaoPrecoDetail);
                    TextView txtAcomodacaoLogradouroDetail = (TextView) findViewById(R.id.txtAcomodacaoLogradouroDetail);
                    TextView txtAcomodacaoNumeroDetail = (TextView) findViewById(R.id.txtAcomodacaoNumeroDetail);
                    TextView txtAcomodacaoComplementoDetail = (TextView) findViewById(R.id.txtAcomodacaoComplementoDetail);
                    TextView txtAcomodacaoBairroDetail = (TextView) findViewById(R.id.txtAcomodacaoBairroDetail);
                    TextView txtAcomodacaoCidadeDetail = (TextView) findViewById(R.id.txtAcomodacaoCidadeDetail);
                    TextView txtAcomodacaoEstadoDetail = (TextView) findViewById(R.id.txtAcomodacaoEstadoDetail);
                    TextView txtAcomodacaoDescricaoDetail = (TextView) findViewById(R.id.txtAcomodacaoDescricaoDetail);

                    txtAcomodacaoTituloDetail.setText(String.format("%s", acomodacao.getTitulo()));
                    txtAcomodacaoTipoDetail.setText(String.format("%s", acomodacao.getTipoEmTexto()));
                    txtAcomodacaoCapacidadeDetail.setText(String.format("%s", acomodacao.getCapacidade()));
                    txtAcomodacaoPrecoDetail.setText(String.format("%s", acomodacao.getPreco()));
                    txtAcomodacaoLogradouroDetail.setText(String.format("%s", acomodacao.getLogradouro()));
                    txtAcomodacaoNumeroDetail.setText(String.format("%s", acomodacao.getNumero()));
                    txtAcomodacaoComplementoDetail.setText(String.format("%s", acomodacao.getComplemento()));
                    txtAcomodacaoBairroDetail.setText(String.format("%s", acomodacao.getBairro()));
                    txtAcomodacaoCidadeDetail.setText(String.format("%s", acomodacao.getCidade()));
                    txtAcomodacaoEstadoDetail.setText(String.format("%s", acomodacao.getEstado()));
                    txtAcomodacaoDescricaoDetail.setText(String.format("%s", acomodacao.getDescricao()));

                    imageListView.setAdapter(new ImageAcomodacaoAdapter(AcomodacaoActivity.this, R.layout.image_acomodacao, urls));

                    LatLng acomodacaoLatLng = new LatLng(acomodacao.getLatitude(), acomodacao.getLongitude());

                    mMap.addMarker(new MarkerOptions().position(acomodacaoLatLng).title("Marker in IC UFF"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(acomodacaoLatLng, 15.0f));
                }
            }

            @Override
            public void onFailure(Call<AcomodacaoUrls> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        long difference = (System.nanoTime() - begin)/1000000;
        String message = "Finished in " + difference + "ms";
        Integer duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, message, duration);
        toast.show();
    }
}
