package com.example.mobdevproject.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.mobdevproject.adapters.ExerciseAdapter;
import com.example.mobdevproject.R;
import com.example.mobdevproject.view_model.TestViewModel;

public class SchoolFragment extends Fragment {

    public SchoolFragment() {
        // Required empty public constructor
    }

    public static SchoolFragment newInstance() {
        SchoolFragment fragment = new SchoolFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_school, container, false);

        setListView(view);

        return view;
    }

    private void setListView(View view) {
        String[] topics = new String[] {
                "Present Simple", "Past Simple", "Future Simple",
                "Present Continuous", "Past Continuous", "Future Continuous",
                "Present Perfect", "Past Perfect", "Future Perfect",
                "Present Perfect Continuous", "Past Perfect Continuous", "Future Perfect Continuous",
        };

        ListView listView = view.findViewById(R.id.topics_list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, topics);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Navigation.findNavController(view).navigate(R.id.action_schoolFragment_to_testFragment2);
            }
        });
    }

}