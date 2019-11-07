package com.howard.gank_sc_hystrix.service;

import com.howard.gank_sc_common.module.Person;
import com.howard.gank_sc_hystrix.config.ServerConfig;
import com.howard.gank_sc_hystrix.dao.PersonRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ServerConfig serverConfig;

    /**
     * 在@HystrixCommand注解的地方，如果查询时间过长，许可服务将中断数据库的调用。默认是1000ms
     * nested exception is com.netflix.hystrix.exception.HystrixRuntimeException: getPersonByName timed-out and fallback failed
     * <p>
     * 通过向@HystrixCommand注解中传递额外的参数，可以自定义Hystrix的等待时机;execution.isolation.thread.timeoutInMilliseconds设置超时时间长度
     *
     * @param id
     * @return
     */
    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")}, fallbackMethod = "getDefaultPersonInfo", threadPoolKey = "personPool", threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "3"), @HystrixProperty(name = "maxQueueSize", value = "10")})
    public Person getPersonByName(String id) {
        System.out.println(Thread.currentThread().getId());
        //randomRunLong();
        Optional<Person> person = personRepository.findById(id);
        return person.orElse(new Person("1", "admin1", 10, "gank", "engineer", "none"));
    }

    private void randomRunLong() {
        Random random = new Random();
        int randomNum = random.nextInt((3 - 1) + 1) + 1;
        if (randomNum == 3) sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Person getDefaultPersonInfo(String id) {
        System.out.println("进入回退机制···");
        Person person1 = new Person(id, "fallback", 10, "gank", "engineer", "none");
        person1.setComment(serverConfig.comment);
        return person1;
    }
}
