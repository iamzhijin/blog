package com.lzhijin.blog.service.bll;

import com.lzhijin.blog.entity.Label;
import com.lzhijin.blog.service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelBLL {
    @Autowired
    ILabelService labelService;

    /**
     * 获取所有标签
     *
     * @return
     * @author lzhijin
     * @since 2019-09-26
     */
    public List<Label> getAllLabel(){
        return labelService.list();
    }
}
