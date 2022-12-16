package org.john.crow.mapper;

import org.john.crow.pojo.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author johnconstantine
 */
public interface CategoryJpaRepository extends CrudRepository<Category, Long> {
    /**
     * find all category by type
     *
     * @param type first level category type
     * @return {@code List<Category>}
     */
    List<Category> findAllByType(Integer type);
}
