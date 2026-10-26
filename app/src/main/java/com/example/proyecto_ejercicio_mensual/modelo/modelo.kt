package com.example.proyecto_ejercicio_mensual.modelo

class modelo {
    data class Curso(
        val id: Int,
        val nombre: String
    )

    data class Inscripcion(
        val id: Int,
        val matricula: String,
        val fecha: String,
        val email: String,
        val cursoId: Int,
        val creadoEn: String
    )
}