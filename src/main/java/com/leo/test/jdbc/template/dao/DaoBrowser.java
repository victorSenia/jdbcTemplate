package com.leo.test.jdbc.template.dao;

import com.leo.test.jdbc.template.model.Browser;

/**
 * Created by Senchenko Victor on 10/1/2016.
 */
public interface DaoBrowser {
    Iterable<Browser> list();

    Browser get(Number id);

    Browser create(Browser browser);

    Browser edit(Browser browser);

    void delete(Number id);
}
