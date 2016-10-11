package net.africanbank.service;

import net.africanbank.domain.ApplicationQueue;

import java.util.List;

/**
 * Created by patricktchankue on 5/13/16.
 */
public interface ApplicationQueueService {

    List<ApplicationQueue> findAll();

    ApplicationQueue findApplicationByParam(String type, String queue, String reason);
    ApplicationQueue save(String name, String type, String queue, String reason, String result);

    ApplicationQueue update(ApplicationQueue app);

    void delete(ApplicationQueue app);


}
