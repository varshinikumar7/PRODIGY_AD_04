package com.example.tictactoe

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tictactoe.databinding.MainBinding
import com.example.tictactoe.ui.theme.TicTacToeTheme


class MainActivity : ComponentActivity() {
    var player = "p1"
    lateinit var binding : MainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bt0.setOnClickListener()
        {
            buttonclick(binding.bt0,binding.result)
        }
        binding.bt1.setOnClickListener()
        {
            buttonclick(binding.bt1,binding.result)
        }
        binding.bt2.setOnClickListener()
        {
            buttonclick(binding.bt2,binding.result)
        }
        binding.bt3.setOnClickListener()
        {
            buttonclick(binding.bt3,binding.result)
        }
        binding.bt4.setOnClickListener()
        {
            buttonclick(binding.bt4,binding.result)
        }
        binding.bt5.setOnClickListener()
        {
            buttonclick(binding.bt5,binding.result)
        }
        binding.bt6.setOnClickListener()
        {
            buttonclick(binding.bt6,binding.result)
        }
        binding.bt7.setOnClickListener()
        {
            buttonclick(binding.bt7,binding.result)
        }
        binding.bt8.setOnClickListener()
        {
            buttonclick(binding.bt8,binding.result)
        }
        binding.playagain.setOnClickListener()
        {
            reset()
            enablebtn()
            binding.result.text="Player X turn"
            player="p1"
        }
    }

    fun buttonclick(btn: Button,res: TextView) {
        if (btn.text == "") {
            if (player == "p1") {
                player = "p2"
                btn.text = "X"
                res.text="Player O turn"
            } else {
                player = "p1"
                btn.text = "O"
                res.text="Player X turn"
            }
        }
        win()
    }

    fun win() {
        if ((binding.bt0.text == "X" && binding.bt1.text == "X" && binding.bt2.text == "X")
            || (binding.bt3.text == "X" && binding.bt4.text == "X" && binding.bt5.text == "X")
            || (binding.bt6.text == "X" && binding.bt7.text == "X" && binding.bt8.text == "X")
            || (binding.bt0.text == "X" && binding.bt3.text == "X" && binding.bt6.text == "X")
            || (binding.bt1.text == "X" && binding.bt4.text == "X" && binding.bt7.text == "X")
            || (binding.bt2.text == "X" && binding.bt5.text == "X" && binding.bt8.text == "X")
            || (binding.bt0.text == "X" && binding.bt4.text == "X" && binding.bt8.text == "X")
            || (binding.bt2.text == "X" && binding.bt4.text == "X" && binding.bt6.text == "X")
        ) {
            toast("Player X won the game")
            binding.result.text="Player X won the game"
            disablebtn()
        }
        else if ((binding.bt0.text == "O" && binding.bt1.text == "O" && binding.bt2.text == "O")
                || (binding.bt3.text == "O" && binding.bt4.text == "O" && binding.bt5.text == "O")
                || (binding.bt6.text == "O" && binding.bt7.text == "O" && binding.bt8.text == "O")
                || (binding.bt0.text == "O" && binding.bt3.text == "O" && binding.bt6.text == "O")
                || (binding.bt1.text == "O" && binding.bt4.text == "O" && binding.bt7.text == "O")
                || (binding.bt2.text == "O" && binding.bt5.text == "O" && binding.bt8.text == "O")
                || (binding.bt0.text == "O" && binding.bt4.text == "O" && binding.bt8.text == "O")
                || (binding.bt2.text == "O" && binding.bt4.text == "O" && binding.bt6.text == "O"))
        {
            toast("Player O won the game")
            binding.result.text="Player O won the game"
            disablebtn()
        }
       else {
            if (binding.bt0.text != "" && binding.bt1.text != "" && binding.bt2.text != "" && binding.bt3.text != "" && binding.bt4.text != "" && binding.bt5.text != "" && binding.bt6.text != ""
                && binding.bt7.text != "" && binding.bt8.text != ""
            ) {
                toast("tie game")
                binding.result.text="Tie game"
            }
        }
    }
    fun disablebtn()
    {
        binding.bt0.isEnabled= false
        binding.bt1.isEnabled= false
        binding.bt2.isEnabled= false
        binding.bt3.isEnabled= false
        binding.bt4.isEnabled= false
        binding.bt5.isEnabled= false
        binding.bt6.isEnabled= false
        binding.bt7.isEnabled= false
        binding.bt8.isEnabled= false

    }
    fun enablebtn()
    {
        binding.bt0.isEnabled= true
        binding.bt1.isEnabled= true
        binding.bt2.isEnabled= true
        binding.bt3.isEnabled= true
        binding.bt4.isEnabled= true
        binding.bt5.isEnabled= true
        binding.bt6.isEnabled= true
        binding.bt7.isEnabled= true
        binding.bt8.isEnabled= true

    }

    fun reset()
    {
        binding.bt0.text = ""
        binding.bt1.text = ""
        binding.bt2.text = ""
        binding.bt3.text = ""
        binding.bt4.text = ""
        binding.bt5.text = ""
        binding.bt6.text = ""
        binding.bt7.text = ""
        binding.bt8.text = ""
    }

    fun toast(msg: String) {
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }

}