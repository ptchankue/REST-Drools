package net.africanbank.service;

import net.africanbank.domain.CreditLimit;
import net.africanbank.repository.CreditLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by patricktchankue on 6/1/16.
 */

@Service
@Transactional
public class CreditLimitServiceImpl implements CreditLimitService{

    @Autowired
    private CreditLimitRepository repo;

    public List<CreditLimit> findAll(){
        return repo.findAll();
    }
}
