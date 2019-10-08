package com.lzhijin.blog.controller;


import com.lzhijin.blog.common.AbstractRestService;
import com.lzhijin.blog.common.ResponseResult;
import com.lzhijin.blog.entity.Label;
import com.lzhijin.blog.service.bll.LabelBLL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

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
public class LabelController extends AbstractRestService {
    public static final Logger logger = LoggerFactory.getLogger(LabelController.class);

    @Autowired
    LabelBLL labelBLL;

    /**
     * 获取所有标签
     *
     * @return
     * @author lzhijin
     * @since 2019-09-26
     */
    @GetMapping(value = "getAllLabel")
    public ResponseResult<List<Label>> getAllLabel(){
        try{
            return this.buildSuccessResult(labelBLL.getAllLabel());
        } catch(Exception e){
            e.printStackTrace();
            logger.error("查询标签失败: " + e.getMessage());
            return this.buildErrorResult("查询标签失败");
        }
    }

}
