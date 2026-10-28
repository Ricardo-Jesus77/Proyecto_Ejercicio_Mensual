package com.example.proyecto_ejercicio_mensual.InterfaceApi

import com.example.proyecto_ejercicio_mensual.Modelo.dataDetalleCurso
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api_detalle.php")
    suspend fun obtenerDetalleCurso( @Query("id") id: Int ): dataDetalleCurso
}