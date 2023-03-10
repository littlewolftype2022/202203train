package com.example.a20230304fragmenttrans;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    private static int COUNT = 0;
    private int mId = 0;
    private final int[] mColors = new int[]{Color.RED, Color.GREEN,Color.BLUE,Color.BLACK};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ++COUNT;
        mId = COUNT;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.myfragment,container,false);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText("This is No."+ mId);
        textView.setBackgroundColor(mColors[mId%mColors.length]);

        return view;
    }
}
