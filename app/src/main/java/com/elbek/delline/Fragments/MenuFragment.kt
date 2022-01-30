package com.elbek.delline.Fragments

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.elbek.delline.LiveListener.NetworkLiveData
import com.elbek.delline.R
import com.elbek.delline.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
    lateinit var orderBtn: LinearLayout
    private var isCheck = 0
    lateinit var binding: FragmentMenuBinding
    lateinit var views: View

    @RequiresApi(Build.VERSION_CODES.N)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater)
        views = inflater.inflate(R.layout.fragment_menu, container, false)
        orderBtn = views.findViewById<LinearLayout>(R.id.zakazat)
        binding.zakazat.setOnClickListener {
            showDialog("Заказать")
        }
        binding.oplat.setOnClickListener {
            showBuyDialog("Платить")
        }
        binding.send.setOnClickListener {
            showSendDialog("Отправить")
        }
        binding.otchot.setOnClickListener {
            showReportsDialog("Отчёты")
        }

        return binding.root
    }

    private fun showDialog(title: String) {
        var listOn: List<String> = listOf("Магазин", "Toshkent", "Farg'ona", "Andijon", "Namangan")
        val dialog = Dialog(requireActivity(), R.style.CustomAlertDialog)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.shop_dialog)
        val spinner = dialog.findViewById<Spinner>(R.id.spinner_market)

        spinner.adapter = ArrayAdapter(
            requireContext(),
            R.layout.spinner_item,
            listOn.toList()
        )
        val body = dialog.findViewById(R.id.bodyName) as TextView
        body.text = title

        val yesBtn = dialog.findViewById(R.id.enter) as Button
        val noBtn = dialog.findViewById(R.id.exit) as Button
        yesBtn.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_brendsFragment)
            dialog.dismiss()

        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()

    }

    fun showBuyDialog(title: String) {
        var listOn: List<String> = listOf("Магазин", "Toshkent", "Farg'ona", "Andijon", "Namangan")
        val dialog = Dialog(requireActivity(), R.style.CustomAlertDialog)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.buy_dialog)
        val spinner = dialog.findViewById<Spinner>(R.id.spinner_market)

        spinner.adapter = ArrayAdapter(
            requireContext(),
            R.layout.spinner_item,
            listOn.toList()
        )
        val body = dialog.findViewById(R.id.bodyName) as TextView
        body.text = title

        val yesBtn = dialog.findViewById(R.id.enter) as Button
        val noBtn = dialog.findViewById(R.id.exit) as Button
        yesBtn.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_brendsFragment)
            dialog.dismiss()

        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    fun showSendDialog(title: String) {
        val dialog = Dialog(requireActivity(), R.style.CustomAlertDialog)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.send_dialog)
        val body = dialog.findViewById(R.id.bodyName) as TextView
        body.text = title

        val yesBtn = dialog.findViewById(R.id.enter) as Button
        val noBtn = dialog.findViewById(R.id.exit) as Button
        yesBtn.setOnClickListener {
            dialog.dismiss()

        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun showReportsDialog(title: String) {
        val dialog = Dialog(requireActivity(), R.style.CustomAlertDialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.reports_dialog)
        val body = dialog.findViewById(R.id.bodyName) as TextView
        val radioGroup = dialog.findViewById(R.id.radioGroup) as RadioGroup
        radioGroup.setOnCheckedChangeListener { p0, p1 ->
            val id = p0.checkedRadioButtonId
            when (id) {
                R.id.radioButton1 -> {
                    isCheck = 1
                }
                R.id.radioButton2 -> {
                    isCheck = 2
                }
                R.id.radioButton3 -> {
                    isCheck = 3
                }
            }
        }
        body.text = title

        val yesBtn = dialog.findViewById(R.id.enter) as Button
        val noBtn = dialog.findViewById(R.id.exit) as Button
        yesBtn.setOnClickListener {
            if (isCheck == 1) {
                showDailyReports("Ежедневные отчёты")
                dialog.dismiss()
            } else if (isCheck == 2) {
                showReconciliation("Клиентская Акт-Сверка")
                dialog.dismiss()
            } else if (isCheck == 3) {
                debitCreditDialog("Дебит кредит")
                dialog.dismiss()
            }

            isCheck = 0
        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    fun showDailyReports(title: String) {
        val dialog = Dialog(requireActivity(), R.style.CustomAlertDialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.daily_reports_dialog)
        val body = dialog.findViewById(R.id.bodyName) as TextView
        body.text = title
        val yesBtn = dialog.findViewById(R.id.enter) as Button
        val noBtn = dialog.findViewById(R.id.exit) as Button
        val radioGroup = dialog.findViewById(R.id.radioGroup) as RadioGroup
        radioGroup.setOnCheckedChangeListener { p0, p1 ->
            val id = p0.checkedRadioButtonId
            when (id) {
                R.id.radioButton1 -> {
                    isCheck = 1
                }
                R.id.radioButton2 -> {
                    isCheck = 2
                }
            }
        }
        yesBtn.setOnClickListener {
            if (isCheck == 1) {
                findNavController().navigate(R.id.action_menuFragment_to_reportsBrendFragment)
                dialog.dismiss()
            } else if (isCheck == 2) {
                findNavController().navigate(R.id.action_menuFragment_to_brendReportFragment)
                dialog.dismiss()
            }
            isCheck = 0
        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun showReconciliation(title: String) {
        var listOn: List<String> = listOf("Магазин", "Toshkent", "Farg'ona", "Andijon", "Namangan")
        val dialog = Dialog(requireActivity(), R.style.CustomAlertDialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.client_reconciliation)
        val spinner = dialog.findViewById<Spinner>(R.id.spinner_market)

        spinner.adapter = ArrayAdapter(
            requireContext(),
            R.layout.spinner_item,
            listOn.toList()
        )
        val body = dialog.findViewById(R.id.bodyName) as TextView
        body.text = title
        val startCalendar = dialog.findViewById(R.id.startCalendar) as TextView
        val endCalendar = dialog.findViewById(R.id.calendar_end) as TextView

        startCalendar.setOnClickListener {
            val dialog = DatePickerDialog(views.context, R.style.DialogTheme)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                dialog.datePicker.setOnDateChangedListener { datePicker, year, month, day ->
                    startCalendar.setText("$day/${month + 1}/$year")
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
        endCalendar.setOnClickListener {
            val dialog = DatePickerDialog(views.context, R.style.DialogTheme)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                dialog.datePicker.setOnDateChangedListener { datePicker, year, month, day ->
                    endCalendar.setText("$day/${month + 1}/$year")
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
        val yesBtn = dialog.findViewById(R.id.enter) as Button
        val noBtn = dialog.findViewById(R.id.exit) as Button
        yesBtn.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_brendReportFragment)
            dialog.dismiss()
        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun debitCreditDialog(title: String) {
        var listOn: List<String> = listOf("Магазин", "Toshkent", "Farg'ona", "Andijon", "Namangan")
        val dialog = Dialog(requireActivity(), R.style.CustomAlertDialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.debit_credit_dialog)
        val spinner = dialog.findViewById<Spinner>(R.id.spinner_market)

        spinner.adapter = ArrayAdapter(
            requireContext(),
            R.layout.spinner_item,
            listOn.toList()
        )
        val body = dialog.findViewById(R.id.bodyName) as TextView
        body.text = title
        val startCalendar = dialog.findViewById(R.id.startCalendar) as TextView
        val endCalendar = dialog.findViewById(R.id.calendar_end) as TextView

        startCalendar.setOnClickListener {
            val dialog = DatePickerDialog(views.context, R.style.DialogTheme)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                dialog.datePicker.setOnDateChangedListener { datePicker, year, month, day ->
                    startCalendar.setText("$day/${month + 1}/$year")
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
        endCalendar.setOnClickListener {
            val dialog = DatePickerDialog(views.context, R.style.DialogTheme)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                dialog.datePicker.setOnDateChangedListener { datePicker, year, month, day ->
                    endCalendar.setText("$day/${month + 1}/$year")
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
        val yesBtn = dialog.findViewById(R.id.enter) as Button
        val noBtn = dialog.findViewById(R.id.exit) as Button
        yesBtn.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_brendReportFragment)
            dialog.dismiss()
        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NetworkLiveData(view.context).observe(viewLifecycleOwner) { isOnline ->
            Toast.makeText(requireActivity(), "$isOnline", Toast.LENGTH_SHORT).show()
        }
    }
}
