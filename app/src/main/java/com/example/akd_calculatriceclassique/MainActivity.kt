package com.example.akd_calculatriceclassique

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.akd_calculatriceclassique.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var editTextNumber3: EditText
    private lateinit var buttonAddition: Button
    private lateinit var textViewResult: TextView
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Corriger : associer la Toolbar comme barre d’action
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Initialisation des vues
        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        editTextNumber3 = findViewById(R.id.editTextNumber3)
        buttonAddition = findViewById(R.id.buttonAddition)
        textViewResult = findViewById(R.id.textViewResult)
        val buttonSubtract = findViewById<Button>(R.id.buttonSubtract)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)
        //val buttonPower = findViewById<Button>(R.id.buttonPower)
        val buttonLn = findViewById<Button>(R.id.buttonLn)
        val buttonLog = findViewById<Button>(R.id.buttonLog)
        val buttonClear = findViewById<Button>(R.id.buttonClear)
        buttonAddition.setOnClickListener {
            val number1 = editTextNumber1.text.toString().toDoubleOrNull()
            val number2 = editTextNumber2.text.toString().toDoubleOrNull()
            val number3 = editTextNumber3.text.toString().toDoubleOrNull()

            if (number1 != null && number2 != null && number3 != null) {
                val result = number1 + number2 + number3
                textViewResult.text = "Résultat : $result"
            } else {
                textViewResult.text = "Veuillez entrer des nombres valides"
            }
        }
        buttonSubtract.setOnClickListener {
            val n1 = editTextNumber1.text.toString().toDoubleOrNull()
            val n2 = editTextNumber2.text.toString().toDoubleOrNull()
            textViewResult.text = if (n1 != null && n2 != null) "Résultat : ${n1 - n2}" else "Entrées invalides"
        }

        buttonMultiply.setOnClickListener {
            val n1 = editTextNumber1.text.toString().toDoubleOrNull()
            val n2 = editTextNumber2.text.toString().toDoubleOrNull()
            textViewResult.text = if (n1 != null && n2 != null) "Résultat : ${n1 * n2}" else "Entrées invalides"
        }

        buttonDivide.setOnClickListener {
            val n1 = editTextNumber1.text.toString().toDoubleOrNull()
            val n2 = editTextNumber2.text.toString().toDoubleOrNull()
            textViewResult.text = if (n1 != null && n2 != null) {
                if (n2 == 0.0) "Division par zéro" else "Résultat : ${n1 / n2}"
            } else "Entrées invalides"
        }

        buttonLn.setOnClickListener {
            val n1 = editTextNumber1.text.toString().toDoubleOrNull()
            textViewResult.text = if (n1 != null && n1 > 0) "Résultat : ${Math.log(n1)}" else "Entrée invalide"
        }

        buttonLog.setOnClickListener {
            val n1 = editTextNumber1.text.toString().toDoubleOrNull()
            textViewResult.text = if (n1 != null && n1 > 0) "Résultat : ${Math.log10(n1)}" else "Entrée invalide"
        }

        buttonClear.setOnClickListener {
            editTextNumber1.text.clear()
            editTextNumber2.text.clear()
            textViewResult.text = "Résultat :"
        }
        // Navigation
        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        //val navController = navHostFragment.navController
        //appBarConfiguration = AppBarConfiguration(navController.graph)

        //setupActionBarWithNavController(navController, appBarConfiguration)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
