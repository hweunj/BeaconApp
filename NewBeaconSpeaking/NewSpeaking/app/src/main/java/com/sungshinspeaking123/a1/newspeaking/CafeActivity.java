package com.sungshinspeaking123.a1.newspeaking;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

/**
 * Created by 1 on 2017-08-23.
 */

public class CafeActivity extends AppCompatActivity {
    ImageButton randomBtn;
    ImageButton btn;
    ListView m_ListView;
    CustomAdapter m_Adapter;
    int file1, file2, file3, file4, file5;
    MediaPlayer mp;
    int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        randomBtn = (ImageButton) findViewById(R.id.randomBtn2);
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
        m_ListView = (ListView) findViewById(R.id.cafeListview);

        // ListView에 어댑터 연결
        m_ListView.setAdapter(m_Adapter);

        random = (int) (Math.random() * 10);
        makeList();

    }

    void makeList() {
        m_Adapter.notifyDataSetChanged();
        switch (random) {
            case 0:
                m_Adapter.add("May I take your order? " + "\n" + "뭘 드시겠어요?", 0);
                m_Adapter.add("A cup of coffee, please. " + "\n" + "커피 한 잔 주세요.", 1);
                m_Adapter.add("Hot or iced?" + "\n" + "뜨거운 것으로 드릴까요? 차가운 것으로 드릴까요?", 0);
                m_Adapter.add("With ice, please." + "\n" + "차가운 것으로 주세요.", 1);
                file1 = R.raw.cafe01_01;
                file2 = R.raw.cafe01_02;
                file3 = R.raw.cafe01_03;
                file4 = R.raw.cafe01_04;
                break;
            case 1:
                m_Adapter.add("Excuse me, could you turn the music down?" + "\n" + "실례지만, 음악이 저희 이야기에 방해됩니다.", 1);
                m_Adapter.add("Certainly." + "\n" + "네, 소리를 낮춰 드릴게요.", 0);
                file1 = R.raw.cafe02_01;
                file2 = R.raw.cafe02_02;
                break;
            case 2:
                m_Adapter.add("How much is it?" + "\n" + "얼마죠?", 1);
                m_Adapter.add("50 dollars." + "\n" + "50달러에요.", 0);
                m_Adapter.add("Do you take credit cards?" + "\n" + "신용카드도 되나요?", 1);
                m_Adapter.add("Of course. Just sign here." + "\n" + "물론이죠. 여기에 서명해 주시겠습니까?", 0);
                m_Adapter.add("All right." + "\n" + "네", 1);
                file1 = R.raw.cafe03_01;
                file2 = R.raw.cafe03_02;
                file3 = R.raw.cafe03_03;
                file4 = R.raw.cafe03_04;
                file5 = R.raw.cafe03_05;
                break;
            case 3:
                m_Adapter.add("Do you know where the restroom is?" + "\n" + "화장실은 어디에요?", 1);
                m_Adapter.add("It’s here." + "\n" + "여기 있어요", 0);
                file1 = R.raw.cafe04_01;
                file2 = R.raw.cafe04_02;
                break;

            case 4:
                m_Adapter.add("How do you like it here?" + "\n" + "여기 분위기 어때요?", 1);
                m_Adapter.add("It's nice. I love it" + "\n" + "좋아요, 무척 맘에 들어요.", 0);
                m_Adapter.add("Do you come here often?" + "\n" + "여기 자주 오세요?", 1);
                m_Adapter.add("It's my first time here, too." + "\n" + "저도 여기 처음이에요.", 0);
                file1 = R.raw.cafe05_01;
                file2 = R.raw.cafe05_02;
                file3 = R.raw.cafe05_03;
                file4 = R.raw.cafe05_04;
                break;
            case 5:
                m_Adapter.add("This cup is dirty. Could I get another one, please?" + "\n" + "컵이 지저분하네요. 다른 것으로 바꿔주시겠어요?", 1);
                m_Adapter.add("I'm sorry. I'll bring you a new one." + "\n" + "죄송합니다. 새로 가져다 드릴게요.", 0);
                file1 = R.raw.cafe06_01;
                file2 = R.raw.cafe06_02;
                break;
            case 6:
                m_Adapter.add("This isn't what I ordered." + "\n" + "이것은 제가 주문한 것이 아니에요.", 1);
                m_Adapter.add("I'm sorry. I'll get you a new order." + "\n" + "죄송합니다. 새로 준비해드릴게요.", 0);
                file1 = R.raw.cafe07_01;
                file2 = R.raw.cafe07_02;
                break;
            case 7:
                m_Adapter.add("Do you have room for two?" + "\n" + "두명 자리가 있나요?", 1);
                m_Adapter.add("I'm sorry. Do you mind waiting until we have a table?" + "\n" + "죄송합니다. 자리가 날 때까지 기다리시겠어요?", 0);
                m_Adapter.add("How long will it take?" + "\n" + "얼마나 기다려야하죠?", 1);
                m_Adapter.add("About twenty minutes." + "\n" + "아마 20분정도요.", 0);
                file1 = R.raw.cafe08_01;
                file2 = R.raw.cafe08_02;
                file3 = R.raw.cafe08_03;
                file4 = R.raw.cafe08_04;
                break;
            case 8:
                m_Adapter.add("How much do I owe you?" + "\n" + "얼마씩 내야하죠?", 1);
                m_Adapter.add("I'll get this." + "\n" + "제가 낼게요.", 0);
                m_Adapter.add("No, I insist." + "\n" + "아니요. 괜찮습니다.", 1);
                m_Adapter.add("Why don't I get this, and you can take me out next time." + "\n" + "이번에는 제가 내고, 다음에 당신이 내세요.", 0);
                m_Adapter.add("TAll right then. Thank you." + "\n" + "네, 그러죠. 덕분에 잘먹었습니다.", 1);
                file1 = R.raw.cafe09_01;
                file2 = R.raw.cafe09_02;
                file3 = R.raw.cafe09_03;
                file4 = R.raw.cafe09_04;
                file5 = R.raw.cafe09_05;
                break;
            case 9:
                m_Adapter.add("May I take your order? " + "\n" + "뭘 드시겠어요?", 0);
                m_Adapter.add("A cup of coffee, please. " + "\n" + "커피 한 잔 주세요.", 1);
                m_Adapter.add("Hot or iced?" + "\n" + "뜨거운 것으로 드릴까요? 차가운 것으로 드릴까요?", 0);
                m_Adapter.add("With ice, please." + "\n" + " 차가운 것으로 주세요.", 1);
                file1 = R.raw.cafe01_01;
                file2 = R.raw.cafe01_02;
                file3 = R.raw.cafe01_03;
                file4 = R.raw.cafe01_04;
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

                }


            }
        });

    }

}
