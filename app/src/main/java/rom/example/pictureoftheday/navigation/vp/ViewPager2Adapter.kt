package rom.example.pictureoftheday.navigation.vp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import rom.example.pictureoftheday.navigation.EarthFragment
import rom.example.pictureoftheday.navigation.MarsFragment
import rom.example.pictureoftheday.navigation.SystemFragment

private val EARTH = EarthFragment()
private val MARS = MarsFragment()
private val SYSTEM = SystemFragment()

class ViewPager2Adapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private val fList = listOf(EARTH, SYSTEM, MARS)

    override fun getItemCount(): Int = fList.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> EARTH
            1 -> MARS
            else -> SYSTEM
        }
    }
}