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
        val badgeEarth = binding.bottomNavigation.getOrCreateBadge(R.id.action_bottom_nav_earth)
        badgeEarth.maxCharacterCount = 5
        badgeEarth.number = 7948
        badgeEarth.backgroundColor = resources.getColor(R.color.mr_badge_background_color)
        badgeEarth.badgeTextColor = resources.getColor(R.color.mr_badge_text_color)
        badgeEarth.badgeGravity = BadgeDrawable.TOP_END
        val badgeMars = binding.bottomNavigation.getOrCreateBadge(R.id.action_bottom_nav_mars)
        badgeMars.maxCharacterCount = 5
        badgeMars.number = 0
        badgeMars.badgeTextColor = resources.getColor(R.color.mr_badge_text_color)
        badgeMars.backgroundColor = resources.getColor(R.color.mr_badge_background_color)
        val badgeSystem = binding.bottomNavigation.getOrCreateBadge(R.id.action_bottom_nav_system)
        badgeSystem.maxCharacterCount = 5
        badgeSystem.number = 7948
        badgeSystem.badgeTextColor = resources.getColor(R.color.mr_badge_text_color)
        badgeSystem.backgroundColor = resources.getColor(R.color.mr_badge_background_color)

//        binding.bottomNavigation.menu.removeItem(R.id.action_bottom_nav_mars)
//        binding.bottomNavigation.menu.removeItem(R.id.action_bottom_nav_system)

        binding.bottomNavigation.inflateMenu(R.menu.menu_bottom_navigation_drawer)
    }
}