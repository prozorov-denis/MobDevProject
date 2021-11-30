package com.example.mobdevproject.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {Topic.class, Exercise.class, Statistics.class},
        version = 1
)
public abstract class EnglishAppDatabase extends RoomDatabase {
    public abstract MyAppEnglishDAO englishDAO();

    private static EnglishAppDatabase instance;

    public static EnglishAppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    EnglishAppDatabase.class,
                    "MyEnglishAppDB"
            )
                    .allowMainThreadQueries()
                    .build();

            instance.populateInitialData();
        }

        return instance;
    }

    private void populateInitialData() {
        if (englishDAO().getAllTopicsList().size() == 0) {
            runInTransaction(new Runnable() {
                @Override
                public void run() {
                    englishDAO().insertTopic(new Topic("Present Simple"));
                    englishDAO().insertTopic(new Topic("Past Simple"));
                    englishDAO().insertTopic(new Topic("Future Simple"));

                    englishDAO().insertTopic(new Topic("Present Continuous"));
                    englishDAO().insertTopic(new Topic("Past Continuous"));
                    englishDAO().insertTopic(new Topic("Future Continuous"));

                    englishDAO().insertTopic(new Topic("Present Perfect"));
                    englishDAO().insertTopic(new Topic("Past Perfect"));
                    englishDAO().insertTopic(new Topic("Future Perfect"));

                    englishDAO().insertTopic(new Topic("Present Perfect Continuous"));
                    englishDAO().insertTopic(new Topic("Past Perfect Continuous"));
                    englishDAO().insertTopic(new Topic("Future Perfect Continuous"));
                }
            });
        }

        Topic topicForCheck = englishDAO().getTopicByTitle("Present Simple");

        if (englishDAO().getExercisesListForTopic(topicForCheck.getId()).size() == 0) {
            runInTransaction(new Runnable() {
                @Override
                public void run() {
                    Topic topic = englishDAO().getTopicByTitle("Present Simple");

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "I .... Spanish with my sister. (study)",
                            "","","","study", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "I (to visit) my aunt once a month.",
                            "visit", "visits", "am visiting", "visit", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "On Saturday they (to go) to the cinema.",
                            "","","","go", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "The sun (to rise) in the East.",
                            "rise", "rises", "am rises", "rises", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Bad students never (to work) hard.",
                            "","","","work", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "My son (to have) a lot of friends to play with.",
                            "","","","has", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "They ___ volleyball at weekends. (not to play)",
                            "not to play", "not play", "don't play","don't play", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "A red traffic light ___ “Stop”. (to mean)",
                            "","","","means", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Martin never ___ me text messages. (to send)",
                            "","","","sends", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "I ___ I’ll show you the city. (to promise)",
                            "","","","promise", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "The bank always ___ on time. (to open)",
                            "","","","opens", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Do you ___ where the post office is? (to know)",
                            "","","","know", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Where _ you _ your books? (to keep)",
                            "do keep","- keep","keep -","do keep", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "He ___ to any political party. (to belong)",
                            "not belong", "doesn't belong", "don't belong","doesn't belong", true));
                }
            });
        }

        topicForCheck = englishDAO().getTopicByTitle("Past Simple");

        if (englishDAO().getExercisesListForTopic(topicForCheck.getId()).size() == 0) {
            runInTransaction(new Runnable() {
                @Override
                public void run() {
                    Topic topic = englishDAO().getTopicByTitle("Past Simple");

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Two years ago I … my old aunt in a small old town.",
                            "visit",
                            "visited",
                            "didn't visited",
                            "visited", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "It … a long visit as my aunt … well.",
                            "was…didn't feel",
                            "was…didn't fall",
                            "did…didn't felt",
                            "was…didn't feel", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "I … to … medicine and food.",
                            "have…buyed",
                            "had…bought",
                            "had…buy",
                            "had…buy", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "I also … dinner and … about the house.",
                            "cook…helped",
                            "cooked…helped",
                            "cooked…help",
                            "cooked…helped", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "One day my aunt asked me: \" … the flowers in the garden yesterday?\"",
                            "Did you water",
                            "You did water",
                            "You watered",
                            "Did you water", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "I … very surprised as she usually did it herself. (to be)",
                            "",
                            "",
                            "",
                            "was", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "But in those days my aunt was so weak, that she … no work in the garden. (can do)",
                            "",
                            "",
                            "",
                            "could do", false));
                }
            });
        }

        topicForCheck = englishDAO().getTopicByTitle("Future Simple");

        if (englishDAO().getExercisesListForTopic(topicForCheck.getId()).size() == 0) {
            runInTransaction(new Runnable() {
                @Override
                public void run() {
                    Topic topic = englishDAO().getTopicByTitle("Future Simple");

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "I (to do) morning exercises.",
                            "",
                            "",
                            "",
                            "will do", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "He (to work) at a factory.",
                            "",
                            "",
                            "",
                            "will work", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "She (to sleep) after dinner.",
                            "",
                            "",
                            "",
                            "will sleep", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "We (to work) part-time next week.",
                            "",
                            "",
                            "",
                            "will work", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "They (to drink) tea tomorrow.",
                            "",
                            "",
                            "",
                            "will drink", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Alice (to have) a sister.",
                            "will have",
                            "have",
                            "will be have",
                            "will have", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Her sister’s name (to be) Ann.",
                            "am",
                            "will be",
                            "will is",
                            "will be", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Ann (to be) a student.",
                            "will be",
                            "be",
                            "will am",
                            "will be", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "She (not to get) up at seven o'clock.",
                            "gets",
                            "won't be",
                            "is getting",
                            "won't be", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "She (to go) to the institute in the morning.",
                            "will goes",
                            "goes",
                            "will go",
                            "will go", true));
                }
            });
        }

        topicForCheck = englishDAO().getTopicByTitle("Present Continuous");

        if (englishDAO().getExercisesListForTopic(topicForCheck.getId()).size() == 0) {
            runInTransaction(new Runnable() {
                @Override
                public void run() {
                    Topic topic = englishDAO().getTopicByTitle("Present Continuous");

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "My car is broken, so I ___ my mum’s.",
                            "am use",
                            "am using",
                            "is using",
                            "am using", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "My brother ___ his own website. It looks great!",
                            "designing",
                            "are designing",
                            "is designing",
                            "is designing", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "___ this birthday party.",
                            "I’m not enjoy",
                            "I’m not enjoing",
                            "I’m not enjoying",
                            "I’m not enjoying", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "My sister ___ a shower at the moment.",
                            "is having",
                            "is have",
                            "are having",
                            "is having", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Andy ___ to Spain this year.",
                            "isn’t go",
                            "aren’t going",
                            "is not going",
                            "is not going", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Ron and Michael (to sit) at the table and doing their homework.",
                            "",
                            "",
                            "",
                            "are sitting", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "My dad (to repair) my bike right now.",
                            "",
                            "",
                            "",
                            "is repairing", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "My parents (to watch) TV right now.",
                            "",
                            "",
                            "",
                            "are watching", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "I (to try) to find a place to stay at the moment.",
                            "",
                            "",
                            "",
                            "am trying", false));
                }
            });
        }

        topicForCheck = englishDAO().getTopicByTitle("Past Continuous");

        if (englishDAO().getExercisesListForTopic(topicForCheck.getId()).size() == 0) {
            runInTransaction(new Runnable() {
                @Override
                public void run() {
                    Topic topic = englishDAO().getTopicByTitle("Past Continuous");

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Sally and Ann ___ in the park when it started raining.",
                            "were run",
                            "was running",
                            "were running",
                            "were running", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "We ___ tea when our grandparents came.",
                            "were having",
                            "were have",
                            "was having",
                            "were having", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "We ___ a New Year tree all morning yesterday.",
                            "were to decorating",
                            "were decorating",
                            "was decorating",
                            "were decorating", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "___ at 8 p.m. yesterday?",
                            "Was she knitting",
                            "Were she knitting",
                            "Knitting she",
                            "Was she knitting", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "We ___ along the coast all evening yesterday.",
                            "were driving",
                            "were drive",
                            "was drive",
                            "were driving", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "He (to wait) for me when I came.",
                            "",
                            "",
                            "",
                            "was waiting", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "He (to paint) the house this time yesterday.",
                            "",
                            "",
                            "",
                            "was painting", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Lucy (to have) a bath at 9 o’clock yesterday.",
                            "",
                            "",
                            "",
                            "was having", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Where were you yesterday evening? I (to visit) my niece in hospital.",
                            "",
                            "",
                            "",
                            "was visiting", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "When I got home, my sister (to play) with a kitten.",
                            "",
                            "",
                            "",
                            "was playing", false));
                }
            });
        }

        topicForCheck = englishDAO().getTopicByTitle("Future Continuous");

        if (englishDAO().getExercisesListForTopic(topicForCheck.getId()).size() == 0) {
            runInTransaction(new Runnable() {
                @Override
                public void run() {
                    Topic topic = englishDAO().getTopicByTitle("Future Continuous");

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Why are you in a hurry? If you arrive at 8 o’clock, they … the meal.",
                            "will be still cooking",
                            "are still be cooking",
                            "still are cooking",
                            "will be still cooking", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "He … when you come back tonight.",
                            "slept",
                            "would be sleeping",
                            "will be sleeping",
                            "will be sleeping", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "I … for my exam on Philosophy all day tomorrow.",
                            "works",
                            "will be working",
                            "have been working",
                            "will be working", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "... you still ... ... at six o'clock?",
                            "Will / working / be",
                            "Will / be / working",
                            "Be / will / working",
                            "Will / be / working", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "You will recognize John. He (to wear) a blue T-shirt.",
                            "",
                            "",
                            "",
                            "will be wearing", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "This time next Monday, I _______ in a huge office in New York. (work)",
                            "",
                            "",
                            "",
                            "will be working", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "This time next year we ________ the Pacific Ocean. (cross)",
                            "",
                            "",
                            "",
                            "will be crossing", false));
                }
            });
        }

        topicForCheck = englishDAO().getTopicByTitle("Present Perfect");

        if (englishDAO().getExercisesListForTopic(topicForCheck.getId()).size() == 0) {
            runInTransaction(new Runnable() {
                @Override
                public void run() {
                    Topic topic = englishDAO().getTopicByTitle("Present Perfect");

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Do we need any tomatoes? No, I ___ some.",
                            "already has bought",
                            "has already bought",
                            "have already bought",
                            "have already bought", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Where is your purse? I ___ it.",
                            "was lost",
                            "has lost",
                            "have lost",
                            "has lost", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "My wife ___ invitations for the party.",
                            "have already sent",
                            "has already sent",
                            "has already send",
                            "has already sent", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "___ the lottery?",
                            "Have you ever won",
                            "Has you ever won",
                            "Have you ever win",
                            "Have you ever won", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "I ___ a computer since I was three.",
                            "has have",
                            "have had",
                            "has had",
                            "have had", true));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Are you going anywhere this summer? Yes, we (to book) a trip to Italy.",
                            "",
                            "",
                            "",
                            "have booked", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "I (never to take) part in marathons.",
                            "",
                            "",
                            "",
                            "have never taken", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "He (to finish) his work. Why don’t we invite him out?",
                            "",
                            "",
                            "",
                            "has finished", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "Tom and I (to be) friends since childhood.",
                            "",
                            "",
                            "",
                            "have been", false));

                    englishDAO().insertExercise(new Exercise(
                            topic.getId(),
                            "He (to sell) his cottage.",
                            "",
                            "",
                            "",
                            "has sold", false));
                }
            });
        }
    }
}