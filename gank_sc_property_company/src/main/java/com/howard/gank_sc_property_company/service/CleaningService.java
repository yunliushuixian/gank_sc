package com.howard.gank_sc_property_company.service;


import org.springframework.stereotype.Service;

@Service
public class CleaningService {

    public void acceptCleaningTask(String msg) {
        System.out.println("物业接受打扫任务" + msg);
    }
}
