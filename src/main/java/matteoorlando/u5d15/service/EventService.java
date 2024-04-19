package matteoorlando.u5d15.service;

import matteoorlando.u5d15.entities.Event;
import matteoorlando.u5d15.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    //Add metodo per aggiornare un evento
    //verifico se l'evento esiste e, in caso affermativo,
    //aggiornio i dettagli dell'evento con quelli forniti nel updatedEvent
    public ResponseEntity<?> updateEvent(Long eventId, Event updatedEvent) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();

            event.setTitle(updatedEvent.getTitle());
            event.setDescription(updatedEvent.getDescription());
            event.setDate(updatedEvent.getDate());
            event.setLocation(updatedEvent.getLocation());
            event.setAvailableSeats(updatedEvent.getAvailableSeats());
            eventRepository.save(event);
            return new ResponseEntity<>("Event updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Event not found", HttpStatus.NOT_FOUND);
        }
    }
}

