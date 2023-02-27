package com.example.fragmentexercises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    private boolean isFragmentDisplayed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.buttonz);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment;
                if (!isFragmentDisplayed) {
                    fragment = SimpleFragment.newInstance();
                    mButton.setText(R.string.open);
                } else {
                    fragment = DisplayFragment.newInstance();
                    mButton.setText(R.string.close);
                }
                displayFragment(fragment);
                isFragmentDisplayed = !isFragmentDisplayed;
            }
        });

        displayFragment(SimpleFragment.newInstance());
    }

    private void displayFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }


//    public void displayFragment(Fragment fragment) {
//        SimpleFragment simpleFragment = SimpleFragment.newInstance();
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager
//                .beginTransaction();
//
//
//        // TODO: Add the SimpleFragment.
////        fragmentTransaction.add(R.id.fragment_container,
////                simpleFragment).addToBackStack(null).commit();
//
//        fragmentTransaction.replace(R.id.fragment_container, fragment)
//                .addToBackStack(null)
//                .commit();
//
//        mButton.setText(R.string.close);
//        isFragmentDisplayed = true;
//    }
//
//    public void closeFragment(Fragment fragment) {
//        // Get the FragmentManager.
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        // Check to see if the fragment is already showing.
//        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager
//                .findFragmentById(R.id.fragment_container);
//
//        if (simpleFragment != null) {
//            // Create and commit the transaction to remove the fragment.
//            FragmentTransaction fragmentTransaction =
//                    fragmentManager.beginTransaction();
//            fragmentTransaction.replace(R.id.fragment_container, fragment)
//                    .addToBackStack(null)
//                    .commit();
//        }
//
//        // Update the Button text.
//        mButton.setText(R.string.open);
//        // Set boolean flag to indicate fragment is closed.
//        isFragmentDisplayed = false;
//    }
}