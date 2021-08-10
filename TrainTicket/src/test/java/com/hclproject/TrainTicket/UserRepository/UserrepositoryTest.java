package com.hclproject.TrainTicket.UserRepository;

import com.hclproject.TrainTicket.Entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserrepositoryTest {

    @Autowired
    private Userrepository undertest;

    @AfterEach
    void tearDown() {
        undertest.deleteAll();
    }

    @Test
    void itShouldfindByUserNameAndPassWord() {
        //given
        String username = "abc";
        String passWord = "1234";
        User user=new User(
                username,
                passWord,
                "rambo@gmail.com",
                "123456789",
                20,
                "user"
        );
        undertest.save(user);
        //when
        undertest.findByUserNameAndPassWord(username,passWord);
         boolean j= undertest.findByUserNameAndPassWord(username,passWord).contains(user.getUserName());
        //then
        assertThat(j).isTrue();
    }
}