package com.lzhijin.blog.controller;

import com.lzhijin.blog.common.AbstractRestService;
import com.lzhijin.blog.common.ResponseResult;
import com.lzhijin.blog.service.bll.LabelBLL;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabelControllerTest extends AbstractRestService {
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
    public ResponseResult getAllLabel(){
        try{
            return this.buildSuccessResult(labelBLL.getAllLabel());
        } catch(Exception e){
            e.printStackTrace();
//            logger.error("查询博客列表失败: " + e.getMessage());
            return this.buildErrorResult("查询博客列表失败");
        }
    }

}