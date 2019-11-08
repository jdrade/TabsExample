package com.example.tabsexample.ui.main;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tabsexample.BlueFragment;
import com.example.tabsexample.R;
import com.example.tabsexample.RedFragment;
import com.example.tabsexample.YellowFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment implements YellowFragment.OnFragmentInteractionListener, BlueFragment.OnFragmentInteractionListener, RedFragment.OnFragmentInteractionListener, GreenFragment.OnFragmentInteractionListener {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static Fragment newInstance(int index) {
        Fragment fragment = null;

        switch(index){
            case 1:fragment = new YellowFragment();
                break;
            case 2:fragment = new BlueFragment();
                break;
            case 3:fragment = new RedFragment();
                break;
            case 4:fragment = new GreenFragment();
                break;

        }

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}