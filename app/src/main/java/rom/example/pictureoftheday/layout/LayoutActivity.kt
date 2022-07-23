package rom.example.pictureoftheday.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import rom.example.pictureoftheday.R
import rom.example.pictureoftheday.databinding.ActivityLayoutBinding
import rom.example.pictureoftheday.layout.fragments.ConstraintFragment
import rom.example.pictureoftheday.layout.fragments.CoordinatorFragment
import rom.example.pictureoftheday.layout.fragments.MotionFragment

class LayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_bottom_navigation_constraint -> {
                    navigationTo(ConstraintFragment())
                    true
                }
                R.id.action_bottom_navigation_coordinator -> {
                    navigationTo(CoordinatorFragment())
                    true
                }
                R.id.action_bottom_navigation_motion -> {
                    navigationTo(MotionFragment())
                    true
                }
                else -> true
            }
        }
        binding.bottomNavigationView.selectedItemId = R.id.action_bottom_navigation_constraint
    }

    private fun navigationTo(f: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, f).commit()
    }


}