package spark.fr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spark.fr.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
