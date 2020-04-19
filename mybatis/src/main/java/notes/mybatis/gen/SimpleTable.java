package notes.mybatis.gen;

import java.util.Date;
import javax.annotation.Generated;

public class SimpleTable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.359+08:00", comments="Source field: simple_table.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.363+08:00", comments="Source field: simple_table.first_name")
    private String firstName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.363+08:00", comments="Source field: simple_table.last_name")
    private String lastName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.364+08:00", comments="Source field: simple_table.birth_date")
    private Date birthDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.364+08:00", comments="Source field: simple_table.employed")
    private String employed;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.364+08:00", comments="Source field: simple_table.occupation")
    private String occupation;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.363+08:00", comments="Source field: simple_table.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.363+08:00", comments="Source field: simple_table.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.363+08:00", comments="Source field: simple_table.first_name")
    public String getFirstName() {
        return firstName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.363+08:00", comments="Source field: simple_table.first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.363+08:00", comments="Source field: simple_table.last_name")
    public String getLastName() {
        return lastName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.363+08:00", comments="Source field: simple_table.last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.364+08:00", comments="Source field: simple_table.birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.364+08:00", comments="Source field: simple_table.birth_date")
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.364+08:00", comments="Source field: simple_table.employed")
    public String getEmployed() {
        return employed;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.364+08:00", comments="Source field: simple_table.employed")
    public void setEmployed(String employed) {
        this.employed = employed == null ? null : employed.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.364+08:00", comments="Source field: simple_table.occupation")
    public String getOccupation() {
        return occupation;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-18T18:24:03.364+08:00", comments="Source field: simple_table.occupation")
    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }
}