package com.example.bitfit1

import android.content.Intent
import android.os.Bundle
import android.view.Display
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "BitFitActivity"
class DetailActivity : AppCompatActivity(){
    private lateinit var foodEditView: EditText
    private lateinit var caloriesEditView: EditText
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_detail)

        foodEditView = findViewById(R.id.foodItem)
        caloriesEditView = findViewById(R.id.CalNum)
        button = findViewById(R.id.newFood)


        button.setOnClickListener {
            val food = foodEditView.text.toString()
            val calories = caloriesEditView.text.toString()
            val item = DisplayBitFit(food, calories)
            lifecycleScope.launch(Dispatchers.IO) {
                (application as BitFitApplication).db.bitFitDao().insert(BitFitEntity(foodName = item.foodName,calories = item.calories))
            }
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)

        }

    }


}