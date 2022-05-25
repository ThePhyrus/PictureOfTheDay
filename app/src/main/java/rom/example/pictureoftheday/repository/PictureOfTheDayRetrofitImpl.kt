package rom.example.pictureoftheday.repository

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rom.example.pictureoftheday.utils.NASA_DOMAIN

class PictureOfTheDayRetrofitImpl {
    private val nasaBaseUrl:String = NASA_DOMAIN

    fun getRetrofit():PictureOfTheDayAPI {//FIXME вынести создание Retrofit
       val pictureOfTheDayRetrofit = Retrofit.Builder()
           .baseUrl(nasaBaseUrl)
           .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
           .build()
        return pictureOfTheDayRetrofit.create(PictureOfTheDayAPI::class.java)
    }
}