package notes.mybatis.gen;

import static notes.mybatis.gen.SimpleTableDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import notes.mybatis.gen.SimpleTable;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface SimpleTableMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.381+08:00", comments="Source Table: simple_table")
    BasicColumn[] selectList = BasicColumn.columnList(id, firstName, lastName, birthDate, employed, occupation);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.369+08:00", comments="Source Table: simple_table")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.37+08:00", comments="Source Table: simple_table")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.371+08:00", comments="Source Table: simple_table")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<SimpleTable> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.371+08:00", comments="Source Table: simple_table")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<SimpleTable> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.372+08:00", comments="Source Table: simple_table")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SimpleTableResult")
    Optional<SimpleTable> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.372+08:00", comments="Source Table: simple_table")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SimpleTableResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="first_name", property="firstName", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_name", property="lastName", jdbcType=JdbcType.VARCHAR),
        @Result(column="birth_date", property="birthDate", jdbcType=JdbcType.DATE),
        @Result(column="employed", property="employed", jdbcType=JdbcType.VARCHAR),
        @Result(column="occupation", property="occupation", jdbcType=JdbcType.VARCHAR)
    })
    List<SimpleTable> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.374+08:00", comments="Source Table: simple_table")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.374+08:00", comments="Source Table: simple_table")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, simpleTable, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.375+08:00", comments="Source Table: simple_table")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, simpleTable, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.375+08:00", comments="Source Table: simple_table")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.376+08:00", comments="Source Table: simple_table")
    default int insert(SimpleTable record) {
        return MyBatis3Utils.insert(this::insert, record, simpleTable, c ->
            c.map(id).toProperty("id")
            .map(firstName).toProperty("firstName")
            .map(lastName).toProperty("lastName")
            .map(birthDate).toProperty("birthDate")
            .map(employed).toProperty("employed")
            .map(occupation).toProperty("occupation")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.377+08:00", comments="Source Table: simple_table")
    default int insertMultiple(Collection<SimpleTable> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, simpleTable, c ->
            c.map(id).toProperty("id")
            .map(firstName).toProperty("firstName")
            .map(lastName).toProperty("lastName")
            .map(birthDate).toProperty("birthDate")
            .map(employed).toProperty("employed")
            .map(occupation).toProperty("occupation")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.378+08:00", comments="Source Table: simple_table")
    default int insertSelective(SimpleTable record) {
        return MyBatis3Utils.insert(this::insert, record, simpleTable, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(firstName).toPropertyWhenPresent("firstName", record::getFirstName)
            .map(lastName).toPropertyWhenPresent("lastName", record::getLastName)
            .map(birthDate).toPropertyWhenPresent("birthDate", record::getBirthDate)
            .map(employed).toPropertyWhenPresent("employed", record::getEmployed)
            .map(occupation).toPropertyWhenPresent("occupation", record::getOccupation)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.382+08:00", comments="Source Table: simple_table")
    default Optional<SimpleTable> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, simpleTable, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.382+08:00", comments="Source Table: simple_table")
    default List<SimpleTable> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, simpleTable, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.382+08:00", comments="Source Table: simple_table")
    default List<SimpleTable> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, simpleTable, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.383+08:00", comments="Source Table: simple_table")
    default Optional<SimpleTable> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.383+08:00", comments="Source Table: simple_table")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, simpleTable, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.384+08:00", comments="Source Table: simple_table")
    static UpdateDSL<UpdateModel> updateAllColumns(SimpleTable record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(firstName).equalTo(record::getFirstName)
                .set(lastName).equalTo(record::getLastName)
                .set(birthDate).equalTo(record::getBirthDate)
                .set(employed).equalTo(record::getEmployed)
                .set(occupation).equalTo(record::getOccupation);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.384+08:00", comments="Source Table: simple_table")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SimpleTable record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(firstName).equalToWhenPresent(record::getFirstName)
                .set(lastName).equalToWhenPresent(record::getLastName)
                .set(birthDate).equalToWhenPresent(record::getBirthDate)
                .set(employed).equalToWhenPresent(record::getEmployed)
                .set(occupation).equalToWhenPresent(record::getOccupation);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.385+08:00", comments="Source Table: simple_table")
    default int updateByPrimaryKey(SimpleTable record) {
        return update(c ->
            c.set(firstName).equalTo(record::getFirstName)
            .set(lastName).equalTo(record::getLastName)
            .set(birthDate).equalTo(record::getBirthDate)
            .set(employed).equalTo(record::getEmployed)
            .set(occupation).equalTo(record::getOccupation)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.386+08:00", comments="Source Table: simple_table")
    default int updateByPrimaryKeySelective(SimpleTable record) {
        return update(c ->
            c.set(firstName).equalToWhenPresent(record::getFirstName)
            .set(lastName).equalToWhenPresent(record::getLastName)
            .set(birthDate).equalToWhenPresent(record::getBirthDate)
            .set(employed).equalToWhenPresent(record::getEmployed)
            .set(occupation).equalToWhenPresent(record::getOccupation)
            .where(id, isEqualTo(record::getId))
        );
    }
}