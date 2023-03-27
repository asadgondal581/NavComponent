package com.example.navcomponent.Fragments


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navcomponent.DataClasses.Money
import java.math.BigDecimal
import com.example.navcomponent.R
import com.example.navcomponent.databinding.FragmentSpecifyAmountBinding

class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    private var navController: NavController? = null
    private var recipient: String? = null
    private var binding: FragmentSpecifyAmountBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // in here you can do logic when backPress is clicked
            }
        })
        recipient = requireArguments().getString("recipient")!!




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentSpecifyAmountBinding.inflate(LayoutInflater.from(context), container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding?.sendBtn?.setOnClickListener(this)
        binding?.cancelBtn?.setOnClickListener(this)
        val message = "Sending money to $recipient"
        binding?.recipient?.text = message
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.send_btn -> {
                if (!TextUtils.isEmpty(binding?.inputAmount?.text.toString())) {

                    val amount = Money(BigDecimal(binding?.inputAmount?.text.toString()))
                    val bundle = bundleOf(
                        "recipient" to recipient,
                        "amount" to amount
                    )
                    navController!!.navigate(
                        R.id.action_specifyAmountFragment_to_confirmationFragment,
                        bundle
                    )
                } else {
                    Toast.makeText(activity, "Enter an amount", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.cancel_btn -> {
                onDetach()
            Toast.makeText(context,"Cancel Button Clicked",Toast.LENGTH_SHORT).show()
                //requireActivity().onBackPressed()
            //
             }
        }
    }

    override fun onDetach() {
        super.onDetach()
    }


}