package net.africanbank.service;

import net.africanbank.domain.CreditLimit;

import java.util.List;

/**
 * Created by patricktchankue on 6/1/16.
 */
public interface CreditLimitService {

    List<CreditLimit> findAll();
}
