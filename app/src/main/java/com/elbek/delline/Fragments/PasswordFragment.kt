package com.elbek.delline.Fragments

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.elbek.delline.R
import org.w3c.dom.Text

class PasswordFragment : Fragment() {
    lateinit var one: TextView
    lateinit var two: TextView
    lateinit var tree: TextView
    lateinit var four: TextView
    lateinit var five: TextView
    lateinit var six: TextView
    lateinit var seven: TextView
    lateinit var eit: TextView
    lateinit var nine: TextView
    lateinit var zero: TextView
    lateinit var changePassword: ImageView
    lateinit var deleteNumber: ImageView
    lateinit var oneIndecator: ImageView
    lateinit var twoIndecator: ImageView
    lateinit var treeIndecator: ImageView
    lateinit var fourIndecator: ImageView
    lateinit var passwordList: ArrayList<String>
    var numberCheck = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val views = inflater.inflate(R.layout.fragment_password, container, false)
        passwordList = ArrayList()
        oneIndecator = views.findViewById(R.id.oneIndecator)
        twoIndecator = views.findViewById(R.id.twoIndecator)
        treeIndecator = views.findViewById(R.id.treeIndecator)
        fourIndecator = views.findViewById(R.id.fourIndecator)
        one = views.findViewById(R.id.one)
        two = views.findViewById(R.id.two)
        tree = views.findViewById(R.id.tree)
        four = views.findViewById(R.id.four)
        five = views.findViewById(R.id.five)
        six = views.findViewById(R.id.six)
        seven = views.findViewById(R.id.seven)
        eit = views.findViewById(R.id.eit)
        nine = views.findViewById(R.id.nine)
        zero = views.findViewById(R.id.zero)
        changePassword = views.findViewById(R.id.changePassword)
        deleteNumber = views.findViewById(R.id.deleteNumber)
        one.setOnClickListener {
            checkPassword("1")
        }
        two.setOnClickListener {
            checkPassword("2")
        }
        tree.setOnClickListener {
            checkPassword("3")
        }
        four.setOnClickListener {
            checkPassword("4")
        }
        five.setOnClickListener {
            checkPassword("5")
        }
        six.setOnClickListener {
            checkPassword("6")
        }
        seven.setOnClickListener {
            checkPassword("7")
        }
        eit.setOnClickListener {
            checkPassword("8")
        }
        nine.setOnClickListener {
            checkPassword("9")
        }
        zero.setOnClickListener {
            checkPassword("0")
        }
        deleteNumber.setOnClickListener {
            if (passwordList.size >= 1) {
                numberCheck--
                removeImage(numberCheck)
                passwordList.removeAt(passwordList.lastIndex)
                vibration()
            }
        }
        return views
    }

    fun checkPassword(number: String) {
        numberCheck++
        if (numberCheck <= 4) {
            passwordList.add(number)
            setImage(numberCheck)
            vibration()
            if (numberCheck == 4) {
                if ("0" == passwordList[0] && "0" == passwordList[1] && "0" == passwordList[2] && "0" == passwordList[3]) {
                    findNavController().navigate(R.id.action_passwordFragment_to_menuFragment)

                }
            }
        } else {
            numberCheck = 4
        }

    }

    fun vibration() {
        val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(80, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(80)
        }
    }

    fun setImage(number: Int) {
        if (number == 1) {
            oneIndecator.setImageResource(R.drawable.ic_spinner)
        }
        if (number == 2) {
            twoIndecator.setImageResource(R.drawable.ic_spinner)
        }
        if (number == 3) {
            treeIndecator.setImageResource(R.drawable.ic_spinner)
        }
        if (number == 4) {
            fourIndecator.setImageResource(R.drawable.ic_spinner)
        }
    }

    fun removeImage(number: Int) {
        if (number == 0) {
            oneIndecator.setImageResource(0)
        }
        if (number == 1) {
            twoIndecator.setImageResource(0)
        }
        if (number == 2) {
            treeIndecator.setImageResource(0)
        }
        if (number == 3) {
            fourIndecator.setImageResource(0)
        }
    }
}