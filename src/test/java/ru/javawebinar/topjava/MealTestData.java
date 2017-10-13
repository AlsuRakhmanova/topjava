package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.BeanMatcher;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;

import static ru.javawebinar.topjava.model.BaseEntity.START_SEQ;

public class MealTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ID = START_SEQ+2;

    public static final Meal MEAL1 = new Meal(ID, LocalDateTime.of(2015, Month.JUNE, 1, 14, 0), "user lunch", 510);
    public static final Meal MEAL2 = new Meal(ID+1, LocalDateTime.of(2015, Month.JUNE, 1, 21, 0), "admin diner", 1000);


    public static final BeanMatcher<Meal> MATCHER = new BeanMatcher<>((expected, actual) -> expected == actual ||
            (Objects.equals(expected.getDateTime(), actual.getDateTime())
                    && Objects.equals(expected.getId(), actual.getId())
                    && Objects.equals(expected.getCalories(), actual.getCalories())
                    && Objects.equals(expected.getDescription(), actual.getDescription())

            )
    );

}
