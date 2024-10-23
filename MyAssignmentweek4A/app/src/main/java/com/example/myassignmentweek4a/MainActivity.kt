package com.example.myassignmentweek4a

import android.content.res.Configuration
import android.graphics.drawable.GradientDrawable.Orientation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var appState : TextView
    private lateinit var orientation: TextView
    var orientationChanged = 0
    private lateinit var orientations : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appState = findViewById(R.id.appState)
        orientation =  findViewById(R.id.orientation)

        appstateChange("OnCreate")
        orientationChanged()


    }

    override fun onStart() {
        super.onStart()
        appstateChange("OnStart")
    }

    override fun onStop() {
        super.onStop()
        appstateChange("OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        appstateChange("OnDestroy")
    }

    override fun onPause() {
        super.onPause()
        appstateChange("OnPause")
    }

    override fun onResume() {
        super.onResume()
        appstateChange("OnResume")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        orientationChanged()
    }

    fun appstateChange(state:String){
        appState.text = "The Activity Lifecycle is at: $state"
    }

    fun orientationChanged(){
         if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
           orientations = "Landscape"
            orientationChanged + 1
        } else {
            orientations = "Portrait"
            orientationChanged + 1
        }

        orientation.text = "Orientation:$orientations\n" +
                "Orientation Changed:$orientationChanged "

    }
}