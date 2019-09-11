package lab.rf.com.band_it.activity.timeline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import lab.rf.com.band_it.R;
import lab.rf.com.band_it.utils.Tools;

public class TimelineFeed extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_timeline_feed, container, false);
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_timeline_feed);
//
//        initToolbar();
//        initComponent();
//    }

//    private void initToolbar() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_menu);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Feed");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        Tools.setSystemBarColor(this, R.color.indigo_700);
//    }

    private void initComponent() {

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_search, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            finish();
//        } else {
//            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
//        }
//        return super.onOptionsItemSelected(item);
//    }

}
