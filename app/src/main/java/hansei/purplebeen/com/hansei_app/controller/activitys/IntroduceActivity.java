package hansei.purplebeen.com.hansei_app.controller.activitys;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import hansei.purplebeen.com.hansei_app.R;
import hansei.purplebeen.com.hansei_app.controller.adapters.FragmentAdapter;
import hansei.purplebeen.com.hansei_app.utills.StatusBarUtill;

public class IntroduceActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentAdapter fragmentAdapter;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtill.setStatusBarGradiant(IntroduceActivity.this);
        setContentView(R.layout.activity_introduce);
        setCustomActionbar();
        init();
        setTabLayout();
        setViewPager();
    }

    private void init() {
        tabLayout = (TabLayout) findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void setTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("홍보 영상"));
        tabLayout.addTab(tabLayout.newTab().setText("학교장 인사"));
        tabLayout.addTab(tabLayout.newTab().setText("오시는 길"));
    }

    private void setViewPager() {
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public void  setCustomActionbar() {
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setElevation(0);
        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.layout_actionbar_type_back, null);
        customView.setClickable(false);
        TextView textView = (TextView) customView.findViewById(R.id.title);
        textView.setText("한세 소개");
        textView.setClickable(false);

        //ImageButton 리스너 설정
        ImageButton imageButton = (ImageButton) customView.findViewById(R.id.btnBack);
        imageButton.setOnClickListener(v -> {
            finish();
        });

        actionBar.setCustomView(customView);
        Toolbar parent = (Toolbar) customView.getParent();
        parent.setContentInsetsAbsolute(0,0);
    }
}
