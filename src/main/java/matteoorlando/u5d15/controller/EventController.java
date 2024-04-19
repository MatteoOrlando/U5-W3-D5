package matteoorlando.u5d15.controller;

import matteoorlando.u5d15.entities.Event;
import matteoorlando.u5d15.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    // Metodo per ottenere tutti gli eventi
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Metodo per creare un nuovo evento
    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    // Metodo per aggiornare un evento esistente
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    // Metodo per eliminare un evento esistente
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        return eventService.deleteEvent(id);
    }

}
