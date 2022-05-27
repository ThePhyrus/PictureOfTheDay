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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance()).commit()
        }
    }
}