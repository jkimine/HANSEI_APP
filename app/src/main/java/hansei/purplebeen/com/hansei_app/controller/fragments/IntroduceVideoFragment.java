package hansei.purplebeen.com.hansei_app.controller.fragments;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import hansei.purplebeen.com.hansei_app.R;

public class IntroduceVideoFragment extends Fragment {

    private View view;
    private ImageButton playButton;
    private Uri uri;
    private static String VIDEO_URL="http://purplebeen.uy.to:8080/resources/images/hansei_video.mp4";
    public IntroduceVideoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_introduce_video, container, false);
        init();
        loadVideo();
        return view;

    }

    private void init() {
        playButton = (ImageButton) view.findViewById(R.id.playButton);
    }

    private void loadVideo() {
        uri = Uri.parse(VIDEO_URL);
        playButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setDataAndType(uri,"video/*");
            startActivityForResult(intent,3000);
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 3000) {
            playButton.setBackground(getActivity().getDrawable(R.drawable.ic_refresh));
        }
    }
}
