package kg.geektech.kotlinlesson3.ui.fragments

import android.view.LayoutInflater
import androidx.fragment.app.activityViewModels
import kg.geektech.kotlinlesson3.R
import kg.geektech.kotlinlesson3.base.BaseFragment
import kg.geektech.kotlinlesson3.base.BaseViewModel
import kg.geektech.kotlinlesson3.data.model.Model
import kg.geektech.kotlinlesson3.databinding.FragmentPhotosBinding
import kg.geektech.kotlinlesson3.ui.adapters.PhotosAdapter

class PhotosFragment : BaseFragment<FragmentPhotosBinding, BaseViewModel>() {

    private val adapter = PhotosAdapter()
    private val list = arrayListOf<Model>()
    private val viewModels: SharedViewModel by activityViewModels()

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentPhotosBinding {
        getNavigation()
        return FragmentPhotosBinding.inflate(inflater)
    }

    override fun initView() = with(binding) {
        list.apply {
            add(Model("https://sputnik.kg/img/07e6/02/0e/1062031197_218:0:781:563_1920x0_80_0_0_11d6898592fa153fd9f8dbe2a0ddf0b9.jpg"))
            add(Model("https://gamebomb.ru/files/galleries/001/4/47/393804.jpg"))
            add(Model("https://www.spieltimes.com/wp-content/uploads/2022/01/Morbius-Spiderman-No-Way-Home-Easter-Egg-You-Might-Have-Missed-in-the-Trailer.jpg"))
            add(Model("https://www.themarysue.com/wp-content/uploads/2022/03/morbius-spider-man-murderer-graffiti.jpg"))
            add(Model("https://www.cinemascomics.com/wp-content/uploads/2022/03/Spider-Man-Morbius-Jared-Leto.jpg"))
            add(Model("https://www.screengeek.net/wp-content/uploads/2020/01/Morbius-Spider-Man-Homecoming.jpg"))
        }
        setUpAdapter()
        adapter.setList(list)
    }

    private fun setUpAdapter() {
        binding.recyclerView.adapter = adapter
    }

    override fun initListener() {
        binding.btnSend.setOnClickListener {
            viewModels.putPicture(adapter.selectedList)
            navigate(R.id.action_galleryFragment_to_selectFragment)
        }
    }

}


