package com.example.proyecto_ejercicio_mensual.InterfaceApi
import com.example.proyecto_ejercicio_mensual.presentador.presentador
import com.example.proyecto_ejercicio_mensual.Modelo.dataDetalleCurso
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET("api_detalle.php")
    suspend fun obtenerDetalleCurso( @Query("id") id: Int ): dataDetalleCurso

    @GET("obtener_cursos.php")
    fun obtenerCursos(): RespuestaCursos

    @GET("obtener_inscripciones.php")
    fun obtenerInscripciones(): RespuestaInscripciones

    @POST("crear_inscripcion.php")
    fun crearInscripcion(
        @Body inscripcion: CrearInscripcion
    ): Respuesta

    @POST("eliminar_inscripcion.php")
    fun eliminarInscripcion(
        @Body datos: EliminarInscripcion
    ): Respuesta
}