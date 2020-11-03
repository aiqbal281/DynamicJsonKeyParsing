package com.aadil.assingment

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.aadil.assingment.ui.summary.SummaryFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        statusBarBg()

        supportFragmentManager.beginTransaction().replace(
            R.id.container,
            SummaryFragment()
        ).addToBackStack("SCORCHERS vs HEAT").commit()

        supportFragmentManager.addOnBackStackChangedListener {
            txtToolBar.text =
                    supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1)
                        .name
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(this)


    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun statusBarBg() {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        window.setBackgroundDrawableResource(R.drawable.nav_bg)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_summary -> supportFragmentManager.beginTransaction().replace(
                R.id.container,
                SummaryFragment()
            ).addToBackStack("SCORCHERS vs HEAT").commit()
            R.id.action_scorecard ->Toast.makeText(this,"scorecard",Toast.LENGTH_SHORT).show()
            R.id.action_commentary ->Toast.makeText(this,"commentary",Toast.LENGTH_SHORT).show()
            R.id.action_info ->Toast.makeText(this,"Info",Toast.LENGTH_SHORT).show()
        }
        return true
    }

}
