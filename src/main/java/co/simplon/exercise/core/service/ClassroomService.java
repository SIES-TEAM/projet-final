package co.simplon.exercise.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.exercise.core.model.Classroom;
import co.simplon.exercise.core.repository.ClassroomRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ClassroomService extends GenericService< Classroom, ClassroomRepository >{

    @Autowired
    private ClassroomRepository classroomRepository;

    public List<Classroom> getAvailableRooms(LocalDate resDate, LocalTime startTime, LocalTime endTime){
        List<Classroom> rooms = classroomRepository.findAvailabeRoomsByDateAndHour(resDate, startTime, endTime);
        return rooms;
    }

}

