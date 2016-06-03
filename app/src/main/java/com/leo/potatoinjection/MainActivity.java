package com.leo.potatoinjection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.leo.potato.Potato;
import com.leo.potato.PotatoInjection;

public class MainActivity extends AppCompatActivity {

    @PotatoInjection(idStr = "text")
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Potato.initInjection(this);
        text.setText("1234");
    }
}
