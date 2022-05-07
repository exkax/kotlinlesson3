package kg.geektech.kotlinlesson3.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import kg.geektech.kotlinlesson3.R

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {

    lateinit var binding: VB
    protected lateinit var viewModel: VM

    private var _navController: NavController? = null

    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host) as NavHostFragment
        _navController = navHostFragment.navController
        initView()
        checkInternet()
        initViewModel()
        initListener()
    }

    fun getNavigation(): NavController? {
        return _navController
    }

    fun navigate(directions: NavDirections) {
        _navController?.navigate(directions)
    }

    fun navigate(directions: Int, data: Bundle? = null) {
        _navController?.navigate(directions, data)
    }

    fun currentDestinationId(): Int? {
        return _navController?.currentDestination?.id
    }

    open fun initView() {} // Инициализации вьюшек
    open fun initListener() {} // Прописываем все логику кликов
    open fun initViewModel() {}// Обрабатываем все обзерверы
    open fun checkInternet() {}
}