package com.daimajia.androidanimations;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BaseInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyActivity extends Activity {

    private ListView mListView;

    private EffectAdapter mAdapter;

    private TextView mTarget;

    private YoYo.YoYoString rope;


    private List<BaseInterpolator> baseInterpolators;


    public List<BaseInterpolator> getBaseInterpolators() {
        List<BaseInterpolator> baseInterpolators = new ArrayList<>();

        baseInterpolators.add(new AccelerateDecelerateInterpolator());
        baseInterpolators.add(new AccelerateInterpolator());
        baseInterpolators.add(new AnticipateInterpolator());
        baseInterpolators.add(new AnticipateOvershootInterpolator());
        baseInterpolators.add(new BounceInterpolator());
        baseInterpolators.add(new CycleInterpolator(3f));
        baseInterpolators.add(new DecelerateInterpolator());
        baseInterpolators.add(new LinearInterpolator());
        baseInterpolators.add(new OvershootInterpolator());

        return baseInterpolators;

    }


    /**
     * Interpolator插值器
     * <p>
     * AccelerateDecelerateInterpolator   在动画开始与介绍的地方速率改变比较慢，在中间的时候加速
     * AccelerateInterpolator                     在动画开始的地方速率改变比较慢，然后开始加速
     * AnticipateInterpolator                      开始的时候向后然后向前甩
     * AnticipateOvershootInterpolator     开始的时候向后然后向前甩一定值后返回最后的值
     * BounceInterpolator                          动画结束的时候弹起
     * CycleInterpolator                             动画循环播放特定的次数，速率改变沿着正弦曲线
     * DecelerateInterpolator                    在动画开始的地方快然后慢
     * LinearInterpolator                            以常量速率改变
     * OvershootInterpolator                      向前甩一定值后再回到原来位置
     *
     * @param savedInstanceState
     * @return
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mListView = (ListView) findViewById(R.id.list_items);
        mTarget = (TextView) findViewById(R.id.hello_world);
        mAdapter = new EffectAdapter(this);
        mListView.setAdapter(mAdapter);

        baseInterpolators = getBaseInterpolators();

        rope = YoYo.with(Techniques.FadeIn).duration(50000).playOn(mTarget);// after start,just click mTarget view, rope is not init

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Techniques technique = (Techniques) view.getTag();

                Random random = new Random();
                int result = random.nextInt(10) + 1;
                BaseInterpolator interpolator = baseInterpolators.get(((position + 1) * result - 3) % 9);
                mTarget.setText(technique.getClass().getSimpleName() + "~~~~" + interpolator.getClass().getSimpleName());

                rope = YoYo.with(technique)
                        .duration(5000)
                        .interpolate(interpolator)
                        .withListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {

                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {
                                Toast.makeText(MyActivity.this, "canceled", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        })
                        .playOn(mTarget);
            }
        });
        findViewById(R.id.hello_world).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rope != null) {
                    rope.stop(true);
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, ExampleActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
