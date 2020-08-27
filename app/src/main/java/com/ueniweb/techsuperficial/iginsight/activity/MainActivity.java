package com.ueniweb.techsuperficial.iginsight.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.rd.PageIndicatorView;
import com.ueniweb.techsuperficial.iginsight.R;
import com.ueniweb.techsuperficial.iginsight.actionhelper.CustomViewpager;
import com.ueniweb.techsuperficial.iginsight.actionhelper.Tools;
import com.ueniweb.techsuperficial.iginsight.actionhelper.ViewAnimation;
import com.ueniweb.techsuperficial.iginsight.adapter.PartnerPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.viewpagerchart)
    CustomViewpager viewpagerchart;
    @BindView(R.id.pageIndicatorView)
    PageIndicatorView dotindicator;
    @BindView(R.id.llexpand)
    LinearLayout mllexpand;
    @BindView(R.id.nested_scroll_view)
    NestedScrollView nested_scroll_view;
    @BindView(R.id.expandpanelll)
    LinearLayout lyt_expand_description;
    @BindView(R.id.img)
    ImageView img;
    View downview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        downview = img;

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSection(view, lyt_expand_description);

            }
        });
        mllexpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSection(img, lyt_expand_description);

            }
        });
    }

    private void init() {
        initVariable();

    }

    private void initVariable() {
        PartnerPagerAdapter partnerPagerAdapter = new PartnerPagerAdapter(getSupportFragmentManager());
        viewpagerchart.setAdapter(partnerPagerAdapter);
        dotindicator.setViewPager(viewpagerchart);
    }

    private void toggleSection(View bt, final View lyt) {
        boolean show = toggleArrow(bt);
        if (show) {
            ViewAnimation.expand(lyt, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    Tools.nestedScrollTo(nested_scroll_view, lyt);
                }
            });
        } else {
            ViewAnimation.collapse(lyt);
        }
    }

    public boolean toggleArrow(View view) {
        if (view.getRotation() == 0) {
            view.animate().setDuration(200).rotation(180);
            return true;
        } else {
            view.animate().setDuration(200).rotation(0);
            return false;
        }
    }
}
