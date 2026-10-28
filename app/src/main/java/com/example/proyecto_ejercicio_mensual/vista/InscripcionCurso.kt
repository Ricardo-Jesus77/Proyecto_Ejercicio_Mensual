package com.example.proyecto_ejercicio_mensual.vista

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.DatePickerDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyecto_ejercicio_mensual.R

class InscripcionCurso : AppCompatActivity() {
    private lateinit var txtNombreCurso: TextView
    private lateinit var edtMatricula: EditText
    private lateinit var edtFecha: EditText
    private lateinit var edtEmail: EditText
    private lateinit var btnConfirmar: Button
    private lateinit var btnCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscripcion_curso)

        txtNombreCurso = findViewById(R.id.txtNombreCurso)
        edtMatricula = findViewById(R.id.edtMatricula)
        edtFecha = findViewById(R.id.edtFecha)
        edtEmail = findViewById(R.id.edtEmail)
        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnCancelar = findViewById(R.id.btnCancelar)

        txtNombreCurso.text = "PROGRAMACIÓN AVANZADA"

        edtFecha.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                mostrarFecha()
            }
        })

        btnConfirmar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                confirmarInscripcion()
            }
        })

        btnCancelar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                limpiarFormulario()
            }
        })
    }

    private fun mostrarFecha() {
        val calendario = Calendar.getInstance()

        val selector = DatePickerDialog(
            this,
            object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(
                    view: android.widget.DatePicker?,
                    anio: Int,
                    mes: Int,
                    dia: Int
                ) {
                    val fecha = String.format(
                        "%04d-%02d-%02d",
                        anio,
                        mes + 1,
                        dia
                    )

                    edtFecha.setText(fecha)
                }
            },
            calendario.get(Calendar.YEAR),
            calendario.get(Calendar.MONTH),
            calendario.get(Calendar.DAY_OF_MONTH)
        )

        selector.show()
    }

    private fun confirmarInscripcion() {
        val matricula = edtMatricula.text.toString().trim()
        val fecha = edtFecha.text.toString().trim()
        val email = edtEmail.text.toString().trim()

        if (matricula.isEmpty() || fecha.isEmpty() || email.isEmpty()) {
            Toast.makeText(
                this,
                "Completa todos los campos",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(
                this,
                "Ingresa un correo válido",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        Toast.makeText(
            this,
            "Datos listos para registrar",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun limpiarFormulario() {
        edtMatricula.setText("")
        edtFecha.setText("")
        edtEmail.setText("")
    }
}