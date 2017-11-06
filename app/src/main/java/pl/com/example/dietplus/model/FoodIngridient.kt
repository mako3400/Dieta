package pl.com.example.dietplus.model

import pl.com.example.dietplus.App
import pl.com.example.dietplus.R

/**
 * Model danych dla składnika pokarmowego
 */
class FoodIngridient(
        val id: Int,
        val name: String,
        val desc: String,
        val danger: String,
        val foodExample: String,
        val dailyMale: String,
        val dailyFem: String,
        val unit: IntakeDoseUnit,
        val imgName: String) {
}

enum class IntakeDoseUnit {
    GRAM() {
        override fun getName() {
            App.appContext.getString(R.string.gram)
        }
    },
    MGRAM() {
        override fun getName() {
            App.appContext.getString(R.string.miligram)

        }
    },
    UGRAM() {
        override fun getName() {
            App.appContext.getString(R.string.mikrogram)
        }
    },
    IU() {
        override fun getName() {
            App.appContext.getString(R.string.unifiedunit)
        }
    };

    abstract fun getName()
}