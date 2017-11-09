package pl.com.example.dietplus

import android.os.Bundle
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import com.github.florent37.materialviewpager.header.HeaderDesign
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import pl.com.example.dietplus.model.FoodIngridient
import pl.com.example.dietplus.recycler.RecyclerViewFragment

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
        initPager()
    }

    private fun initPager() {
        materialpager.viewPager.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int) = RecyclerViewFragment.newInstance(ingridientArray[position])
            override fun getCount() = ingridientArray.size
            override fun getPageTitle(position: Int) = ingridientArray[position].name
        }
        materialpager.setMaterialViewPagerListener({ page ->
            HeaderDesign.fromColorResAndDrawable(R.color.black, ingridientArray[page].drawable)
        })
        materialpager.viewPager.offscreenPageLimit = materialpager.viewPager.adapter.count

        materialpager.pagerTitleStrip.setViewPager(materialpager.viewPager)
    }

    companion object {
        private val FOOD_ING_TYPE = object : TypeToken<List<FoodIngridient>>() {}.type
    }
}
