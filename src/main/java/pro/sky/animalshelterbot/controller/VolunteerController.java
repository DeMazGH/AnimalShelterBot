package pro.sky.animalshelterbot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    private final Logger logger = LoggerFactory.getLogger(VolunteerController.class);

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }



}
