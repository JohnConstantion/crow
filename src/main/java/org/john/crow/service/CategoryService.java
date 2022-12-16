package org.john.crow.service;

import org.john.crow.pojo.entity.Category;

import java.util.List;

/**
 * @author johnconstantine
 */
public interface CategoryService {

    /**
     * find all first level categories
     *
     * @return {@link List<Category>}
     */
    List<Category> queryAllRootLevelCat();
}
