package com.example.proyecto_ejercicio_mensual.Vista

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyecto_ejercicio_mensual.Modelo.dataDetalleCurso
import com.example.proyecto_ejercicio_mensual.Presentador.clsVistaDetallePresentador
import com.example.proyecto_ejercicio_mensual.R


class vista_detalle : AppCompatActivity (){
    private lateinit var presentador: clsVistaDetallePresentador

    private lateinit var btnBack: Button
    private lateinit var imgCurso: ImageView
    private lateinit var txtCursos: TextView
    private lateinit var txtCodigo: TextView
    private lateinit var txtDescripcion: TextView
    private lateinit var txtEspacios: TextView
    private lateinit var txtHoras: TextView
    private lateinit var txtDias: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_vista_detalle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnBack = findViewById(R.id.btnBack)
        imgCurso = findViewById(R.id.imgCurso)
        txtCursos = findViewById(R.id.txtCursos)
        txtCodigo = findViewById(R.id.txtCodigo)
        txtDescripcion = findViewById(R.id.txtDescripcion)
        txtEspacios = findViewById(R.id.txtEspacios)
        txtHoras = findViewById(R.id.txtHoras)
        txtDias = findViewById(R.id.txtDias)

        btnBack.setOnClickListener {
            finish()
        }
        presentador = clsVistaDetallePresentador(this)

        // Obtener el ID del curso enviado desde la pantalla anterior
        val idCurso = intent.getIntExtra("idCurso", -1)

        if (idCurso != -1) {
            presentador.iniciar(idCurso)
        } else {
            mostrarError("No se recibió el ID del curso")
        }
    }
    fun mostrarDetalle(curso: dataDetalleCurso) {
        txtCursos.text = curso.curso
        txtCodigo.text = curso.codigo
        txtDescripcion.text = curso.descripcion ?: "Sin descripción"
        txtEspacios.text = curso.espacio
        txtHoras.text = curso.total_horas
        txtDias.text = curso.dias_atencion
    }
        fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }


}