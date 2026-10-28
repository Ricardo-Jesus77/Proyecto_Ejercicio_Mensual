package com.example.proyecto_ejercicio_mensual.modelo

class clsCursosModelo {
    suspend fun obternerCursosPorCarrera(carreraId: Int): List<dataCursos>{
        return RetrofitCliente.apiService.obtenerCursos(carreraId)
    }
}