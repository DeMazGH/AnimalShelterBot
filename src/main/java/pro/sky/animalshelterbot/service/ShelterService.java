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
     * Метод создает экземпляр класса {@link Shelter} и устанавливает значение его полей согласно значениям
     * параметров метода, после этого сохраняет сущность в БД
     * с помошью метода {@link ShelterRepository#save(Object)}.
     *
     * @param name название приюта, не может быть {@code null}
     * @param address адрес приюта, не может быть {@code null}
     * @param info дополнительная информация о приюте
     * @param map карта, как добраться до приюта
     */
    public void createShelter(String name, String address, String info, byte[] map) {
        logger.info("Was invoked method - createShelter");

        Shelter shelter = new Shelter();
        shelter.setName(name);
        shelter.setAddress(address);
        shelter.setInfo(info);
        shelter.setMap(map);

        shelterRepository.save(shelter);
    }
}
