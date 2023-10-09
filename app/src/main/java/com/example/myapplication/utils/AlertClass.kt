package com.example.myapplication.utils

import android.app.AlertDialog
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService



class AlertClass {
    companion object {

        fun alert(context: Context, title: String, body: String) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(title)
            builder.setMessage(body)
            builder.setPositiveButton(android.R.string.yes) { dialog, which ->

            }
            builder.show()
        }
    }
}
