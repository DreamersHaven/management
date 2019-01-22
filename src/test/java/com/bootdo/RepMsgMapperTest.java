package com.bootdo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootdo.wechat.dao.RespMsgDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepMsgMapperTest {

	@Autowired
	private RespMsgDao respMsgDao;
	@Test
	@Rollback
	public void test() {
		System.out.println(respMsgDao.list(null));
	}

}
