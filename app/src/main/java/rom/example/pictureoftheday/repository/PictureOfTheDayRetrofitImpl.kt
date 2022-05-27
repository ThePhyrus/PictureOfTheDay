package rom.example.pictureoftheday.repository

import android.util.Log
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rom.example.pictureoftheday.utils.NASA_DOMAIN
import rom.example.pictureoftheday.utils.TAG

class PictureOfTheDayRetrofitImpl {
    private val nasaBaseUrl: String = NASA_DOMAIN

    private val pictureOfTheDayRetrofit = Retrofit.Builder()
        .baseUrl(nasaBaseUrl)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()

    fun getRetrofit(): PictureOfTheDayAPI {//FIXME вынести создание Retrofit
        Log.d(TAG, "getRetrofit() called $pictureOfTheDayRetrofit")
        return pictureOfTheDayRetrofit.create(PictureOfTheDayAPI::class.java)
    }
}