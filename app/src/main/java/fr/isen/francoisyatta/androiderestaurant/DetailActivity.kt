package fr.isen.francoisyatta.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.francoisyatta.androiderestaurant.model.Items

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val items = intent.getSerializableExtra("dishes") as Items
    }
}