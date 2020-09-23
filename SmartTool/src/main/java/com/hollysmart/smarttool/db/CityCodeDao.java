package com.hollysmart.smarttool.db;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.List;

public class CityCodeDao {
    private Dao<CityCodeBean, Integer> ope;
    public CityCodeDao(DBHelper helper) {
        try {
            ope = helper.getDao(CityCodeBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public CityCodeBean getCityInfo(String cityName){
        try {
            CityCodeBean bean = ope.queryBuilder().where().like("cityName", "%" + cityName + "%").queryForFirst();
            return bean;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public List<CityCodeBean> getAllData(){
        try {
            List<CityCodeBean>  list = ope.queryForAll();

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
