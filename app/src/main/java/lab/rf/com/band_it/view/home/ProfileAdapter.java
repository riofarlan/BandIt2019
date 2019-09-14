package lab.rf.com.band_it.view.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lab.rf.com.band_it.databinding.ItemSwipeProfileBinding;
import lab.rf.com.band_it.model.People;
import lab.rf.com.band_it.view.callback.IItemClick;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    private List<People> peopleList;
    private LayoutInflater layoutInflater;
    private IItemClick<People> listener;

    public ProfileAdapter(Context context, List<People> peopleList) {
        this.peopleList = peopleList;
        layoutInflater = LayoutInflater.from(context);
    }

    public void addListener(IItemClick itemClick) {
        this.listener = itemClick;
    }

    public void removeListener() {
        listener = null;
    }

    public void addPeopleList(List<People> newsList) {
        if (!this.peopleList.isEmpty()) {
            this.peopleList.clear();
        }
        this.peopleList.addAll(newsList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(ItemSwipeProfileBinding.inflate(layoutInflater, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final People people = peopleList.get(i);
        viewHolder.binding.setPeople(people);
        viewHolder.binding.setItemClickListener(click -> {
            if (listener == null) {
                return;
            }
            listener.onItemClick(people);
        });
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemSwipeProfileBinding binding;

        public ViewHolder(ItemSwipeProfileBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

