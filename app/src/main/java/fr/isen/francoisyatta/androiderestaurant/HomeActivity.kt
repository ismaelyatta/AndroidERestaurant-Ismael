package fr.isen.francoisyatta.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.francoisyatta.androiderestaurant.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.entree.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("category", "Entrées")
            startActivity(intent)

        }

        binding.plat.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("category", "Plats")
            startActivity(intent)

        }

        binding.dessert.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("category", "Desserts")
            startActivity(intent)

        }


    }
}