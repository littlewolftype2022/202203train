package com.example.a20230304fragmenttrans;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private Button mAddButton;
    private Button mRemoveButton;

    private Fragment mMyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager =getSupportFragmentManager();

        mAddButton = (Button) findViewById(R.id.add);
        mRemoveButton = (Button) findViewById(R.id.remove);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });
        mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragment();
            }
        });
    }
    private void removeFragment(){
        mFragmentManager.popBackStack();
    }
    private void addFragment(){

        mMyFragment = new MyFragment();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);


        fragmentTransaction.add(R.id.container,mMyFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}