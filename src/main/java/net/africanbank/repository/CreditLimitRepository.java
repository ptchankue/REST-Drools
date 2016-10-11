package net.africanbank.repository;

import net.africanbank.domain.CreditLimit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by patricktchankue on 6/1/16.
 */


public interface CreditLimitRepository extends JpaRepository <CreditLimit, Long> {

}
