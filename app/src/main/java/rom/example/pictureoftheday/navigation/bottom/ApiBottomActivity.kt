package rom.example.pictureoftheday.navigation.bottom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.badge.BadgeDrawable
import rom.example.pictureoftheday.R
import rom.example.pictureoftheday.databinding.ActivityApiBottomBinding
import rom.example.pictureoftheday.navigation.EarthFragment
import rom.example.pictureoftheday.navigation.MarsFragment
import rom.example.pictureoftheday.navigation.SystemFragment

class ApiBottomActivity : AppCompatActivity() {
    lateinit var binding: ActivityApiBottomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.ToxicGreenTheme)
        binding = ActivityApiBottomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_bottom_nav_earth -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, EarthFragment.newInstance()).commit()
                }
                R.id.action_bottom_nav_mars -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, MarsFragment.newInstance()).commit()
                }
                R.id.action_bottom_nav_system -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SystemFragment.newInstance()).commit()
                }
            }
            true
        }
        binding.bottomNavigation.selectedItemId = R.id.action_bottom_nav_mars
        val badge = binding.bottomNavigation.getOrCreateBadge(R.id.action_bottom_nav_earth)
        badge.number = 9794
        badge.maxCharacterCount = 5
        badge.backgroundColor = resources.getColor(R.color.mr_badge_background_color)
        badge.badgeTextColor = resources.getColor(R.color.mr_badge_text_color)
        badge.badgeGravity = BadgeDrawable.TOP_END
    }
}