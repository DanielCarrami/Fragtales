package com.example.alumno.fragtales;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.media.MediaPlayer;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    private ShapeDrawable mDrawable;

    private MediaPlayer player;
    private int volume;
    Button button;
    SeekBar seekBar;
    View fractal;
    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;
    private Rect mRect = new Rect();
    private Rect mBounds = new Rect();
    private static final int OFFSET = 120;
    private int mOffset = OFFSET;
    private static final int MULTIPLIER = 100;
    private int mColorBackground;
    private int mColorRectangle;
    private int mColorAccent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        volume = 50;
        player = MediaPlayer.create(this, R.raw.nuncaessuficiente);
        player.setVolume((float)volume/100, (float)volume/100);
        seekBar .setProgress(volume);
        seekBar.setOnSeekBarChangeListener(this);

    }

    public void drawSomething(View fractal) {



    }

    public void playPause(View v){
        if(player.isPlaying()){
            player.pause();
            button.setText("Play");
        } else {
            player.start();
            button.setText("Pause");
        }
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        volume = seekBar.getProgress();
        player.setVolume((float)volume/100, (float)volume/100);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    /*public static void Dibujar(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.BLUE);
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);//Filtro antialiasing

        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 5.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 5.0);
        g2.drawLine(x1, y1, x2, y2);
        Dibujar(g2, x2, y2, angle - 20, depth - 1);
        Dibujar(g2, x2, y2, angle + 20, depth - 1);
    }*/

}



