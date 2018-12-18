package com.trembear.bookauthorization;

import com.trembear.bookauthorization.dao.BCUserMapper;
import com.trembear.bookauthorization.entity.BCUser;
import com.trembear.bookauthorization.entity.BCUserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookauthorizationApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private BCUserMapper bcUserMapper;
    @Test
    public void contextLoads() {
//        List<BCUser> list= bcUserMapper.selectByExample(new BCUserExample());
        BCUser bcUser=new BCUser();
        bcUser.setUsername("tom");
        bcUser.setPassword("123456");
        bcUser.setBookcoin(12);
        bcUser.setIsused("1");
        bcUser.setPhone("13125090573");
        bcUser.setWxnumber("trembear");
        bcUserMapper.insert(bcUser);

    }

}
