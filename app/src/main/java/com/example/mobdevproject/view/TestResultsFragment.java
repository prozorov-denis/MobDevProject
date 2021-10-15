package com.example.mobdevproject.view;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobdevproject.R;
import com.example.mobdevproject.view_model.TestViewModel;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestResultsFragment extends Fragment {

    private TestViewModel viewModel;

    public static TestResultsFragment newInstance() {
        return new TestResultsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(TestViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.test_results_fragment, container, false);

        TextView textView = view.findViewById(R.id.resultsTextView);
        textView.setText("Результат: " + viewModel.getResult() + " Время:" + viewModel.getTime());

        PieChart pieChart = view.findViewById(R.id.resultsPieChart);

        setPieCart(pieChart);

        setBackBtn(view);

        return view;
    }

    private void setPieCart(PieChart pieChart) {
        ArrayList<PieEntry> results;
        int result;

        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(0);

        result = viewModel.getResult();

        results = new ArrayList<PieEntry>();

        results.add(new PieEntry(result));
        results.add(new PieEntry(100 - result));

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.rgb(98, 0, 238));
        colors.add(Color.rgb(3, 218, 198));

        PieDataSet pieDataSet = new PieDataSet(results, "");

        pieChart.setData(new PieData(pieDataSet));
        pieDataSet.setColors(colors);
        pieChart.invalidate();
    }

    private void setBackBtn(View testResultsFragment) {
        Button back_to_school_btn = testResultsFragment.findViewById(R.id.back_to_school_btn);

        back_to_school_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(testResultsFragment).navigate(R.id.action_testResultsFragment2_to_schoolFragment);
            }
        });
    }

}