package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    TextView textView ;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

        // MainActivity에서 전달한 점수를 get
        int score = getIntent().getIntExtra("Score",0);
        textView.setText("점수 : " + score + " 점");

        setScoreImage(score);

        // '다시 시작' 버튼 클릭 시
        findViewById(R.id.btn_restart).setOnClickListener(
                restart->{
                    Intent intent  = new Intent(ScoreActivity.this , MainActivity.class);
                    startActivity(intent);
                    finish();
                }
        );
    }

    // 점수에 따라 이미지 설정
    private void setScoreImage(int score) {
        if (score == 5) {
            imageView.setImageResource(R.drawable.excellent); // 5점이면 excellent
        } else if (score >= 3) {
            imageView.setImageResource(R.drawable.good); // 3~4점이면 good
        } else {
            imageView.setImageResource(R.drawable.bad); // 1~2점이면 bad
        }
    }
}