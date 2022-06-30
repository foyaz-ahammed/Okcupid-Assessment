package com.okcupid.assessment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.okcupid.assessment.R
import com.okcupid.assessment.adapters.TabsViewpagerAdapter
import com.okcupid.assessment.databinding.ActivityMainBinding

/**
 * Activity for the main page
 */
class MainActivity : AppCompatActivity() {

    companion object {
        private val TAB_TITLES = listOf(R.string.special_blend, R.string.match_percent)
    }

    // Binding variable
    private lateinit var binding: ActivityMainBinding

    // Viewpager adapter attached to TabLayout
    private val adapter = TabsViewpagerAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup TabLayout and Viewpager
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tabs, binding.viewpager) { tab: TabLayout.Tab, position: Int ->
            tab.text = getString(TAB_TITLES[position])
        }.attach()

        binding.viewpager.isUserInputEnabled = false
    }
}