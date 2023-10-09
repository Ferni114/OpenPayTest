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
    /* lateinit var populars:RecyclerView
    lateinit var qualifieds:RecyclerView
    lateinit var next:RecyclerView */

    /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }
    } */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_movies, container, false)

        /* var qualifieds=view.findViewById<RecyclerView>(R.id.qualifieds)
        var next=view.findViewById<RecyclerView>(R.id.next) */

        /* requestPopularsMovies(populars)
        requestQualifiedsMovies(qualifieds)
        requestNextMovies(next) */
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

    /* fun loadPopulars(populars:RecyclerView,list:MoviesResponse){
        populars.layoutManager=
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        var array=ArrayList<MovieModel>()
        for (item in list.results) {
            array.add(MovieModel(item.id,"https://www.themoviedb.org/t/p/w220_and_h330_face"+item.picture, item.title, item.date))
        }
        val adapter = MovieAdapter(array)
        populars.adapter = adapter
    }

    fun loadQualifieds(qualifieds:RecyclerView,list:MoviesResponse){
        qualifieds.layoutManager=
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        var array=ArrayList<MovieModel>()
        for (item in list.results) {
            array.add(MovieModel(item.id,"https://www.themoviedb.org/t/p/w220_and_h330_face"+item.picture, item.title, item.date))
        }
        val adapter = MovieAdapter(array)
        qualifieds.adapter = adapter
    }

    fun loadNext(next:RecyclerView,list:MoviesResponse){
        next.layoutManager=
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        var array=ArrayList<MovieModel>()
        for (item in list.results) {
            array.add(MovieModel(item.id,"https://www.themoviedb.org/t/p/w220_and_h330_face"+item.picture, item.title, item.date))
        }
        val adapter = MovieAdapter(array)
        next.adapter = adapter
    } */

    /* data class MovieModel(var id:Int, var picture:String, var title:String, var date:String){

    } */

    /* class MovieAdapter(val array: List<MovieModel>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_view, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val movieModel = array[position]
            Picasso.get().load(movieModel.picture).resize(130,200).into(holder.picture)
            holder.title.text=movieModel.title
            holder.date.text=movieModel.date
        }

        override fun getItemCount(): Int {
            return array.size
        }

        class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
            val picture: ImageView = item.findViewById(R.id.picture)
            val title: TextView = item.findViewById(R.id.title)
            val date: TextView = item.findViewById(R.id.date)
        }
    } */

    /* fun requestPopularsMovies(populars:RecyclerView){
        CoroutineScope(Dispatchers.IO).launch {
            var resp=APIClient.getRetrofit()?.create(APIService::class.java)?.getMovies("popular")
            if(resp?.isSuccessful == true) {
                // Log.e("results",resp?.body().toString())

                withContext(Dispatchers.Main){
                     loadPopulars(populars,resp.body() as MoviesResponse)
                }
            }
        }
    }

    fun requestQualifiedsMovies(qualifieds:RecyclerView){
        CoroutineScope(Dispatchers.IO).launch {
             var array = APIClient.getRetrofit()?.create(APIService::class.java)?.getMovies("top_rated")
            if(array?.isSuccessful == true) {
                // Log.e("results",resp?.body().toString())

                withContext(Dispatchers.Main){
                     loadPopulars(qualifieds,array.body() as MoviesResponse)
                }
            }
        }
    }

    fun requestNextMovies(next:RecyclerView){
        CoroutineScope(Dispatchers.IO).launch {
             var array = APIClient.getRetrofit()?.create(APIService::class.java)?.getMovies("upcoming")
            if(array?.isSuccessful == true) {
                // Log.e("results",resp?.body().toString())
                withContext(Dispatchers.Main){
                      loadPopulars(next,array.body() as MoviesResponse)
                }
            }
        }
    } */


}