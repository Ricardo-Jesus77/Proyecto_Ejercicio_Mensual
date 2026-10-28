package com.example.proyecto_ejercicio_mensual.presentador
import com.example.proyecto_ejercicio_mensual.Modelo.RetrofitCliente
import com.example.proyecto_ejercicio_mensual.modelo.modelo


class presentador {
    fun obtenerCursos(): List<modelo.Curso>? {
        return try {
            val respuesta = RetrofitCliente.api.obtenerCursos()

            if (respuesta.success) {
                respuesta.cursos
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    fun obtenerInscripciones(): List<modelo.Inscripcion>? {
        return try {
            val respuesta = RetrofitCliente.api.obtenerInscripciones()

            if (respuesta.success) {
                respuesta.inscripciones
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    fun crearInscripcion(inscripcion: CrearInscripcion): Boolean {
        return try {
            val respuesta = RetrofitCliente.api.crearInscripcion(inscripcion)
            respuesta.success
        } catch (e: Exception) {
            false
        }
    }

    fun eliminarInscripcion(id: Int): Boolean {
        return try {
            val respuesta = RetrofitCliente.api.eliminarInscripcion(id)
            respuesta.success
        } catch (e: Exception) {
            false
        }
    }
}