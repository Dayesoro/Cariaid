package com.example.cariaid.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.cariaid.data.dataStore.DataStoreImpl
import com.example.cariaid.ui.dashboard.DashBoardActivity
import com.example.cariaid.ui.onboarding.OnBoardingActivity
import com.example.cariaid.utils.Constant.USER_ONBOARDING
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {
 @Inject
 lateinit var dataStoreImpl: DataStoreImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigate()

    }

    private fun navigate(){
        lifecycleScope.launch{
            val isDataStoreEmpty = dataStoreImpl.getValue(USER_ONBOARDING)
            if(isDataStoreEmpty.isNullOrEmpty()){
                startActivity(Intent(applicationContext,DashBoardActivity::class.java))
            }else{
                startActivity(Intent(applicationContext,OnBoardingActivity::class.java))
            }
        }
    }

}