package com.paeparo.paeparo_mobile.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.paeparo.paeparo_mobile.R
import com.paeparo.paeparo_mobile.databinding.ActivityMainBinding
import com.paeparo.paeparo_mobile.fragment.CommunityFragment
import com.paeparo.paeparo_mobile.fragment.MyHomeFragment
import com.paeparo.paeparo_mobile.fragment.TripFragment

class MainActivity : AppCompatActivity(), OnPostFragmentInteractionListener {
    private lateinit var binding: ActivityMainBinding
    private var currentTabId: Int = -1
    private val communityFragment = CommunityFragment()
    private val tripFragment = TripFragment()
    private val myHomeFragment = MyHomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fl_main_view, tripFragment)
            .commit()

        binding.bvMainBottomNavigation.setOnItemSelectedListener { item ->
            if (item.itemId != currentTabId) {
                val ft = supportFragmentManager.beginTransaction()
                when (item.itemId) {
                    R.id.community_fragment -> {
                        ft.replace(R.id.fl_main_view, communityFragment).commit()
                    }

                    R.id.trip_fragment -> {
                        ft.replace(R.id.fl_main_view, tripFragment).commit()
                    }

                    R.id.mypage_fragment -> {
                        ft.replace(R.id.fl_main_view, myHomeFragment).commit()
                    }
                }
                currentTabId = item.itemId
                true
            } else {
                false
            }
        }
        binding.bvMainBottomNavigation.selectedItemId = R.id.trip_fragment
    }

    override fun onPostFragmentDisplayed() {
        binding.bvMainBottomNavigation.visibility = View.GONE
        val layoutParams = binding.flMainView.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        binding.flMainView.layoutParams = layoutParams
    }

    override fun onPostFragmentDismissed() {
        binding.bvMainBottomNavigation.visibility = View.VISIBLE
        val layoutParams = binding.flMainView.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.bottomToTop = binding.bvMainBottomNavigation.id
        binding.flMainView.layoutParams = layoutParams
    }


//    // 추후 삭제할께요 ㅎ;
//    private fun testRetrofit(){
//        val service = KakaoRetroFit.kakaoKeyWordService
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = service.get(BuildConfig.KAKAO_API_KEY,"카카오프렌즈")
//
//            withContext(Dispatchers.Main){
//                if(response.isSuccessful){
//                                    }
//                else {
//                    Timber.d(response.code().toString()+"\n\n\n context : "+response.toString())
//                }
//            }
//        }
}

interface OnPostFragmentInteractionListener {
    fun onPostFragmentDisplayed()
    fun onPostFragmentDismissed()
}