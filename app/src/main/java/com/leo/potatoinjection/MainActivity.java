package com.leo.potatoinjection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.leo.potato.Potato;
import com.leo.potato.PotatoInjection;

public class MainActivity extends AppCompatActivity {

    @PotatoInjection(idStr = "text",click = "textViewClick")
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Potato.initInjection(this);
        text.setText("1234");
    }
    void textViewClick(View v){
        Toast.makeText(MainActivity.this, "123", Toast.LENGTH_SHORT).show();
    }
}
