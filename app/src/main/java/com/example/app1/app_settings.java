package com.example.app1;

import java.io.Serializable;

public class app_settings implements Serializable {

    private String setting_name;
    private String setting_feature;

    public app_settings(String setting_name,String setting_feature)
    {
        this.setting_name=setting_name;
        this.setting_feature=setting_feature;

    }


    public void setSetting_name(String name)
    {
        setting_name=name;
    }

    String getSetting_name()
    {
        return setting_name;
    }

    public void setSetting_feature(String f)
    {
        setting_feature=f;
    }

    String getSetting_feature()
    {
        return setting_feature;
    }
}
