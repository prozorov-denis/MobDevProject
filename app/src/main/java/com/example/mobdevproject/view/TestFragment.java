package com.example.mobdevproject.view;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobdevproject.R;
import com.example.mobdevproject.view.adapters.ExerciseAdapter;
import com.example.mobdevproject.view_model.TestViewModel;

import java.util.concurrent.TimeUnit;

public class TestFragment extends Fragment {

    private RecyclerView recyclerView;
    private TestViewModel viewModel;
    private Chronometer chronometer;

    public TestFragment() { }

    public static TestFragment newInstance() {
        TestFragment fragment = new TestFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(requireActivity()).get(TestViewModel.class);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test, container, false);

        recyclerView = view.findViewById(R.id.exercises_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new ExerciseAdapter(viewModel.getExercises_list()));

        setFinishTestBtn(view);

        chronometer = new Chronometer(this.getContext());

        return view;
    }

    private void setFinishTestBtn(View testFragment) {
        Button finish_test_btn = testFragment.findViewById(R.id.finish_test_btn);

        finish_test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long ms = SystemClock.elapsedRealtime() - chronometer.getBase();
                long minutes = TimeUnit.MILLISECONDS.toMinutes(ms);
                long seconds = TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(minutes);

                String time = minutes + ":" + seconds;

                viewModel.setTime(time);

                Navigation.findNavController(testFragment).navigate(R.id.action_testFragment2_to_testResultsFragment2);
            }
        });
    }

}
