package com.example.myapplication.ui.log;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.lifecycle.ViewModelProvider;
import com.example.myapplication.R;
import java.util.Locale;

public class LogFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private EditText date;
    private LogViewModel logViewModel;

    public LogFragment() {
        // Required empty public constructor
    }

    public static LogFragment newInstance(String param1, String param2) {
        LogFragment fragment = new LogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log, container, false);

        // Initialize the ViewModel
        logViewModel = new ViewModelProvider(this).get(LogViewModel.class);

        // Find EditText field by ID
        date = view.findViewById(R.id.editTextDate);

        // Format and set the current date
        SimpleDateFormat dateF = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault());
        String currentDate = dateF.format(Calendar.getInstance().getTime());
        date.setText(currentDate);

        return view;
    }
}
