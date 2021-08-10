package com.hclproject.TrainTicket.UserService.UserServiceImpl;

import com.hclproject.TrainTicket.Entity.Passengers;
import com.hclproject.TrainTicket.Entity.TicketEntity;
import com.hclproject.TrainTicket.Entity.Train;
import com.hclproject.TrainTicket.UserRepository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class TicketServiceImplTest {

    @Mock
    private TicketRepository ticketRepository;
    private TicketServiceImpl ticketServicetest;

    @BeforeEach
    void setUp() {

        ticketServicetest=new TicketServiceImpl(ticketRepository);
    }

    @Test
    void bookById() {
        List<Passengers> passenger=new ArrayList<>();
        passenger.add(new Passengers(5L,"raj",25,5L));

        TicketEntity tickets=new TicketEntity(2,25,1,300.00,1,"bng","kol",
                passenger );
        ticketServicetest.booktickets(tickets);
        ArgumentCaptor<TicketEntity> userArgumentCaptor=
                ArgumentCaptor.forClass(TicketEntity.class);
        Mockito.verify(ticketRepository)
                .save(userArgumentCaptor.capture());
        TicketEntity captorValue = userArgumentCaptor.getValue();

        assertThat(captorValue).isEqualTo(tickets);
    }
}