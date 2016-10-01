package com.leo.test.jdbc.template.mapper;

import com.leo.test.jdbc.template.model.Browser;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Senchenko Victor on 10/1/2016.
 */
@Service
public class BrowserMapper implements RowMapper<Browser> {
    @Override
    public Browser mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Browser(resultSet.getInt("id"), resultSet.getString("browser"), resultSet.getString("css_grade"),
                resultSet.getString("engine"), resultSet.getString("engine_version"), resultSet.getString("platform"));
    }
}
