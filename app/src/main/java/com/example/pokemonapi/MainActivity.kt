package com.example.pokemonapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import com.bumptech.glide.Glide
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    var happyUrl = " "
    var captureUrl = " "
    var colorUrl = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)
        val happiness = findViewById<TextView>(R.id.outHappy)
        val captureRate = findViewById<TextView>(R.id.outCapture)
        val color = findViewById<TextView>(R.id.outColor)

        val pokemon : EditText = findViewById(R.id.input)

//        getPokeUrl()
        Log.d("petImageURL", "pet image URL set")

        getNextBerry(button, happiness, captureRate, color, pokemon)

    }
    private fun getPokeUrl(x : String){
        val client = AsyncHttpClient()

//        val poke : String = pokemon.toString()



        client["https://pokeapi.co/api/v2/pokemon-species/${x}", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("Dog", "response successful")
                happyUrl = json.jsonObject.getString("base_happiness")
                captureUrl = json.jsonObject.getString("capture_rate")
                colorUrl = json.jsonObject.getString("color")
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
    private fun getNextBerry(button: Button, happiness: TextView, captureRate : TextView, color : TextView, pokemon : EditText){
        Log.d("nextBerry", "Hit getNextBerry()")
        button.setOnClickListener {
            val poke = pokemon.text.toString()
            getPokeUrl(poke)
            Log.d("Button", happyUrl)

            val happyText = "This is base happiness: ${happyUrl}"
            val captureText = "This is capture rate: ${captureUrl}"
            val colorText = "This is color: ${colorUrl}"

            happiness.text = happyText
            captureRate.text = captureText
            color.text = colorText
        }
    }
}

