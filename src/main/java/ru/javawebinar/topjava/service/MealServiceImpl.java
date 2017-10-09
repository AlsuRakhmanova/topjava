package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository repository;

    @Override
    public Meal save(Meal meal) {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public Meal get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
            }

    @Override
    public void update(Meal meal) {

    }

    @Override
    public List<Meal> getAll(int userId) {
        return (List<Meal>)repository.getAll(userId);

    }
}