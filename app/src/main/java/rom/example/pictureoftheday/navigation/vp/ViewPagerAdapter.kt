package rom.example.pictureoftheday.navigation.vp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import rom.example.pictureoftheday.navigation.EarthFragment
import rom.example.pictureoftheday.navigation.MarsFragment
import rom.example.pictureoftheday.navigation.SystemFragment

private val EARTH = EarthFragment()
private val MARS = MarsFragment()
private val SYSTEM = SystemFragment()

class ViewPagerAdapter(private val fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val fList = listOf(EARTH, SYSTEM, MARS)

    override fun getCount(): Int {
        return fList.size
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> EARTH
            1 -> MARS
            else -> SYSTEM
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "Earth"
            1 -> "Mars"
            else -> "System"
        }
    }
}