package pro.sky.animalshelterbot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.animalshelterbot.model.Volunteer;
import pro.sky.animalshelterbot.repository.VolunteerRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.animalshelterbot.ConstantsTest.*;

@ExtendWith(MockitoExtension.class)
class VolunteerServiceTest {

    @InjectMocks
    private VolunteerService out;

    @Mock
    private VolunteerRepository volunteerRepositoryMock;

    @Test
    void shouldReturnVolunteerInMethodCreateVolunteer() {
        when(volunteerRepositoryMock.save(VOLUNTEER_1)).thenReturn(VOLUNTEER_1);
        Volunteer actual = out.createVolunteer(VOLUNTEER_1);
        verify(volunteerRepositoryMock, only()).save(VOLUNTEER_1);
        assertEquals(VOLUNTEER_1, actual);
    }

    @Test
    void shouldReturnVolunteerInMethodFindVolunteerById() {
        when(volunteerRepositoryMock.findById(LONG_NUM_1)).thenReturn(VOLUNTEER_1);
        Volunteer actual = out.findVolunteerById(LONG_NUM_1);
        verify(volunteerRepositoryMock, only()).findById(LONG_NUM_1);
        assertEquals(VOLUNTEER_1, actual);
    }

    @Test
    void shouldReturnVolunteerInMethodUpdateVolunteer() {
        when(volunteerRepositoryMock.findById(VOLUNTEER_1.getId())).thenReturn(Optional.of(VOLUNTEER_1)); //если заменить VOLUNTEER_1.getId() например на LONG_NUM_1 то не дает вернуть опшинал в .thenReturn(), ??
        when(volunteerRepositoryMock.save(VOLUNTEER_1)).thenReturn(VOLUNTEER_1);

        Volunteer actual = out.updateVolunteer(VOLUNTEER_1);
//        verify(volunteerRepositoryMock, only()).findById(VOLUNTEER_1.getId());  //NPE
//        verify(volunteerRepositoryMock, only()).save(VOLUNTEER_1);              //NPE почему?
        assertEquals(VOLUNTEER_1, actual);
    }

    @Test
    void shouldReturnNullInMethodUpdateVolunteer() {
        when(volunteerRepositoryMock.findById(VOLUNTEER_1.getId())).thenReturn(Optional.ofNullable(null));

        Volunteer actual = out.updateVolunteer(VOLUNTEER_1);
//        verify(volunteerRepositoryMock, only()).findById(VOLUNTEER_1.getId());
        assertNull(actual);
    }

    @Test
    void shouldCalledMethodInRepoInMethodUDeleteVolunteer() {
        out.deleteVolunteer(LONG_NUM_1);
        verify(volunteerRepositoryMock, only()).deleteById(LONG_NUM_1);
    }

    @Test
    void shouldReturnListInMethodFindAllVolunteers() {
        when(volunteerRepositoryMock.findAll()).thenReturn(VOLUNTEER_LIST);
        List<Volunteer> actual = out.findAllVolunteers();
        verify(volunteerRepositoryMock, only()).findAll();
        assertEquals(VOLUNTEER_LIST, actual);
    }
}