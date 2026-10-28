package com.example.proyecto_ejercicio_mensual.presentador
import com.example.proyecto_ejercicio_mensual.modelo.clsVistaDetalleModelo
import com.example.proyecto_ejercicio_mensual.modelo.dataDetalleCurso
import com.example.proyecto_ejercicio_mensual.vista.vista_detalle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsVistaDetallePresentador (private val vista: vista_detalle) {
    private val modelo = clsVistaDetalleModelo()

    private var detalleCurso: dataDetalleCurso? = null

    fun iniciar(id: Int) {

        CoroutineScope(Dispatchers.Main).launch {
            try {
                detalleCurso = modelo.obtenerDetalleCurso(id)
                vista.mostrarDetalle(detalleCurso!!)
            } catch (e: Exception) {
                vista.mostrarError("Error: " + e.localizedMessage)
            }
        }
    }
}