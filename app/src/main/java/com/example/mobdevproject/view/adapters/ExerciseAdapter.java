package com.example.mobdevproject.view.adapters;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobdevproject.R;
import com.example.mobdevproject.model.Exercise;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExercisesRecyclerViewHolder> {
    private List<Exercise> exercises;

    public ExerciseAdapter(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.exercise_card;
    }

    @NonNull
    @Override
    public ExercisesRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        ExercisesRecyclerViewHolder viewHolder = new ExercisesRecyclerViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExercisesRecyclerViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.getQuestionView().setText(String.valueOf(exercise.getTask()));
        holder.getAnswerView().setText(String.valueOf(exercise.getAnswer()));
        holder.getAnswerView().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                exercises.get(holder.getAdapterPosition()).setAnswer(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public class ExercisesRecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView questionView;
        private EditText answerView;

        public ExercisesRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            questionView = itemView.findViewById(R.id.question);

            answerView = itemView.findViewById(R.id.answer);
        }

        public TextView getQuestionView() {
            return questionView;
        }

        public EditText getAnswerView() {
            return answerView;
        }
    }
}


