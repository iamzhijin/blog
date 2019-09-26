package com.lzhijin.blog.controller;


import com.lzhijin.blog.common.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 标签类型表 前端控制器
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-26
 */
@Controller
@RequestMapping("/label")
public class LabelController {

    /**
     * 获取所有标签
     *
     * @return
     * @author lzhijin
     * @since 2019-09-26
     */
    @GetMapping(value = "getAllLabel")
    public ResponseResult getAllLabel(){
        return null;
    }

}
