package com.example.cariaid.ui.onboarding

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.cariaid.R
import com.example.cariaid.databinding.ActivityOnBoardingBinding
import com.example.cariaid.ui.onboarding.adapter.OnBoardingAdapter
import com.example.cariaid.ui.onboarding.uiState.OnboardingModel

class OnBoardingActivity : AppCompatActivity() {
    val listView  = OnBoardingAdapter()
    lateinit var binding:ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpOnBoarding()
    }

    private fun setUpOnBoarding() {
        binding.list.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL,false)
        binding.list.adapter = listView
        val onBoardObject  = listOf(
            OnboardingModel(R.drawable.onbordgraphics1,"Discover Charities To Donate\n To in the UK"),
            OnboardingModel(R.drawable.onbordgraphics2,"Donate Items to These\n charities "),
            OnboardingModel(R.drawable.onbordgraphics3,"Donate to causes that\n matter to you")
        )
        listView.submitList(onBoardObject)
        PagerSnapHelper().attachToRecyclerView(binding.list)


        binding.list.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (listView.currentList){
                    Log.d("OnBoard","${listView.itemCount}")
                }
                if (recyclerView.canScrollHorizontally(RecyclerView.FOCUS_RIGHT)){

                }
            }
        })
    }


}