package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        Button btnSelected=(Button) view;
        btnSelected.setBackgroundColor(Color.RED);
        int CellID=0;
        switch ((btnSelected.getId())){
            case R.id.btn1:
                CellID=1;
                break;

            case R.id.btn2:
                CellID=2;
                break;

            case R.id.btn3:
                CellID=3;
                break;

            case R.id.btn4:
                CellID=4;
                break;

            case R.id.btn5:
                CellID=5;
                break;

            case R.id.btn6:
                CellID=6;
                break;

            case R.id.btn7:
                CellID=7;
                break;

            case R.id.btn8:
                CellID=8;
                break;

            case R.id.btn9:
                CellID=9;
                break;
        }
        PlayGame(CellID, btnSelected);
    }
    int ActivePlayer=1;
    ArrayList<Integer> Player1=new ArrayList<Integer>();
    ArrayList<Integer> Player2=new ArrayList<Integer>();
    void PlayGame(int CellID, Button btnSelected) {

        if (ActivePlayer==1){
            btnSelected.setText("X");
            btnSelected.setBackgroundColor(Color.GREEN);
            Player1.add(CellID);
            ActivePlayer=2;

            AutoPlay();
        }
        else if (ActivePlayer==2){
            btnSelected.setText("O");
            btnSelected.setBackgroundColor(Color.BLUE);
            Player2.add(CellID);
            ActivePlayer=1;
        }

        btnSelected.setEnabled(false);
        CheckWinner();
    }

    void CheckWinner(){
        int Winner=-1;
        //row 1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
            Winner=1;
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
            Winner=2;
        }
        //row2
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
            Winner=1;
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){
            Winner=2;
        }
        //row3
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
            Winner=1;
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
            Winner=2;
        }

        //col1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){
            Winner=1;
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){
            Winner=2;
        }
        //col2
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
            Winner=1;
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
            Winner=2;
        }
        //col3
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){
            Winner=1;
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
            Winner=2;
        }
        if (Winner !=-1){
            if (Winner==1){
                Toast.makeText(this, "Player 1 is Winner",Toast.LENGTH_LONG).show();
            }
            if (Winner==2){
                Toast.makeText(this, "Player 2 is Winner",Toast.LENGTH_LONG).show();
            }
        }
    }

    void AutoPlay(){

        ArrayList<Integer> EmptyCells=new ArrayList<Integer>(); //all unselected cells
        //Find empty cells
        for (int cellID=1; cellID<10;cellID++){
            if (!(Player1.contains(cellID) || Player2.contains(cellID))){
                EmptyCells.add(cellID);
            }
        }
        Random r= new Random();
        int RandIndex=r.nextInt(EmptyCells.size()-0)+0;
        int CellID=EmptyCells.get(RandIndex);

        Button btnSelected;
        switch (CellID){
            case 1:
                btnSelected=findViewById(R.id.btn1);
                break;

            case 2:
                btnSelected=findViewById(R.id.btn2);
                break;

            case 3:
                btnSelected=findViewById(R.id.btn3);
                break;

            case 4:
                btnSelected=findViewById(R.id.btn4);
                break;

            case 5:
                btnSelected=findViewById(R.id.btn5);
                break;

            case 6:
                btnSelected=findViewById(R.id.btn6);
                break;

            case 7:
                btnSelected=findViewById(R.id.btn7);
                break;

            case 8:
                btnSelected=findViewById(R.id.btn8);
                break;

            case 9:
                btnSelected=findViewById(R.id.btn9);
                break;

            default:
                btnSelected=findViewById(R.id.btn1);
                break;
        }

        PlayGame(CellID, btnSelected);
    }
}