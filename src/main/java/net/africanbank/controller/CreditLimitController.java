package net.africanbank.controller;

import net.africanbank.domain.CreditLimit;
import net.africanbank.repository.CreditLimitRepository;
import net.africanbank.service.CreditLimitService;
import net.africanbank.utils.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by patricktchankue on 6/1/16.
 */

@RestController
@RequestMapping(value = "/credit-limit")
public class CreditLimitController {

    @Autowired
    private CreditLimitService service;



    @RequestMapping("/")
    public List<CreditLimit> getAll(){
        return service.findAll();
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public ResponseEntity search(@RequestParam("card_type") String card_type,
                              @RequestParam("num_credit_card") String num_credit_card,
                              @RequestParam("home_owner") String home_owner)
    {


        List<CreditLimit> rules = getAll();
        CreditLimit input = new CreditLimit(card_type, num_credit_card, home_owner);

        CreditLimit match = null;

        for(int i=0; i< rules.size(); i++){
            if(rules.get(i).match(input)){
                match = rules.get(i);
            }
        }

        if (match==null){
            Map<String,String> result = new HashMap<String,String>();
            result.put("message", "Could not find the corresponding rule");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(result);
        } else{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(match);
        }
        //return match;

    }
}
