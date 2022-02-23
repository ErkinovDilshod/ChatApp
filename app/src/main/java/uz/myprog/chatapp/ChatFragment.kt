package uz.myprog.chatapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import uz.myprog.chatapp.databinding.FragmentChatBinding
import java.text.SimpleDateFormat
import java.util.*


class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding

     private var data:ArrayList<TextMessage> = arrayListOf()
     //var recyclerView: RecyclerView = View(requireContext()).findViewById(R.id.chat_recyclerView)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentChatBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        val sendButton:ImageView = binding.btnSendMessage
        val chatText:EditText = binding.chatEditText
        //val senderMessage:TextView = view.findViewById(R.id.tv_sender_message)

     //   recyclerView = chat_recyclerView

        sendButton.setOnClickListener{

            if (chatText.text.isEmpty()){
                Toast.makeText(requireContext(), "This place must not empty!!!", Toast.LENGTH_SHORT)
                    .show()
            }
            else {
                val currentTime: String =
                    SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
                val itemModel = TextMessage(chatText.text.toString(), currentTime)

                val llm = LinearLayoutManager(requireContext())
                llm.stackFromEnd = true     // items gravity sticks to bottom
                llm.reverseLayout = false
                binding.chatRecyclerView.layoutManager = llm
                data.add(itemModel)
                val adapter = Adapter(data)
                binding.chatRecyclerView.adapter = adapter
                binding.chatEditText.text.clear()
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding
    }

}