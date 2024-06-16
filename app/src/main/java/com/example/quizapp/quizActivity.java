package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class quizActivity extends AppCompatActivity {
    // 퀴즈에 사용될 데이터 배열
    String[] question_list = {"손흥민 선수의 소속팀은?",
            "이강인 선수의 소속팀은?","저번 시즌 트레블을 달성한 팀은?"
            ,"다음 중 옳지 않은 리그명은?",
           "2023 발롱도르 수상자는?"
    };
    String[] choose_list = {"리버풀","토트넘","바이에른 뮌헨","도르트문트",
            "맨체스터 시티","바이에른 뮌헨","레알 마드리드","파리 생제르맹",
            "레알 마드리드","아스날","맨체스터 시티","FC 바르셀로나",
            "프리미어 리그","라기가","분데스리가","리그앙",
            "리오넬 메시","킬리안 음바페","카림 벤제마","크리스티아누 호날두"
    };
    String[] correct_list = {"토트넘","파리 생제르맹","맨체스터 시티","라기가","리오넬 메시"};


    TextView cpt_question , text_question;
    Button btn_choose1 , btn_choose2 , btn_choose3 , btn_choose4 , btn_next;


    int currentQuestion =  0  ;
    int scorePlayer =  0  ;
    boolean isclickBtn = false;
    String valueChoose = "";
    Button btn_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        cpt_question = findViewById(R.id.cpt_question);
        text_question = findViewById(R.id.text_question);

        btn_choose1 = findViewById(R.id.btn_choose1);
        btn_choose2 = findViewById(R.id.btn_choose2);
        btn_choose3 = findViewById(R.id.btn_choose3);
        btn_choose4 = findViewById(R.id.btn_choose4);
        btn_next = findViewById(R.id.btn_next);

        // 퀴즈 데이터 로드, '다음' 버튼 클릭 이벤트 설정
        loadData();
        btn_next.setOnClickListener(
                view -> {
                        if (isclickBtn){
                            isclickBtn = false;

                            // 선택한 답이 정답과 일치하는지 확인 후, Toast 메세지 표시
                            if(!valueChoose.equals(correct_list[currentQuestion])){
                                Toast.makeText(quizActivity.this , "오답입니다.",Toast.LENGTH_LONG).show();
                                btn_click.setBackgroundResource(R.drawable.background_btn_wrong);

                            }else {
                                Toast.makeText(quizActivity.this , "정답입니다!",Toast.LENGTH_LONG).show();
                                btn_click.setBackgroundResource(R.drawable.background_btn_correct);

                                scorePlayer++;
                            }
                            // 일정 시간(1초; 1000ms) 후에 다음 퀴즈로 이동 또는 퀴즈 종료
                            new Handler().postDelayed(() -> {
                                if(currentQuestion!=question_list.length-1){
                                    currentQuestion = currentQuestion + 1;
                                    loadData();
                                    valueChoose = "";
                                    btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);

                                }else {
                                    // 퀴즈가 모두 끝나면 점수를 담아 ScoreActivity로 이동
                                    Intent intent  = new Intent(quizActivity.this , ScoreActivity.class);
                                    intent.putExtra("Score" , scorePlayer);
                                    startActivity(intent);
                                    finish();
                                }

                            },1000);

                        }else {
                            Toast.makeText(quizActivity.this ,  "하나의 보기만 선택하세요.",Toast.LENGTH_LONG).show();
                        }
                }
        );


    }

    // 퀴즈 데이터 로드 메소드
    void loadData(){
        cpt_question.setText((currentQuestion+1) + "/" + question_list.length);
        text_question.setText(question_list[currentQuestion]);

        btn_choose1.setText(choose_list[4 * currentQuestion]);
        btn_choose2.setText(choose_list[4 * currentQuestion+1]);
        btn_choose3.setText(choose_list[4 * currentQuestion+2]);
        btn_choose4.setText(choose_list[4 * currentQuestion+3]);

    }

    // 퀴즈 보기 버튼을 클릭 시 호출되는 메소드
    public void ClickChoose(View view) {
        btn_click = (Button)view;

        if (isclickBtn) {
            btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);
        }
        chooseBtn();


    }
    void chooseBtn(){

        btn_click.setBackgroundResource(R.drawable.background_btn_choose_color);
        isclickBtn = true;
        valueChoose = btn_click.getText().toString();
    }
}