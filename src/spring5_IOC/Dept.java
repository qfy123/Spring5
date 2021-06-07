package spring5_IOC;

/**
 * @author QFY
 * @Description
 * @create 2021-05-28 19:19
 */
public class Dept {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                '}';
    }
}
