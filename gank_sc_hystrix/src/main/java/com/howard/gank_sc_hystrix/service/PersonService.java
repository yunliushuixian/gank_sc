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
     *
     * circuitBreaker.requestVolumeThreshold:控制在Hystrix将考虑调用断路器跳闸之前，在一个10秒的窗口内必须出现的连续调用数量
     * circuitBreaker.errorThresholdPercentage:调用必须失败的百分比（由于超时，将抛出一个异常；或者返回HTTP 500）
     * circuitBreaker.sleepWindowInMilliseconds:一旦断路跳闸,Hystrix允许另外的调用通过来看服务是否恢复健康之前Hystrix将休眠的时间
     *
     * metrics.rollingStats.timeInMilliseconds,用于控制窗口的大小，默认是10秒
     * metrics.rollingStats.numBuckets:控制在窗口中定义并被收集的统计次数。
     * Hystrix将使用15秒窗口并将统计数据收集到五个长度为三秒的桶中。进入的统计窗口越小，窗口中保存的桶数越大，在高容量服务上就可以提高CPU和内存利用率。
     *
     *
     * @param id
     * @return
     */
    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"), @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "75"), @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "7000"), @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "15000"), @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "5")}, fallbackMethod = "getDefaultPersonInfo", threadPoolKey = "personPool", threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "3"), @HystrixProperty(name = "maxQueueSize", value = "10")})
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
