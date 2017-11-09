package pl.com.example.dietplus.model

import android.graphics.drawable.Drawable
import android.support.v4.content.res.ResourcesCompat
import pl.com.example.dietplus.App
import pl.com.example.dietplus.R
import java.io.Serializable

/**
 * Model danych dla składnika pokarmowego
 */
data class FoodIngridient(
        val id: Int,
        val name: String,
        val desc: String,
        val danger: String,
        val foodExample: String,
        private val dailyMale: String,
        private val dailyFem: String,
        private val unit: IntakeDoseUnit,
        private val imgName: String) :Serializable {

    /**
     * Tekst dziennego zapotrzebowania w formacie
     * man = 10 mg
     * woman = 8 mg
     */
    val intake
        get() = """${"\u2642"} = $dailyMale ${unit.getLocalName()}
                  |${"\u2640"} = $dailyFem ${unit.getLocalName()}""".trimMargin()

    /**
     * Drawable nagłówka składnika odżywczego
     */
    val drawable: Drawable?
        get() {
            val ctx = App.appContext
            val id = ctx.resources.getIdentifier(imgName, DRAWABLE_TYPE_DEF, ctx.packageName)
            return ResourcesCompat.getDrawable(ctx.resources, id, null)
        }

    companion object {
        const val DRAWABLE_TYPE_DEF = "drawable"
    }
}

/**
 * Typ wyliczeniowy jednostek zapotrzebowania dziennego
 */
enum class IntakeDoseUnit {
    GRAM() {
        override fun getLocalName() = App.appContext.getString(R.string.gram)
    },
    MGRAM() {
        override fun getLocalName() = App.appContext.getString(R.string.miligram)
    },
    UGRAM() {
        override fun getLocalName() = App.appContext.getString(R.string.mikrogram)
    },
    IU() {
        override fun getLocalName() = App.appContext.getString(R.string.unifiedunit)
    },
    UNKNOWN() {
        override fun getLocalName() = App.appContext.getString(R.string.unifiedunit)
    };

    abstract fun getLocalName(): String?
}