package com.example.proyecto_ejercicio_mensual.Modelo

import com.example.proyecto_ejercicio_mensual.Modelo.RetrofitCliente

class clsVistaDetalleModelo {
    suspend fun obtenerDetalleCurso(id: Int): dataDetalleCurso {
        return RetrofitCliente.apiService.obtenerDetalleCurso(id)
    }

}