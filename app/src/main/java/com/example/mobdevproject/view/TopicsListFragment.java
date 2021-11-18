package com.example.mobdevproject.view;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mobdevproject.R;
import com.example.mobdevproject.view_model.TopicsViewModel;

public class TopicsListFragment extends Fragment {

    private TopicsViewModel viewModel;

    public static TopicsListFragment newInstance() {
        return new TopicsListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this).get(TopicsViewModel.class);

        View view = inflater.inflate(R.layout.topics_list_fragment, container, false);

        setStartTestBtn(view);

        return view;
    }

    private void setStartTestBtn(View topicsFragment) {
        Button start_test_btn = topicsFragment.findViewById(R.id.start_test_btn);

        start_test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestFragment testFragment = new TestFragment();

                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                //transaction.replace(R.id.schoolContentFragment, testFragment);
                transaction.commit();
            }
        });
    }

}