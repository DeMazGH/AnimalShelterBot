package pro.sky.animalshelterbot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Класс содержит информацию о приюте
 */
@Entity
public class Shelter {
    /**
     * идентификатор записи, primary key
     */
    @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;
}
