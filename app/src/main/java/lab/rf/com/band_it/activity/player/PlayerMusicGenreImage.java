package lab.rf.com.band_it.activity.player;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import lab.rf.com.band_it.R;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerMusicGenreImage extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_player_music_genre_image, container, false);
    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_player_music_genre_image);
//    }

    public void genreClick(View view) {
        if (view instanceof Button) {
            Button b = (Button) view;
            b.setSelected(!b.isSelected());
        }
    }
}
