package pro.sky.animalshelterbot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.sky.animalshelterbot.model.Pet;
import pro.sky.animalshelterbot.repository.PetRepository;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Transactional
    public void create(String petName) {
        Pet pet = new Pet();
        pet.setPetName(petName);
        petRepository.save(pet);
    }
}
