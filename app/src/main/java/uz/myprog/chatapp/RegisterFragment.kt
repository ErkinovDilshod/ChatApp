package uz.myprog.chatapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import uz.myprog.chatapp.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    lateinit var auth: FirebaseAuth
    private lateinit var reference: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        auth = FirebaseAuth.getInstance()

        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.btnRegister.setOnClickListener {

            val txt_username: String = binding.edtRegisterUsername.text.toString()
            val txt_email: String = binding.edtRegisterEmail.text.toString()
            val txt_password: String = binding.edtRegisterPassword.text.toString()


            if (binding.edtRegisterUsername.text.isEmpty() || binding.edtRegisterEmail.text.isEmpty() || binding.edtRegisterPassword.text.isEmpty())
                Toast.makeText(
                    requireContext(),
                    "All fields must not be empty!!!",
                    Toast.LENGTH_SHORT
                ).show()
            else if (txt_password.length < 6)
                Toast.makeText(
                    requireContext(),
                    "Password length must be with at least 6 characters",
                    Toast.LENGTH_SHORT
                ).show()
            else {
                register(txt_username, txt_email, txt_password)
            }
        }

        return binding.root
    }

    private fun register(username: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(OnCompleteListener<AuthResult>() { it ->
                Log.i("TAG1111", "register: ${it.isSuccessful.toString()}")

                    if (it.isSuccessful) {
                        val firebaseUser: FirebaseUser? = auth.currentUser
                        assert(firebaseUser != null)
                        val userId: String = firebaseUser!!.uid

                        val reference = FirebaseDatabase.getInstance().reference.child(userId)

                        val hashMap: HashMap<String, String> = HashMap()
                        hashMap["id"] = userId
                        hashMap["username"] = username
                        hashMap["imageURL"] = "default"

                        reference.setValue(hashMap)
                            .addOnCompleteListener(OnCompleteListener<Void> { task ->


                                    if (it.isSuccessful) {
                                        Navigation.findNavController(binding.root)
                                            .navigate(R.id.action_registerFragment_to_mainFragment)
                                    }

                            })
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "You can't register both this email or password",
                            Toast.LENGTH_SHORT
                        ).show()
                    }


            })

    }


}