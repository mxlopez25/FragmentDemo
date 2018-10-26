package com.example.maximolopez.fragmentdemo;

import android.os.Bundle;
import android.os.FileObserver;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maximolopez.fragmentdemo.fragments.FormFragment;

public class MainActivity extends AppCompatActivity implements FormFragment.DataTransfer {

    private TextView mTextMessage;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private FormFragment formFragment = new FormFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    FormFragment fForm = (FormFragment) fragmentManager.findFragmentByTag(FormFragment.TAG);
                    if(fForm != null && !fForm.isVisible())
                    {
                        switchFragment(formFragment);
                    } else {
                        fragmentManager.beginTransaction()
                                .replace(R.id.fl_fragments, formFragment, FormFragment.TAG)
                                .commit();
                        return true;
                    }
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fl_fragments, new FormFragment(), FormFragment.TAG).commit();

    }

    public boolean switchFragment(Fragment fragment)
    {
        fragmentManager.beginTransaction()
                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .show(fragment)
                .commit();
        return true;
    }

    @Override
    public void TextData(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}
