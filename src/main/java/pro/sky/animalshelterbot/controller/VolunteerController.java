package pro.sky.animalshelterbot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.animalshelterbot.model.Volunteer;
import pro.sky.animalshelterbot.service.VolunteerService;

/**
 * Класс для обработки запросов от клиента и возвращения результатов,
 * работает с сущностью {@link pro.sky.animalshelterbot.service.VolunteerService}.
 */
@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    private final VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @PostMapping
    public ResponseEntity<Volunteer> createVolunteer(@RequestBody Volunteer volunteer) {

        Volunteer createdVolunteer = volunteerService.createVolunteer(volunteer);
        return ResponseEntity.ok(createdVolunteer);
    }

    @GetMapping("{volunteerId}")
    public ResponseEntity<Volunteer> findVolunteer(@PathVariable long volunteerId) {

        Volunteer volunteer = volunteerService.findVolunteerById(volunteerId);
        if (volunteer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(volunteer);
    }

    @PutMapping
    public ResponseEntity<Volunteer> updateVolunteer(@RequestBody Volunteer volunteer) {

        Volunteer updatedVolunteer = volunteerService.updateVolunteer(volunteer);
        if (updatedVolunteer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedVolunteer);
    }

    @DeleteMapping("{volunteerId}")
    public ResponseEntity<Volunteer> deleteVolunteer(@PathVariable long volunteerId) {

        volunteerService.deleteVolunteer(volunteerId);
        return ResponseEntity.ok().build();
    }
}
