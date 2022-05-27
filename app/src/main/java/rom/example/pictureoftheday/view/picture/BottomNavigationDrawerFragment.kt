package rom.example.pictureoftheday.view.picture

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import rom.example.pictureoftheday.R
import rom.example.pictureoftheday.databinding.BottomNavigationLayoutBinding
import rom.example.pictureoftheday.utils.TAG


class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    private var _binding: BottomNavigationLayoutBinding? = null
    private val binding: BottomNavigationLayoutBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomNavigationLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigationOne -> {
                    Log.d(TAG, "onOptionsItemSelected() called with: $it")
                }
                R.id.navigationTwo -> {
                    Log.d(TAG, "onOptionsItemSelected() called with: $it")
                }
            }
            true
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = BottomNavigationDrawerFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}