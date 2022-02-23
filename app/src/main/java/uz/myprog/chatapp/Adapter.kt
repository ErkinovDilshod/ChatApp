package uz.myprog.chatapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val data: ArrayList<TextMessage>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
   class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemText: TextView = itemView.findViewById(R.id.tv_sender_message)
        var itemTime: TextView = itemView.findViewById(R.id.tv_sender_message_time)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_chat_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemText.text = data[position].textSender
        holder.itemTime.text = data[position].textTime
    }

    override fun getItemCount(): Int {
        return data.size
    }
}