package com.zna.server.dao;

import com.zna.server.entity.bo.FromPictureBO;

public interface FromPictureDAO {
    void addFromPicture(FromPictureBO fromPictureBO);
    void updateFromPicture(FromPictureBO fromPictureBO);
    int getCount();
    FromPictureBO getFromPicture();
}
