package com.example.splashscreen

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.google.android.material.navigation.NavigationView
import java.util.*


class Home_Screen : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var recyclerView: RecyclerView
    private lateinit var companylist:ArrayList<company>
    private lateinit var companyAdapter: companyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val actionBar: ActionBar?
        actionBar = supportActionBar

        var admission=findViewById<ImageView>(R.id.box4)
        admission.setOnClickListener {
            val url="https://admission.abes.ac.in/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        val colorDrawable = ColorDrawable(Color.parseColor("#FF552B28"))

        // Set BackgroundDrawable

        // Set BackgroundDrawable
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(colorDrawable)
        }


        val drawerLayout:DrawerLayout=findViewById(R.id.drawerLayout)
        val navView:NavigationView=findViewById(R.id.nav_view)

        toggle= ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.AbesBusinessSchool->Toast.makeText(applicationContext,"clicked abes ",Toast.LENGTH_SHORT).show()
                R.id.registration->Toast.makeText(applicationContext,"clicked registration ",Toast.LENGTH_SHORT).show()
                R.id.events->Toast.makeText(applicationContext,"clicked events ",Toast.LENGTH_SHORT).show()
                R.id.admissions->Toast.makeText(applicationContext,"clicked admissions ",Toast.LENGTH_SHORT).show()
                R.id.placement->Toast.makeText(applicationContext,"clicked placement ",Toast.LENGTH_SHORT).show()
                R.id.aboutus->Toast.makeText(applicationContext,"clicked about us ",Toast.LENGTH_SHORT).show()
                R.id.logout->Toast.makeText(applicationContext,"clicked log out ",Toast.LENGTH_SHORT).show()
                R.id.RateUs->Toast.makeText(applicationContext,"clicked rate us ",Toast.LENGTH_SHORT).show()
                R.id.share->share()
            }
            true

        }
        init()
//        val btnopendrawer:ImageView=findViewById(R.id.btnopendrawer)
//        btnopendrawer.setOnClickListener{
//            drawerLayout.openDrawer(findViewById(R.id.nav_view))
//        }

        val c = Calendar.getInstance()

        var text=""
        val hour = c.get(Calendar.HOUR_OF_DAY)

        val time=findViewById<TextView>(R.id.gd)
        if(hour<12)
            text="Good Morning !!"
        else if(hour<=18)
            text="Good Afternoon !!"
        else
            text="Good Evening !!"
        time.text=text


    }

    private fun share() {
        val intent = Intent(Intent.ACTION_SEND)
        val url = "https://qithub.com/ashu2125/AbesEC"
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "Hey, Checkout this cool app $url")
        val chooser = Intent.createChooser(intent,  "Share this app using ...")
        startActivity(chooser)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    private  fun init() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val snapHelper : SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        companylist = ArrayList()
        addDataToList()

        companyAdapter= companyAdapter(companylist)
        recyclerView.adapter=companyAdapter
    }



    private fun addDataToList() {

        companylist.add(company(R.drawable.amazon))
        companylist.add(company(R.drawable.cisco))
        companylist.add(company(R.drawable.cognizants))
        companylist.add(company(R.drawable.microsoft))
        companylist.add(company(R.drawable.wipro))
        companylist.add(company(R.drawable.adobe))


    }

}
//val drawerLayout=findViewById<DrawerLayout>(R.id.drawerLayout)
//val navView=findViewById<NavigationView>(R.id.nav_view)
//
//toggle= ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
//drawerLayout.addDrawerListener(toggle)
//toggle.syncState()
//
//supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//navView.setNavigationItemSelectedListener {
//
//    when(it.itemId){
//
//        R.id.viewRoom -> startActivity(Intent(applicationContext,RoomType::class.java))
//        R.id.privacy -> startActivity(Intent(applicationContext, termsNcondition::class.java))
//        R.id.share -> share()
//        R.id.rate -> Toast.makeText(applicationContext, "rate", Toast.LENGTH_SHORT).show()
//        R.id.logout -> Toast.makeText(applicationContext,"logout",Toast.LENGTH_SHORT).show()
//
//    }
//    true
//}   //y drawer k code
