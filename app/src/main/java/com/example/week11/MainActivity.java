package com.example.week11;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.week11.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment((new HomeFragment()));
                    break;
                case R.id.message:
                    replaceFragment((new messageFragment()));
                    break;
                case R.id.notification:
                    replaceFragment((new notificationFragment()));
                    break;
                case R.id.settings:
                    replaceFragment((new settingsFragment()));
                    break;
                case R.id.reaction:
                    replaceFragment((new reactionFragment()));
                    break;
            }
            return true;
        });


    }

    private void replaceFragment(Fragment Fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }
}