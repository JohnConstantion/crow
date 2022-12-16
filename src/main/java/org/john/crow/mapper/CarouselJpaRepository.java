package org.john.crow.mapper;

import org.john.crow.pojo.entity.Carousel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 轮播图
 *
 * @author johnconstantine
 */
public interface CarouselJpaRepository extends CrudRepository<Carousel, Long> {

    /**
     * find by isShow
     *
     * @param isShow show or not found
     * @return {@code List<Carousel>}
     */
    List<Carousel> findAllByIsShow(Integer isShow);
}
