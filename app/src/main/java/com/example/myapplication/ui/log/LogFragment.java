package com.example.myapplication.ui.log;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;

import java.util.Locale;

public class LogFragment extends Fragment {

    private EditText date;
    private Button submitButton;
    private RadioButton painType1;
    private RadioButton painType2;
    private RadioButton painType3;
    private RadioButton painType4;

    private SeekBar painLevel;


    int check;



    public LogFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log, container, false);

        // Find the EditText for date
        date = view.findViewById(R.id.editTextDate);

        // Format and set the current date
        SimpleDateFormat dateF = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault());
        String currentDate = dateF.format(Calendar.getInstance().getTime());
        date.setText(currentDate);

        // Find the submit button
        submitButton = view.findViewById(R.id.submitButton);

        // Set the click listener to navigate to SubmitFragment
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use NavController to navigate to SubmitFragment
                moveForward(v);  // Action defined in the navigation graph
            }
        });

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void moveForward(View view) {
        check = 0;

        painType1 = getView().findViewById(R.id.pain_type_one);
        painType2 = getView().findViewById(R.id.pain_type_two);
        painType3 = getView().findViewById(R.id.pain_type_three);
        painType4 = getView().findViewById(R.id.pain_type_four);
        painLevel = getView().findViewById(R.id.pain_level_bar);


        int painLevelValue = painLevel.getProgress();


        //validate time
        if (painLevelValue == 0) {
            // Show an error message using Toast since SeekBar doesn't have setError()
            Toast.makeText(getContext(), "Please select a pain level", Toast.LENGTH_SHORT).show();
            check += 1;
            return;
        }

        if(!painType1.isChecked() && !painType2.isChecked() && !painType2.isChecked() && !painType2.isChecked())
        {
            Toast.makeText(getContext(), "Please select a pain type", Toast.LENGTH_SHORT).show();
            check += 1;
            return;
        }



        if (check ==0)
        {
            NavHostFragment.findNavController(LogFragment.this)
                    .navigate(R.id.action_navigation_log_to_navigation_submit);
        }
    }
}
