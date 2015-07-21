package com.winhtaikaung.co;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawpicture();

        LinearLayout ll = (LinearLayout) findViewById(R.id.rect);
        ll.setBackgroundDrawable(new BitmapDrawable(bitmapoverlay(drawpicture(),drawEye(),getSmile())));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    Bitmap drawpicture(){
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#F2E16C"));
        Paint paint_jacket=new Paint();
        paint_jacket.setColor(Color.parseColor("#2D71A1"));



        Bitmap bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);



        Canvas canvas = new Canvas(bg);
        canvas.drawArc(new RectF(100, 100, 350, 350), 180, 180, true, paint);
        canvas.drawRect(new RectF(100, 210, 350, 350), paint);
        Canvas canvas1=new Canvas(bg);
        canvas1.drawArc(new RectF(100, 200, 350, 500), 360, 180, false, paint_jacket);

        return bg;
    }

    Bitmap drawEye(){
        Paint paint_eyebg=new Paint();
        paint_eyebg.setColor(Color.parseColor("#EDEDED"));


        Paint paint_eyerim=new Paint();
        paint_eyerim.setColor(Color.parseColor("#F2E16C"));

        Paint paint_eyeinside=new Paint();
        paint_eyeinside.setColor(Color.parseColor("#FFFFFF"));

        Paint paint_red=new Paint();
        paint_red.setColor(Color.parseColor("#FFE342"));

        Paint paint_black=new Paint();
        paint_black.setColor(Color.parseColor("#000000"));


        Bitmap bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas_eye=new Canvas(bg);

        Bitmap bg_eyeinside=Bitmap.createBitmap(bg.getWidth(),bg.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas_bg_inside=new Canvas(bg_eyeinside);
        canvas_bg_inside.drawOval(new RectF(240, 200, 300, 280), paint_red);
        canvas_bg_inside.drawBitmap(bg_eyeinside, 0, 0, null);

        canvas_eye.drawCircle(230, 200, 60, paint_eyebg);
        canvas_eye.drawCircle(230, 200, 50, paint_eyebg);
        canvas_eye.drawBitmap(bg_eyeinside, -40, -40, null);
        canvas_eye.drawCircle(230, 200, 35, paint_eyeinside);
        canvas_eye.drawCircle(220, 200, 20, paint_black);
        canvas_eye.drawCircle(220, 200, 2, paint_eyebg);



        return bg;
    }

    Bitmap getSmile(){

        float x1,y1,x3,y3;
        x1=200;
        y1=300;
        x3=250;
        y3=300;


        Paint paint = new Paint() {
            {
                setStyle(Paint.Style.STROKE);
                setStrokeCap(Paint.Cap.ROUND);
                setStrokeWidth(3.0f);
                setAntiAlias(true);
            }
        };
        final Path path = new Path();
        path.moveTo(x1, 290);

        final float x2 = (x3 + x1) / 2;
        final float y2 = (y3 + y1) / 2;
        path.cubicTo(x1,y1,x2, y2, x3, y3);
        Bitmap bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas_smile=new Canvas(bg);
        canvas_smile.drawPath(path,paint);
        return bg;
    }


    Bitmap bitmapoverlay(Bitmap bmp1,Bitmap bmp2,Bitmap smilestroke){
        Bitmap bmOverlay = Bitmap.createBitmap(bmp1.getWidth(), bmp1.getHeight(), bmp2.getConfig());
        Canvas canvas = new Canvas(bmOverlay);
        canvas.drawBitmap(bmp1,new Matrix(), null);
        canvas.drawBitmap(bmp2, 0,0, null);
        canvas.drawBitmap(smilestroke, 0,0, null);
        return bmOverlay;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
