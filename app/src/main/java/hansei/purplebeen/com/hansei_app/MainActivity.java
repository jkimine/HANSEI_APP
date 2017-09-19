package hansei.purplebeen.com.hansei_app;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import hansei.purplebeen.com.hansei_app.beans.HomeItem;
import hansei.purplebeen.com.hansei_app.utills.StatusBarUtill;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<HomeItem> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtill.setStatusBarGradiant(MainActivity.this);
        setContentView(R.layout.activity_main);

        init();
        setRecyclerView();
        addData();
    }


    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        items = new ArrayList<HomeItem>();
    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new RecyclerAdapter(getApplicationContext(),items,R.layout.item_home_card_view));
    }

    private void addData() {
        items.add(new HomeItem(R.drawable.card1,"home"));
        items.add(new HomeItem(R.drawable.card1,"home"));
        items.add(new HomeItem(R.drawable.card1,"home"));
        items.add(new HomeItem(R.drawable.card1,"home"));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
