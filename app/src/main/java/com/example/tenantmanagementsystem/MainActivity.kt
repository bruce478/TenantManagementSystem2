package com.example.tenantmanagementsystem
import com.example.tenantmanagementsystem.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tenantmanagementsystemgroupa.Tenant

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
binding.saveButton.setOnClickListener {
    val name=binding.tenantNameEditText.text.toString()
    val  phone=binding.phoneEditText.text.toString()
    val rent= binding.rentEditText.text.toString()
    val tenant = Tenant(name, phone, rent)
    binding.tenant = tenant
}
        // android.R.id.content always exists, so the layout XML needs no id
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameEditText = findViewById<EditText>(R.id.tenantNameEditText)
        val phoneEditText = findViewById<EditText>(R.id.phoneEditText)
        val rentEditText = findViewById<EditText>(R.id.rentEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val resultTextView = findViewById<TextView>(R.id.tenantResultTextView)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val rent = rentEditText.text.toString().trim()

            if (name.isEmpty() || phone.isEmpty() || rent.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                resultTextView.text = "Name: $name\nPhone: $phone\nRent Paid: KES $rent"
            }
        }
    }
}