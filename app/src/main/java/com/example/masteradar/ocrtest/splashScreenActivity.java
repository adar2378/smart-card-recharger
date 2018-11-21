package com.example.masteradar.ocrtest;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class splashScreenActivity extends AppCompatActivity {
    TextView appname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        appname = findViewById(R.id.appnameAnimated);

        setTvZoomInOutAnimation(appname);
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2400);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        myThread.start();


    }
    private void setTvZoomInOutAnimation(final TextView textView)
    {
        // TODO Auto-generated method stub

        final float startSize = 56;
        final float endSize = 26;
        final int animationDuration = 2000; // Animation duration in ms

        ValueAnimator animator = ValueAnimator.ofFloat(startSize, endSize);
        animator.setDuration(animationDuration);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator)
            {
                float animatedValue = (Float) valueAnimator.getAnimatedValue();
                textView.setTextSize(animatedValue);
            }
        });

        //animator.setRepeatCount(ValueAnimator.INFINITE);  // Use this line for infinite animations
        animator.setRepeatCount(0);
        animator.start();
    }
}
