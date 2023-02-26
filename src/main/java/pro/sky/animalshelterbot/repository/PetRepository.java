package pro.sky.animalshelterbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.animalshelterbot.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
