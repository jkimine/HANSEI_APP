package hansei.purplebeen.com.hansei_app.controller.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import hansei.purplebeen.com.hansei_app.controller.fragments.IntroduceVideoFragment;
import hansei.purplebeen.com.hansei_app.controller.fragments.MapIntroduceFragment;
import hansei.purplebeen.com.hansei_app.controller.fragments.PrincipalFragment;

/**
 * Created by baehyeonbin on 2017. 9. 19..
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                IntroduceVideoFragment introduceVideoFragment = new IntroduceVideoFragment();
                return introduceVideoFragment;
            case 1:
                return PrincipalFragment.newInstance();
            case 2:
                return MapIntroduceFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
