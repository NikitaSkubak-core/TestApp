package com.nikitosii.testapp.util.ext

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions

fun NavController.hasAction(navDirections: NavDirections) =
    currentDestination?.getAction(navDirections.actionId) != null

fun NavController.hasAction(actionId: Int) = currentDestination?.getAction(actionId) != null

fun AppCompatActivity.findParentNavController(@IdRes navHostFragmentResId: Int): NavHostController {
    val navHostFragment = supportFragmentManager.findFragmentById(navHostFragmentResId)
    return (NavHostFragment.findNavController(navHostFragment!!) as NavHostController)
}

fun NavController.safeNavigation(navDirections: NavDirections) {
    runCatching {
        val action = currentDestination?.getAction(navDirections.actionId)
        val options by lazy {
            navOptions {
                anim {
                    enter = androidx.navigation.ui.R.anim.nav_default_enter_anim
                    exit = androidx.navigation.ui.R.anim.nav_default_exit_anim
                    popEnter = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim
                    popExit = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim
                }
                launchSingleTop = action?.navOptions?.shouldLaunchSingleTop() ?: false
                popUpTo(action?.navOptions?.popUpTo ?: -1) { inclusive = action?.navOptions?.isPopUpToInclusive ?: false }
            }
        }

        if (hasAction(navDirections)) navigate(navDirections, options)
    }
}