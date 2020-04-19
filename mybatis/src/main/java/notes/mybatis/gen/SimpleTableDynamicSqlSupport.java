package notes.mybatis.gen;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SimpleTableDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.367+08:00", comments="Source Table: simple_table")
    public static final SimpleTable simpleTable = new SimpleTable();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.368+08:00", comments="Source field: simple_table.id")
    public static final SqlColumn<Integer> id = simpleTable.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.368+08:00", comments="Source field: simple_table.first_name")
    public static final SqlColumn<String> firstName = simpleTable.firstName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.368+08:00", comments="Source field: simple_table.last_name")
    public static final SqlColumn<String> lastName = simpleTable.lastName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.368+08:00", comments="Source field: simple_table.birth_date")
    public static final SqlColumn<Date> birthDate = simpleTable.birthDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.368+08:00", comments="Source field: simple_table.employed")
    public static final SqlColumn<String> employed = simpleTable.employed;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.369+08:00", comments="Source field: simple_table.occupation")
    public static final SqlColumn<String> occupation = simpleTable.occupation;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.367+08:00", comments="Source Table: simple_table")
    public static final class SimpleTable extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> firstName = column("first_name", JDBCType.VARCHAR);

        public final SqlColumn<String> lastName = column("last_name", JDBCType.VARCHAR);

        public final SqlColumn<Date> birthDate = column("birth_date", JDBCType.DATE);

        public final SqlColumn<String> employed = column("employed", JDBCType.VARCHAR);

        public final SqlColumn<String> occupation = column("occupation", JDBCType.VARCHAR);

        public SimpleTable() {
            super("simple_table");
        }
    }
}