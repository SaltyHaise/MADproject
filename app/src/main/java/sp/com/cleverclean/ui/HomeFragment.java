package sp.com.cleverclean.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import sp.com.cleverclean.R;



public class HomeFragment extends Fragment {
    ImageView homepic;
    public static TextView home_forecast, home_location, home_temperature;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView homepic=(ImageView) view.findViewById(R.id.imageView2);
        homepic.setImageResource(R.drawable.images);
        return view;
    }


}