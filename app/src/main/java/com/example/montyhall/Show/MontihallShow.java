package com.example.montyhall.Show;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import com.example.montyhall.MainActivity;
import com.example.montyhall.R;

public class MontihallShow extends AppCompatActivity {
    int cnt = 0; // 말풍선이 몇 번 클릭됐는지 확인하는 변수

    ImageButton ib_door1, ib_door2, ib_door3; // 문 imagebutton
    Boolean d1, d2, d3; // 클릭 된 문 확인하기 위한 변수
    Boolean ansd1, ansd2, ansd3;
    int randomAns;
    int countclick = 0; // 문 클릭이 여러개 됐는지 확인하는 변수

    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_montihallshow);

        final TextView hostTv = findViewById(R.id.tv_host);

        ib_door1 = findViewById(R.id.iv_door1);
        ib_door1.setVisibility(View.INVISIBLE);
        ib_door2 = findViewById(R.id.iv_door2);
        ib_door2.setVisibility(View.INVISIBLE);
        ib_door3 = findViewById(R.id.iv_door3);
        ib_door3.setVisibility(View.INVISIBLE);


        d1 = false;
        d2 = false;
        d3 = false;

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        randomAns = random.nextInt(3) + 1; // 매번 1~3까지의 수를 random하게 생성
        ansd1 = ansd2 = ansd3 = false; // 모두 false로 초기화 한 후, 아래 switch문에서 실제 스포츠카가 있는 곳 선택후 true로 변경
        switch (randomAns) {
            case 1:
                ansd1 = true;
                break;
            case 2:
                ansd2 = true;
                break;
            case 3:
                ansd3 = true;
                break;
        }

        temp = "스포츠카는 " + randomAns + "번째\n문에 있었습니다!";
        /* random값이 잘 들어가는지 확인하는 코드, 계속하면서 이상 없으면 냅두기
        System.out.println("@@@" + randomAns);
        if(ansd1){
            System.out.println("@@@1번");
        }else if(ansd2){
            System.out.println("@@@2번");
        }else if(ansd3){
            System.out.println("@@@3번");
        }*/

        LinearLayout hostLl = findViewById(R.id.linearlayout_host);
        hostLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hostTv.setText("퀴즈쇼에 오신 것을\n환영합니다.");
                cnt++;
                switch (cnt) {
                    case 1:
                        hostTv.setText("먼저 퀴즈쇼에 오신\n것을 환영합니다~!");
                        break;
                    case 2:
                        hostTv.setText("이어서 몬티홀 퀴즈를\n시작하도록 하겠습니다");
                        break;
                    case 3:
                        ib_door1.setVisibility(View.VISIBLE);
                        ib_door2.setVisibility(View.VISIBLE);
                        ib_door3.setVisibility(View.VISIBLE);
                        hostTv.setText("여기 총 세 개의\n문이 있습니다.");
                        break;
                    case 4:
                        hostTv.setText("두 개의 문 안에는\n각각 염소 한마리씩이\n있고,");
                        break;
                    case 5:
                        hostTv.setText("나머지 한 문에는\n최고급 스포츠 카가\n있습니다.");
                        break;
                    case 6:
                        hostTv.setText("문을 선택하시고 안에서\n나오는 상품을 가져가시면\n되는 간단한 게임입니다.");
                        break;
                    case 7:
                        hostTv.setText("왼쪽부터 1번, 2번\n3번 문입니다.");
                        break;
                    case 8:
                        hostTv.setText("선택하려는 문을\n하나만 클릭해주세요.");

                        ib_door1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (d1) {
                                    ib_door1.setImageResource(R.drawable.door);
                                    d1 = false;
                                    countclick--;
                                } else {
                                    ib_door1.setImageResource(R.drawable.doorselect);
                                    d1 = true;
                                    countclick++;
                                }
                            }
                        });
                        ib_door2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (d2) {
                                    ib_door2.setImageResource(R.drawable.door);
                                    d2 = false;
                                    countclick--;
                                    countclick++;
                                } else {
                                    ib_door2.setImageResource(R.drawable.doorselect);
                                    d2 = true;
                                }
                            }
                        });
                        ib_door3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (d3) {
                                    ib_door3.setImageResource(R.drawable.door);
                                    d3 = false;
                                    countclick--;
                                } else {
                                    ib_door3.setImageResource(R.drawable.doorselect);
                                    d3 = true;
                                    countclick++;
                                }
                            }
                        });
                        /*if (countclick != 1 && countclick != 0) {
                            hostTv.setText("문을 하나만 선택해주세요.");
                            ib_door1.setImageResource(R.drawable.door);
                            d1 = false;
                            ib_door2.setImageResource(R.drawable.door);
                            d2 = false;
                            ib_door3.setImageResource(R.drawable.door);
                            d3 = false;
                        } else {
                            break;
                        }*/
                        break;
                    case 9:
                        if (!d1 && !ansd1) {
                            ib_door1.setImageResource(R.drawable.doorgoat);
                            hostTv.setText("1번 문에는\n염소가 있었습니다!");
                        } else if (!d2 && !ansd2) {
                            ib_door2.setImageResource(R.drawable.doorgoat);
                            hostTv.setText("2번 문에는\n염소가 있었습니다!");
                        } else if (!d3 && !ansd3) {
                            ib_door3.setImageResource(R.drawable.doorgoat);
                            hostTv.setText("3번 문에는\n염소가 있었습니다!");
                        }
                    case 10:
                        hostTv.setText("문을 바꾸시려면 다른\n문을 클릭해주세요!");
                        ib_door1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ib_door1.setImageResource(R.drawable.doorselect);
                                if (d2) {
                                    ib_door2.setImageResource(R.drawable.door);
                                } else if (d3) {
                                    ib_door3.setImageResource(R.drawable.door);
                                }
                                d1 = true;
                                d2 = false;
                                d3 = false;
                            }
                        });
                        ib_door2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ib_door2.setImageResource(R.drawable.doorselect);
                                if (d1) {
                                    ib_door1.setImageResource(R.drawable.door);
                                } else if (d3) {
                                    ib_door3.setImageResource(R.drawable.door);
                                }
                                d1 = false;
                                d2 = true;
                                d3 = false;
                            }
                        });
                        ib_door3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ib_door3.setImageResource(R.drawable.doorselect);
                                if (d2) {
                                    ib_door2.setImageResource(R.drawable.door);
                                } else if (d1) {
                                    ib_door1.setImageResource(R.drawable.door);
                                }
                                d1 = false;
                                d2 = false;
                                d3 = true;
                            }
                        });
                        break;
                    case 11:
                        hostTv.setText(temp);
                        break;
                    case 12:
                        if((d1 && ansd1)||(d2 && ansd2)||(d3 && ansd3)){ // 사용자가 고른 문과 스포츠 카가 있었던 문이 같으면 축하 메세지 출력
                            hostTv.setText("같은 문에 스포츠카가\n있네요. 축하드립니다!");
                        }else{
                            hostTv.setText("아쉽게도 다른 문에\n스포츠 카가 있었네요.");
                        }
                        break;
                    case 13:
                        hostTv.setText("그런데 잠깐! 여기서\n문을 바꾸는 것이 문을\n바꾸지 않는 것보다");
                        break;
                    case 14:
                        hostTv.setText("무려 두 배의 확률이\n높다는 것을 알고\n계셨나요?");
                        break;
                    case 15:
                        hostTv.setText("자세한 것은 다른 항목을\n통해서 알아봐요!");
                        break;
                    case 16:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }
}
