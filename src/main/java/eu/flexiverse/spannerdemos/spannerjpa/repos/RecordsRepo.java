package eu.flexiverse.spannerdemos.spannerjpa.repos;

import eu.flexiverse.spannerdemos.spannerjpa.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordsRepo  extends JpaRepository<Record, String>  {
}
