package com.test.lt_testapplication.fragments

import android.os.Bundle
import android.view.*
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.test.lt_testapplication.R
import com.test.lt_testapplication.databinding.FragmentMainBinding
import com.test.lt_testapplication.utilities.setupWithNavController

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_refresh -> {
                        // TODO Refresh the list
                        true
                    }
                    else -> false
                }
            }

            toolbar.navigationIcon = ResourcesCompat.getDrawable(
                resources,
                R.drawable.ic_button_back,
                null
            )

            bottomNavigationView.setupWithNavController(
                navGraphIds = listOf(
                    R.navigation.nav_graph_home,
                    R.navigation.nav_graph_favorites,
                    R.navigation.nav_graph_account
                ),
                fragmentManager = childFragmentManager,
                containerId = R.id.nav_host_fragment_main,
                intent = requireActivity().intent,
                onItemSelected = {
                    // TODO Прописать действия с аппбаром (?)
                    val navHostFragment = childFragmentManager
                        .findFragmentById(R.id.nav_host_fragment_main) as NavHostFragment
                    toolbar.setupWithNavController(navHostFragment.navController)
                    toolbar.menu.clear()
                    toolbar.inflateMenu(R.menu.menu_details)
                    toolbar.title = "Ebaaaaaat"
                }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}