package lab.rf.com.band_it.adapter;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import lab.rf.com.band_it.activity.bottomsheet.BottomSheetFull;
import lab.rf.com.band_it.activity.gridlist.GridTwoLine;
import lab.rf.com.band_it.activity.player.PlayerMusicGenreImage;
import lab.rf.com.band_it.activity.profile.ProfilePurple;
import lab.rf.com.band_it.activity.timeline.TimelineFeed;
import lab.rf.com.band_it.tinderexample.TinderActivity;
import lab.rf.com.band_it.view.home.HomeFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
//    TimelineFeed tab1;
    HomeFragment tab1;
    BottomSheetFull tab2;
    GridTwoLine tab3;
    PlayerMusicGenreImage tab4;
    ProfilePurple tab5;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
//        tab1 = new TimelineFeed();
        tab1 = new HomeFragment();
        tab2 = new BottomSheetFull();
        tab3 = new GridTwoLine();
        tab4 = new PlayerMusicGenreImage();
        tab5 = new ProfilePurple();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        Log.d("xxxxyyyy","get tab "+position);
        switch (position) {
            case 0:
                fragment = tab1;
                break;
            case 1:
                fragment = tab2;
                break;
            case 2:
                fragment = tab3;
                break;
            case 3:
                fragment = tab4;
                break;
            case 4:
                fragment = tab5;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}
