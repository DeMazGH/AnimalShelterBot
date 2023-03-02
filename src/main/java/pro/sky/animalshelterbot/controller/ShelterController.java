package pro.sky.animalshelterbot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
     * @return данные созданного приюта
     */
    @PostMapping
    public ResponseEntity<Shelter> createShelter(@RequestBody Shelter shelter) {
        Shelter createdShelter = shelterService.createShelter(shelter);
        return ResponseEntity.ok(shelter);
    }

    /**
     * Метод принимает запрос с параметром id приюта и возвращает в теле ответа данные о приюте.
     *
     * @param shelterId - идентификатор приюта
     * @return 200 - данные о приюте, 404 - приют не найден
     */
    @GetMapping({"{shelterId}"})
    public ResponseEntity<Shelter> getShelter(@PathVariable long shelterId) {
        Shelter shelter = shelterService.findShelterById(shelterId);
        if (shelter == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shelter);
    }
}
