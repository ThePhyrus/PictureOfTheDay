package rom.example.pictureoftheday.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import rom.example.pictureoftheday.R
import rom.example.pictureoftheday.databinding.ActivityApiBinding
import rom.example.pictureoftheday.databinding.ActivityMainBinding
import rom.example.pictureoftheday.navigation.vp.ViewPagerAdapter
import rom.example.pictureoftheday.view.picture.PictureOfTheDayFragment


class ApiActivity : AppCompatActivity() {
    lateinit var binding: ActivityApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.ToxicGreenTheme)
        binding = ActivityApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
//        binding.textOne.setTextColor(resources.getColor(R.color.blue_test))
//        binding.textOne.setTextColor(resources.getColor(R.color.red_600))

    }
}