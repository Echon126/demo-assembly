package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.demo.entity.ParamInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParamInfoMapper extends BaseMapper<ParamInfo> {
    void insertParam (ParamInfo paramInfo) ;
}
