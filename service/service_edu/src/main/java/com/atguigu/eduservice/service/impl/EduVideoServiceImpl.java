package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.mapper.EduVideoMapper;
import com.atguigu.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-04-07
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    //    注入vodclien
    @Autowired
    private VodClient vodClient;


    //    TODO 删除小节 删除对应的视频文件
    @Override
    public void removeVideoByCourseId(String courseId) {

//        根据课程id查询课程所有视频id
        QueryWrapper<EduVideo> wrapperVideo = new QueryWrapper<>();
        wrapperVideo.eq("courseid", courseId);
        wrapperVideo.select("videosourceid");
        List<EduVideo> eduVideoList = baseMapper.selectList(wrapperVideo);
//        List<EduVideo> -> List<String>
        List<String> videoIds = new ArrayList<>();
        for (int i = 0; i < eduVideoList.size(); i++) {
            EduVideo eduVideo = eduVideoList.get(i);
            String videosourceid = eduVideo.getVideosourceid();
            if (!StringUtils.isEmpty(videosourceid)) {
                videoIds.add(videosourceid);
            }
        }
//        删除多个视频id
        if (videoIds.size() > 0) {
            vodClient.deleteBatch(videoIds);
        }


//        this /basemapper
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("courseid", courseId);
        baseMapper.delete(wrapper);
    }
}
