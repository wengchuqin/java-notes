package notes.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MybatisConfigTest {
    @Autowired
    private CityMapper cityMapper;


    @Test
    public void test2(){
        System.out.println(cityMapper.findByState("广东"));
    }
}