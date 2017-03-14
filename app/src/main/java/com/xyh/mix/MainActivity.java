package com.xyh.mix;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.xyh.mix.fragment.ContentFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_CONTENT = "TAG_CONTENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();
    }

    private void initFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fl_main, new ContentFragment(), TAG_CONTENT);
        transaction.commit();
    }
}
