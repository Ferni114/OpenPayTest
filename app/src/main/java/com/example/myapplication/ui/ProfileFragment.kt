 package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.myapplication.viewmodel.ProfileViewModel
import com.example.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

 // TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view= inflater.inflate(R.layout.fragment_profile, container, false)



        loadMVVM(view)
        return view
    }

    fun loadMVVM(view:View){
        val profileViewModel: ProfileViewModel by viewModels()
        profileViewModel.usermodel.observe(viewLifecycleOwner, Observer {info ->
            var picture: ImageView =view.findViewById(R.id.picture)
            var name: TextView =view.findViewById(R.id.name)
            var username: TextView =view.findViewById(R.id.username)
            Picasso.get().load("https://www.themoviedb.org/t/p/w150_and_h150_face"+info.avatar.tmdb.path).into(picture)
            name.text=info.name
            username.text=info.username
        })
        CoroutineScope(Dispatchers.IO).launch {
            profileViewModel.loadInformation()
        }
    }

    /* fun loadInfo(view:View,info:UserResponse){
        var picture: ImageView =view.findViewById(R.id.picture)
        var name: TextView =view.findViewById(R.id.name)
        var username: TextView =view.findViewById(R.id.username)
       Picasso.get().load("https://www.themoviedb.org/t/p/w150_and_h150_face"+info.avatar.tmdb.path).into(picture)
       name.text=info.name
        username.text=info.username
    }

    fun requestUser(view:View){
        CoroutineScope(Dispatchers.IO).launch {
            var array = APIClient.getRetrofit()?.create(APIService::class.java)?.getUser()
            if(array?.isSuccessful == true) {

                withContext(Dispatchers.Main){
                    loadInfo(view,array.body() as UserResponse)
                }
            }
        }
    } */


}