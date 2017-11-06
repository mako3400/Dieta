package pl.com.example.dietplus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import pl.com.example.dietplus.model.FoodIngridient

class MainActivity : AppCompatActivity() {

    val ingridientArray by lazy {
        val jsonStream = assets.open("base.json")
        val size = jsonStream.available()
        val buffer = ByteArray(size)
        jsonStream.read(buffer)
        jsonStream.close()
        val jsonString = String(buffer, Charsets.UTF_8)
        Gson().fromJson<List<FoodIngridient>>(jsonString, FOOD_ING_TYPE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
       private val FOOD_ING_TYPE = object : TypeToken<List<FoodIngridient>>(){}.type
    }
}
