package rom.example.pictureoftheday.view.settings

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.google.android.material.tabs.TabLayout
import rom.example.pictureoftheday.R
import rom.example.pictureoftheday.databinding.FragmentSettingsBinding
import rom.example.pictureoftheday.utils.TAG


class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding: FragmentSettingsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupChipGroup()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(requireContext(), "${tab?.position?.plus(1)}", Toast.LENGTH_SHORT)
                    .show()
                when (tab?.position?.plus(1)) {
                    1 -> {
                        Log.d(TAG, "onTabSelected() called with: tab = $tab")
                    }
                    2 -> {
                        Log.d(TAG, "onTabSelected() called with: tab = $tab")
                    }
                    3 -> {
                        Log.d(TAG, "onTabSelected() called with: tab = $tab")
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // TODO("Not yet implemented")
            }

        })
    }

    private fun setupChipGroup() {
        binding.chipGroup.setOnCheckedChangeListener { group, position ->

            /*when(position){ //todo HW
                1 -> {viewModel.sendRequestToday()}
                2 -> {viewModel.sendRequestYesterday()}
                3 -> {viewModel.sendRequestTheDayBeforeYesterday()}
                4 -> {viewModel.sendRequestFullHD()}
            }*/

            /*when(position){ //todo HW
                1 -> {viewModel.sendRequest(data)}
                2 -> {viewModel.sendRequest(data-1)}
                3 -> {viewModel.sendRequestTheDayBefore(data-2)}
                4 -> {viewModel.sendRequest(data-3)}
            }*/

            group.findViewById<Chip>(position)?.let {
                Log.d(TAG, "renderData: ${it.text} $position")
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}