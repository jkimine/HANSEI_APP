package hansei.purplebeen.com.hansei_app.controller.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hansei.purplebeen.com.hansei_app.R;

public class MapIntroduceFragment extends Fragment {

    public MapIntroduceFragment() {
        // Required empty public constructor
    }

    public static MapIntroduceFragment newInstance() {
        MapIntroduceFragment fragment = new MapIntroduceFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map_introduce, container, false);
    }
}
