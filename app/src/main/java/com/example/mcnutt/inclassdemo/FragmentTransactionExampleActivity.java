package com.example.mcnutt.inclassdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FragmentTransactionExampleActivity extends AppCompatActivity {

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_transaction_example);
        manager = getFragmentManager();
    }

    public void addFragmentA(View view) {
        Fragment fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentA, "fragA");
        transaction.commit();
    }

    public void removeFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        if (fragmentA != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentA);
            transaction.commit();
        }
    }

    public void addFragmentB(View view) {
        Fragment fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentB, "fragB");
        transaction.commit();
    }

    public void removeFragmentB(View view) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        if (fragmentB != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentB);
            transaction.commit();
        }
    }

    public void replaceByFragmentA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentA, "fragA");
        transaction.commit();
    }

    public void replaceByFragmentB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentB, "fragB");
        transaction.commit();
    }

    public void attachFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        if (fragmentA != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.attach(fragmentA);
            transaction.commit();
        }
    }

    public void detachFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        if (fragmentA != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.detach(fragmentA);
            transaction.commit();
        }
    }

    public void showFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        if (fragmentA != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.show(fragmentA);
            transaction.commit();
        }
    }

    public void hideFragmentB(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        if (fragmentA != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.hide(fragmentA);
            transaction.commit();
        }
    }
}
