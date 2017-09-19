package hansei.purplebeen.com.hansei_app;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import hansei.purplebeen.com.hansei_app.utills.StatusBarUtill;

public class IntroduceActivity extends AppCompatActivity {
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtill.setStatusBarGradiant(IntroduceActivity.this);
        setContentView(R.layout.activity_introduce);
        setCustomActionbar();
    }
    public void  setCustomActionbar() {
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

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
