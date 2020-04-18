package notes.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author: wengchuqin
 * @create: 2020-04-18 17:28
 */
@Mapper
public interface CityMapper {

    @Select("SELECT * FROM city WHERE state = #{state}")
    City findByState(@Param("state") String state);

}

