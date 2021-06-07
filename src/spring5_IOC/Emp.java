package spring5_IOC;

/**
 * @author QFY
 * @Description
 * @create 2021-05-28 19:19
 */
public class Emp {
    private Dept dept;
    private String name;
    private String gender;

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
