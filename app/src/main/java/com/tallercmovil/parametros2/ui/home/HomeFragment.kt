package com.tallercmovil.parametros2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tallercmovil.parametros2.R
import com.tallercmovil.parametros2.databinding.FragmentHomeBinding
import com.tallercmovil.parametros2.ui.gallery.GalleryViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val galleryViewModel: GalleryViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnIrFragmentGallery.setOnClickListener {
            galleryViewModel.cambiaItem("Playstation")
            findNavController().navigate(R.id.action_nav_home_to_nav_gallery)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}