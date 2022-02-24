package uz.myprog.chatapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import uz.myprog.chatapp.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    lateinit var auth:FirebaseAuth
    private lateinit var reference:DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



        val view = inflater.inflate(R.layout.fragment_register, container, false)
        binding = FragmentRegisterBinding.inflate(inflater, container,  false)
        binding.btnRegister.setOnClickListener{
            if (binding.edtRegisterUsername.text.isEmpty() || binding.edtRegisterEmail.text.isEmpty() || binding.edtRegisterPassword.text.isEmpty())
                Toast.makeText(
                    requireContext(),
                    "All fields must not be empty!!!",
                    Toast.LENGTH_SHORT
                ).show()
            else{
                Navigation.findNavController(binding.root).navigate(R.id.action_registerFragment_to_mainFragment)
            }
        }

        return binding.root
    }

    private fun register( username:String, email:String, password:String){

    }

}