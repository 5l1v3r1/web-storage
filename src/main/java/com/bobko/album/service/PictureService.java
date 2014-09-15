package com.bobko.album.service;

/**
 * @author oleksii bobko
 * @data 12.08.2013
 */

import java.util.List;

import com.bobko.album.domain.Picture;

public interface PictureService {

    public void addPicture(Picture pic);

    public List<Picture> list(int shift, int count);

    public Picture getPicture(Integer id);
    
    public void removePicture(Integer id);

}
