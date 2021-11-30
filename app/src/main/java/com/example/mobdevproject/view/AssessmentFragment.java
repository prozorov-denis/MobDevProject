package com.example.mobdevproject.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobdevproject.R;
import com.example.mobdevproject.view_model.SchoolViewModel;
import com.example.mobdevproject.view_model.StatisticsViewModel;

public class AssessmentFragment extends Fragment {
    private StatisticsViewModel viewModel;

    public AssessmentFragment() {
        // Required empty public constructor
    }

    public static AssessmentFragment newInstance() {
        AssessmentFragment fragment = new AssessmentFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_assessment, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(StatisticsViewModel.class);

        TextView resAverageTextView = view.findViewById(R.id.resAverageStatTextView);
        TextView resBestTextView = view.findViewById(R.id.resBestStatTextView);
        TextView timeAverageTextView = view.findViewById(R.id.timeAverageStatTextView);
        TextView timeBestTextView = view.findViewById(R.id.timeBestStatTextView);

        resAverageTextView.setText("Средний результат: " + viewModel.getAverageResult());
        resBestTextView.setText("Лучший результат: " + viewModel.getBestResult());
        timeAverageTextView.setText("Среднее время: " + viewModel.getAverageTime());
        timeBestTextView.setText("Лучшее время: " + viewModel.getBestTime());

        return view;
    }
}