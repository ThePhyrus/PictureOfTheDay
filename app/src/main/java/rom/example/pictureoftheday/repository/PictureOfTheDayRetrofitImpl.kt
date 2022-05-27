package rom.example.pictureoftheday.repository

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rom.example.pictureoftheday.utils.NASA_DOMAIN

class PictureOfTheDayRetrofitImpl {
    //FIXME правильно ли я вынес создание Retrofit?
    private val nasaBaseUrl: String = NASA_DOMAIN
    private val pictureOfTheDayRetrofit = Retrofit.Builder()
        .baseUrl(nasaBaseUrl)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()

    fun getRetrofit(): PictureOfTheDayAPI {
        return pictureOfTheDayRetrofit.create(PictureOfTheDayAPI::class.java)
    }
}