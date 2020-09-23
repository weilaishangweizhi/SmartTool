package com.hollysmart.smarttool.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "citycode")
public class CityCodeBean {


    @DatabaseField(columnName = "cityCode")
    private String cityCode;
    @DatabaseField(columnName = "cityName")
    private String cityName;
    @DatabaseField(columnName = "cityForShort")
    private String cityForShort;


    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityForShort() {
        return cityForShort;
    }

    public void setCityForShort(String cityForShort) {
        this.cityForShort = cityForShort;
    }


    @Override
    public String toString() {
        return "CityCodeBean{" +
                "cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityForShort='" + cityForShort + '\'' +
                '}';
    }
}
