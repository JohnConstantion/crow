package org.john.crow.service.impl;

import org.john.crow.mapper.CarouselJpaRepository;
import org.john.crow.pojo.entity.Carousel;
import org.john.crow.service.CarouselService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author johnconstantine
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    private final CarouselJpaRepository carouselJpaRepository;

    public CarouselServiceImpl(CarouselJpaRepository carouselJpaRepository) {
        this.carouselJpaRepository = carouselJpaRepository;
    }


    @Override
    public List<Carousel> queryAll(Integer isShow) {
        return carouselJpaRepository.findAllByIsShow(isShow);
    }
}
