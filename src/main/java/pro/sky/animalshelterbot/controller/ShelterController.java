package pro.sky.animalshelterbot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.animalshelterbot.model.Shelter;
import pro.sky.animalshelterbot.service.ShelterService;

/**
 * Класс для обработки запросов от клиента и возвращения результатов,
 * работает с сущностью {@link pro.sky.animalshelterbot.service.ShelterService}.
 */
@RestController
@RequestMapping("/shelter")
public class ShelterController {

    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    /**
     * Метод принимает запрос с телом в формате JSON и создает сущность {@link Shelter}
     * Используется метод createShelter из сервиса {@link ShelterService}
     *
     * @param shelter тело запроса с данными о создаваемом приюте
     * @return в теле ответа возвращает данные созданного приюта
     */
    @PostMapping
    public ResponseEntity<Shelter> createShelter(@RequestBody Shelter shelter) {
        Shelter createdShelter = shelterService.createShelter(shelter);
        return ResponseEntity.ok(shelter);
    }
}
