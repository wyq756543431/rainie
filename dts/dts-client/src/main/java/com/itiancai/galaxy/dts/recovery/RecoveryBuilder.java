package com.itiancai.galaxy.dts.recovery;


import com.google.common.collect.Maps;
import com.itiancai.galaxy.dts.XAResourceActionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RecoveryBuilder implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(RecoveryBuilder.class);

    private Map<String, ActivityStateResolver> activityStateResolverHashMap = Maps.newHashMap();

    private Map<String, XAResourceActionService> actionServiceHandlerMap = Maps.newHashMap();

    private ListableBeanFactory beanFactory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.beanFactory = applicationContext;
    }

    public ActivityStateResolver getActivityStateResolver(String name) {
        if (activityStateResolverHashMap.isEmpty()) {
            init();
        }
        return this.activityStateResolverHashMap.get(name);
    }

    public boolean exists(String type, String name) {
        init();
        if(type.equals("action")){
            return actionServiceHandlerMap.containsKey(name);
        }

        if(type.equals("activity")){
            return activityStateResolverHashMap.containsKey(name);
        }

        return false;
    }



    public XAResourceActionService getActionServiceHandler(String name) {
        if (actionServiceHandlerMap.isEmpty()) {
            init();
        }
        return this.actionServiceHandlerMap.get(name);
    }


    private void init() {

        Map<String, ActivityStateResolver> activityStateResolverMap = beanFactory.getBeansOfType(ActivityStateResolver.class);
        for (ActivityStateResolver activityStateResolver : activityStateResolverMap.values()) {
            logger.info("init ActivityStateResolver name is {}", activityStateResolver.name());
            this.activityStateResolverHashMap.put(activityStateResolver.name(), activityStateResolver);
        }

        Map<String, XAResourceActionService> actionServiceHandlerMap = beanFactory.getBeansOfType(XAResourceActionService.class);

        for (XAResourceActionService actionServiceHandler : actionServiceHandlerMap.values()) {
            logger.info("init actionServiceHandler name is {}", actionServiceHandler.name());
            this.actionServiceHandlerMap.put(actionServiceHandler.name(), actionServiceHandler);
        }


    }


}
