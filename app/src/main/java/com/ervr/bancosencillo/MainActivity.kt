package com.ervr.bancosencillo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var saldoValueTextView: TextView
    private lateinit var depositAmountEditText: EditText
    private lateinit var withdrawAmountEditText: EditText
    private var saldo: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saldoValueTextView = findViewById(R.id.saldoValueTextView)
        depositAmountEditText = findViewById(R.id.depositAmountEditText)
        withdrawAmountEditText = findViewById(R.id.withdrawAmountEditText)

        val depositButton: Button = findViewById(R.id.depositButton)
        depositButton.setOnClickListener {
            depositar()
        }

        val withdrawButton: Button = findViewById(R.id.withdrawButton)
        withdrawButton.setOnClickListener {
            retirar()
        }

        val exitButton: Button = findViewById(R.id.exitButton)
        exitButton.setOnClickListener {
            finish()
        }
    }

    private fun depositar() {
        val depositText: String = depositAmountEditText.text.toString()
        if (depositText.isNotEmpty()) {
            val depositAmount: Double = depositText.toDouble()
            saldo += depositAmount
            saldoValueTextView.text = saldo.toString()
            depositAmountEditText.setText("")
        }
    }

    private fun retirar() {
        val withdrawText: String = withdrawAmountEditText.text.toString()
        if (withdrawText.isNotEmpty()) {
            val withdrawAmount: Double = withdrawText.toDouble()
            if (withdrawAmount <= saldo) {
                saldo -= withdrawAmount
                saldoValueTextView.text = saldo.toString()
                withdrawAmountEditText.setText("")
            }
        }
    }
}
