package hansei.purplebeen.com.hansei_app.controller.activitys;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import hansei.purplebeen.com.hansei_app.R;
import hansei.purplebeen.com.hansei_app.beans.Meal;
import hansei.purplebeen.com.hansei_app.services.MealService;
import hansei.purplebeen.com.hansei_app.utills.StatusBarUtill;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealActivity extends AppCompatActivity {
    private ActionBar actionBar;
    private Retrofit retrofit;
    private MealService mealService;
    private Meal meal;
    private TextView menu;
    private TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtill.setStatusBarGradiant(MealActivity.this);
        setContentView(R.layout.activity_meal);

        init();
        loadData();
        setCustomActionbar();
    }

    private void init() {
        retrofit = new Retrofit.Builder().baseUrl("http://n0rr.iptime.org:8000").addConverterFactory(GsonConverterFactory.create()).build();
        mealService = retrofit.create(MealService.class);
        menu = (TextView) findViewById(R.id.menu);
        date = (TextView) findViewById(R.id.date);
    }

    private void loadData() {
        Call<Meal> call = mealService.getMeal();
        call.enqueue(new Callback<Meal>() {
            @Override
            public void onResponse(Call<Meal> call, Response<Meal> response) {
                Meal meal = response.body();
                if(meal.getSuccess().equals("success")) {
                    menu.setText(meal.getMenu());
                    date.setText(meal.getDate());
                } else {
                    Snackbar.make(getWindow().getDecorView().getRootView(), meal.getSuccess(), Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Meal> call, Throwable t) {
                Snackbar.make(getWindow().getDecorView().getRootView(), "알 수 없는 오류가 발생하였습니다!", Snackbar.LENGTH_LONG).show();
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
        textView.setText("오늘의 급식");
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
