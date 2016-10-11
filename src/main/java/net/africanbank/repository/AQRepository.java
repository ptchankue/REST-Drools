package net.africanbank.repository;

import net.africanbank.domain.ApplicationQueue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AQRepository extends CrudRepository<ApplicationQueue,Long>{

	List<ApplicationQueue> findByApplicationTypeAndQueueNameAndReasonCode(String application_type, String queue_name, String reason_code);
}
