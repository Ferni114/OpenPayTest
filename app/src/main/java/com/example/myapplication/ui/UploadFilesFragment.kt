package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.myapplication.utils.AlertClass
import com.example.myapplication.R
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

/**
 * A simple [Fragment] subclass.
 * Use the [UploadFilesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UploadFilesFragment: Fragment() {    // TODO: Rename and change types of parameters
    lateinit var storageRef: StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var fs=FirebaseStorage.getInstance()
        storageRef=fs.reference
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.uploadfiles_fragment, container, false)
        var button=view.findViewById<Button>(R.id.open_dialog)
        button.setOnClickListener{
            launchGallery()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun launchGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK)
        galleryIntent.type = "image/*"
        imagePickerActivityResult.launch(galleryIntent)
    }

    private var imagePickerActivityResult: ActivityResultLauncher<Intent> =
    // lambda expression to receive a result back, here we
        // receive single item(photo) on selection
        registerForActivityResult( ActivityResultContracts.StartActivityForResult()) { result ->
            if (result != null) {
                // getting URI of selected Image
                val imageUri: Uri? = result.data?.data

                val sd = getFileName(requireContext(), imageUri!!)

                val uploadTask = storageRef.child("pictures/$sd").putFile(imageUri)

                uploadTask.addOnSuccessListener {
                    // using glide library to display the image
                    AlertClass.alert(
                        requireContext(),
                        "Correcto",
                        "Se ha subido el archivo correctamente"
                    )
                    storageRef.child("pictures/$sd").downloadUrl.addOnSuccessListener {

                    }.addOnFailureListener {
                        AlertClass.alert(requireContext(), "Error", "Error al descargar la imagen")
                    }
                }.addOnFailureListener {
                    AlertClass.alert(requireContext(), "Error", "Error al Subir la imagen")
                }
            }
        }

    @SuppressLint("Range")
    private fun getFileName(context: Context, uri: Uri): String? {
        if (uri.scheme == "content") {
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            cursor.use {
                if (cursor != null) {
                    if(cursor.moveToFirst()) {
                        return cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                    }
                }
            }
        }
        return uri.path?.lastIndexOf('/')?.let { uri.path?.substring(it) }
    }


}