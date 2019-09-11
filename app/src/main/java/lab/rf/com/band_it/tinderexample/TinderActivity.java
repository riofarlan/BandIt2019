package lab.rf.com.band_it.tinderexample;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import lab.rf.com.band_it.R;
import lab.rf.com.band_it.adapter.AdapterPeopleLeft;
import lab.rf.com.band_it.data.DataGenerator;
import lab.rf.com.band_it.fragment.FragmentBottomSheetDialogFull;
import lab.rf.com.band_it.model.People;

public class TinderActivity extends Fragment {
    private SwipePlaceHolderView mSwipeView;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_swipe_test1, container, false);

        mSwipeView = view.findViewById(R.id.swipeView);
        mContext = getActivity().getApplicationContext();

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        for(Profile profile : Utils.loadProfiles(this.getActivity().getApplicationContext())){
            try {
                mSwipeView.addView(new TinderCard(mContext, profile, mSwipeView));
            } catch (Exception e){
                Log.e("sasads",e.getMessage(), e);
            }
        }

        view.findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(false);
            }
        });

        view.findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(true);
            }
        });

        return view;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        mSwipeView = (SwipePlaceHolderView)findViewById(R.id.swipeView);
//        mContext = getApplicationContext();
//
//        mSwipeView.getBuilder()
//                .setDisplayViewCount(3)
//                .setSwipeDecor(new SwipeDecor()
//                        .setPaddingTop(20)
//                        .setRelativeScale(0.01f)
//                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
//                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));
//
//
//        for(Profile profile : Utils.loadProfiles(this.getApplicationContext())){
//            mSwipeView.addView(new TinderCard(mContext, profile, mSwipeView));
//        }
//
//        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mSwipeView.doSwipe(false);
//            }
//        });
//
//        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mSwipeView.doSwipe(true);
//            }
//        });
//    }

}
