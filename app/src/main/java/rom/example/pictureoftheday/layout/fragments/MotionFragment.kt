package rom.example.pictureoftheday.layout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rom.example.pictureoftheday.R
import rom.example.pictureoftheday.databinding.FragmentMotionBinding


class MotionFragment : Fragment() {


    private var _binding: FragmentMotionBinding? = null
    private val binding: FragmentMotionBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMotionBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    companion object {
        @JvmStatic
        fun newInstance() = MotionFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}