package co.simplon.exercise.core.service;

import co.simplon.exercise.core.model.Classroom;
import co.simplon.exercise.web.ClassroomController;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ClassroomServiceTest extends TestCase{

    private MockMvc mockMvc;

    @Autowired
    private ClassroomService roomServiceMock;

    @Before
    public void setUp() {
        roomServiceMock = mock(ClassroomService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new ClassroomController(roomServiceMock)).build();

    }

    //Add WebApplicationContext field here

    //The setUp() method is omitted.

    @Test
    @SuppressWarnings({ "deprecation", "unchecked" })
    public void test_n1() throws Exception {
        Classroom first  = new Classroom("room1",14);
        Classroom second = new Classroom("room2",10);
        final ArrayList<Classroom> roomList = new ArrayList<Classroom>();
        roomList.add( first );
        roomList.add( second );

        when(roomServiceMock.getAll()).thenReturn(roomList);
        when(roomServiceMock.addOrUpdate(Mockito.any(Classroom.class))).thenAnswer(new Answer() {
            public Object answer(InvocationOnMock invocation) {
                Classroom room = (Classroom) invocation.getArguments()[0];
                roomList.add(room);
                return room;
            }
        });
        MvcResult fullResult = mockMvc.perform(get("/classroom"))
                .andExpect(status().isOk()).andReturn();
        assertEquals( ((List)fullResult.getModelAndView().getModel().get("classrooms")).size(), 2 );

        mockMvc.perform(get("/classroom/add?name=salle&capacity=15"))
                .andExpect(status().isFound());
        assertEquals( roomList.size(), 3 );

    }

}