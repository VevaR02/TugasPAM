package com.example.mesenmakanan.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mesenmakanan.R
import com.example.mesenmakanan.data.Food
import com.example.mesenmakanan.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val foodList = listOf(
            Food(
                R.drawable.massaman_curry,
                "Massaman Curry, Thailand",
                "Hindangan asal Thailand ini memiliki cita rasa yang pedas, manis dan gurih.",
                "Rp 25.000"
            ),
            Food(
                R.drawable.neapolitan_pizza,
                "Neapolitan Pizza, Italy",
                "Pizza ini terbuat dari adonan yang ditambahkan dengan tomat, garam, minyak zaitun, kemangi dan juga keju.",
                "Rp 30.000"
            ),
            Food(
                R.drawable.coklat,
                "Coklat, Mexico",
                "Terbuat dari biji kokoa yang dapat diolah menjadi berbagai jenis cemilan.",
                "Rp 20.000"
            ),
            Food(
                R.drawable.sushi,
                "Sushi, Japan",
                "Sushi menjadi salah satu makanan yang digemari banyak orang di dunia, termasuk di Indonesia.",
                "Rp 45.000"
            ),
            Food(
                R.drawable.peking_duck,
                "Peking Duck, China",
                "Peking Duck, yakni olahan bebek yang dilapisi dengan sirup maltosa.",
                "Rp 30.000"
            ),
            Food(
                R.drawable.hamburger,
                "Hamburger, Jerman",
                "Dari kombinasi roti, daging, dan salad yang berhasil menarik perhatian dunia.",
                "Rp 20.000"
            ),
            Food(
                R.drawable.penang_assam_laksa,
                "Penang Assam Laksa, Malaysia",
                "Terbuat dari ikan makarel rebus, asam jawa, cabai, mint, serai, bawang, dan juga nanas.",
                "Rp 25.000"
            ),
            Food(
                R.drawable.tom_yum_goong,
                "Tom Yum Goong, Thailand",
                "Sajian yang terbuat dari udang, jamur, tomat, serai, lengkuas, dan daun jeruk",
                "Rp 30.000"
            ),
            Food(
                R.drawable.es_krim,
                "Es Krim, Global",
                "Tersedia dengan banyak varian rasa dan topping, seperti cokelat, sirup, selai hingga wafer.",
                "Rp 20.000"
            ),
            Food(
                R.drawable.chicken_muamba,
                "Chicken Muamba, Gabon",
                "Gabon yang terbuat dari ayam, bawang putih, cabai, tomat, merica, garam, mentega, dan okra.",
                "Rp 45.000"
            ),
            Food(
                R.drawable.rendang,
                "Rendang, Indonesia",
                "Hidangan asal Minang ini terbuat dari daging sapi yang direbus dengan santan dan campuran rempah, seperti serai, lengkuas, bawang, putih, kunyit, jahe, dan cabai.",
                "Rp 50.000"
            ),
            Food(
                R.drawable.piri_piri_chicken,
                "Piri-piri Chicken, Mozambik",
                "Sajian ayam ini dimasak dengan jeruk nipis, merica, bawang putih, santan, dan saus piri-piri.",
                "Rp 30.000"
            )

        )


        foodAdapter = FoodAdapter { selectedFood ->
            val action = HomeFragmentDirections.actionHomeFragmentToOrderDetailFragment(selectedFood)
            findNavController().navigate(action)
        }

        binding.recyclerViewFood.apply {
            adapter = foodAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        foodAdapter.submitList(foodList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
