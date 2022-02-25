package com.example.tictactoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btnClick(view:View){
        val btnselected :Button = view as Button
        var cellid=0
        when(btnselected.id){
            R.id.button1 -> cellid =1
            R.id.button2 -> cellid =2
            R.id.button3 -> cellid =3
            R.id.button4 -> cellid =4
            R.id.button5 -> cellid =5
            R.id.button6 -> cellid =6
            R.id.button7 -> cellid =7
            R.id.button8 -> cellid =8
            R.id.button9 -> cellid =9
        }
        playGame(cellid,btnselected)
    }
    var activeplayer=1
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    fun playGame(cellid:Int,btnselected:Button){
        if(activeplayer==1){
            btnselected.text="X"
            btnselected.setBackgroundResource(R.color.blue)
            player1.add(cellid)
            activeplayer=2
            autoPlay()
        }
        else{
            btnselected.text="O"
            btnselected.setBackgroundResource(R.color.darkgreen)
            player2.add(cellid)
            activeplayer=1
        }
        btnselected.isEnabled=false
        checkWiner()
    }
    fun checkWiner(){
        var winer=-1
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winer=1;
        }
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winer=2;
        }
        //
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winer=1;
        }
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winer=2;
        }
        //
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winer=1;
        }
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winer=2;
        }
        //
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winer=1;
        }
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winer=2;
        }
        //
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winer=1;
        }
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winer=2;
        }
        //
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winer=1;
        }
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winer=2;
        }

        //
        if(player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
            winer=1;
        }
        if(player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
            winer=2;
        }
//
        if(player1.contains(3)&&player1.contains(5)&&player1.contains(7)){
            winer=1;
        }
        if(player2.contains(3)&&player2.contains(5)&&player2.contains(7)){
            winer=2;
        }
        if(winer==1){
            Toast.makeText(this,"player 1 is winer", Toast.LENGTH_LONG).show()
        }
        else if(winer==2){
            Toast.makeText(this,"player 2 is winer", Toast.LENGTH_LONG).show()
        }
    }
    fun autoPlay(){
        var emptyCell= ArrayList<Int>()
        for(cellId in 1..9){
            if(!(player1.contains(cellId)||player2.contains(cellId))){
                emptyCell.add(cellId)
            }
        }
        val r =Random()
        val randomize=r.nextInt(emptyCell.size)
        val cellId= emptyCell[randomize]
        val selected : Button?
         selected= when(cellId){
            1->button1
            2->button2
            3->button3
            4->button4
            5->button5
            6->button6
            7->button7
            8->button8
            9->button9
            else->{button1}
        }
        playGame(cellId,selected)
    }
}