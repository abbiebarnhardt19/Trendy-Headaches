package com.example.myapplication.ui.Graphs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentGraphsBinding;

public class GraphsFragment extends Fragment {

    private FragmentGraphsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GraphsViewModel GraphsViewModel =
                new ViewModelProvider(this).get(GraphsViewModel.class);

        binding = FragmentGraphsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGraphs;
        GraphsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}