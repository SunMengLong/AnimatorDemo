package com.menglong.animatordemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.menglong.animatordemo.R;

public class BaseActivity extends Activity {

    private ImageView title_back;
    private TextView title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_base);
    }

    public void initTitle(String title){
        title_back = (ImageView) findViewById(R.id.title_back);
        title_text = (TextView) findViewById(R.id.title_text);
        title_text.setText(title);
        title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
