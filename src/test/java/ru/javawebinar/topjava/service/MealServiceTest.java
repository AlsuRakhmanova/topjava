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
        MATCHER.assertCollectionEquals(Collections.singletonList(MEAL1), service.getAll(USER_ID));
    }

    @Test
    public void getBetweenDates() throws Exception {
    }

    @Test
    public void getBetweenDateTimes() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void save() throws Exception {
    }

}