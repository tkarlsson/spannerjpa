package eu.flexiverse.spannerdemos.spannerjpa.repos;

import eu.flexiverse.spannerdemos.spannerjpa.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistsRepo extends JpaRepository<Artist, String>
{

}
