package com.zna.server.dao;

import com.zna.server.entity.bo.ContactWayBO;

public interface ContactWayDAO {
    /**
     * 添加联系方式
     * @param contactWayBO
     */
    void addContactWay(ContactWayBO contactWayBO);

    /**
     * 修改联系方式
     * @param contactWayBO
     */
    void updateContactWay(ContactWayBO contactWayBO);

    /**
     * 查询条数
     * @return
     */
    int getCount();

    /**
     * 查询
     * @return
     */
    ContactWayBO getContactWay();
}
