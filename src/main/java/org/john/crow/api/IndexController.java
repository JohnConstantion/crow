package org.john.crow.api;

import org.john.crow.common.enums.YesOrNo;
import org.john.crow.common.utils.JsonResult;
import org.john.crow.pojo.entity.Carousel;
import org.john.crow.pojo.entity.Category;
import org.john.crow.service.CarouselService;
import org.john.crow.service.CategoryService;
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
    private final CategoryService categoryService;
    public IndexController(CarouselService carouselService, CategoryService categoryService) {
        this.carouselService = carouselService;
        this.categoryService = categoryService;
    }

    @GetMapping("/carousel")
    public JsonResult carousel() {
        List<Carousel> carouselList = carouselService.queryAll(YesOrNo.YES.type);
        return JsonResult.ok(carouselList);
    }

    @GetMapping("/cats")
    public JsonResult cats() {
        List<Category> categories = categoryService.queryAllRootLevelCat();
        return JsonResult.ok(categories);
    }

}
