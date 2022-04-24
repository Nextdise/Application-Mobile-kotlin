package com.example.myapplication
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_idee.view.*




class IdeeAdapter(
    private val idees: MutableList<Idee>

) : RecyclerView.Adapter<IdeeAdapter.IdeeViewHolder>(){
    class IdeeViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdeeViewHolder {
        return IdeeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_idee,
                parent,
                false
            )
        )
    }
    fun addIdee(idee : Idee){
        idees.add(idee)
        notifyItemChanged(idees.size - 1)

    }
    fun deleteDoneIdee(){
        idees.removeAll{ idee ->
            idee.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvIdeeTitle: TextView, isChecked: Boolean) {
        if(isChecked) {
            tvIdeeTitle.paintFlags = tvIdeeTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvIdeeTitle.paintFlags = tvIdeeTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }


    override fun onBindViewHolder(holder: IdeeViewHolder, position: Int) {
        val curIdee = idees[position]
        holder.itemView.apply {
            tvIdeeTitle.text = curIdee.title
            cbDone.isChecked = curIdee.isChecked
            toggleStrikeThrough(tvIdeeTitle ,curIdee.isChecked)
            cbDone.setOnCheckedChangeListener {_,isChecked ->
                toggleStrikeThrough(tvIdeeTitle, isChecked)
                curIdee.isChecked =!curIdee.isChecked
            }
        }

    }

    override fun getItemCount(): Int {
        return idees.size

    }
}