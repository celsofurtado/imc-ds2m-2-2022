package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.imc20.databinding.ActivityCalculateBinding

class CalculateActivity : AppCompatActivity() {

    lateinit var binding: ActivityCalculateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        loadProfile()

        binding.buttonCalculate.setOnClickListener {
            bmiCalculate()
        }

    }

    private fun bmiCalculate() {
        val openResult = Intent(this, ResultActivity::class.java)

        // Enviar dados de uma Activity para outra
        openResult.putExtra("peso", binding.editTextWeight.text.toString())
        openResult.putExtra("preco", 40.98)

        startActivity(openResult)
    }

    private fun loadProfile() {
        // Abrir o arquivo SharedPreferences
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        binding.textViewUsername.text = dados.getString("name", "")
        binding.textViewEmail.text = dados.getString("email", "")
        binding.textViewWeight.text = "${resources.getText(R.string.weight)}: ${dados.getInt("weight", 0)} Kg "
        binding.textViewHeight.text = "${resources.getText(R.string.height)}: ${dados.getFloat("height", 0.0f)}"
    }
}