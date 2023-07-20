package com.example.bancoproyectos.api;

import com.example.bancoproyectos.Listadoproyectos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiProyecto {
    @GET("proyecto/{id}")
    Call<Listadoproyectos> getProyecto(@Path("id") String id);

}
