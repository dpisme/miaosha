package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewObject.ItemVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.ItemService;
import com.miaoshaproject.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 1639489689@qq.com
 * @date 2019/1/4 0004 下午 9:51
 */
@RestController
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    //创建商品
    @PostMapping(value = "/create",consumes = {"application/x-www-form-urlencoded"})
    public CommonReturnType createItem(@Valid ItemModel itemModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("参数校验失败:" + bindingResult.getFieldError().getDefaultMessage());
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        //封装service请求用来创建商品
        ItemModel itemModel1 = itemService.createItem(itemModel);
        ItemVO itemVO = convertVOFromModel(itemModel1);
        return CommonReturnType.create(itemVO);
    }

    //商品详情页浏览
    @GetMapping(value = "/get")
    public CommonReturnType getItem(@RequestParam("id") Integer id) {
        ItemModel itemModel = itemService.getItemById(id);
        ItemVO itemVO = convertVOFromModel(itemModel);
        return CommonReturnType.create(itemVO);
    }

    //商品列表页面浏览
    @GetMapping(value = "/list")
    public CommonReturnType listItem() {
        List<ItemModel> listModelList = itemService.listItem();

        //使用stream api将list内的itemModel转化为itemVO
        List<ItemVO> itemVOList = listModelList.stream().map(itemModel -> {
            ItemVO itemVO = convertVOFromModel(itemModel);
            return itemVO;
        }).collect(Collectors.toList());
        return CommonReturnType.create(itemVOList);
    }

    private ItemVO convertVOFromModel(ItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(itemModel, itemVO);
        return itemVO;
    }
}
