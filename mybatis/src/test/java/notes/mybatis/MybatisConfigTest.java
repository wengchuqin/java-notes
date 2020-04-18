package notes.mybatis;

import notes.mybatis.gen.SimpleTable;
import notes.mybatis.gen.SimpleTableMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static notes.mybatis.gen.SimpleTableDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isBetween;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MybatisConfigTest {
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private SimpleTableMapper simpleTableMapper;


    @Test
    public void test2(){
        System.out.println(cityMapper.findByState("广东"));
    }


    @Test
    public void test3() {
        SelectStatementProvider selectStatement =
                select(id, firstName, lastName)
                        .from(simpleTable)
                        .where()
                        .and(id, isBetween(1).and(4))
                        .orderBy(firstName)
                        .build()
                        .render(RenderingStrategies.MYBATIS3);
        List<SimpleTable> results = simpleTableMapper.selectMany(selectStatement);
        System.out.println(results);
    }



}