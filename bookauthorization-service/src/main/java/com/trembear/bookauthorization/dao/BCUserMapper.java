package com.trembear.bookauthorization.dao;

import java.util.List;

import com.trembear.bookauthorization.entity.BCUser;
import com.trembear.bookauthorization.entity.BCUserExample;
import org.apache.ibatis.annotations.Param;

public interface BCUserMapper {
    int countByExample(BCUserExample example);

    int deleteByExample(BCUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(BCUser record);

    int insertSelective(BCUser record);

    List<BCUser> selectByExample(BCUserExample example);

    BCUser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") BCUser record, @Param("example") BCUserExample example);

    int updateByExample(@Param("record") BCUser record, @Param("example") BCUserExample example);

    int updateByPrimaryKeySelective(BCUser record);

    int updateByPrimaryKey(BCUser record);
}