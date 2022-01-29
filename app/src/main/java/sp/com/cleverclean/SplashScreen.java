package sp.com.cleverclean;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import sp.com.cleverclean.ui.home.HomeFragment;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    MediaPlayer mySong;
    ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager
                .LayoutParams
                .FLAG_FULLSCREEN, WindowManager
                .LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        icon = findViewById(R.id.imageView);
        icon.setImageResource(R.drawable.images);
        mySong=MediaPlayer.create(SplashScreen.this,R.raw.music);
        mySong.start();
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }

        },SPLASH_TIME_OUT);
    }

    protected void onPause(){
        super.onPause();
        mySong.release();
        finish();
    }
}