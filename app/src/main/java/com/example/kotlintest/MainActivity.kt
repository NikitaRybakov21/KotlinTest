package com.example.kotlintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() , InterfaceKotlin {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, FragmentKotlin(), null).commit()

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setOnMenuItemClickListener { item ->
            if(item.itemId == R.id.options1){
                Toast.makeText(this,"Options 1",Toast.LENGTH_SHORT).show()
            }
            if(item.itemId == R.id.options2){
                Toast.makeText(this,"Options 2",Toast.LENGTH_SHORT).show()
            }
            false
        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer)

        val toggle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigation = findViewById<NavigationView>(R.id.navigation)
        navigation.setNavigationItemSelectedListener{ item ->
            if(item.itemId == R.id.optionsNav1){
                Toast.makeText(this,"Nav options 1",Toast.LENGTH_SHORT).show()
                drawer.closeDrawer(GravityCompat.START)

                supportFragmentManager.beginTransaction().replace(R.id.container, FragmentKotlin(), null).commit()
            }
            if(item.itemId == R.id.optionsNav2){
                Toast.makeText(this,"Nav options 2",Toast.LENGTH_SHORT).show()
                drawer.closeDrawer(GravityCompat.START)

                val intent = Intent(this,NewActivity::class.java)
                startActivity(intent)
            }
            false
        }
        action()
    }

    override fun action() {
        val b = Obj.sin(1.0)
        val p = Obj.pi
        println(b + p)

        val data = Data("data4445")
        val dataCopy = data.copy()

        data.name = "new Data3333"

        println(data.name)
        println(dataCopy.name)
    }

}