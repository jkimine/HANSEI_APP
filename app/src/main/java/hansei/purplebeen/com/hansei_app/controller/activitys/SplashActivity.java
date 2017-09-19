package hansei.purplebeen.com.hansei_app.controller.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hansei.purplebeen.com.hansei_app.R;
import hansei.purplebeen.com.hansei_app.utills.StatusBarUtill;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtill.setStatusBarGradiant(SplashActivity.this);
        setContentView(R.layout.activity_splash);

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(4000);
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
