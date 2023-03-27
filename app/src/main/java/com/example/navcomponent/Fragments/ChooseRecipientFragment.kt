package com.example.navcomponent.Fragments

import com.example.navcomponent.R
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navcomponent.databinding.FragmentChooseRecipientBinding

class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    private var navController: NavController? = null
    private var binding: FragmentChooseRecipientBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            FragmentChooseRecipientBinding.inflate(LayoutInflater.from(context), container, false)

        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding?.nextBtn?.setOnClickListener(this)
        binding?.cancelBtn?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.next_btn -> {
                if (!TextUtils.isEmpty(binding?.inputRecipient?.text.toString())) {
                    val bundle = bundleOf("recipient" to binding?.inputRecipient?.text.toString())
                    navController!!.navigate(
                        R.id.action_chooseRecipientFragment_to_specifyAmountFragment,
                        bundle
                    )
                } else {
                    Toast.makeText(activity, "Enter a name", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.cancel_btn -> requireActivity().onBackPressed()
        }
    }
}