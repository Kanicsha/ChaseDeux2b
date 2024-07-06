package com.example.cheese_chase;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  {
        TextView tv,score,cheese,disappear;
        boolean yes_choice=false;
    ImageView imageView;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        canvas_view cv=findViewById(R.id.canvas_view);
        tv=findViewById(R.id.text_view);
        cheese=findViewById(R.id.cheese);
        disappear=findViewById(R.id.disappearing);
//        cv.setOnTextChangedListener(new TextChangeListener() {
//            @Override
//            public void onTextChange(String text) {
//                TextView tv=findViewById(R.id.text_view);
//                tv.setText("score");
//            }
//        });
        cv.setMainActivity(this);
//        imageView=findViewById(R.id.tommy);




    }
    public void showDialog(){
        canvas_view cv=findViewById(R.id.canvas_view);
        AlertDialog winDialog = new AlertDialog.Builder(this).create();
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.winner_dialog, null);
         score=view.findViewById(R.id.textView2);
        winDialog.setView(view);
        Button home=view.findViewById(R.id.home);
        Button play_again = view.findViewById(R.id.play_again);
        // TextView score=view.findViewById(R.id.textView2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winDialog.dismiss();
            }
        });
        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winDialog.cancel();
                cv.resetGame();
            }
        });
        winDialog.show();
    }
    public void setDialogText(String text) {
        if(score!=null)score.setText(text);
    }
    public void onDrawFinished(TextView textView) {
        tv.setText("Hello from CanvasView!");
    }


   public void onTextChange(String text) {
       tv.setText(text);
   }
   public void setImageView(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
   }
    public void setDisappear(String text) {
        disappear.setText(text);
    }

    public void setCheese(String text){
        cheese.setText(text);
   }
    public void showDialog2(){
        canvas_view cv=findViewById(R.id.canvas_view);
        AlertDialog winDialog = new AlertDialog.Builder(this).create();
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.dialog_yn, null);
        winDialog.setView(view);
        Button yes=view.findViewById(R.id.yes);
        Button no = view.findViewById(R.id.no);
        // TextView score=view.findViewById(R.id.textView2);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winDialog.dismiss();
                cv.cheeseCollected--;
                yes_choice=true;
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winDialog.dismiss();
            }
        });
        winDialog.show();
    }



}