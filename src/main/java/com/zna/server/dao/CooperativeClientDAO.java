package com.zna.server.dao;

import com.zna.server.entity.bo.CooperativeClientBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CooperativeClientDAO {
    /**
     * 新增合作客户图片
     * @param cooperativeClientBO
     */
    void addCooperativeClient(CooperativeClientBO cooperativeClientBO);

    /**
     * 批量删除合作客户图片
     * @param ids
     * @return
     */
    boolean delCooperativeClient(@Param("ids") Integer[] ids);

    /**
     * 修改合作客户图片
     * @param cooperativeClientBO
     */
    void updateCooperativeClient(CooperativeClientBO cooperativeClientBO);

    /**
     * 查询合作客户图片
     * @return
     */
    List<CooperativeClientBO> getCooperativeClient();
}
