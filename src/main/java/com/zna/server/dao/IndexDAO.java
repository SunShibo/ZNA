package com.zna.server.dao;

import com.zna.server.entity.bo.IndexBO;

import java.util.List;

public interface IndexDAO {
    /**
     * 添加首页内容
     * @param indexBO
     */
    void addIndex(IndexBO indexBO);

    /**
     * 删除首页内容
     * @param id
     */
    void delIndex(int id);

    /**
     * 修改首页内容
     * @param indexBO
     */
    void updateIndex(IndexBO indexBO);

    /**
     * 获取首页内容
     * @return
     */
    List<IndexBO> selectIndex();
}
