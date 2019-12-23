package com.techedge.spring.ums.data.repository;

import com.techedge.spring.ums.data.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserPersistance(){
        User user = new User("Murugesh", "Kumar");
        testEntityManager.persist(user);
        testEntityManager.flush();

        User userFromDB = userRepository.findById(1).orElse(null);

        Assert.assertNotNull(userFromDB);
        Assert.assertEquals("Murugesh",userFromDB.getFirstName());
        Assert.assertEquals("Kumar",userFromDB.getLastName());
        Assert.assertNotNull(userFromDB.getId());

    }


}
