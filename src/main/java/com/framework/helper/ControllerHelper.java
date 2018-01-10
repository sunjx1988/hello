package com.framework.helper;

import com.framework.annotation.Action;
import com.framework.annotation.Controller;
import com.framework.bean.ActionHandler;
import com.framework.bean.Request;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by sunjx on 2018/1/10.
 */
public final class ControllerHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerHelper.class);

    /**
     * 请求和请求处理类映射
     */
    private static final Map<Request, ActionHandler> ACTION_HANDLER_MAP = new HashMap<>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getClassByType(Controller.class);

        if(!CollectionUtils.isEmpty(controllerClassSet)) {
            for (Class<?> controllerClass : controllerClassSet) {

                Method[] methods = controllerClass.getDeclaredMethods();

                if(ArrayUtils.isNotEmpty(methods)){
                    for(Method method : methods){

                        if(method.isAnnotationPresent(Action.class)){
                            //获取注解类
                            Action action = method.getAnnotation(Action.class);
                            //获取注解值
                            String mapping = action.value();

                            //验证url映射规则
                            if(mapping.matches("\\w+:/\\w*")){
                                //拆分请求方法，请求路径
                                String [] array = mapping.split(":");
                                if(ArrayUtils.isNotEmpty(array) && array.length == 2){
                                    String requestMethod = array[0].toLowerCase();
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod,requestPath);
                                    ActionHandler handler = new ActionHandler(controllerClass, method);
                                    ACTION_HANDLER_MAP.put(request, handler);

                                    LOGGER.info("action handler {RequestPath:"+ requestPath +", RequestMethod:"+requestMethod+"," +
                                            " HandlerClass:"+handler.getClass().getName()+", HandlerMethod:"+method.getName()+"}");
                                }
                            }
                        }
                    }
                }
            }

            LOGGER.info("action handler map completed");
        }
    }

    /**
     * 获取ActionHandler
     */
    public static ActionHandler getHandler(String requestMethod, String requestPath){
        Request request = new Request(requestMethod.toLowerCase(), requestPath);
        return ACTION_HANDLER_MAP.get(request);
    }
}
