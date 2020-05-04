package com.example.mcnutt.inclassdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class FragmentTransactionExampleActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private static final String TAG = FragmentTransactionExampleActivity.class.getSimpleName();

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_transaction_example);
        manager = getSupportFragmentManager();
        manager.addOnBackStackChangedListener(this);
    }

    public void addFragmentA(View view) {
        Fragment fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentA, "fragA");
        transaction.addToBackStack("AddFragA");
        transaction.commit();
    }

    public void removeFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        if (fragmentA != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentA);
            transaction.addToBackStack("RemoveFragA");
            transaction.commit();
        }
    }

    public void addFragmentB(View view) {
        Fragment fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentB, "fragB");
        transaction.addToBackStack("AddFragB");
        transaction.commit();
    }

    public void removeFragmentB(View view) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        if (fragmentB != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentB);
            transaction.addToBackStack("RemoveFragB");
            transaction.commit();
        }
    }

    public void replaceByFragmentA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentA, "fragA");
        transaction.addToBackStack("ReplaceByFragA");
        transaction.commit();
    }

    public void replaceByFragmentB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentB, "fragB");
        transaction.addToBackStack("ReplaceByFragB");
        transaction.commit();
    }

    public void showFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        if (fragmentA != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.show(fragmentA);
            transaction.addToBackStack("ShowFragA");
            transaction.commit();
        }
    }

    public void hideFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        if (fragmentA != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.hide(fragmentA);
            transaction.addToBackStack("HideFragA");
            transaction.commit();
        }
    }

    public void dummyBackButtonClick(View view) {
        manager.popBackStack();
    }

    public void popAddFragAInclusiveTransaction(View view) {
        manager.popBackStack("AddFragA", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void popAddFragBTransaction(View view) {
        manager.popBackStack("AddFragB", 0);
    }

    @Override
    public void onBackStackChanged() {
        int length = manager.getBackStackEntryCount();
        StringBuilder msg = new StringBuilder();
        for(int i = length - 1; i >= 0; i--) {
            msg.append("Index ").append(i).append(" : ");
            msg.append(manager.getBackStackEntryAt(i).getName());
            msg.append("\n");
        }

        Log.i(TAG, "\n" + msg.toString() + " \n ");
    }

    @Override
    public void onBackPressed() {
        if (manager.getBackStackEntryCount() > 0) {
            manager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public void attachFragmentB(View view) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        if (fragmentB != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.attach(fragmentB);
            transaction.addToBackStack("AttachFragB");
            transaction.commit();
        }
    }

    public void detachFragmentB(View view) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        if (fragmentB != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.detach(fragmentB);
            transaction.addToBackStack("DetachFragB");
            transaction.commit();
        }
    }
}
