package lab.rf.com.band_it.activity.bottomsheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import lab.rf.com.band_it.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import lab.rf.com.band_it.adapter.AdapterPeopleLeft;
import lab.rf.com.band_it.data.DataGenerator;
import lab.rf.com.band_it.fragment.FragmentBottomSheetDialogFull;
import lab.rf.com.band_it.model.People;
import lab.rf.com.band_it.utils.Tools;

public class BottomSheetFull extends Fragment {

    private RecyclerView recyclerView;
    private AdapterPeopleLeft adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_bottom_sheet_full, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //set data and list adapter
        adapter = new AdapterPeopleLeft(getActivity().getApplicationContext(), DataGenerator.getPeopleData(getActivity().getApplicationContext()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new AdapterPeopleLeft.OnItemClickListener() {
            @Override
            public void onItemClick(View view, People obj, int pos) {
                FragmentBottomSheetDialogFull fragment = new FragmentBottomSheetDialogFull();
                fragment.setPeople(obj);
                fragment.show(getActivity().getSupportFragmentManager(), fragment.getTag());
            }
        });

//        // display first sheet
//        FragmentBottomSheetDialogFull fragment = new FragmentBottomSheetDialogFull();
//        fragment.setPeople(adapter.getItem(0));
//        fragment.show(getActivity().getSupportFragmentManager(), fragment.getTag());

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        initComponent();
    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_bottom_sheet_full);
//
//        initComponent();
////        initToolbar();
//        Toast.makeText(this, "Swipe up bottom sheet", Toast.LENGTH_SHORT).show();
//    }

//    private void initComponent() {
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        //set data and list adapter
//        adapter = new AdapterPeopleLeft(this, DataGenerator.getPeopleData(this));
//        recyclerView.setAdapter(adapter);
//        adapter.setOnItemClickListener(new AdapterPeopleLeft.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, People obj, int pos) {
//                FragmentBottomSheetDialogFull fragment = new FragmentBottomSheetDialogFull();
//                fragment.setPeople(obj);
//                fragment.show(getSupportFragmentManager(), fragment.getTag());
//            }
//        });
//
//        // display first sheet
//        FragmentBottomSheetDialogFull fragment = new FragmentBottomSheetDialogFull();
//        fragment.setPeople(adapter.getItem(0));
//        fragment.show(getSupportFragmentManager(), fragment.getTag());
//    }

//    private void initToolbar() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_menu);
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("Full");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        Tools.setSystemBarColor(this);
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_basic, menu);
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
