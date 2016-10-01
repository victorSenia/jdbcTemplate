package com.leo.test.jdbc.template.controller;

import com.leo.test.jdbc.template.dao.DaoBrowser;
import com.leo.test.jdbc.template.model.Browser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Senchenko Victor on 10/1/2016.
 */
@RestController
@RequestMapping("browser")
public class BrowserController {
    @Autowired
    private DaoBrowser daoBrowser;

    @GetMapping("")
    public Iterable<Browser> list() {
        return daoBrowser.list();
    }

    @GetMapping("{id}")
    public Browser get(@PathVariable Integer id) {
        return daoBrowser.get(id);
    }

    @PostMapping("")
    public Browser create(@RequestBody Browser browser) {
        return daoBrowser.create(browser);
    }

    @PostMapping("{id}")
    public Browser edit(@PathVariable Integer id, @RequestBody Browser browser) {
        browser.setId(id);
        return daoBrowser.edit(browser);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        daoBrowser.delete(id);
    }
}
