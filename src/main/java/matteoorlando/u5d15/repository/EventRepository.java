package matteoorlando.u5d15.repository;

import matteoorlando.u5d15.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByDate(String date);
    List<Event> findByLocation(String location);
}
