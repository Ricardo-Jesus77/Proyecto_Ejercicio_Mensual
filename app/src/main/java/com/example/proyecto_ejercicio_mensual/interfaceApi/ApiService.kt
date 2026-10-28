package com.example.proyecto_ejercicio_mensual.interfaceApi
import com.example.proyecto_ejercicio_mensual.modelo.dataCarreras
import com.example.proyecto_ejercicio_mensual.modelo.dataCursos
import com.example.proyecto_ejercicio_mensual.modelo.dataDetalleCurso
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {


    @GET("obtener_carreras.php")
    suspend fun obtenerCarreras(): List<dataCarreras>
    @GET("obtener_cursos.php")
    suspend fun obtenerCursos(@Query("carrera_id") carreraId : Int): List<dataCursos>

    @GET("api_detalle.php")
    suspend fun obtenerDetalleCurso( @Query("id") id: Int ): dataDetalleCurso

    @GET("obtener_cursos2.php")
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