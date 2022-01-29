package sp.com.cleverclean.ui.activitylog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import sp.com.cleverclean.R;
import sp.com.cleverclean.databinding.FragmentGalleryBinding;
import sp.com.cleverclean.databinding.FragmentHomeBinding;
import sp.com.cleverclean.databinding.FragmentLogBinding;
import sp.com.cleverclean.ui.home.HomeViewModel;

public class LogFragment extends Fragment {

    private FragmentLogBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLogBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textLog;

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}