package net.africanbank.controller;

import net.africanbank.domain.ApplicationQueue;
import net.africanbank.service.ApplicationQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by patricktchankue on 5/13/16.
 */
@RestController
@RequestMapping(value = "/application/queue")
public class ApplicationQueueController {

    @Autowired
    private ApplicationQueueService applicationQueueService;

    @RequestMapping(value = "/")
    public List<ApplicationQueue> get() {

        //return new ResponseEntity<ApplicationQueue>(application, HttpStatus.OK);
        return applicationQueueService.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Cacheable("application_queue")
    public ApplicationQueue getRule(@RequestParam(value = "type", required=true) String type,
                                    @RequestParam(value="queue", required=true) String queue,
                                    @RequestParam(value="reason", required=true) String reason) {

        return applicationQueueService.findApplicationByParam(type, queue, reason);
    }

    @RequestMapping(value = "/rule", method = RequestMethod.POST)
    public ApplicationQueue get(@Valid @RequestBody ApplicationQueue application) {
        return applicationQueueService.findApplicationByParam(application.getApplicationType(),
                application.getQueueName(), application.getReasonCode());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity add(@Valid @RequestBody ApplicationQueue application) {
        try {
            ApplicationQueue app = applicationQueueService.save(application.getRuleName(),application.getApplicationType(),
                    application.getQueueName(), application.getReasonCode(), application.getResult());
            return new ResponseEntity<ApplicationQueue>(app, HttpStatus.CREATED);
        }catch (Exception ex){
            Map<String,String> result = new HashMap<String,String>();

            result.put("message", ex.toString());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(result);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody ApplicationQueue application) {
        try {
            ApplicationQueue app = applicationQueueService.update(application);
            return new ResponseEntity<ApplicationQueue>(app, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            Map<String,String> result = new HashMap<String,String>();

            result.put("message", ex.toString());
            result.put("error", "404");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(result);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity delete(@Valid @RequestBody ApplicationQueue application) {
        Map<String,String> result = new HashMap<String,String>();

        try {
            ApplicationQueue app = applicationQueueService.update(application);
            result.put("message", application.getId() + " Successfully deleted!");
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(result);

        }catch (Exception ex){

            result.put("message", ex.toString());
            result.put("error", "404");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(result);
        }
    }



}
