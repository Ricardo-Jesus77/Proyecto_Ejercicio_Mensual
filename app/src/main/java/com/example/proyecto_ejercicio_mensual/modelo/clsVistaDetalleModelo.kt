package com.example.proyecto_ejercicio_mensual.modelo

class clsVistaDetalleModelo {
    suspend fun obtenerDetalleCurso(id: Int): dataDetalleCurso {
        return RetrofitCliente.apiService.obtenerDetalleCurso(id)
    }

}