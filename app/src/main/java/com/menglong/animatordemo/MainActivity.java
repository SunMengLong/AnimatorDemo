package com.menglong.animatordemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.menglong.animatordemo.base.BaseActivity;
import com.menglong.animatordemo.rotate.RotateActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button rotate_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setView();
    }

    private void setView() {
        rotate_but.setOnClickListener(this);
    }

    private void initView() {
        rotate_but = (Button) findViewById(R.id.rotate_but);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rotate_but:
                intent(RotateActivity.class);
                break;
            default:
                break;
        }
    }

    private void intent(Class clas){
        Intent i = new Intent(this,clas);
        startActivity(i);
    }
}
