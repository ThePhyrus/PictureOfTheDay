package rom.example.pictureoftheday.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import rom.example.pictureoftheday.R
import rom.example.pictureoftheday.databinding.ActivityMainBinding
import rom.example.pictureoftheday.view.picture.PictureOfTheDayFragment


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.ToxicGreenTheme) //FIXME как-то криво добавил темы? Теперь без этой строчки приложение не работает. Почему?
        // todo HW 1 обязательно перед setContentView
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // todo HW 2 если момент setContentView уже упущен, то вызываем recreate()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance()).commit()
        }
    }
}