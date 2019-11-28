package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    EditText edt_phone;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_url = findViewById(R.id.btnURL);
        Button btn_call = findViewById(R.id.btnCall);
        Button btn_camera = findViewById(R.id.btnCamera);
        Button btn_album = findViewById(R.id.btnImg);
        Button btn_map = findViewById(R.id.btnMap);
        edt_phone = findViewById(R.id.edtPhone);
        btn_url.setOnClickListener(this);
        btn_call.setOnClickListener(this);
        btn_camera.setOnClickListener(this);
        btn_album.setOnClickListener(this);
        btn_map.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnURL: //開啟google網頁
                uri= Uri.parse("http://www.google.com.tw");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
                break;
            case R.id.btnCall: //開啟撥打電話頁面
                uri =Uri.parse("tel:"+edt_phone.getText().toString());
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
                break;
            case R.id.btnCamera: //開啟相機
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                break;
            case R.id.btnImg:  //開啟相簿
                intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, 0);

                break;
            case R.id.btnMap: //開啟地圖
                uri = Uri.parse("geo:24.948436, 121.229220");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
        }
    }
}
