package net.africanbank.repository;

import net.africanbank.domain.ApplicationQueue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationQueueRepository extends JpaRepository<ApplicationQueue,Long> {

    ApplicationQueue findByApplicationTypeAndQueueNameAndReasonCode(String application_type, String queue_name, String reason_code);

}