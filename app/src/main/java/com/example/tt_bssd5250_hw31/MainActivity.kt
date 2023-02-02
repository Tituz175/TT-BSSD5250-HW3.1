package com.example.tt_bssd5250_hw31

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragmentLinearLayout = LinearLayoutCompat(this).apply {
            id = View.generateViewId()
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        val relativeLayout = RelativeLayout(this).apply {
            setBackgroundColor(Color.LTGRAY)
            addView(fragmentLinearLayout)
        }

        setContentView(relativeLayout)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(fragmentLinearLayout.id, NoteFragment.newInstance(), null)
        }
    }
}