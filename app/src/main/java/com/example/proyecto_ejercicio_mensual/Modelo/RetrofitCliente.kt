package com.example.proyecto_ejercicio_mensual.Modelo
import com.example.proyecto_ejercicio_mensual.InterfaceApi.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object RetrofitCliente {
    private const val BASE_URL = "http://10.0.2.2/cursos_api/"
    private val jsonConfig = Json{
        ignoreUnknownKeys = true
    }
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory( jsonConfig.asConverterFactory("application/json".toMediaType()) )
            .build()
            .create(ApiService::class.java) }
}