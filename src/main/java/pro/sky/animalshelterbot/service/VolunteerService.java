package pro.sky.animalshelterbot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.animalshelterbot.model.Volunteer;
import pro.sky.animalshelterbot.repository.VolunteerRepository;

/**
 * Класс сервиса для работы с {@link VolunteerRepository} и сущностью {@link pro.sky.animalshelterbot.model.Volunteer}
 */
@Service
public class VolunteerService {

    private final VolunteerRepository volunteerRepository;

    private final Logger logger = LoggerFactory.getLogger(VolunteerService.class);

    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    /**
     * Метод сохраняет сущность {@link Volunteer} в БД, с помошью метода {@link VolunteerRepository#save(Object)}
     *
     * @param volunteer данные о волонтере
     * @return данные о сохраненном волонтере
     */
    public Volunteer createVolunteer(Volunteer volunteer) {
        logger.info("Was invoked - method  createVolunteer");

        return volunteerRepository.save(volunteer);
    }

    /**
     * Метод ищет данные о волонтере по его id.
     * Используется метод {@link VolunteerRepository#findById(long)}
     *
     * @param id идентификатор волонтера
     * @return данные о волонтере
     */
    public Volunteer getVolunteer(long id) {
        logger.info("Was invoked method - getVolunteer");

        return volunteerRepository.findById(id);
    }

    /**
     * Метод изменяет данные волонтера, заменяет сущность {@link Volunteer} по указанному в ней id.
     * Используется метод {@link VolunteerRepository#save(Object)}
     *
     * @param updatedVolunteer измененные данные волонтера
     * @return измененные данные волонтера, если волонтер не найден возвращает {@code null}
     */
    public Volunteer updateVolunteer(Volunteer updatedVolunteer) {
        logger.info("Was invoked method - updateVolunteer");

        return volunteerRepository.save(updatedVolunteer);
    }

    /**
     * Метод удаляет сущность {@link Volunteer} по указанному id.
     * Используется метод {@link VolunteerRepository#deleteById(Object)}
     *
     * @param id идентификатор удаляемого волонтера
     */
    public void deleteVolunteer(long id) {
        logger.info("Was invoked method - deleteVolunteer");

        volunteerRepository.deleteById(id);
    }
}
