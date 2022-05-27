package rom.example.pictureoftheday.view.picture

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.chip.Chip
import rom.example.pictureoftheday.R
import rom.example.pictureoftheday.databinding.FragmentPictureOfTheDayBinding
import rom.example.pictureoftheday.utils.TAG
import rom.example.pictureoftheday.utils.WIKI_DOMAIN
import rom.example.pictureoftheday.view.MainActivity
import rom.example.pictureoftheday.viewmodel.PictureOfTheDayAppState
import rom.example.pictureoftheday.viewmodel.PictureOfTheDayViewModel


class PictureOfTheDayFragment : Fragment() {

    private var _binding: FragmentPictureOfTheDayBinding? = null
    private val binding: FragmentPictureOfTheDayBinding get() = _binding!!
    private var isMain =
        true//FIXME зачем это свойство? Я ещё с isRussian не разобрался в погодном приложении((

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPictureOfTheDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.app_bar_fav -> {
                Log.d(TAG, "onOptionsItemSelected() called with: item = $item")
            }
            R.id.app_bar_settings -> {
                Log.d(TAG, "onOptionsItemSelected() called with: item = $item")
            }
            android.R.id.home -> {
                BottomNavigationDrawerFragment.newInstance()
                    .show(requireActivity().supportFragmentManager, "TAG!???!!?") //todo dismiss
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer {
            renderData(it)
        })
        viewModel.sendRequest()
        setEndIconOnClickListener()
    }

    private fun setEndIconOnClickListener() {
        binding.inputLayout.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("$WIKI_DOMAIN${binding.inputEditText.text.toString()}")
            })
        }
    }

    private fun renderData(pictureOfTheDayAppState: PictureOfTheDayAppState) {
        when (pictureOfTheDayAppState) {
            is PictureOfTheDayAppState.Error -> {}//todo
            is PictureOfTheDayAppState.Loading -> {}//todo
            is PictureOfTheDayAppState.Success -> {
                with(binding) {
                    imageView.load(pictureOfTheDayAppState.pictureOfTheDayResponseData.hdurl) {
                        //todo HW скрасить ожидание картинки
                    }//.url
                    lifeHack.title.text =
                        pictureOfTheDayAppState.pictureOfTheDayResponseData.title
                    lifeHack.explanation.text =
                        pictureOfTheDayAppState.pictureOfTheDayResponseData.explanation
                }
            }
        }

        createBottomSheetBehavior()

        setupToolbar()

        setupFAB()

        setupChipGroup()
    }

    private fun createBottomSheetBehavior() {
        val bottomShiftBehavior = BottomSheetBehavior.from(binding.lifeHack.bottomSheetContainer)
        bottomShiftBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        bottomShiftBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_DRAGGING -> {}
                    BottomSheetBehavior.STATE_COLLAPSED -> {}
                    BottomSheetBehavior.STATE_EXPANDED -> {}
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {}
                    BottomSheetBehavior.STATE_HIDDEN -> {}
                    BottomSheetBehavior.STATE_SETTLING -> {}
                }
                Log.d(
                    TAG,
                    "onStateChanged() called with: bottomSheet = $bottomSheet, newState = $newState"
                )
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.d(TAG, "onSlide() called with: bottomSheet")
            }
        })
    }

    private fun setupFAB() {
        binding.fab.setOnClickListener {
            if (isMain) {
                binding.bottomAppBar.navigationIcon = null
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                binding.fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_back_fab
                    )
                )
                //                binding.bottomAppBar.replaceMenu(//todo показать другое меню)
            } else {
                binding.bottomAppBar.navigationIcon = (ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_hamburger_menu_bottom_bar
                ))
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                binding.fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_plus_fab
                    )
                )
                //                binding.bottomAppBar.replaceMenu(R.menu.menu_bottom_bar)
            }
            isMain = !isMain
        }
    }

    private fun setupChipGroup() {
        binding.chipGroup.setOnCheckedChangeListener { group, position ->

            /*when(position){ //todo HW
                1 -> {viewModel.sendRequestToday()}
                2 -> {viewModel.sendRequestYesterday()}
                3 -> {viewModel.sendRequestTheDayBeforeYesterday()}
                4 -> {viewModel.sendRequestFullHD()}
            }*/

            /*when(position){ //todo HW лучший вариант
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

    private fun setupToolbar() {
        (requireActivity() as MainActivity).setSupportActionBar(binding.bottomAppBar)
        setHasOptionsMenu(true)
    }


    companion object {
        @JvmStatic
        fun newInstance() = PictureOfTheDayFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}