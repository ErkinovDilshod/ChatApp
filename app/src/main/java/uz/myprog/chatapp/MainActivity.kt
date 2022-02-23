package uz.myprog.chatapp

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setLightStatusBar(View(this), this)
    }

//    private fun setLightStatusBar(view: View, activity: Activity) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            var flags = view.systemUiVisibility
//            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//            view.systemUiVisibility = flags
//            activity.window.statusBarColor = Color.WHITE
//        }
//    }

    private fun setLightStatusBar(view: View, activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var flags = view.systemUiVisibility
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            view.systemUiVisibility = flags
            //activity.window.statusBarColor = Color.WHITE
        }
    }
}