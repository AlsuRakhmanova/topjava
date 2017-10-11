package ru.javawebinar.topjava.util;

import org.springframework.jdbc.core.RowMapper;
import ru.javawebinar.topjava.model.Meal;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomRowMapper implements RowMapper{

    public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
        Meal meal = new Meal();
        meal.setId(rs.getInt("id"));
        meal.setDateTime(rs.getTimestamp("time").toLocalDateTime());
        meal.setCalories(rs.getInt("calories"));
        meal.setDescription(rs.getString("description"));
        return meal;
    }
}
