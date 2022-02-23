package uz.myprog.chatapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorDestinationBuilder

class MainFragment : Fragment() {

    private lateinit var button: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)

        button = view.findViewById(R.id.btn_chat)

        button.setOnClickListener{

            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_chatFragment)
        }

        return view
    }


}