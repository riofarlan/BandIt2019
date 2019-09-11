package lab.rf.com.band_it.activity.gridlist;

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
import androidx.recyclerview.widget.GridLayoutManager;
import lab.rf.com.band_it.R;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import lab.rf.com.band_it.adapter.AdapterGridTwoLine;
import lab.rf.com.band_it.data.DataGenerator;
import lab.rf.com.band_it.model.Image;
import lab.rf.com.band_it.utils.Tools;
import lab.rf.com.band_it.widget.SpacingItemDecoration;

public class GridTwoLine extends Fragment {

    private View parent_view;

    private RecyclerView recyclerView;
    private AdapterGridTwoLine mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_grid_two_line, container, false);
        initComponent(view);
        return view;
    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_grid_two_line);
//        parent_view = findViewById(android.R.id.content);
//
////        initToolbar();
//        initComponent();
//    }

//    private void initToolbar() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_menu);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Two Line");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        Tools.setSystemBarColor(this, R.color.grey_1000);
//    }

    private void initComponent(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(getActivity().getApplicationContext(), 3), true));
        recyclerView.setHasFixedSize(true);

        List<Image> items = DataGenerator.getImageDate(getActivity().getApplicationContext());
        items.addAll(DataGenerator.getImageDate(getActivity().getApplicationContext()));
        items.addAll(DataGenerator.getImageDate(getActivity().getApplicationContext()));
        items.addAll(DataGenerator.getImageDate(getActivity().getApplicationContext()));

        //set data and list adapter
        mAdapter = new AdapterGridTwoLine(getActivity().getApplicationContext(), items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterGridTwoLine.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Image obj, int position) {
                Snackbar.make(view, obj.name + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_search_setting, menu);
//        return true;
//    }
//
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
