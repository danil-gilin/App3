package com.example.app3.basic_menu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.app3.games.Games
import com.example.app3.R
import com.example.app3.databinding.PersonalAccount2Binding
import com.example.app3.databinding.PersonalAccountBinding
import kotlin.random.Random as Random

class PersonalAccount : AppCompatActivity() {
    private lateinit var bindingclass: PersonalAccount2Binding
    private val dataPlayModel:DataPlayMenu by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingclass = PersonalAccount2Binding.inflate(layoutInflater)
        setContentView(bindingclass.root)
        val avatar = intent.getIntExtra("Img", 0)!!
        val name = intent.getStringExtra("Name")!!

        bindingclass.viewPager2.adapter = ViewPagerFragmentStateAdapter(supportFragmentManager,this.lifecycle)



        //openFrag(Achievements.newInstance(),bindingclass.menuHolder.id)
        //openFrag(PlayMenu.newInstance(),bindingclass.menuHolder.id)
        dataPlayModel.imId.value=avatar
        dataPlayModel.nameP.value=name
    }

    private fun openFrag(f: Fragment,idHolder:Int){
        supportFragmentManager.beginTransaction().replace(idHolder,f).commit()
    }


}

