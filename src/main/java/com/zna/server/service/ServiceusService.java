package com.zna.server.service;

import com.zna.server.dao.ServiceusDAO;
import com.zna.server.entity.bo.ServiceusBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service("serviceService")
@Transactional
public class ServiceusService {
    @Resource
    private ServiceusDAO serviceusDAO;


    public void updateservice(String pictureUrl,String pictureUrlPc,String context,String title){
        ServiceusBO serviceusBO = new ServiceusBO();
        serviceusBO.setTitle(title);
        serviceusBO.setContext(context);
        serviceusBO.setPictureUrl(pictureUrl);
        serviceusBO.setPictureUrlPc(pictureUrlPc);
        //查询表中数据
        int t = serviceusDAO.getCount();
        //没有数据就新增
        if (t<1){
            serviceusDAO.addservice(serviceusBO);
        }else {
            //有数据就修改更新
            serviceusDAO.updateservice(serviceusBO);
        }

    }

    public ServiceusBO getservice(){
        return serviceusDAO.getservice();
    }


}
