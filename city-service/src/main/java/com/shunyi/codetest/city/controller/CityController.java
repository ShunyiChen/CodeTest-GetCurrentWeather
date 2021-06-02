package com.shunyi.codetest.city.controller;

import com.alibaba.fastjson.JSON;
import com.shunyi.codetest.city.service.CityService;
import com.shunyi.codetest.common.entity.City;
import com.shunyi.codetest.common.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Shunyi Chen
 * @create 2021-06-02 15:57
 */
@RestController
@Slf4j
public class CityController {
//    @Value("${server.port}")
//    private String serverPort;

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/city/findall")
    public CommonResult findAll() {
        List<City> list = cityService.list();
        log.info("********查询结果："+ JSON.toJSONString(list));
        return CommonResult.builder().code(200).message("查询成功").data(list).build();
    }

    @PostMapping(value = "/city/create")
    public CommonResult create(@RequestBody City city) {
        boolean res = cityService.save(city);
        log.info("********插入结果："+res+",CityID="+city.getId());
        if(res) {
            return CommonResult.builder().code(200).message("插入成功").data(null).build();
        } else {
            return CommonResult.builder().code(500).message("插入失败").data(null).build();
        }
    }

    @DeleteMapping(value = "/city/delete/{id}")
    public CommonResult delete(@PathVariable("id") Long id) {
        boolean res = cityService.removeById(id);
        log.info("********删除结果："+res);
        if(res) {
            return CommonResult.builder().code(200).message("删除成功").data(null).build();
        } else {
            return CommonResult.builder().code(500).message("删除失败").data(null).build();
        }
    }
}
