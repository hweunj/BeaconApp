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

public class HospitalActivity extends AppCompatActivity {

    ImageButton btn;
    ImageButton randomBtn;
    ListView m_ListView;
    CustomAdapter m_Adapter;
    int file1, file2, file3, file4, file5, file6, file7, file8;
    MediaPlayer mp;
    int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        randomBtn = (ImageButton) findViewById(R.id.randomBtn);
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
        m_ListView = (ListView) findViewById(R.id.hosListView);

        // ListView에 어댑터 연결
        m_ListView.setAdapter(m_Adapter);

        random = (int) (Math.random() * 10);
        makeList();


    }

    void makeList() {
        m_Adapter.notifyDataSetChanged();
        switch (random) {
            case 0:
                m_Adapter.add("Hello. This is Mayo Clinic. How may I help you?" + "\n" + "어서오세요. 메이요 클리닉입니다. 무엇을 도와드릴까요?", 0);
                m_Adapter.add("I'd like to make an appointment with Dr.James at 10 o'clock on Monday." + "\n" + "제임스 선생님께 월요일 10시에 예약하고 싶습니다.", 1);
                m_Adapter.add("Wait a minute. I'm sorry. The doctor is booked up that day." + "\n" + "잠시만 기다려주세요. 죄송해요. 그날은 예약이 다 찼어요.", 0);
                m_Adapter.add("What about other days?" + "\n" + "다른 날은 어때요?", 1);
                m_Adapter.add("Are you available at 10 o'clock on Tuesday" + "\n" + "화요일 10시는 어떠세요?", 0);
                m_Adapter.add("Yes, I'm available." + "\n" + "네. 가능해요", 1);
                file1 = R.raw.hos01_01;
                file2 = R.raw.hos01_02;
                file3 = R.raw.hos01_03;
                file4 = R.raw.hos01_04;
                file5 = R.raw.hos01_05;
                file6 = R.raw.hos01_06;
                break;
            case 1:
                m_Adapter.add("I've come to receive treatment." + "\n" + "진료 받으러 왔어요.", 1);
                m_Adapter.add("Of course, did you make an appointment?" + "\n" + "어서오세요. 예약하셨나요?", 0);
                m_Adapter.add("No, I didn't." + "\n" + "아니요.", 1);
                m_Adapter.add("Would you give me your health insurance card?" + "\n" + "보험증을 주시겠어요?", 0);
                m_Adapter.add("Here it is." + "\n" + "여기있어요.", 1);
                m_Adapter.add("Please wait here until we call your name." + "\n" + "이름을 부를 때까지 기다려주세요.", 0);
                file1 = R.raw.hos02_01;
                file2 = R.raw.hos02_02;
                file3 = R.raw.hos02_03;
                file4 = R.raw.hos02_04;
                file5 = R.raw.hos02_05;
                file6 = R.raw.hos02_06;
                break;
            case 2:
                m_Adapter.add("What's the matter?" + "\n" + "어디가 아프세요?", 0);
                m_Adapter.add("I have a stomachache." + "\n" + "배가 아파요.", 1);
                m_Adapter.add("When did it start hurting?" + "\n" + "언제부터 아프셨어요?", 0);
                m_Adapter.add("Since I had lunch yesterday." + "\n" + "어제 점심 먹은 후부터요.", 1);
                m_Adapter.add("What did you have for lunch?" + "\n" + "점심으로 무엇을 드셨어요?", 0);
                m_Adapter.add("I had steak." + "\n" + "스테이크를 먹었어요.", 1);
                m_Adapter.add("Is it only your stomach that aches?" + "\n" + "배만 아프신가요?", 0);
                m_Adapter.add("No, I have diarrhea, too." + "\n" + "아니요. 설사도 해요.", 1);
                file1 = R.raw.hos03_01;
                file2 = R.raw.hos03_02;
                file3 = R.raw.hos03_03;
                file4 = R.raw.hos03_04;
                file5 = R.raw.hos03_05;
                file6 = R.raw.hos03_06;
                file7 = R.raw.hos03_07;
                file8 = R.raw.hos03_08;
                break;
            case 3:
                m_Adapter.add("Does it hurt when I touch here?" + "\n" + "여기를 누르면 아프세요?", 0);
                m_Adapter.add("Yes, it hurts." + "\n" + "네. 아파요.", 1);
                m_Adapter.add("How does it hurt?" + "\n" + "어떻게 아프세요?", 0);
                m_Adapter.add("It feels like stabbing needles each time you press." + "\n" + "누를 때마다 바늘로 찌르는 듯이 아파요.", 1);
                file1 = R.raw.hos04_01;
                file2 = R.raw.hos04_02;
                file3 = R.raw.hos04_03;
                file4 = R.raw.hos04_04;
                break;

            case 4:
                m_Adapter.add("I'll write you a prescription." + "\n" + "처방전 써드릴게요.", 0);
                m_Adapter.add("Okay" + "\n" + "네.", 1);
                m_Adapter.add("Do you have any allergies?" + "\n" + "혹시 알레르기가 있나요?", 0);
                m_Adapter.add("No, I don't." + "\n" + "아니요. 없어요.", 1);
                m_Adapter.add("We're going to give you a shot, too." + "\n" + "주사도 한 대 놔드릴게요.", 0);
                m_Adapter.add("OK. When should I come back?" + "\n" + "네. 언제 다시 오면 될까요?", 1);
                m_Adapter.add("Please come back in three days." + "\n" + "3일 뒤에 다시 오세요.", 0);
                file1 = R.raw.hos05_01;
                file2 = R.raw.hos05_02;
                file3 = R.raw.hos05_03;
                file4 = R.raw.hos05_04;
                file5 = R.raw.hos05_05;
                file6 = R.raw.hos05_06;
                file7 = R.raw.hos05_07;
                break;
            case 5:
                m_Adapter.add("What did your doctor say?" + "\n" + "의사선생님이 뭐라고 하셔?", 1);
                m_Adapter.add("He said I had acute appendicitis." + "\n" + "급성 맹장염이래.", 0);
                m_Adapter.add("When will you be discharged?" + "\n" + "언제 퇴원하니?", 1);
                m_Adapter.add("Sunday." + "\n" + "일요일에 퇴원해.", 0);
                m_Adapter.add("Take good care of yourself." + "\n" + "몸조리 잘하렴.", 1);
                m_Adapter.add("Thank you for visiting me." + "\n" + "와줘서 고마워.", 0);
                file1 = R.raw.hos06_01;
                file2 = R.raw.hos06_02;
                file3 = R.raw.hos06_03;
                file4 = R.raw.hos06_04;
                file5 = R.raw.hos06_05;
                break;
            case 6:
                m_Adapter.add("How many pills do I have to take a day?" + "\n" + "하루에 몇 알씩 먹어야하죠?", 1);
                m_Adapter.add("Take one three times a day." + "\n" + "한알씩 하루에 세 번 드세요.", 0);
                m_Adapter.add("Are there any side effects?" + "\n" + "부작용이 있나요?", 1);
                m_Adapter.add("You might feel sleepy." + "\n" + "졸릴 수 있어요.", 0);
                file1 = R.raw.hos07_01;
                file2 = R.raw.hos07_02;
                file3 = R.raw.hos07_03;
                file4 = R.raw.hos07_04;
                break;

            case 7:
                m_Adapter.add("Do you have any medication for a cold?" + "\n" + "감기약 있나요?", 1);
                m_Adapter.add("Sure, how much do you need?" + "\n" + "네, 얼마나 필요하세요?", 0);
                m_Adapter.add("I need enough for two people." + "\n" + "두 사람분 주세요.", 1);
                file1 = R.raw.hos08_01;
                file2 = R.raw.hos08_02;
                file3 = R.raw.hos08_03;
                break;

            case 8:
                m_Adapter.add("I think my leg is broken" + "\n" + "저 다리가 부러진 것 같아요.", 1);
                m_Adapter.add("Lie down here. How did you hurt yourself?" + "\n" + "여기 누우세요. 어디서 다치셨어요?", 0);
                m_Adapter.add("I slipped on the stairs." + "\n" + "계단에서 미끄러졌어요...", 1);
                m_Adapter.add("Does it hurt here?" + "\n" + "여기가 아프세요?", 0);
                m_Adapter.add("Yes, it hurts so much!" + "\n" + "네, 거기가 너무 아파요!", 1);
                m_Adapter.add("Let's get it X-rayed." + "\n" + "엑스레이를 찍어봐야겠어요.", 0);
                file1 = R.raw.hos09_01;
                file2 = R.raw.hos09_02;
                file3 = R.raw.hos09_03;
                file4 = R.raw.hos09_04;
                file5 = R.raw.hos09_05;
                file6 = R.raw.hos09_06;
                break;

            case 9:
                m_Adapter.add("I can't chew because I have a toothache." + "\n" + "치통이 있어서 씹을 수가 없어요.", 1);
                m_Adapter.add("Open your mouth wide. You have a cavity on your upper right side." + "\n" + "입을 크게 벌려보세요. 오른쪽 위에 충치가 있네요.", 0);
                m_Adapter.add("Please treat it now." + "\n" + "지금 바로 치료해주세요", 1);
                m_Adapter.add("Okay. Let me put you under anesthesia first." + "\n" + "네, 마취부터 할게요.", 0);
                file1 = R.raw.hos10_01;
                file2 = R.raw.hos10_02;
                file3 = R.raw.hos10_03;
                file4 = R.raw.hos10_04;
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

                    case 6:
                        mp = MediaPlayer.create(
                                getApplicationContext(), // 현재 화면의 제어권자
                                file7); // 음악파일
                        mp.setLooping(false); // true:무한반복
                        mp.start(); // 노래 재생 시작
                        break;

                    case 7:
                        mp = MediaPlayer.create(
                                getApplicationContext(), // 현재 화면의 제어권자
                                file8); // 음악파일
                        mp.setLooping(false); // true:무한반복
                        mp.start(); // 노래 재생 시작
                        break;

                }


            }
        });

    }

}

