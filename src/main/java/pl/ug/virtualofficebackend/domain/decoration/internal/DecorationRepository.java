package pl.ug.virtualofficebackend.domain.decoration.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.decoration.entity.Decoration;

@Repository
public interface DecorationRepository extends JpaRepository<Decoration, Long> {
}
