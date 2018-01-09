package com.framework;

import com.framework.helper.ClassHelper;
import com.framework.helper.ConfigHelper;
import com.framework.util.ClassUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sunjx on 2018/1/9.
 */
public final class HelperLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelperLoader.class);

    public static void init(){
        try {

            Class<?>[] classList = {
                    ConfigHelper.class,
                    ClassHelper.class
            };

            for (Class<?> cls : classList){
                LOGGER.info("load " + cls.getName());
                ClassUtil.loadClass(cls.getName(), true);
            }

        }catch (Exception e){
            LOGGER.error("load class failure");
        }
        LOGGER.info("load all class success");
    }
}
