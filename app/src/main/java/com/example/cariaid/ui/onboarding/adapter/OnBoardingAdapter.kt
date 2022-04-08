package com.example.cariaid.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cariaid.databinding.OnboardingItemBinding
import com.example.cariaid.ui.onboarding.uiState.OnboardingModel


class OnBoardingAdapter: ListAdapter<OnboardingModel, OnBoardingAdapter.OnBoardingViewHolder>(OnBoardDiffCallBack){

    class OnBoardingViewHolder(private val binding:OnboardingItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(model: OnboardingModel){
          with(binding){
              onboardImage.setImageResource(model.image)
              onBoardDesc.text = model.description
          }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
       return OnBoardingViewHolder(OnboardingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
       val data = getItem(position)
        holder.bind(data)
    }

    object OnBoardDiffCallBack :DiffUtil.ItemCallback<OnboardingModel>(){
        override fun areItemsTheSame(oldItem: OnboardingModel, newItem: OnboardingModel): Boolean {
          return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: OnboardingModel,
            newItem: OnboardingModel
        ): Boolean {
            return oldItem.description == newItem.description
        }

    }

}