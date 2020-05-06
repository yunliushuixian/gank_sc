package com.howard.gank_sc_owner;

import com.howard.gank_sc_owner.cleaning.HouseCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventListener {
    @Autowired
    private HouseCleaningService houseCleaningService;

    @EventListener
    public void onStartApp(ApplicationEvent apx) {
        System.out.println("开始请求");
        houseCleaningService.submitClean("sss");
    }

}
