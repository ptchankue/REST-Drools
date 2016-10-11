package net.africanbank.controller;

import net.africanbank.domain.Credit;
import net.africanbank.domain.CreditLimit;
import net.africanbank.utils.DroolsUtil;
import org.drools.runtime.StatefulKnowledgeSession;
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
 * Created by patricktchankue on 6/2/16.
 */

@RestController
@RequestMapping(value = "/drools/credit-limit")
public class DroolsExampleController {

    Map<String, String> response = new HashMap<String, String>();

    @RequestMapping("/")
    public ResponseEntity getAll() {
        Map<String, String> result = new HashMap<String, String>();
        result.put("message", "Welcome to DROOLS rules wrapped in REST APIs");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(result);

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity checkRule(@RequestParam("card_type") String card_type,
                                    @RequestParam("num_credit_card") int num_credit_card,
                                    @RequestParam("home_owner") boolean home_owner) {

        DroolsUtil util = new DroolsUtil();

        StatefulKnowledgeSession session = util.createKnowledgeBase("credit_limit.drl")
                .newStatefulKnowledgeSession();

        Credit input = new Credit(card_type, home_owner, num_credit_card);

        try{
            session.insert(input);
            session.fireAllRules();

            System.out.println(input);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(input);

        }finally {
            session.dispose();
        }
//        response.put("message", "My response in case of issues");
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(response);

    }
}
/*

Database: packageBuilder.addPackageFromDrl(new StringReader(drl))
 */