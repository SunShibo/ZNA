package com.zna.server.dao;

import com.zna.server.entity.bo.AboutUsBO;

public interface AboutUsDAO {
    /**
     * 新增关于我们
     * @param aboutUsBO
     */
    void addAboutUs(AboutUsBO aboutUsBO);

    /**
     * 修改关于我们
     * @param aboutUsBO
     */
    void updateAboutUs(AboutUsBO aboutUsBO);

    /**
     * 查询条数
     * @return
     */
    int getCount();

    /**
     * 查询
     * @return
     */
    AboutUsBO getAboutUs();
}
