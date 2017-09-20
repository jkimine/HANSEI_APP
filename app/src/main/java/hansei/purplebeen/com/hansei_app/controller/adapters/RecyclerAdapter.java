package hansei.purplebeen.com.hansei_app.controller.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import hansei.purplebeen.com.hansei_app.R;
import hansei.purplebeen.com.hansei_app.beans.HomeItem;
import hansei.purplebeen.com.hansei_app.controller.activitys.IntroduceActivity;
import hansei.purplebeen.com.hansei_app.controller.activitys.MealActivity;

/**
 * Created by baehyeonbin on 2017. 9. 19..
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context context;
    private List<HomeItem> items;
    private int itemLayout;
    public RecyclerAdapter(Context context, List<HomeItem> items, int itemLayout) {
        this.context=context;
        this.items=items;
        this.itemLayout=itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent, false);
        return new ViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final HomeItem item = items.get(position);
        Drawable drawable = context.getDrawable(item.getImage());
        holder.imageView.setBackground(drawable);
        holder.imageView.setOnClickListener(v -> {
            switch(position) {
                case 0:
                    break;
                case 1:
                    context.startActivity(new Intent(context, IntroduceActivity.class));
                    break;
                case 6:
                    context.startActivity(new Intent(context, MealActivity.class));
                default:
                    break;
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
        }
    }
}

