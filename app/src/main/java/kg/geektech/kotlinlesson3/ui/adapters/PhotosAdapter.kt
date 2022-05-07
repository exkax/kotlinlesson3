package kg.geektech.kotlinlesson3.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.kotlinlesson3.common.loadWithGlide
import kg.geektech.kotlinlesson3.data.model.Model
import kg.geektech.kotlinlesson3.databinding.ItemSelectedBinding

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    private lateinit var binding: ItemSelectedBinding
    private var list = arrayListOf<Model>()
    val selectedList = arrayListOf<Model>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        binding = ItemSelectedBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(list: ArrayList<Model>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class PhotoViewHolder(private val binding: ItemSelectedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Model) {
            model.image?.let { binding.ivImage.loadWithGlide(it) }
            binding.root.setOnClickListener {
                if (binding.selectionImage.isInvisible) {
                    binding.selectionImage.isVisible = true
                    selectionImage(model.image)
                } else {
                    binding.selectionImage.isInvisible = true
                    isSelectionImage(model.image)
                }
            }
        }

        private fun isSelectionImage(ivImage: String?) {
            selectedList.remove(Model(ivImage))
        }

        private fun selectionImage(ivImage: String?) {
            selectedList.add(Model(ivImage))
        }

    }
}