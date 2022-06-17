package com.example.stonescissorpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var humanScore : Int = 0
    var computerScore : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tvpaper: Button = findViewById(R.id.paper_b)
        var tvscissor: Button = findViewById(R.id.scissor_b)
        var tvrock: Button = findViewById(R.id.rock_b)

        var tvhuman: ImageView = findViewById(R.id.human_choice)

        var tvscore : TextView = findViewById(R.id.score_f)

        tvpaper.setOnClickListener{
            tvhuman.setImageResource(R.drawable.paper)
            var message : String = playerchoice("Paper")
            Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
            tvscore.setText("Score: Human " + humanScore.toString() + " Computer " + computerScore.toString())
        }
        tvscissor.setOnClickListener{
            tvhuman.setImageResource(R.drawable.scissors)
            var message : String = playerchoice("Scissor")
            Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
            tvscore.setText("Score: Human " + humanScore.toString() + " Computer " + computerScore.toString())
        }
        tvrock.setOnClickListener{
            tvhuman.setImageResource(R.drawable.rock)
            var message : String = playerchoice("Rock")
            Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
            tvscore.setText("Score: Human " + humanScore.toString() + " Computer " + computerScore.toString())
        }
    }
    private fun playerchoice(player_turn: String): String {
        var computerchoicestring = ""
        val obj = Choice()

        when(obj.playturn()){
            1->computerchoicestring="Rock"
            2->computerchoicestring="Paper"
            3->computerchoicestring="Scissor"
            4->computerchoicestring="Rock"
            5->computerchoicestring="Paper"
            6->computerchoicestring="Scissor"
            7->computerchoicestring="Rock"
            8->computerchoicestring="Paper"
            9->computerchoicestring="Scissor"
            10->computerchoicestring="Paper"
        }

        var tvcomputer: ImageView = findViewById(R.id.Computer_choice)

        when(computerchoicestring){
            "Rock"->tvcomputer.setImageResource(R.drawable.rock)
            "Paper"->tvcomputer.setImageResource(R.drawable.paper)
            "Scissor"->tvcomputer.setImageResource(R.drawable.scissors)
        }
        if(computerchoicestring==player_turn){
            return "Draw. Nobody won"
        }
        else if(player_turn=="Rock" && computerchoicestring=="Scissor"){
            humanScore++
            return "Rock crushes scissor. You win"
        }
        else if(player_turn=="Rock" && computerchoicestring=="Paper"){
            computerScore++
            return "Paper covers rock. Computer wins"
        }
        else if(player_turn=="Scissor" && computerchoicestring=="Rock"){
            computerScore++
            return "Rock crushes scissor. Computer wins"
        }
        else if(player_turn=="Scissor" && computerchoicestring=="Paper"){
            humanScore++
            return "Scissor cuts paper. You win"
        }
        else if(player_turn=="Paper" && computerchoicestring=="Scissor"){
            computerScore++
            return "Scissor cuts paper. Computer wins"
        }
        else if(player_turn=="Paper" && computerchoicestring=="Rock"){
            humanScore++
            return "Paper covers rock. You win"
        }
        else return "Not sure"
    }
}
class Choice(){
    fun playturn(): Int {
        return (1..10).random()
    }
}