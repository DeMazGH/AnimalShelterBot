package pro.sky.animalshelterbot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.sky.animalshelterbot.model.Connection;
import pro.sky.animalshelterbot.repository.ConnectoinRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 */
public class ConnectionService {
    @Service
    public class PetService {

        private final ConnectoinRepository connectionRepository;

        public PetService(ConnectoinRepository connectionRepository) {
            this.connectionRepository = connectionRepository;
        }

        @Transactional
        public void create(long petId, long chatId, LocalDateTime dateTime) {
            Connection connection = new Connection();
            connection.setPetId(petId);
            connection.setChatId(chatId);
            connection.setDateTime(dateTime.truncatedTo(ChronoUnit.MINUTES));
            connectionRepository.save(connection);
        }
    }
}