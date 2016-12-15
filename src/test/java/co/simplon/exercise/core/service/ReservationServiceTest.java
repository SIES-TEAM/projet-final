package co.simplon.exercise.core.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring-config.xml"
})
public class ReservationServiceTest {

    @Autowired
    private ReservationService reservationService;

//    @Test
//    public void searchAvailibilityByDate() throws Exception {
//        reservationService.(LocalDate.of(2014, Month.JANUARY, 1), LocalTime.of(15,00,00), LocalTime.of(16,00,00));
//    }

}