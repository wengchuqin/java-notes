package notes.mybatis;

/**
 * @author: wengchuqin
 * @create: 2020-04-18 17:29
 */
public class City {
    private Integer id;
    private String state;

    public City() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", state='" + state + '\'' +
                '}';
    }
}
