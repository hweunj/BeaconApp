package com.sungshinspeaking123.a1.newspeaking;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

/**
 * Created by 1 on 2017-08-23.
 */

public class SchoolActivity extends AppCompatActivity {
    ImageButton btn;
    ImageButton randomBtn;
    ListView m_ListView;
    CustomAdapter m_Adapter;
    int file1, file2, file3, file4, file5, file6;
    MediaPlayer mp;
    int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        randomBtn = (ImageButton) findViewById(R.id.randomBtn1);
        randomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m_Adapter.clear();
                random = (int) (Math.random() * 10);
                makeList();
            }
        });

        btn = (ImageButton) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

            m_Adapter = new CustomAdapter();

            // Xml에서 추가한 ListView 연결
            m_ListView = (ListView) findViewById(R.id.SchoolListview);

            // ListView에 어댑터 연결
            m_ListView.setAdapter(m_Adapter);

        random = (int) (Math.random() * 10);
        makeList();
    }

    void makeList() {
        m_Adapter.notifyDataSetChanged();
        switch (random ){
            case 0:
                m_Adapter.add("Professor, I have to ask you something. " +  "\n" + "교수님. 질문이 있습니다.", 1);
                m_Adapter.add("Yes, what is it? "+  "\n" + "네. 무엇이죠?", 0);
                m_Adapter.add("What is my grade for this semester ?"+  "\n" + "저의 이번학기 성적이 어떻게 됩니까?", 1);
                m_Adapter.add("You got a B+"+"\n"+" B+입니다.", 0);
                m_Adapter.add("Can I ask you what the criteria is? "+"\n"+"평가기준이 어떻게 되는지 여쭈어도 되겠습니까?", 1);
                m_Adapter.add("It's based on your assignments and test scores. "+"\n"+"  평가기준은 과제와 시험성적입니다.", 0);
                file1 = R.raw.school01_01;
                file2 = R.raw.school01_02;
                file3 = R.raw.school01_03;
                file4 = R.raw.school01_04;
                file5 = R.raw.school01_05;
                file6 = R.raw.school01_06;
                break;
            case 1:
                m_Adapter.add(" How was the test?" +"\n"+"시험 잘 봤니?", 1);
                m_Adapter.add("It was OK." + "\n"+"응 괜찮았어.", 0);
                m_Adapter.add(" Were the questions what you expected?" +"\n"+"너가 예상한 문제가 나왔어?", 1);
                m_Adapter.add("Yes, but I think I made a mistake on question number four." + "\n"+"응. 하지만 4번문제는 실수한 것 같아.", 0);
                file1 = R.raw.school02_01;
                file2 = R.raw.school02_02;
                file3 = R.raw.school02_03;
                file4 = R.raw.school02_04;
                break;
            case 2:
                m_Adapter.add("Next week is finals. What does it cover?" +"\n"+ "다음주가 기말시험이야. 시험범위가 어떻게 되지?", 1);
                m_Adapter.add("The whole text."+"\n"+"교재 전부야.", 0);
                m_Adapter.add("This exam is going to be hard."+"\n"+"이번 시험은 어렵겠다.", 1);
                m_Adapter.add("Yeah, I'm going to be up all night preparing for the exam."+"\n"+" 준비하려면 밤새야 할 거야.", 0);
                file1 = R.raw.school03_01;
                file2 = R.raw.school03_02;
                file3 = R.raw.school03_03;
                file4 = R.raw.school03_04;
                break;

            case 3:
                m_Adapter.add("When is this assignment due?"+"\n"+"과제 제출기한이 언제까지 입니까?", 1);
                m_Adapter.add("Turn it in by this Friday"+"\n"+"금요일까지 제출하세요.", 0);
                m_Adapter.add("How long should it be?"+"\n"+"분량은 어느정도로 해야 합니까?", 1);
                m_Adapter.add("About five pages."+"\n"+"다섯장 정도로 하세요.", 0);
                file1 = R.raw.school04_01;
                file2 = R.raw.school04_02;
                file3 = R.raw.school04_03;
                file4 = R.raw.school04_04;
                break;
            case 4:
                m_Adapter.add(" How many classes are you taking this semester?"+"\n"+"이번학기에 몇과목 들어?", 1);
                m_Adapter.add("I'm taking five classes."+"\n"+"나는 다섯과목 들어.", 0);
                m_Adapter.add("How many electives are you taking?"+"\n"+"교양과목은 몇 개 들어?", 1);
                m_Adapter.add(" I can only take one elective this semester."+"\n"+"난 이번 학기에 교양과목 한 개만 들을 수 있어.", 0);
                file1 = R.raw.school05_01;
                file2 = R.raw.school05_02;
                file3 = R.raw.school05_03;
                file4 = R.raw.school05_04;
                break;
            case 5:
                m_Adapter.add("I'm taking a roll call now. Lee Young-Hee."+"\n"+"출석부를게요. 이영희?", 0);
                m_Adapter.add("Present."+"\n"+"여기요.", 1);
                m_Adapter.add("Where did we get up to last time?"+"\n"+"지난번에 어디까지 했죠?", 0);
                m_Adapter.add("We were at page 24."+"\n"+"24쪽까지 했습니다.", 1);
                m_Adapter.add("Open your books, then."+"\n"+"그럼 책을 펴세요.", 0);
                file1 = R.raw.school06_01;
                file2 = R.raw.school06_02;
                file3 = R.raw.school06_03;
                file4 = R.raw.school06_04;
                file5 = R.raw.school06_05;
                break;
            case 6:
                m_Adapter.add("Can you find this book for me?"+"\n"+"이 책좀 찾아주시겠어요?", 1);
                m_Adapter.add("Just a minute. It's is in the reading room on the second floor."+"\n"+"잠시만요. 그 책은 2층에 있어요.", 0);
                m_Adapter.add("Thank you."+"\n"+"감사합니다.", 1);
                file1 = R.raw.school07_01;
                file2 = R.raw.school07_02;
                file3 = R.raw.school07_03;
                break;
            case 7:
                m_Adapter.add("I'd like to check this book out."+"\n"+" 이 책을 빌리고 싶은데요.", 1);
                m_Adapter.add("Do you have a library card?"+"\n"+"도서관 회원증이 있나요?", 0);
                m_Adapter.add("Yes, here it is."+"\n"+"네 여기요", 1);
                m_Adapter.add("Here you are. It is due by April the 11th."+"\n"+"여기있습니다. 4월 11일까지 반납해주세요.", 0);
                file1 = R.raw.school08_01;
                file2 = R.raw.school08_02;
                file3 = R.raw.school08_03;
                file4 = R.raw.school08_04;
                break;
            case 8:
                m_Adapter.add("I'm looking for The Iliad."+"\n"+"일리아드라는 책을 찾고있어요.", 1);
                m_Adapter.add("Just a minute. I'm sorry. They're all out."+"\n"+"잠시만요. 죄송하지만 빌릴 수 있는 책이 없네요.", 0);
                m_Adapter.add("Can you put me on the waiting list?"+"\n"+"예약을 할 수 있을까요?", 1);
                file1 = R.raw.school09_01;
                file2 = R.raw.school09_02;
                file3 = R.raw.school09_03;
                break;
            case 9:
                m_Adapter.add("When do I have to return it?"+"\n"+"언제까지 반납해야 하죠?", 1);
                m_Adapter.add("It is due by April the 11th."+"\n"+"반납일은 4월 11일까지입니다.", 0);
                m_Adapter.add("Is there a late fine? Can I renew it?"+"\n"+" 연체하면 벌금이 있나요? 연장할 수 있을까요?", 1);
                file1 = R.raw.school10_01;
                file2 = R.raw.school10_02;
                file3 = R.raw.school10_03;
                break;

        }
        m_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mp = MediaPlayer.create(
                                getApplicationContext(), // 현재 화면의 제어권자
                                file1); // 음악파일
                        mp.setLooping(false); // true:무한반복
                        mp.start(); // 노래 재생 시작
                        break;

                    case 1:
                        mp = MediaPlayer.create(
                                getApplicationContext(), // 현재 화면의 제어권자
                                file2); // 음악파일
                        mp.setLooping(false); // true:무한반복
                        mp.start(); // 노래 재생 시작
                        break;

                    case 2:
                        mp = MediaPlayer.create(
                                getApplicationContext(), // 현재 화면의 제어권자
                                file3); // 음악파일
                        mp.setLooping(false); // true:무한반복
                        mp.start(); // 노래 재생 시작
                        break;

                    case 3:
                        mp = MediaPlayer.create(
                                getApplicationContext(), // 현재 화면의 제어권자
                                file4); // 음악파일
                        mp.setLooping(false); // true:무한반복
                        mp.start(); // 노래 재생 시작
                        break;

                    case 4:
                        mp = MediaPlayer.create(
                                getApplicationContext(), // 현재 화면의 제어권자
                                file5); // 음악파일
                        mp.setLooping(false); // true:무한반복
                        mp.start(); // 노래 재생 시작
                        break;

                    case 5:
                        mp = MediaPlayer.create(
                                getApplicationContext(), // 현재 화면의 제어권자
                                file6); // 음악파일
                        mp.setLooping(false); // true:무한반복
                        mp.start(); // 노래 재생 시작
                        break;

                }

            }
        });

    }
}