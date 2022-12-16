package org.john.crow.service.impl;

import org.john.crow.mapper.CategoryJpaRepository;
import org.john.crow.pojo.entity.Category;
import org.john.crow.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author johnconstantine
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryJpaRepository categoryJpaRepository;

    public CategoryServiceImpl(CategoryJpaRepository categoryJpaRepository) {
        this.categoryJpaRepository = categoryJpaRepository;
    }

    @Override
    public List<Category> queryAllRootLevelCat() {
        return categoryJpaRepository.findAllByType(1);
    }
}
