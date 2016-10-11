package net.africanbank.service;

import net.africanbank.domain.ApplicationQueue;
import net.africanbank.repository.ApplicationQueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by patricktchankue on 5/13/16.
 */
@Service
@Transactional
public class ApplicationQueueServiceImpl implements ApplicationQueueService {

    @Autowired
    private ApplicationQueueRepository appQueueRepository;

    public List<ApplicationQueue> findAll() {
        return appQueueRepository.findAll();
        //return null;
    }

    public ApplicationQueue findApplicationByParam(String type, String queue, String reason){
        System.out.println(">>> findApplication by param "+ type + " " + queue + " "+ reason);
        return appQueueRepository.findByApplicationTypeAndQueueNameAndReasonCode(type, queue, reason);
    }

    public ApplicationQueue save(String name, String type, String queue, String reason, String result){
        return appQueueRepository.save(new ApplicationQueue(name, type, queue, reason, result));
    }

    public ApplicationQueue update(ApplicationQueue app){
        System.out.println(">>> update this:" + app.getId() + " " + app.getResult());

        ApplicationQueue update =  appQueueRepository.findOne(app.getId());
        System.out.println(">>> found: " + update +"\n"+ app);
        if(update != null){
            update.setRuleName(app.getRuleName());
            update.setApplicationType(app.getApplicationType());
            update.setQueueName(app.getQueueName());
            update.setReasonCode(app.getReasonCode());
            update.setResult(app.getResult());

            return appQueueRepository.save(update);

        } else {
            return null;
        }

    }

    public void delete(ApplicationQueue app) {

        ApplicationQueue item =  appQueueRepository.findOne(app.getId());

        if(item != null){

            appQueueRepository.delete(item);

        } else {
            System.out.println(">>> Couldn't find the record to be deleted");
        }
    }


}
