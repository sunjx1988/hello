package com.framework.helper;

import com.framework.ConfigConstant;
import com.framework.util.PropsUtil;

import java.util.Properties;

/**
 * Created by sunjx on 2018/1/9.
 */
public final class ConfigHelper {

    private static final Properties PROPERTIES_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取应用基础包名
     */
    public static String getAppBasePackage(){
        return PropsUtil.getString(PROPERTIES_PROPS, ConfigConstant.APP_BASE_PACKAGE, "");
    }
}
