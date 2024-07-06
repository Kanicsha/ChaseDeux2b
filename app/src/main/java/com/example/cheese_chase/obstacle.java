package com.example.cheese_chase;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;

public class obstacle {
    Bitmap bm;
    int size;
    Paint paint=new Paint();
    Paint paint_outline=new Paint();
    float left,right,bottom,top;
    float speed;
    int current_track;
    float gap_down;

    public obstacle(Bitmap bm,int size,float left,float top) {
        this.bm=bm;
        this.size = size;
        this.left=left;
        this.right=left+size;
        this.top=top;
        this.bottom=top+size;
        this.current_track=-1;
        this.gap_down=80; //gap to place the next obstacle

    }


    public void create_obstacle(Canvas canvas) {
        paint.setColor(Color.parseColor("#0288D1"));;
        paint.setStyle(Paint.Style.FILL);
        paint_outline.setColor(Color.BLACK);
        paint_outline.setStrokeWidth(10);
        paint_outline.setStyle(Paint.Style.STROKE);
        //canvas.drawRect(left,top,right,bottom,paint);
        canvas.drawBitmap(bm,left,top,paint);
        //canvas.drawRect(left,top,right,bottom,paint_outline);


    }
    public void increase_speed(float speed){ //make it move upwards if speed is positive n down when neg
        top=top-speed;
        bottom-=speed;
    }

    public void setGap_down(int gapDown){
    this.gap_down=gapDown;}

    public void setTop(float top1,float gap_previous_obstacle){
        this.top=top1+gap_previous_obstacle;
        this.bottom=this.top+this.size;
    }
    public void setTop(float top){

        this.top=top;
        Log.i("tot", String.valueOf(this.top));
        this.bottom=top+this.size;
    }

    public void setLeft(float left) {
        this.left = left;
        this.right=left+this.size;
    }
}




