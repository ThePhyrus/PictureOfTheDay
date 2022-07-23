package rom.example.pictureoftheday.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import rom.example.pictureoftheday.R
import rom.example.pictureoftheday.databinding.ActivityApiBinding
import rom.example.pictureoftheday.navigation.vp.ViewPager2Adapter


class ApiActivity : AppCompatActivity() {
    lateinit var binding: ActivityApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.ToxicGreenTheme)
        binding = ActivityApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPager2Adapter(this)

        TabLayoutMediator(
            binding.mTabLayout,
            binding.viewPager,
            object : TabLayoutMediator.TabConfigurationStrategy {
                override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                    tab.text = when (position) {
                        0 -> "Earth"
                        1 -> "Mars"
                        else -> "System"
                    }
                }

            }).attach()

    }
}