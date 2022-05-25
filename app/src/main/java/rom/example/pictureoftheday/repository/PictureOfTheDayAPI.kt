package rom.example.pictureoftheday.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import rom.example.pictureoftheday.BuildConfig
import rom.example.pictureoftheday.utils.NASA_ENDPOINT

interface PictureOfTheDayAPI {

    @GET(NASA_ENDPOINT)
    fun getPictureOfTheDay (@Query("api_key") apiKey:String): Call<PictureOfTheDayResponseData>
}