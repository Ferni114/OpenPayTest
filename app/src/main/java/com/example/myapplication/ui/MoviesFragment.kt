package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.domain.MovieAdapter
import com.example.myapplication.data.MovieModel
import com.example.myapplication.viewmodel.MoviesViewModel
import com.example.myapplication.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [MoviesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoviesFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_movies, container, false)


        loadMVVMPopulars(view)

        return view
    }

    fun loadMVVMPopulars(view:View){
        val moviesViewModel: MoviesViewModel by viewModels()
        moviesViewModel.moviepopularsmodel.observe(viewLifecycleOwner, Observer {list ->

                    var populars = view.findViewById<RecyclerView>(R.id.populars)
                    populars.layoutManager =
                        LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                    var array = ArrayList<MovieModel>()

                    for (item in list.results) {
                        array.add(
                            MovieModel(
                                item.id,
                                "https://www.themoviedb.org/t/p/w220_and_h330_face" + item.picture,
                                item.title,
                                item.date
                            )
                        )
                    }
                    val adapter = MovieAdapter(array)

                    populars.adapter = adapter

            loadMVVMQualifieds(view)


        })
        CoroutineScope(Dispatchers.IO).launch {
            moviesViewModel.loadPopulars()
        }

    }

    fun loadMVVMQualifieds(view:View){
        val moviesViewModel: MoviesViewModel by viewModels()
        moviesViewModel.moviequalifiedsmodel.observe(viewLifecycleOwner, Observer { list ->

            var qualifieds = view.findViewById<RecyclerView>(R.id.qualifieds)
            qualifieds.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            var array = ArrayList<MovieModel>()
            for (item in list.results) {
                array.add(
                    MovieModel(
                        item.id,
                        "https://www.themoviedb.org/t/p/w220_and_h330_face" + item.picture,
                        item.title,
                        item.date
                    )
                )
            }
            val adapter = MovieAdapter(array)
            qualifieds.adapter = adapter

            loadMVVMNext(view)
        })
        CoroutineScope(Dispatchers.IO).launch {
            moviesViewModel.loadQualifieds()
        }
    }

    fun loadMVVMNext(view:View){
        val moviesViewModel: MoviesViewModel by viewModels()
        moviesViewModel.movienextmodel.observe(viewLifecycleOwner, Observer { list ->

            var next = view.findViewById<RecyclerView>(R.id.next)
            next.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            var array = ArrayList<MovieModel>()
            for (item in list.results) {
                array.add(
                    MovieModel(
                        item.id,
                        "https://www.themoviedb.org/t/p/w220_and_h330_face" + item.picture,
                        item.title,
                        item.date
                    )
                )
            }
            val adapter = MovieAdapter(array)
            next.adapter = adapter


        })
        CoroutineScope(Dispatchers.IO).launch {
            moviesViewModel.loadNext()
        }
    }


}