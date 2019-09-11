package lab.rf.com.band_it.adapter;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import lab.rf.com.band_it.activity.timeline.TimelineFeed;

public class PagerAdapterHistory extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    TimelineFeed pesananFragment;
    TimelineFeed riwayatFragment;
    TimelineFeed riwayatFragment2;
    TimelineFeed riwayatFragment3;
    TimelineFeed riwayatFragment4;

    public PagerAdapterHistory(FragmentManager fm, int NumbOfTabs) {
        super(fm);
        Log.d("zzzzzz", ""+NumbOfTabs);
        this.mNumOfTabs = NumbOfTabs;
        pesananFragment = new TimelineFeed();
        riwayatFragment = new TimelineFeed();
        riwayatFragment2 = new TimelineFeed();
        riwayatFragment3 = new TimelineFeed();
        riwayatFragment4 = new TimelineFeed();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        Log.d("xxxxyyyy","get tab "+position);
        switch (position) {
//            case 0: return new ActiveHOrderFragment();
//            case 1: return new PastHOrderFragment();
            case 0:
                fragment = pesananFragment;
                break;
            case 1:
                fragment = riwayatFragment;
                break;
            case 2:
                fragment = riwayatFragment2;
                break;
            case 3:
                fragment = riwayatFragment3;
                break;
            case 4:
                fragment = riwayatFragment4;
                break;
        }
        return fragment;

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
