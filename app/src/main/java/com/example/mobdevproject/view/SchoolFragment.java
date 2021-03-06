package com.example.mobdevproject.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mobdevproject.R;
import com.example.mobdevproject.model.Topic;
import com.example.mobdevproject.view_model.SchoolViewModel;

import java.util.ArrayList;
import java.util.List;

public class SchoolFragment extends Fragment {
    private SchoolViewModel schoolViewModel;

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
        schoolViewModel = new ViewModelProvider(requireActivity()).get(SchoolViewModel.class);
        setListView(view);

        return view;
    }

    private void setListView(View view) {
        List<Topic> topics = schoolViewModel.getTopics();

        ArrayList<String> topics_titles = new ArrayList<String>();

        for (Topic t: topics) {
            topics_titles.add(t.getTitle());
        }

        ListView listView = view.findViewById(R.id.topics_list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, topics_titles);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                schoolViewModel.setCurrentTopic(topics_titles.get(position));

                if (schoolViewModel.getExercises_list().size() > 0)
                    Navigation.findNavController(view).navigate(R.id.action_schoolFragment_to_testFragment2);
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setMessage("????????????????, ?????????????? ?????? ???????????? ???????? ?????? ???? ??????????????????. ???? ?????? ???????????????? ?? ?????????????????? ????????????????????!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
        });
    }

}