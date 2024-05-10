package com.example.bmi_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShoppingListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_list)

        val ingredients = listOf("broccoli florets", "unsalted butter", "heavy cream", "grated parmesan cheese", "minced garlic",
                "nutmeg", "salt", "pepper", "parsley sprigs")

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = ShoppingListAdapter(ingredients)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val backButton: Button = findViewById(R.id.backBtn)
        backButton.setOnClickListener {
            val intent = Intent(this, RecipesActivity::class.java)
            startActivity(intent)
        }
    }
}