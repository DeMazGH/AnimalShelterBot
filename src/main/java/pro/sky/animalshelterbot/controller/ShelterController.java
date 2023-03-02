package pro.sky.animalshelterbot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


}
