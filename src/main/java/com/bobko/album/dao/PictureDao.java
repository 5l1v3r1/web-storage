package com.bobko.album.dao;

/**
 * @author oleksii bobko
 * @data 12.08.2013
 * @see PictureDAO
 */

import org.springframework.stereotype.Repository;

import com.bobko.album.dao.base.HibernateDao;
import com.bobko.album.dao.interfaces.IPictureDao;
import com.bobko.album.domain.Picture;

@Repository
public class PictureDao extends HibernateDao<Picture, Integer> implements
        IPictureDao<Picture, Integer> {
}
