package com.example.app3.basic_menu

import android.R
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.app3.databinding.FragmentTrainGameBinding
import com.example.app3.games.Field
import com.example.app3.games.Point


class Train_game : Fragment() {
    lateinit var binding: FragmentTrainGameBinding
    lateinit var Center : Point
    private val dataPlayMenu:DataPlayMenu by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentTrainGameBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
               Center = Point(binding.x.scrollX/2, binding.lnFTrain.height / 2)
               var previewFields = Field(binding.fieldTrain, 1, Center.x, Center.y, 40)
    }




    companion object {
        @JvmStatic
        fun newInstance() = Train_game()
    }
}