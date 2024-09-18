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
const val KEY_ROUTE = "RouteActivity.KEY_INPUT_ROUTE"
class RouteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_route)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val price = intent.getFloatExtra(KEY_PRICE,0f)
        val consum = intent.getFloatExtra(KEY_CONSUM, 0f)

        val edtRoute =findViewById<TextInputEditText>(R.id.edt_route)

        val btnResult =findViewById<Button>(R.id.btn_result)

        btnResult.setOnClickListener {
            val RouteStr: String = edtRoute.text.toString()
            if (RouteStr == ""){
                Snackbar.make(edtRoute, "Preencha todos os Campos",
                    Snackbar.LENGTH_LONG).show()
            } else {
                val route = edtRoute.text.toString().toFloat()

                val intet = Intent(this, ResultActivity::class.java)
                intet.putExtra(KEY_ROUTE, route)
                intet.putExtra(KEY_CONSUM, consum)
                intet.putExtra(KEY_PRICE, price)
                startActivity(intet)



            }
        }
    }
}