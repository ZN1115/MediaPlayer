package com.example.zn.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class myMediaPlayer extends AppCompatActivity implements View.OnClickListener {

    /*如果class的名稱跟MediaPlayer()這個方法一樣的話，會找不到，解決方法有2，1是更改class的名稱，2是要android.media.MediaPlayer()*/
    private MediaPlayer mediaPlayer ;
    public Button B_player;
    private Button B_pause;
    private Button B_stop;
    private boolean isplaying =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);


        Button();

    }

    private void Button()
    {
        B_player=findViewById(R.id.B_Play);
        B_pause=findViewById(R.id.B_pause);
        B_stop=findViewById(R.id.B_stop);
        B_player.setOnClickListener(this);
        B_pause.setOnClickListener(this);
        B_stop.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();

    }

    @Override
        public void onClick(View view) {
        switch (view.getId()){
            case R.id.B_Play:
                if(isplaying)
                {
                    mediaPlayer = MediaPlayer.create(this,R.raw.whistle);
                    isplaying=false;
                }
                mediaPlayer.start();
                B_player.setEnabled(false);
                B_pause.setEnabled(true);
                B_stop.setEnabled(true);
                System.out.println(isplaying);

                break;
            case R.id.B_pause:
                mediaPlayer.pause();
                B_player.setEnabled(true);
                B_pause.setEnabled(false);
                B_stop.setEnabled(true);
                System.out.println(isplaying);
                break;
            case R.id.B_stop:
                mediaPlayer.stop();
                mediaPlayer.release();
                isplaying=true;
                B_player.setEnabled(true);
                B_pause.setEnabled(false);
                B_stop.setEnabled(false);
                System.out.println(isplaying);
                break;


        }
    }

}
