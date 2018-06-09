package com.menglong.animatordemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView rotate_img;
    private Animation animation;
    private Button rotate_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        rotate_img = (ImageView) findViewById(R.id.rotate_img);
        rotate_but = (Button) findViewById(R.id.rotate_but);
        rotate_but.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //xml文件实现方式
        xml();
        //代码实现方式
//        code();
    }

    private void code() {
        Animation rotate = new RotateAnimation(0f, 359f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        LinearInterpolator lin = new LinearInterpolator();
        rotate.setInterpolator(lin); //设置插值器
        rotate.setDuration(1000);//设置动画持续周期
        rotate.setRepeatCount(-1);//设置重复次数
        rotate.setFillAfter(true);//动画执行完后是否停留在执行完的状态
//        rotate.setStartOffset(1000);//执行前的等待时间  单位ms
        rotate_img.setAnimation(rotate);
        rotate_img.startAnimation(rotate);
    }

    private void xml() {
        //xml文件动画执行
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        //setInterpolator设置动画的旋转速率：LinearInterpolator为匀速
        //另：Accelerateinterpolator为加速效果、DecelerateInterpolator为减速效果、默认为开始结束慢中间快。
        LinearInterpolator lin = new LinearInterpolator();
        animation.setInterpolator(lin);
//        animation.setStartOffset(1000);//表示执行start函数后等待开始运行的时间，单位为ms。
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始回调方法
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束
                rotate_img.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重复执行
            }
        });
        rotate_img.startAnimation(animation);
    }
//当横竖屏切换且设置Activity不重新创建时，导致位置偏移的解决方法
//    @Override public void onConfigurationChanged(Configuration newConfig) { super.onConfigurationChanged(newConfig); if (operatingAnim != null && infoOperatingIV != null && operatingAnim.hasStarted()) { infoOperatingIV.clearAnimation(); infoOperatingIV.startAnimation(operatingAnim); } }

}
