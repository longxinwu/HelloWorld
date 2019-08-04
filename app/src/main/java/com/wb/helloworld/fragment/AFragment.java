package com.wb.helloworld.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wb.helloworld.R;

/**
 * @Author bo wang
 * @Description 测试
 * @Date 2019/8/4 21:00
 */
public class AFragment extends Fragment {

    private String title;
    private TextView TVTitle;

    public AFragment(String string) {
        title = string;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TVTitle = view.findViewById(R.id.TV_title);
        TVTitle.setText(title);
    }
}
