package com.hclproject.TrainTicket.UserService.UserServiceImpl;

import com.hclproject.TrainTicket.Entity.Train;
import com.hclproject.TrainTicket.Entity.User;
import com.hclproject.TrainTicket.UserRepository.TrainRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TrainServiceImplTest {

    @Mock
    private TrainRepository trainRepository;
    private  TrainServiceImpl trainServiceTest;

    @BeforeEach
    void setUp() {

        trainServiceTest=new TrainServiceImpl(trainRepository);
    }

    @Test
    void saveTrain() {

        Train train=new Train(
                4L,1023,"trainname","Source","Destination",100,
                Date.valueOf(LocalDate.now())
        );
        trainServiceTest.saveTrain(train);
        ArgumentCaptor<Train> userArgumentCaptor=
                ArgumentCaptor.forClass(Train.class);
        Mockito.verify(trainRepository)
                .save(userArgumentCaptor.capture());
        Train captorValue = userArgumentCaptor.getValue();

        assertThat(captorValue).isEqualTo(train);
    }

    @Test
    void getalltrain() {
        trainServiceTest.getalltrain();
        Mockito.verify(trainRepository).findAll();
    }
}