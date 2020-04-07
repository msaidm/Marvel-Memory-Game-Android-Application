package com.example.matchingapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;


import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Chronometer;
import android.widget.ImageView;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import android.os.SystemClock;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {
    TextView timerLabel ;
    CountDownTimer mCountDownTimer;
    private ImageButton startButton;
    boolean mTimerRunning;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    ImageView image8;
    ImageView image9;
    ImageView image10;
    ImageView image11;
    ImageView image12;
    TextView scoreTextView ;
    TextView time ;
    final int[] pictures = {1,2,3,4,5,6,7,8,9,10,11,12};
    //ImageView[] imagesArray1={image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12};
    boolean startFlag=false;
    boolean[] imagesFlags = {false,false,false,false,false,false,false,false,false,false,false,false};
    int count=0;
    int firstPic=1;
    int secondPic=1;
    int firstView;
    int secondView;
    int score  = 0 ;
    MediaPlayer hulkVoices = null;
    MediaPlayer ironmanVoices = null;
    MediaPlayer captainVoices = null;
    MediaPlayer blackVoices =null;
    MediaPlayer spidermanVoices = null;
    MediaPlayer drStrangeVoices = null;


    static void shuffleArray(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random random1 = new Random();


        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = random1.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
    Handler handler = new Handler();

    void makeAnimation(final ImageView image)
    {
        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(image, "scaleX", 1f, 0f);
        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(image, "scaleX", 0f, 1f);

        oa1.setInterpolator(new DecelerateInterpolator());
        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
        oa1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                image.setImageResource(R.drawable.marvel);
                oa2.start();
            }
        });
        oa1.start();
    }

    protected void putImage(final ImageView view, int tag){
        imagesFlags[tag]=true;
        if(count==0)
        {
            firstPic=pictures[tag];
            firstView=tag;
            if(tag==0)
                image1.setEnabled(false);
            if(tag==1)
                image2.setEnabled(false);
            if(tag==2)
                image3.setEnabled(false);
            if(tag==3)
                image4.setEnabled(false);
            if(tag==4)
                image5.setEnabled(false);
            if(tag==5)
                image6.setEnabled(false);
            if(tag==6)
                image7.setEnabled(false);
            if(tag==8)
                image9.setEnabled(false);
            if(tag==9)
                image10.setEnabled(false);
            if(tag==10)
                image11.setEnabled(false);
            if(tag==11)
                image12.setEnabled(false);

        }
        else if(count==1)
        {
            secondPic=pictures[tag];
            secondView=tag;
        }

        if(pictures[tag]==1||pictures[tag]==7)
        {
            hulkVoices= MediaPlayer.create(MainActivity.this, R.raw.hulk);
            hulkVoices.start();

            final ObjectAnimator oa1 = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f);
            final ObjectAnimator oa2 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
            final ImageView View = view;
            oa1.setInterpolator(new DecelerateInterpolator());
            oa2.setInterpolator(new AccelerateDecelerateInterpolator());
            oa1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view.setBackground(null);
                    view.setImageResource(R.drawable.hulk);
                    oa2.start();
                }
            });
            oa1.start();

        }
        else if(pictures[tag]==2||pictures[tag]==8){
            ironmanVoices= MediaPlayer.create(MainActivity.this, R.raw.ironman);
            ironmanVoices.start();

            final ObjectAnimator oa1 = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f);
            final ObjectAnimator oa2 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
            final ImageView View = view;
            oa1.setInterpolator(new DecelerateInterpolator());
            oa2.setInterpolator(new AccelerateDecelerateInterpolator());
            oa1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view.setBackground(null);
                    view.setImageResource(R.drawable.ironman);
                    oa2.start();
                }
            });
            oa1.start();
        }
        else if(pictures[tag]==3||pictures[tag]==9){
            drStrangeVoices= MediaPlayer.create(MainActivity.this, R.raw.drstrange);
            drStrangeVoices.start();

            final ObjectAnimator oa1 = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f);
            final ObjectAnimator oa2 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
            final ImageView View = view;
            oa1.setInterpolator(new DecelerateInterpolator());
            oa2.setInterpolator(new AccelerateDecelerateInterpolator());
            oa1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    View.setBackground(null);
                    View.setImageResource(R.drawable.drstrange);
                    oa2.start();
                }
            });
            oa1.start();
        }
        else if(pictures[tag]==4||pictures[tag]==10){
            spidermanVoices= MediaPlayer.create(MainActivity.this, R.raw.spiderman);
            spidermanVoices.start();

            final ObjectAnimator oa1 = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f);
            final ObjectAnimator oa2 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
            final ImageView View = view;
            View.setBackground(null);
            oa1.setInterpolator(new DecelerateInterpolator());
            oa2.setInterpolator(new AccelerateDecelerateInterpolator());
            oa1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    View.setImageResource(R.drawable.spiderman);
                    oa2.start();
                }
            });
            oa1.start();
        }
        else if(pictures[tag]==5||pictures[tag]==11){
            captainVoices= MediaPlayer.create(MainActivity.this, R.raw.captainamerica);
            captainVoices.start();

            final ObjectAnimator oa1 = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f);
            final ObjectAnimator oa2 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
            final ImageView View = view;
            View.setBackground(null);
            oa1.setInterpolator(new DecelerateInterpolator());
            oa2.setInterpolator(new AccelerateDecelerateInterpolator());
            oa1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    View.setImageResource(R.drawable.captainamerica);
                    oa2.start();
                }
            });
            oa1.start();
        }
        else if(pictures[tag]==6||pictures[tag]==12){
            blackVoices= MediaPlayer.create(MainActivity.this, R.raw.black);
            blackVoices.start();

            final ObjectAnimator oa1 = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f);
            final ObjectAnimator oa2 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
            final ImageView View = view;
            View.setBackground(null);
            oa1.setInterpolator(new DecelerateInterpolator());
            oa2.setInterpolator(new AccelerateDecelerateInterpolator());
            oa1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    View.setImageResource(R.drawable.black);
                    oa2.start();
                }
            });
            oa1.start();

        }


        if(count==1) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if ((firstPic == 1 && secondPic == 7)  || (firstPic == 7 && secondPic == 1) ) {
                        if(firstView==0||secondView==0) {
                            image1.setVisibility(View.INVISIBLE);
                        }
                        if(firstView==1||secondView==1)
                            image2.setVisibility(View.INVISIBLE);
                        if(firstView==2||secondView==2)
                            image3.setVisibility(View.INVISIBLE);
                        if(firstView==3||secondView==3)
                            image4.setVisibility(View.INVISIBLE);
                        if(firstView==4||secondView==4)
                            image5.setVisibility(View.INVISIBLE);
                        if(firstView==5||secondView==5)
                            image6.setVisibility(View.INVISIBLE);
                        if(firstView==6||secondView==6)
                            image7.setVisibility(View.INVISIBLE);
                        if(firstView==7||secondView==7)
                            image8.setVisibility(View.INVISIBLE);
                        if(firstView==8||secondView==8)
                            image9.setVisibility(View.INVISIBLE);
                        if(firstView==9||secondView==9)
                            image10.setVisibility(View.INVISIBLE);
                        if(firstView==10||secondView==10)
                            image11.setVisibility(View.INVISIBLE);
                        if(firstView==11||secondView==11)
                            image12.setVisibility(View.INVISIBLE);
                        count=0;
                        score+=10;
                        scoreTextView.setText(score+"");
                    } else if ((firstPic == 2 && secondPic == 8 ) || (firstPic == 8 && secondPic == 2)) {
                        if(firstView==0||secondView==0)
                            image1.setVisibility(View.INVISIBLE);
                        if(firstView==1||secondView==1)
                            image2.setVisibility(View.INVISIBLE);
                        if(firstView==2||secondView==2)
                            image3.setVisibility(View.INVISIBLE);
                        if(firstView==3||secondView==3)
                            image4.setVisibility(View.INVISIBLE);
                        if(firstView==4||secondView==4)
                            image5.setVisibility(View.INVISIBLE);
                        if(firstView==5||secondView==5)
                            image6.setVisibility(View.INVISIBLE);
                        if(firstView==6||secondView==6)
                            image7.setVisibility(View.INVISIBLE);
                        if(firstView==7||secondView==7)
                            image8.setVisibility(View.INVISIBLE);
                        if(firstView==8||secondView==8)
                            image9.setVisibility(View.INVISIBLE);
                        if(firstView==9||secondView==9)
                            image10.setVisibility(View.INVISIBLE);
                        if(firstView==10||secondView==10)
                            image11.setVisibility(View.INVISIBLE);
                        if(firstView==11||secondView==11)
                            image12.setVisibility(View.INVISIBLE);
                        count = 0;
                        score+=10;
                        scoreTextView.setText(score+"");
                    } else if ((firstPic == 3 && secondPic == 9 || (firstPic == 9 && secondPic == 3))) {
                        if(firstView==0||secondView==0)
                            image1.setVisibility(View.INVISIBLE);
                        if(firstView==1||secondView==1)
                            image2.setVisibility(View.INVISIBLE);
                        if(firstView==2||secondView==2)
                            image3.setVisibility(View.INVISIBLE);
                        if(firstView==3||secondView==3)
                            image4.setVisibility(View.INVISIBLE);
                        if(firstView==4||secondView==4)
                            image5.setVisibility(View.INVISIBLE);
                        if(firstView==5||secondView==5)
                            image6.setVisibility(View.INVISIBLE);
                        if(firstView==6||secondView==6)
                            image7.setVisibility(View.INVISIBLE);
                        if(firstView==7||secondView==7)
                            image8.setVisibility(View.INVISIBLE);
                        if(firstView==8||secondView==8)
                            image9.setVisibility(View.INVISIBLE);
                        if(firstView==9||secondView==9)
                            image10.setVisibility(View.INVISIBLE);
                        if(firstView==10||secondView==10)
                            image11.setVisibility(View.INVISIBLE);
                        if(firstView==11||secondView==11)
                            image12.setVisibility(View.INVISIBLE);
                        count = 0;
                        score+=10;
                        scoreTextView.setText(score+"");
                    } else if ((firstPic == 4 && secondPic == 10) || (firstPic == 10 && secondPic == 4)) {
                        if(firstView==0||secondView==0)
                            image1.setVisibility(View.INVISIBLE);
                        if(firstView==1||secondView==1)
                            image2.setVisibility(View.INVISIBLE);
                        if(firstView==2||secondView==2)
                            image3.setVisibility(View.INVISIBLE);
                        if(firstView==3||secondView==3)
                            image4.setVisibility(View.INVISIBLE);
                        if(firstView==4||secondView==4)
                            image5.setVisibility(View.INVISIBLE);
                        if(firstView==5||secondView==5)
                            image6.setVisibility(View.INVISIBLE);
                        if(firstView==6||secondView==6)
                            image7.setVisibility(View.INVISIBLE);
                        if(firstView==7||secondView==7)
                            image8.setVisibility(View.INVISIBLE);
                        if(firstView==8||secondView==8)
                            image9.setVisibility(View.INVISIBLE);
                        if(firstView==9||secondView==9)
                            image10.setVisibility(View.INVISIBLE);
                        if(firstView==10||secondView==10)
                            image11.setVisibility(View.INVISIBLE);
                        if(firstView==11||secondView==11)
                            image12.setVisibility(View.INVISIBLE);
                        count = 0;
                        score+=10;
                        scoreTextView.setText(score+"");
                    } else if ((firstPic == 5 && secondPic == 11 )|| (firstPic == 11 && secondPic == 5)) {
                        if(firstView==0||secondView==0)
                            image1.setVisibility(View.INVISIBLE);
                        if(firstView==1||secondView==1)
                            image2.setVisibility(View.INVISIBLE);
                        if(firstView==2||secondView==2)
                            image3.setVisibility(View.INVISIBLE);
                        if(firstView==3||secondView==3)
                            image4.setVisibility(View.INVISIBLE);
                        if(firstView==4||secondView==4)
                            image5.setVisibility(View.INVISIBLE);
                        if(firstView==5||secondView==5)
                            image6.setVisibility(View.INVISIBLE);
                        if(firstView==6||secondView==6)
                            image7.setVisibility(View.INVISIBLE);
                        if(firstView==7||secondView==7)
                            image8.setVisibility(View.INVISIBLE);
                        if(firstView==8||secondView==8)
                            image9.setVisibility(View.INVISIBLE);
                        if(firstView==9||secondView==9)
                            image10.setVisibility(View.INVISIBLE);
                        if(firstView==10||secondView==10)
                            image11.setVisibility(View.INVISIBLE);
                        if(firstView==11||secondView==11)
                            image12.setVisibility(View.INVISIBLE);
                        count = 0;
                        score+=10;
                        scoreTextView.setText(score+"");
                    } else if ((firstPic == 6 && secondPic == 12) || (firstPic == 12 && secondPic == 6)) {
                        if(firstView==0||secondView==0)
                            image1.setVisibility(View.INVISIBLE);
                        if(firstView==1||secondView==1)
                            image2.setVisibility(View.INVISIBLE);
                        if(firstView==2||secondView==2)
                            image3.setVisibility(View.INVISIBLE);
                        if(firstView==3||secondView==3)
                            image4.setVisibility(View.INVISIBLE);
                        if(firstView==4||secondView==4)
                            image5.setVisibility(View.INVISIBLE);
                        if(firstView==5||secondView==5)
                            image6.setVisibility(View.INVISIBLE);
                        if(firstView==6||secondView==6)
                            image7.setVisibility(View.INVISIBLE);
                        if(firstView==7||secondView==7)
                            image8.setVisibility(View.INVISIBLE);
                        if(firstView==8||secondView==8)
                            image9.setVisibility(View.INVISIBLE);
                        if(firstView==9||secondView==9)
                            image10.setVisibility(View.INVISIBLE);
                        if(firstView==10||secondView==10)
                            image11.setVisibility(View.INVISIBLE);
                        if(firstView==11||secondView==11)
                            image12.setVisibility(View.INVISIBLE);
                        count = 0;
                        score+=10;
                        scoreTextView.setText(score+"");
                    }
                    else {
                        if(firstView==0||secondView==0)
                        {   image1.setBackground(null);
                            makeAnimation(image1);
                        }
                        if(firstView==1||secondView==1)
                        {   image2.setBackground(null);
                            makeAnimation(image2);
                        }
                        if(firstView==2||secondView==2)
                        {   image3.setBackground(null);
                            makeAnimation(image3);
                        }
                        if(firstView==3||secondView==3)
                        {   image4.setBackground(null);
                            makeAnimation(image4);
                        }
                        if(firstView==4||secondView==4)
                        {   image5.setBackground(null);
                            makeAnimation(image5);
                        }
                        if(firstView==5||secondView==5)
                        {   image6.setBackground(null);
                            makeAnimation(image6);
                        }
                        if(firstView==6||secondView==6)
                        {   image7.setBackground(null);
                            makeAnimation(image7);
                        }
                        if(firstView==7||secondView==7)
                        {   image8.setBackground(null);
                            makeAnimation(image8);
                        }
                        if(firstView==8||secondView==8)
                        {   image9.setBackground(null);
                            makeAnimation(image9);
                        }
                        if(firstView==9||secondView==9)
                        {   image10.setBackground(null);
                            makeAnimation(image10);
                        }
                        if(firstView==10||secondView==10)
                        {   image11.setBackground(null);
                            makeAnimation(image11);
                        }
                        if(firstView==11||secondView==11)
                        {   image12.setBackground(null);
                            makeAnimation(image12);
                        }
                        count = 0;
                    }

                    image1.setEnabled(true);
                    image2.setEnabled(true);
                    image3.setEnabled(true);
                    image4.setEnabled(true);
                    image5.setEnabled(true);
                    image6.setEnabled(true);
                    image7.setEnabled(true);
                    image8.setEnabled(true);
                    image9.setEnabled(true);
                    image10.setEnabled(true);
                    image11.setEnabled(true);
                    image12.setEnabled(true);

                    if(image1.getVisibility()==View.INVISIBLE && image2.getVisibility()==View.INVISIBLE
                            && image3.getVisibility()==View.INVISIBLE && image4.getVisibility()==View.INVISIBLE
                            && image5.getVisibility()==View.INVISIBLE && image6.getVisibility()==View.INVISIBLE
                            && image7.getVisibility()==View.INVISIBLE&& image8.getVisibility()==View.INVISIBLE
                            && image9.getVisibility()==View.INVISIBLE&& image10.getVisibility()==View.INVISIBLE
                            && image11.getVisibility()==View.INVISIBLE&& image12.getVisibility()==View.INVISIBLE)
                    {
                        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which){
                                    case DialogInterface.BUTTON_POSITIVE:
                                        startButton.performClick();
                                        break;

                                    case DialogInterface.BUTTON_NEGATIVE:
                                        finish();
                                        break;
                                }
                            }
                        };

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Game Over").setPositiveButton("Play again?", dialogClickListener)
                                .setNegativeButton("Exit?", dialogClickListener).show();
                    }

                }
            }, 2000);
        }
        count++;
    }








    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //timerLabel = findViewById(R.id.time);
        startButton = findViewById(R.id.start);
        final Chronometer chronometer = (Chronometer)findViewById(R.id.ChoTimer);
        image1= (ImageView) findViewById(R.id.image1);
        image2= (ImageView) findViewById(R.id.image2);
        image3= (ImageView) findViewById(R.id.image3);
        image4= (ImageView) findViewById(R.id.image4);
        image5= (ImageView) findViewById(R.id.image5);
        image6= (ImageView) findViewById(R.id.image6);
        image7= (ImageView) findViewById(R.id.image7);
        image8= (ImageView) findViewById(R.id.image8);
        image9= (ImageView) findViewById(R.id.image9);
        image10= (ImageView) findViewById(R.id.image10);
        image11= (ImageView) findViewById(R.id.image11);
        image12= (ImageView) findViewById(R.id.image12);
        scoreTextView= (TextView) findViewById(R.id.score);
        final ImageView[] imagesArray1={image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12};
        shuffleArray(pictures);
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0);

//            myMediaPlayer.start();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFlag=true;
                long systemCurrTime = SystemClock.elapsedRealtime();
                chronometer.setBase(systemCurrTime);
                chronometer.start();
                shuffleArray(pictures);
                image1.setImageResource(R.drawable.marvel);
                image2.setImageResource(R.drawable.marvel);
                image3.setImageResource(R.drawable.marvel);
                image4.setImageResource(R.drawable.marvel);
                image5.setImageResource(R.drawable.marvel);
                image6.setImageResource(R.drawable.marvel);
                image7.setImageResource(R.drawable.marvel);
                image8.setImageResource(R.drawable.marvel);
                image9.setImageResource(R.drawable.marvel);
                image10.setImageResource(R.drawable.marvel);
                image11.setImageResource(R.drawable.marvel);
                image12.setImageResource(R.drawable.marvel);

                image1.setVisibility(View.VISIBLE);
                image2.setVisibility(View.VISIBLE);
                image3.setVisibility(View.VISIBLE);
                image4.setVisibility(View.VISIBLE);
                image5.setVisibility(View.VISIBLE);
                image6.setVisibility(View.VISIBLE);
                image7.setVisibility(View.VISIBLE);
                image8.setVisibility(View.VISIBLE);
                image9.setVisibility(View.VISIBLE);
                image10.setVisibility(View.VISIBLE);
                image11.setVisibility(View.VISIBLE);
                image12.setVisibility(View.VISIBLE);
                score =0;
                scoreTextView.setText(score+"");
                count=0;
            }
        });


        image1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (startFlag && count<2) {
                    putImage(image1, 0);


                }
            }

        });

        image2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (startFlag && count<2) {
                    putImage(image2, 1);


                }
            }

        });
        image3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (startFlag && count<2) {
                    putImage(image3, 2);
                                   }
            }

        });
        image4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (startFlag && count<2) {
                    putImage(image4, 3);


                }
            }

        });
        image5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (startFlag && count<2) {
                    putImage(image5, 4);


                }
            }

        });
        image6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (startFlag && count<2) {
                    putImage(image6, 5);


                }
            }

        });
        image7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (startFlag && count<2) {
                    putImage(image7, 6);
                }
            }

        });
        image8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (startFlag && count<2) {
                    putImage(image8, 7);

                }
            }

        });
        image9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (startFlag && count<2) {
                    putImage(image9, 8);


                }
            }

        });
        image10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (startFlag && count<2) {
                    putImage(image10, 9);

                }
            }

        });
        image11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (startFlag && count<2) {
                    putImage(image11, 10);

                }
            }

        });
        image12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (startFlag && count<2) {
                    putImage(image12, 11);

                }
            }

        });





    }



    }

