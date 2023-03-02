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
        return ResponseEntity.ok(createdShelter);
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

    /**
     * Метод принимает запрос с телом в формате JSON и создает сущность {@link Shelter}
     * Используется метод createShelter из сервиса {@link ShelterService}
     *
     * @param shelter тело запроса с измененными данными о приюте
     * @return 200 - данные измененного приюта, 404 - приют не найден
     */
    @PutMapping
    public ResponseEntity<Shelter> updateShelter(@RequestBody Shelter shelter) {
        Shelter updatedShelter = shelterService.updateShelter(shelter);
        if (updatedShelter == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedShelter);
    }

    /**
     * Метод принимает запрос с параметром id приюта и удаляет сущность {@link Shelter}
     * Используется метод createShelter из сервиса {@link ShelterService}
     *
     * @param shelterId идентификатор удаляемого приюта
     * @return 200
     */
    @DeleteMapping("{shelterId}")
    public ResponseEntity<Shelter> deleteShelter(@PathVariable long shelterId) {
        shelterService.deleteShelter(shelterId);
        return ResponseEntity.ok().build();
    }
}
