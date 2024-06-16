/*
* 프로그램 제목: 축구 퀴즈 맞추기(QuizApp)
* 학번: 2019111672
* 이름: 김규민
* 작성 날짜(최종 수정일): 23-12-24
* */

package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // activity_main.xml 화면에 표시
        setContentView(R.layout.activity_main);

    }

    /*
     * main_btn 메소드:
     * 버튼 클릭 이벤트 처리하는 메소드
     */
    public void main_btn(View view) {
        int viewId = view.getId();

        if (viewId == R.id.btn_play) {
            // quizActivity로 이동하는 인텐트 생성, 실행
            startActivity(new Intent(MainActivity.this, quizActivity.class));
        } else if (viewId == R.id.btn_exit) {
            // 현재 액티비티 종료, 앱 완전히 종료
            this.finishAffinity();
        }
    }

}