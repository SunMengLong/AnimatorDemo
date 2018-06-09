package com.menglong.animatordemo.translate;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.menglong.animatordemo.R;
import com.menglong.animatordemo.base.BaseActivity;

public class TranslateActivity extends BaseActivity implements View.OnClickListener {

    private ImageView translate_img;
    private Animation translateAnimation;
    private Button translate_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        initView();
    }

    private void initView() {
        super.initTitle("平移动画");
        translate_img = (ImageView) findViewById(R.id.translate_img);
        translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
//        Interpolator interpolator = new LinearInterpolator();//匀速
//        Interpolator interpolator = new AccelerateInterpolator();//先慢后快
//        Interpolator interpolator = new AnticipateInterpolator();//开始回弹效果
//        Interpolator interpolator = new BounceInterpolator();//结束回弹效果
//        Interpolator interpolator = new CycleInterpolator(2);//跳一跳效果
//        Interpolator interpolator = new OvershootInterpolator(1);//动画结束时向前弹一定距离再回到原来位置
//        Interpolator interpolator = new AccelerateDecelerateInterpolator();//系统默认的动画效果，先加速后减速
//        Interpolator interpolator = new AnticipateOvershootInterpolator();//开始之前向前甩，结束的时候向后甩
        Interpolator interpolator = new DecelerateInterpolator();//开始加速再减速
        translateAnimation.setInterpolator(interpolator);
        translate_but = (Button) findViewById(R.id.translate_but);
        translate_but.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.translate_but:
//                translate_img.startAnimation(translateAnimation);
                code();
                break;
            default:
                break;
        }
    }

    //代码实现方式
    private void code(){
        TranslateAnimation translateAnimation1 = new TranslateAnimation(0,0,0,1000);
//        使用java代码的方式创建TranslateAnimation，传入六个参数，fromXType、fromXValue、toXType、toXValue和fromYType、fromYValue、toYType、toYValue，使用如下构造方法。
//        参数说明：
//        fromXType：动画开始前的X坐标类型。取值范围为ABSOLUTE（绝对位置）、RELATIVE_TO_SELF（以自身宽或高为参考）、RELATIVE_TO_PARENT（以父控件宽或高为参考）。
//        fromXValue：动画开始前的X坐标值。当对应的Type为ABSOLUTE时，表示绝对位置；否则表示相对位置，1.0表示100%。
//        toXType：动画结束后的X坐标类型。
//        toXValue：动画结束后的X坐标值。
//        fromYType：动画开始前的Y坐标类型。
//        fromYValue：动画开始前的Y坐标值。
//        toYType：动画结束后的Y坐标类型。
//        toYValue：动画结束后的Y坐标值。
        translateAnimation1.setDuration(1000);
        translateAnimation1.setInterpolator(new DecelerateInterpolator());
        translate_img.startAnimation(translateAnimation1);
        translateAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束
                translate_img.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重复
            }
        });
    }
}
