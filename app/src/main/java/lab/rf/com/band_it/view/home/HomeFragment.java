package lab.rf.com.band_it.view.home;

import android.view.animation.LinearInterpolator;

import androidx.recyclerview.widget.DefaultItemAnimator;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.List;

import lab.rf.com.band_it.R;
import lab.rf.com.band_it.data.DataGenerator;
import lab.rf.com.band_it.databinding.FragmentHomeBinding;
import lab.rf.com.band_it.model.People;
import lab.rf.com.band_it.view.base.BaseFragment;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

    private CardStackLayoutManager manager;
    private ProfileAdapter adapter;

    private List<People> peopleList = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void createLayout() {
        manager = new CardStackLayoutManager(getContext());
        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.HORIZONTAL);
        manager.setCanScrollHorizontal(true);
        manager.setCanScrollVertical(false);
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);
        manager.setOverlayInterpolator(new LinearInterpolator());

        adapter = new ProfileAdapter(getContext(), peopleList);
        adapter.addPeopleList(DataGenerator.getPeopleData(getContext()));

        binding.cardStackView.setLayoutManager(manager);
        binding.cardStackView.setAdapter(adapter);
        binding.cardStackView.setItemAnimator(new DefaultItemAnimator());
    }
}
