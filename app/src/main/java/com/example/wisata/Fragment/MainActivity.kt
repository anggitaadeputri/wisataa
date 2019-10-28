package com.example.wisata.Fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.wisata.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val fragment: Fragment

            when (item.itemId) {
                R.id.navigation_laut -> {
                    fragment = LautFragment ()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.javaClass.simpleName)
                        .commit();
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_darat -> {

                    fragment = DaratFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.javaClass.simpleName)
                        .commit();
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            navigation.selectedItemId = R.id.navigation_laut
        }
    }

}