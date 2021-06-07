package jdbcTemplate.entity;

/**
 * @author QFY
 * @Description
 * @create 2021-06-03 10:54
 */
public class User {
    private Integer userId;
    private String username;
    private String uStatus;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getuStatus() {
        return uStatus;
    }

    public void setuStatus(String uStatus) {
        this.uStatus = uStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", uStatus='" + uStatus + '\'' +
                '}';
    }
}
