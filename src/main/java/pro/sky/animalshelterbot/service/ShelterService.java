package pro.sky.animalshelterbot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.animalshelterbot.model.Shelter;
import pro.sky.animalshelterbot.repository.ShelterRepository;

/**
 * Класс сервиса для работы с {@link ShelterRepository} и сущностью {@link Shelter}
 */
@Service
public class ShelterService {

    private final ShelterRepository shelterRepository;

    private final Logger logger = LoggerFactory.getLogger(ShelterService.class);

    public ShelterService(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    /**
     * Метод сохраняет {@link Shelter с помошью метода {@link ShelterRepository#save(Object)}.
     *
     * @param shelter данные о приюте, не может быть {@code null}
     */
    public Shelter createShelter(Shelter shelter) {
        logger.info("Was invoked method - createShelter");
        return shelterRepository.save(shelter);
    }
}
