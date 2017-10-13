package ru.javawebinar.topjava.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.DbPopulator;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;
import static ru.javawebinar.topjava.MealTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
public class MealServiceTest {

    static {
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService service;

    @Autowired
    private DbPopulator dbPopulator;
    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }


    @Test
    public void get() throws Exception {
        Meal meal = service.get(ID,USER_ID);
        MATCHER.assertEquals(MEAL1, meal);
    }

    @Test
    public void delete() throws Exception {
        service.delete(ID,USER_ID);
        MATCHER.assertCollectionEquals(Collections.singletonList(MEAL2), service.getAll(USER_ID+1));
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundGet() throws Exception {
        service.get(1,1);
    }
    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        service.delete(1,1);
    }
//    @Test(expected = NotFoundException.class)
//    public void testNotFoundUpdate() throws Exception {
//
//    }
    @Test
    public void getBetweenDates() throws Exception {
        Collection<Meal> all = service.getBetweenDates(LocalDate.MIN, LocalDate.MAX,USER_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(MEAL1), all);
    }

    @Test
    public void getBetweenDateTimes() throws Exception {
        Collection<Meal> all = service.getBetweenDateTimes(LocalDateTime.MIN, LocalDateTime.MAX,USER_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(MEAL1), all);
    }

    @Test
    public void getAll() throws Exception {
        Collection<Meal> all = service.getAll(USER_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(MEAL1), all);
     }

    @Test
    public void update() throws Exception {
        Meal newMeal = new Meal(null, LocalDateTime.of(2015, Month.JUNE, 01, 17, 0), "user diner", 1000);
        Meal created = service.update(newMeal, USER_ID);
        newMeal.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(newMeal, MEAL1), service.getAll(USER_ID));
    }

    @Test
    public void save() throws Exception {
        Meal newMeal = new Meal(null, LocalDateTime.of(2015, Month.JUNE, 01, 17, 0), "user diner", 1000);
        Meal created = service.save(newMeal, USER_ID);
        newMeal.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(newMeal, MEAL1), service.getAll(USER_ID));
    }

}