package uz.myprog.chatapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_chat.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class ChatFragment : Fragment() {

     var data:ArrayList<TextMessage> = arrayListOf()
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        val sendButton:ImageView = view.findViewById(R.id.btn_send_message)
        val chatText:EditText = view.findViewById(R.id.chat_edit_text)
        //val senderMessage:TextView = view.findViewById(R.id.tv_sender_message)

     //   recyclerView = chat_recyclerView

        sendButton.setOnClickListener{
            val currentTime: String = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
            val itemModel = TextMessage(chatText.text.toString(), currentTime)

            chat_recyclerView.layoutManager = LinearLayoutManager(requireContext())
            data.add(itemModel)
            val adapter = Adapter(data)
            chat_recyclerView.adapter = adapter

        }
        return view
    }



}