package kurly.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SosRepository extends JpaRepository<Sos, Long> {


}
