package org.john.crow.api;

import org.john.crow.common.enums.YesOrNo;
import org.john.crow.common.utils.JsonResult;
import org.john.crow.pojo.entity.Carousel;
import org.john.crow.service.CarouselService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author johnconstantine
 */
@RestController
@RequestMapping("/index")
public class IndexController {
    private final CarouselService carouselService;

    public IndexController(CarouselService carouselService) {
        this.carouselService = carouselService;
    }

    @GetMapping("/carousel")
    public JsonResult carousel() {
        List<Carousel> carouselList = carouselService.queryAll(YesOrNo.YES.type);
        return JsonResult.ok(carouselList);
    }
}
