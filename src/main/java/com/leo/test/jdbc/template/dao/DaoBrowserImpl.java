package com.leo.test.jdbc.template.dao;

import com.leo.test.jdbc.template.mapper.BrowserMapper;
import com.leo.test.jdbc.template.model.Browser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * Created by Senchenko Victor on 10/1/2016.
 */
@Service
public class DaoBrowserImpl implements DaoBrowser {
    //    @Autowired
    private JdbcTemplate template;

    @Autowired
    private BrowserMapper mapper;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public Iterable<Browser> list() {
        return template.query("SELECT * FROM browser", mapper);
    }

    @Override
    public Browser get(Number id) {
        return template.queryForObject("SELECT * FROM browser WHERE id = ?", new Object[]{id}, mapper);
    }

    @Override
    public Browser create(Browser browser) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update("INSERT INTO browser (browser,css_grade,engine,engine_version,platform) VALUE (?,?,?,?,?)",
                new Object[]{browser.getBrowser(), browser.getCssGrade(), browser.getEngine(), browser
                        .getEngineVersion(), browser.getPlatform()}, keyHolder);
        return get(keyHolder.getKey());
    }

    @Override
    public Browser edit(Browser browser) {
        template.update("UPDATE browser SET browser=?, css_grade=?, engine=?, engine_version=?, platform=? WHERE id=?", new Object[]{browser.getBrowser(), browser.getCssGrade(), browser.getEngine(), browser
                .getEngineVersion(), browser.getPlatform(), browser.getId()});
        return get(browser.getId());
    }

    @Override
    public void delete(Number id) {
        template.update("DELETE FROM browser WHERE id=?", new Object[]{id});
    }
}
