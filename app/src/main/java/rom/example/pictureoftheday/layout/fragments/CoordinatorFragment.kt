package rom.example.pictureoftheday.layout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rom.example.pictureoftheday.R
import rom.example.pictureoftheday.databinding.FragmentConstraintBinding
import rom.example.pictureoftheday.databinding.FragmentCoordinatorBinding


class CoordinatorFragment : Fragment() {


    private var _binding: FragmentCoordinatorBinding? = null
    private val binding: FragmentCoordinatorBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoordinatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = CoordinatorFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}