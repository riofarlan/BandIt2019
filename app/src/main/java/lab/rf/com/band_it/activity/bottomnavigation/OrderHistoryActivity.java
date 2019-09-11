package lab.rf.com.band_it.activity.bottomnavigation;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import lab.rf.com.band_it.adapter.PagerAdapterHistory;

import lab.rf.com.band_it.R;


public class OrderHistoryActivity extends AppCompatActivity {
    private static final String TAG = "OrderHistoryActivity";
    private PagerAdapterHistory htab_adapter;
    private TabLayout htab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_history);

        Toolbar toolbar = findViewById(R.id.toolbar_order_history);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Pesanan Saya");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        htab = findViewById(R.id.tab_layout);

//        tabLayout.addTab(tabLayout.newTab().setText("Active Order(s)"));
//        tabLayout.addTab(tabLayout.newTab().setText("Past Order(s)"));
        htab.addTab(htab.newTab().setText("Pesanan"));
        htab.addTab(htab.newTab().setText("Riwayat"));

        htab.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        htab_adapter = new PagerAdapterHistory(getSupportFragmentManager(), htab.getTabCount());
        viewPager.setAdapter(htab_adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(htab));
        htab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0 :
                        break;
                    case 1:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(htab.getTabAt(0).isSelected()) {
        } else {
        }
    }
}
