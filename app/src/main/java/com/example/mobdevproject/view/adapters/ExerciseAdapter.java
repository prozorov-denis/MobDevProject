package com.example.mobdevproject.view.adapters;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobdevproject.R;
import com.example.mobdevproject.model.Exercise;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Exercise> exercises;

    public ExerciseAdapter(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public int getItemViewType(final int position) {

        if (exercises.get(position).getHasMultipleChoice())
            return R.layout.exercise_multi_card;
        else
            return R.layout.exercise_card;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        if (viewType == R.layout.exercise_card) {
            ExercisesRecyclerViewHolder exVM = new ExercisesRecyclerViewHolder(view);
            return exVM;
        }
        else {
            ExercisesMultiRecyclerViewHolder exMultiVM = new ExercisesMultiRecyclerViewHolder(view);
            return exMultiVM;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);

        if (exercise.getHasMultipleChoice()) {
            ExercisesMultiRecyclerViewHolder exMultiVH = (ExercisesMultiRecyclerViewHolder) holder;
            exMultiVH.getQuestionView().setText(String.valueOf(exercise.getTask()));
            exMultiVH.getRb1().setText(exercise.getAnswer1());
            exMultiVH.getRb2().setText(exercise.getAnswer2());
            exMultiVH.getRb3().setText(exercise.getAnswer3());
            exMultiVH.getRadioGroup().setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case -1:
                            exercise.setAnswer("");
                            break;
                        case R.id.answerRadio1:
                            exercise.setAnswer(exercise.getAnswer1());
                            break;
                        case R.id.answerRadio2:
                            exercise.setAnswer(exercise.getAnswer2());
                            break;
                        case R.id.answerRadio3:
                            exercise.setAnswer(exercise.getAnswer3());
                            break;
                    }
                }
            });
        }
        else {
            ExercisesRecyclerViewHolder exVH = (ExercisesRecyclerViewHolder) holder;
            exVH.getQuestionView().setText(String.valueOf(exercise.getTask()));
            exVH.getAnswerView().setText(String.valueOf(exercise.getAnswer()));
            exVH.getAnswerView().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    exercises.get(exVH.getAdapterPosition()).setAnswer(charSequence.toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
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

    public class ExercisesMultiRecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView questionView;
        private RadioGroup radioGroup;
        private RadioButton rb1;
        private RadioButton rb2;
        private RadioButton rb3;

        public ExercisesMultiRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            questionView = itemView.findViewById(R.id.question);
            radioGroup = itemView.findViewById(R.id.answersGroup);
            rb1 = itemView.findViewById(R.id.answerRadio1);
            rb2 = itemView.findViewById(R.id.answerRadio2);
            rb3 = itemView.findViewById(R.id.answerRadio3);
        }

        public TextView getQuestionView() {
            return questionView;
        }

        public RadioGroup getRadioGroup() {
            return radioGroup;
        }

        public RadioButton getRb1() {
            return rb1;
        }

        public RadioButton getRb2() {
            return rb2;
        }

        public RadioButton getRb3() {
            return rb3;
        }
    }
}


