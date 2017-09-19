package hansei.purplebeen.com.hansei_app.controller.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hansei.purplebeen.com.hansei_app.R;

public class PrincipalFragment extends Fragment {

    public PrincipalFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PrincipalFragment newInstance() {
        PrincipalFragment fragment = new PrincipalFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_principal, container, false);
    }


}
