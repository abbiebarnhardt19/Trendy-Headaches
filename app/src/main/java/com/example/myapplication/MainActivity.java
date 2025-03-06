package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // BottomNavigationView
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Set up AppBarConfiguration with all top-level destinations
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_graphs, R.id.navigation_profile, R.id.navigation_table, R.id.navigation_log, R.id.navigation_stats)
                .build();

        // NavController for handling fragment transactions
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        // Link BottomNavigationView with NavController
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Handle bottom navigation item selection
        navView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            // If we are in SubmitFragment and user clicks on Log, navigate to LogFragment
            if (id == R.id.navigation_log) {
                if (navController.getCurrentDestination().getId() == R.id.navigation_submit) {
                    navController.navigate(R.id.action_navigation_submit_to_navigation_log);
                } else {
                    navController.navigate(R.id.navigation_log);
                }
            } else if (id == R.id.navigation_graphs) {
                navController.navigate(R.id.navigation_graphs);
            } else if (id == R.id.navigation_stats) {
                navController.navigate(R.id.navigation_stats);
            } else if (id == R.id.navigation_profile) {
                navController.navigate(R.id.navigation_profile);
            } else if (id == R.id.navigation_table) {
                navController.navigate(R.id.navigation_table);
            }

            // Return true to indicate the item is handled
            return true;
        });
    }
}
