package org.john.crow.service;

import org.john.crow.pojo.entity.Carousel;

import java.util.List;

/**
 * @author johnconstantine
 */
public interface CarouselService {
    /**
     * find all carousel list
     *
     * @param isShow isShow
     * @return {@code  List<Carousel>}
     */
    List<Carousel> queryAll(Integer isShow);
}