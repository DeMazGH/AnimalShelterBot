package pro.sky.animalshelterbot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.sky.animalshelterbot.model.Pet;
import pro.sky.animalshelterbot.repository.PetRepository;

/**
 *Класс сервиса для работы с {@link PetRepository} и сущностью {@link Pet}
 */
@Service
public class PetService {

    private final PetRepository petRepository;

    private final Logger logger = LoggerFactory.getLogger(PetService.class);

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    /**
     * Метод создает экземпляр класса {@link Pet} и устанавливает значение его полей согласно значениям
     * параметров метода, после этого сохраняет сущность в БД с помошью метода {@link PetRepository#save(Object)}.
     *
     * @param petName имя питомца, не может быть {@code null}
     */
    @Transactional
    public void create(String petName) {
        logger.info("Method create has been run");

        Pet pet = new Pet();
        pet.setPetName(petName);
        petRepository.save(pet);
    }
}
