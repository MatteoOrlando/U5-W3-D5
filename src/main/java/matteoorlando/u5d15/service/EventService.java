package matteoorlando.u5d15.service;

import matteoorlando.u5d15.entities.Event;
import matteoorlando.u5d15.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.http.HttpStatus;


@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public ResponseEntity<?> createEvent(Event event) {

        if (event == null || event.getTitle() == null || event.getDate() == null || event.getLocation() == null || event.getAvailableSeats() <= 0) {
            return new ResponseEntity<>("Invalid event details", HttpStatus.BAD_REQUEST);
        }

        eventRepository.save(event);

        return new ResponseEntity<>("Event created successfully", HttpStatus.CREATED);
    }
}

