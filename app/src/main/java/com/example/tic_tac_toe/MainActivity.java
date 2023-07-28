package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //state
    //0->X
    //1->O
    //2->Null
    //players
    //0->X
    //1->O
    //2->blank
    int activeplayer=0;
    int []gamestate={ 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 };
    int [][]winpositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameactive=true;
    @SuppressLint("SetTextI18n")
    public void playerTap(View view) {

        ImageView img=(ImageView) view;
        int tappedimage=Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            TextView status = findViewById(R.id.status);
            status.setText("Click reset !!");
            return;
        }
        if(gamestate[tappedimage]==2) {
            gamestate[tappedimage] = activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer == 0) {
                activeplayer = 1;
                img.setImageResource(R.drawable.x);
                TextView status = findViewById(R.id.status);
                status.setText("Its O's turn now");
            } else {
                activeplayer = 0;
                img.setImageResource(R.drawable.o);
                TextView status = findViewById(R.id.status);
                status.setText("Its x's turn now");
            }
            img.animate().translationYBy(1000f).setDuration(400);
        }
        for(int []winposition:winpositions){
            if(gamestate[winposition[0]]==gamestate[winposition[1]] &&
                    gamestate[winposition[1]]==gamestate[winposition[2]] &&
                    gamestate[winposition[0]]!=2){
                String winnerstr;
                gameactive=false;
                if(gamestate[winposition[0]]==0){
                    winnerstr="X has won,Click reset";
                }else{
                    winnerstr="O has won,Click reset";
                }
                TextView status=findViewById(R.id.status);
                status.setText(winnerstr);
            }
        }
        int count=0;
        for (int j : gamestate) {
            if (j != 2 && gameactive) {
                count++;
            }
        }
        if(count==9){
            TextView status=findViewById(R.id.status);
            status.setText("Its a Tie,Click Reset");
            gameactive=false;
        }
    }
    @SuppressLint("SetTextI18n")
    public void gamereset(View view){
        gameactive=true;
        activeplayer=0;
        Arrays.fill(gamestate, 2);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        TextView status=findViewById(R.id.status);
        status.setText("Its x's turn now");
    }
    public void funcreset(View view){
        gamereset(view);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}