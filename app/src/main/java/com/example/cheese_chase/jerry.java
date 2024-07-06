package com.example.cheese_chase;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class jerry {

    Bitmap bm;
    float x_center,y_center;
    int radius;
    float speed; //to make tom move closer to jerry by decreasing y_center using this factor
    Paint paint=new Paint();
    Paint paint_outline=new Paint();
    int current_track;


    public jerry(Bitmap bm,float x, float y, int r, float s){
        this.bm=bm;
        x_center=x;
        y_center=y;
        radius=r;
        speed=s;
        current_track=1;
    }
    public void increase_speed(float speed){
        y_center=y_center-speed;
    }

    public void create_jerry(Canvas canvas){
        paint.setColor(Color.parseColor("#795548"));
        paint.setStyle(Paint.Style.FILL);
        paint_outline.setColor(Color.BLACK);
        paint_outline.setStrokeWidth(10);
        paint_outline.setStyle(Paint.Style.STROKE);
        //canvas.drawCircle(x_center,y_center,radius,paint);
       // canvas.drawCircle(x_center,y_center,radius,paint_outline);
        canvas.drawBitmap(bm,x_center,y_center,paint);

    }
    public float getX_center(){
        return x_center;
    }
    public void setSpeed(float speed){
        this.speed=speed;
    }
    public float getY_center(){
        return y_center;
    }
    public int getRadius(){
        return radius;
    }


}
