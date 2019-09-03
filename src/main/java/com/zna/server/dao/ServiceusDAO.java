package com.zna.server.dao;

import com.zna.server.entity.bo.ServiceusBO;

public interface ServiceusDAO {
    void addservice(ServiceusBO serviceusBO);
    void updateservice(ServiceusBO serviceusBO);
    int getCount();
    ServiceusBO getservice();
}
