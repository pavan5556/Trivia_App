package com.pavan.triviaapp.source.data;

import com.pavan.triviaapp.source.model.Options;
import com.pavan.triviaapp.source.model.Question;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dummy {


    public static List<Question> getQuestionList() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Who is the best cricketer in the world?"));
        questions.add(new Question("What are the colors in the Indian national flag?"));

        return questions;
    }

    public static List<Options> getOptionsList() {
        List<Options> optionsList = new ArrayList<>();
        Options options1 = new Options();
        options1.setOptions(new ArrayList<String>(Arrays.asList("Sachin Tendulkar",
                "Virat Kolli", "Adam Gilchirst", "Jacques Kallis")));
        options1.setIsmultiselect(false);
        optionsList.add(options1);
        Options options2 = new Options();
        options2.setOptions(new ArrayList<String>(Arrays.asList("White",
                "Yellow", "Orange", "Green")));
        options2.setIsmultiselect(true);
        optionsList.add(options2);

        return optionsList;

    }
}
