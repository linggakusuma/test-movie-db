package com.lingga.testmoviedb

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.lingga.testmoviedb.databinding.ActivityMainBinding
import com.lingga.testmoviedb.ui.base.BaseActivity
import com.lingga.testmoviedb.ui.category.CategoryBottomSheetFragment
import com.lingga.testmoviedb.ui.category.CategoryItemClickListener
import com.lingga.testmoviedb.utils.Constant
import com.lingga.testmoviedb.utils.ext.hide
import com.lingga.testmoviedb.utils.ext.show

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main),
    CategoryItemClickListener {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    private val navGraph by lazy { navController.navInflater.inflate(R.navigation.navigation) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBottomSheet()
        setUpNavigation()
        hideCategory()
    }

    private fun setBottomSheet() {
        val bottomSheet = CategoryBottomSheetFragment()
        binding.buttonCategory.setOnClickListener {
            supportFragmentManager.let { supportManager ->
                bottomSheet.show(supportManager, bottomSheet.tag)
            }
        }
    }

    private fun setUpNavigation() {
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.movieUpcomingFragment,
                R.id.movieTopRatedFragment,
                R.id.movieNowPlayingFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun hideCategory() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.buttonCategory.apply {
                when (destination.id) {
                    R.id.homeFragment -> show()
                    R.id.movieUpcomingFragment -> show()
                    R.id.movieNowPlayingFragment -> show()
                    R.id.movieTopRatedFragment -> show()
                    R.id.movieDetailFragment -> hide()
                    R.id.favoriteFragment -> hide()
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean =
        navController.navigateUp() || super.onSupportNavigateUp()

    override fun onItemClick(item: String) {
        when (item) {
            Constant.POPULAR -> {
                navGraph.startDestination = R.id.homeFragment
                navController.graph = navGraph
            }
            Constant.UPCOMING -> {
                navGraph.startDestination = R.id.movieUpcomingFragment
                navController.graph = navGraph
            }
            Constant.TOP_RATED -> {
                navGraph.startDestination = R.id.movieTopRatedFragment
                navController.graph = navGraph
            }
            Constant.NOW_PLAYING -> {
                navGraph.startDestination = R.id.movieNowPlayingFragment
                navController.graph = navGraph
            }
        }
    }
}