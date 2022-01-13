package com.example.login

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.login.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [loginFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class loginFragment2 : Fragment() {
    private var _binding: loginFragment2? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val sharedPrefrencesHelper: SharedPrefrencesHelper? = null
    var firstname: TextView? = null
    var lastname:TextView? = null
    var usernamee:TextView? = null
    var email:TextView? = null
    var logoutBtn: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        val sharedPrefrencesHelper: SharedPrefrencesHelper = SharedPrefrencesHelper(requireContext())
        var txtView_firstname: TextView? = binding.firstname
        var txtView_lastname: TextView? = binding.lastname
        var txtView_usernamee: TextView? = binding.usernamee
        var txtView_email: TextView? = binding.email
        var btn_logoutBtn: Button? = binding.logoutBtn

        val username:String? = sharedPrefrencesHelper.username;
        if (username == null || username.isEmpty()) {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment) //Here we navigate to the Login Fragment
//            startActivity(new Intent(this, LoginActivity.class));
//            finish();
        }
        txtView_firstname!!.text = sharedPrefrencesHelper.firstname
        txtView_lastname!!.text = sharedPrefrencesHelper.lastname
        txtView_usernamee!!.text = sharedPrefrencesHelper.username
        txtView_email!!.text = sharedPrefrencesHelper.email
        logoutBtn!!.setOnClickListener {
            sharedPrefrencesHelper.setFirstname(null)
            sharedPrefrencesHelper.setLastname(null)
            sharedPrefrencesHelper.setUsername(null)
            sharedPrefrencesHelper.setEmail(null)
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }
        logoutBtn!!.setOnClickListener(object : OnClickListener() {
            fun onClick(view: View?) {
                sharedPrefrencesHelper.setFirstname(null)
                sharedPrefrencesHelper.setLastname(null)
                sharedPrefrencesHelper.setUsername(null)
                sharedPrefrencesHelper.setEmail(null)
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                finish()
            }
        })
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login2, container, false)
        _binding = loginFragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment loginFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            loginFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}