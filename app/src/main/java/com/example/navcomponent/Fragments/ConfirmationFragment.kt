package com.example.navcomponent.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navcomponent.DataClasses.Money
import com.example.navcomponent.databinding.FragmentConfirmationBinding


class ConfirmationFragment : Fragment() {

    private var recipient: String? = null
    private var money: Money? = null
    private var binding: FragmentConfirmationBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = requireArguments().getString("recipient")
        money = requireArguments().getParcelable("amount")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            FragmentConfirmationBinding.inflate(LayoutInflater.from(context), container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val amount = money!!.amount
        val confirmationMessage = "You have sent $amount to $recipient"
        binding?.confirmationMessage?.text = confirmationMessage
    }


}