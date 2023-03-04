package pro.sky.animalshelterbot.service;

import org.springframework.stereotype.Service;
import pro.sky.animalshelterbot.repository.VolunteerRepository;

/**
 * Класс сервиса для работы с {@link VolunteerRepository} и сущностью {@link pro.sky.animalshelterbot.model.Volunteer}
 */
@Service
public class VolunteerService {

    private final VolunteerRepository volunteerRepository;

    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }


}
