package rom.example.pictureoftheday.viewmodel

import rom.example.pictureoftheday.repository.PictureOfTheDayResponseData

sealed class PictureOfTheDayAppState {
    data class Success(val pictureOfTheDayResponseData: PictureOfTheDayResponseData) :
        PictureOfTheDayAppState()

    data class Error(val error: Throwable) : PictureOfTheDayAppState()
    data class Loading(val progress: Int?) : PictureOfTheDayAppState()

}
