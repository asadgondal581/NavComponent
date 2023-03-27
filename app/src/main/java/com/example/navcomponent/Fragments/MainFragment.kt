package com.example.navcomponent.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navcomponent.R
import com.example.navcomponent.databinding.FragmentMainBinding

class MainFragment : Fragment(), View.OnClickListener {

    private var navController: NavController? = null
    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(LayoutInflater.from(context), container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding?.viewTransactionsBtn?.setOnClickListener(this)
        binding?.sendMoneyBtn?.setOnClickListener(this)
        binding?.viewBalanceBtn?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.view_transactions_btn -> navController!!.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
            R.id.send_money_btn -> navController!!.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
            R.id.view_balance_btn -> navController!!.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }
    }


}