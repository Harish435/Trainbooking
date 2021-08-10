package com.hclproject.TrainTicket.UserService.UserServiceImpl;

import com.hclproject.TrainTicket.CustomException.UseralreadyExist;
import com.hclproject.TrainTicket.Entity.User;
import com.hclproject.TrainTicket.UserRepository.Userrepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;



import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private Userrepository userrepository;
       private UserServiceImpl userServiceTest;

    @BeforeEach
    void setUp() {

        userServiceTest=new UserServiceImpl(userrepository);
    }
    @Test
    void CangetAllUseres(){
        //when
         userServiceTest.getallusers();
         //then
       Mockito.verify(userrepository).findAll();//deleteAll fail

    }

    @Test
    void Cansaveusers() {
        User user=new User(
                (long) 9,
                "ukde",
                "4321",
                "kkk@gmail.com",
                "123456789",
                20,
                "user"
        );
        userServiceTest.saveusers(user);
        ArgumentCaptor<User> userArgumentCaptor=
                ArgumentCaptor.forClass(User.class);
        Mockito.verify(userrepository)
                .save(userArgumentCaptor.capture());
        User captorValue = userArgumentCaptor.getValue();

        assertThat(captorValue).isEqualTo(user);
    }

    @Test
    void willthrowemailtaken() {
        User user=new User(
                (long) 9,
                "ukde",
                "4321",
                "kkk@gmail.com",
                "123456789",
                20,
                "user"
        );

        given(userrepository.findByEmail(user.getEmail()))
                .willReturn(java.util.Optional.of(user));

        assertThatThrownBy(()->userServiceTest.saveusers(user))
                .isInstanceOf(UseralreadyExist.class)
                .hasMessageContaining("User Already Exist!!");
    }

    @Test
    @Disabled
    void getallusers() {
        when(userrepository.findAll()).thenReturn(Stream.of(new User((long) 9,
                "ukde",
                "4321",
                "kkk@gmail.com",
                "123456789",
                20,
                "user")
        ).collect(Collectors.toList()));
        assertEquals(1,userServiceTest.getallusers().size());
    }

}