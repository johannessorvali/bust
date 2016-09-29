package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Arrest;

public interface ArrestRepository extends JpaRepository<Arrest, Long> {

    
    
}
