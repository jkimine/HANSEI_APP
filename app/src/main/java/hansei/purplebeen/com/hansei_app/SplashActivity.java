package hansei.purplebeen.com.hansei_app;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

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
