package com.test.lt_testapplication.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.test.lt_testapplication.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.toolbar.apply {
//            binding.toolbar.setOnMenuItemClickListener { item ->
//                when (item.itemId) {
//                    R.id.action_refresh -> {
//                        // TODO: Refresh the list
//                        true
//                    }
//                    else -> false
//                }
//            }
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}