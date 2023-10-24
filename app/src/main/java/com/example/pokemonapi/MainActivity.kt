package com.example.pokemonapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var pokeList: MutableList<String>
    private lateinit var rvPoke: RecyclerView

//    private lateinit var temp : MutableList<String>

    var happyUrl = " "
    var captureUrl = " "
    var colorUrl = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPoke = findViewById(R.id.poke_list)
        pokeList = mutableListOf()


//        val button = findViewById<Button>(R.id.button)
        val happiness = findViewById<TextView>(R.id.outHappy)
        val captureRate = findViewById<TextView>(R.id.outCapture)
        val color = findViewById<TextView>(R.id.outColor)

//        val pokemon : EditText = findViewById(R.id.input)

        getPokeUrl(happiness, captureRate, color)
        Log.d("petImageURL", "pet image URL set")

//        getNextBerry(button, happiness, captureRate, color)

    }
    private fun getPokeUrl(happiness: TextView, captureRate : TextView, color : TextView){
        val client = AsyncHttpClient()

//      val poke : String = pokemon.toString()

        client["https://pokeapi.co/api/v2/pokemon?offset=20&limit=10", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                val pokeImageArray = json.jsonObject.getJSONArray("results")
                Log.d("JSON WORKS", "$pokeImageArray")

                for (i in 0 until pokeImageArray.length()) {
                    val c = pokeImageArray.getJSONObject(i)
                    val name = c.getString("name")
                    val happyText = "This is pokemon name: $name"
                    happiness.text = happyText
                    val url = c.getString("url")
                    val urls = "This is pokemon url: $url"
                    captureRate.text = urls
//

//                    if (c.getString("name") == "name"){
//
//                    } else if (c.getString("url") == "url"){
//                        val url = c.getString("url")
//                        val urls = "This is pokemon url: $url"
//
//                    }
//                    captureRate.text = urls


//                    temp.add(name)


                    pokeList.add(pokeImageArray.getString(i))
                }
//                happiness.text = temp
                val adapter = pokeAdapter(pokeList)
                rvPoke.adapter = adapter
                rvPoke.layoutManager = LinearLayoutManager(this@MainActivity)

                Log.d("Dog", "response successful")
//                happyUrl = json.jsonObject.getString("name")
//
//                captureUrl = json.jsonObject.getString("capture_rate")
//                colorUrl = json.jsonObject.getString("color")
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Dog Error", errorResponse)
            }
        }]
    }
//    private fun getNextBerry(button: Button, happiness: TextView, captureRate : TextView, color : TextView){
//        Log.d("nextBerry", "Hit getNextBerry()")
//        button.setOnClickListener {
//            getPokeUrl()
//            Log.d("Button", happyUrl)
//
////            val happyText = "This is base happiness: $happyUrl"
//            val happyText = "This is base happiness: HEYEYEY"
////            val captureText = "This is capture rate: ${captureUrl}"
////            val colorText = "This is color: ${colorUrl}"
//
//            happiness.text = happyText
////            captureRate.text = captureText
////            color.text = colorText
//        }
 //   }
}

