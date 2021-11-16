package com.example.fortuneteller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Fortune fortune;
    TextView jokeView;
    Button jokeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JokeManager jm = new JokeManager();
        jokeButton = findViewById(R.id.jokeButton);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            fortune = jm.GetFortune();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    jokeView.setText(fortune.fortune);
                                }
                            });
                        }
                });
                thread.start();
            }
        });
        jokeView = findViewById(R.id.jokeView);


    }
}