package hansei.purplebeen.com.hansei_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
        addData();
        setRecyclerView();
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
        items.add(new HomeItem(R.drawable.introduce,"introduce"));
        items.add(new HomeItem(R.drawable.hacking,"hacking"));
        items.add(new HomeItem(R.drawable.usn,"usn"));
        items.add(new HomeItem(R.drawable.game,"game"));
        items.add(new HomeItem(R.drawable.admission,"admission"));
        items.add(new HomeItem(R.drawable.lunch,"lunch"));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
