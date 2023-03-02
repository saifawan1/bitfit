package com.example.bitfit1


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

private const val TAG = "MainActivity/"

class MainActivity : AppCompatActivity() {
    private val items = mutableListOf<DisplayBitFit>()
    private lateinit var itemsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        itemsRecyclerView = findViewById(R.id.itemsRc)
        val itemsAdapter = BitFitAdapter(items)
        itemsRecyclerView.adapter = itemsAdapter
        itemsRecyclerView.layoutManager = LinearLayoutManager(this)

        val newFoodButton = findViewById<Button>(R.id.addFood)
        newFoodButton.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            this.startActivity(intent)
        }
        lifecycleScope.launch {
            (application as BitFitApplication).db.bitFitDao().getAll().collect { databaseList ->
                Log.d("database",databaseList.toString())
                databaseList.map { entity ->
                    DisplayBitFit(
                        entity.foodName,
                        entity.calories,
                    )
                }.also { mappedList ->
                    items.clear()
                    items.addAll(mappedList)
                    itemsAdapter.notifyDataSetChanged()
                }
            }
        }
    }

}