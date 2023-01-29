package fr.isen.francoisyatta.androiderestaurant

import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.francoisyatta.androiderestaurant.databinding.ActivityCategoryBinding
import fr.isen.francoisyatta.androiderestaurant.model.DataResult
import fr.isen.francoisyatta.androiderestaurant.model.Items
import org.json.JSONObject


class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding
    private lateinit var category: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        category = intent.getStringExtra("category") ?: ""


        binding.categoryList.layoutManager = LinearLayoutManager(this)
        binding.categoryList.adapter = CategoryAdapter(arrayListOf<Items>()) {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        val dishes = resources.getStringArray(R.array.plats).toList()
        loadDishesFromAPI()
    }

    private fun loadDishesFromAPI() {

        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonObject, {
                Log.w("MealActivity", "response : $it")
                handleAPIData(it.toString())
            }, {
                Log.w("MealActivity", "error : $it")
            }

        )
        Volley.newRequestQueue(this).add(jsonRequest)

    }

    private fun handleAPIData(data: String) {
        var dishesResult = Gson().fromJson(data, DataResult::class.java)
        val dichesCategory = dishesResult.data.firstOrNull { it.nameFr == category }

        val adapter = binding.categoryList.adapter as CategoryAdapter
        adapter.refreshList(dichesCategory?.items as ArrayList<Items>)


    }

}