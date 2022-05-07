package kg.geektech.kotlinlesson3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kg.geektech.kotlinlesson3.base.BaseFragment
import kg.geektech.kotlinlesson3.base.BaseViewModel
import kg.geektech.kotlinlesson3.data.model.Model
import kg.geektech.kotlinlesson3.databinding.FragmentSelectedBinding
import kg.geektech.kotlinlesson3.ui.adapters.PhotosAdapter

class SelectedFragment : BaseFragment<FragmentSelectedBinding, BaseViewModel>() {

    private val adapter = PhotosAdapter()
    private val viewModels: SharedViewModel by activityViewModels()

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentSelectedBinding {
        return FragmentSelectedBinding.inflate(inflater)
    }

    override fun initView() = with(binding) {

    }

    private fun setUpAdapter() {
        binding.recyclerView.adapter = adapter
    }

    override fun initViewModel() {
        viewModels.listState.observe(viewLifecycleOwner, Observer {
            setUpAdapter()
            adapter.setList(it as ArrayList<Model>)
        })
    }

}