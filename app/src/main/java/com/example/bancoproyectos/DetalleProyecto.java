package com.example.bancoproyectos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bancoproyectos.api.ApiProyecto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalleProyecto extends AppCompatActivity {
    private  RecyclerView recyclerView;
    private RecyclerView.Adapter<ListaListadoProyectosAdapter.ViewHolder> adapter;
    private List<Listadoproyectos> proyectoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_proyecto);
        listadoProyecto();

    }
    public void onClick(View view) {
        Intent intent = new Intent(DetalleProyecto.this, MainActivitylistado.class);
        startActivity(intent);
    }
    private  void listadoProyecto(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://lexa2334.pythonanywhere.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiProyecto apiProyecto = retrofit.create(ApiProyecto.class);
        Call<Listadoproyectos> call = apiProyecto.getProyecto("1");

        call.enqueue(new Callback<Listadoproyectos>() {
            @Override
            public void onResponse(Call<Listadoproyectos> call, Response<Listadoproyectos> response) {

            }

            @Override
            public void onFailure(Call<Listadoproyectos> call, Throwable t) {

            }
        });
    }
}