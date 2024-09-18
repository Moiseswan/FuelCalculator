package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
const val KEY_CONSUM = "ConsumptionActivity.KEY_INPUT_CONSUMPTION"

class ConsumptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumption)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val price = intent.getFloatExtra(KEY_PRICE, 0f)

        val edtConsumo = findViewById<TextInputEditText>(R.id.edt_consumo)
        val btnNext2 = findViewById<Button>(R.id.btn_next2)

        btnNext2.setOnClickListener {
            val ConsumStr: String = edtConsumo.text.toString()
            if (ConsumStr == ""){
                Snackbar.make(edtConsumo, "Preencha todos os Campos",
                    Snackbar.LENGTH_LONG).show()
            } else {
                val consum = edtConsumo.text.toString().toFloat()
                val intent = Intent(this, RouteActivity::class.java)
                intent.putExtra(KEY_CONSUM, consum)
                intent.putExtra(KEY_PRICE, price)
                startActivity(intent)
            }
        }
    }
}