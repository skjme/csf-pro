package cn.chaseshu.shardingjdbcmasterslave;

import cn.chaseshu.shardingjdbcmasterslave.repository.UserRepository;
import cn.chaseshu.shardingjdbcmasterslave.service.UserService;
import com.sun.imageio.plugins.png.PNGImageReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcMasterSlaveApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	UserRepository userRepository;

	@Test
	public void contextLoads() {

		userService.list();
		//userRepository.list();
	}

}
