package at.bha.CCRest.repository;

import at.bha.CCRest.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface GreetingRepository extends CrudRepository<Greeting,Integer> {



}
