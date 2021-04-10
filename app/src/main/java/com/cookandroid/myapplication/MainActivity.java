package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// 안드로이드 어플리케이션은 Activity, BroadCastReceiver, Content Provider, Service 총 4가지의 부품으로 구성되어 있다.
public class MainActivity extends AppCompatActivity {

    EditText et_id;
//    Button btn_test;
    ImageView test;

    private Button btn_move;
    private EditText et_test;
    private String str;
    private ListView list;
     EditText et_save;
     String shared = "file";

    private SwitchCompat sc_save;
    private String sharedSwitch;
    private Button custom_move;
    private Button camera_move;
    private Button recyclerView_move;
    private Button fragment_move;
    private Button thread_move;
    private Button dialog_move;
    private Button service_move;
    private Button spinner_move;
    private Button musicPlayer_move;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Activity가 실행되면 가장 먼저 onCreate 메소드가 호출된다.

        super.onCreate(savedInstanceState); // 상위 클래스의 onCreate 메소드를 먼저 호출하고 오버라이드된 메서드를 처리한다는 뜻이다.
        setContentView(R.layout.activity_main);

        init();

        buttonMove();
        clickImage();
        adapt();
        textSharedPreferences();
        switchSharedPreferences();

//        et_id = findViewById(R.id.et_id);
//        btn_test = findViewById(R.id.btn_test);
//
//        btn_test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                et_id.setText("김정우");
//            }
//        });

//        String jung = "정우";
//        Log.e("MainActivity : ", jung); // Log.e Log.d 활용하기
    }

    private void switchSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(sharedSwitch, 0);
        Boolean checked = sharedPreferences.getBoolean("kim", false); // 아무 값도 들어있지 않으면 false를 반환한다.
        sc_save.setChecked(checked);
    }

    private void textSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("jung", ""); // 아무 값도 들어 있지 않으면 ""를 반환하는 것
        System.out.println("값체크"+value);
        et_save.setText(value);
    }

    @Override
    protected void onDestroy() { // 앱을 종료를 시켰을 때, 엑티비티를 벗어났을때, onDestroy가 호출된다.
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString(); // 현재 et_save에 써져 있는 값을 가져온다.
        editor.putString("jung", value);
        editor.commit(); // 실제적인 세이브

        SharedPreferences sharedPreferences2 = getSharedPreferences(sharedSwitch, 0);
        SharedPreferences.Editor editor2 = sharedPreferences2.edit();
        Boolean checked = sc_save.isChecked();
        editor2.putBoolean("kim", checked);
        editor2.commit(); // 실제적인 세이브
    }

    private void adapt() {
        List<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);
        data.add("정우");
        data.add("안드로이드");
        data.add("사과");
        adapter.notifyDataSetChanged();
    }

    private void init() {
        et_test = findViewById(R.id.et_test);
        btn_move = findViewById(R.id.btn_move);
        list = (ListView)findViewById(R.id.list);
        test = (ImageView)findViewById(R.id.test);
        et_save = (EditText)findViewById(R.id.et_save);
        sc_save =(SwitchCompat)findViewById(R.id.sc_save);
        custom_move = findViewById(R.id.custom_move);
        camera_move = findViewById(R.id.camera_move);
        recyclerView_move = findViewById(R.id.recyclerView_move);
        fragment_move = findViewById(R.id.fragment_move);
        thread_move = findViewById(R.id.thread_move);
        dialog_move = findViewById(R.id.dialog_move);
        service_move = findViewById(R.id.service_move);
        spinner_move = findViewById(R.id.spinner_move);
        musicPlayer_move = findViewById(R.id.musicPlayer_move);
    }

    private void buttonMove() {
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Intent intent = new Intent(MainActivity.this, SubActivity.class);
                  str = et_test.getText().toString();
                  intent.putExtra("str", str);
                  startActivity(intent); // 액티비티 이동
            }
        });

        custom_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NavigateMenuCustom.class);
                startActivity(intent); // 액티비티 이동
            }
        });

        camera_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Camera.class);
                startActivity(intent); // 액티비티 이동
            }
        });

        recyclerView_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyRecyclerView.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        fragment_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Fragment.class);
                startActivity(intent); // 액티비티 이동
            }
        });

        thread_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThreadExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        service_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ServiceExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        dialog_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        spinner_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SpinnerExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        musicPlayer_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MusicPlayerExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
    }

    private void clickImage() {
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "김정우짱", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
