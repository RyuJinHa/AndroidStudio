package com.example.test.ui.calling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.test.R;

public class CallingFragment extends Fragment {

    private CallingViewModel CallingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CallingViewModel =
                ViewModelProviders.of(this).get(CallingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calling, container, false);
        final TextView textView = root.findViewById(R.id.text_calling);
        CallingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}