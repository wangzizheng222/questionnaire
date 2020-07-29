package entity;

/**
 * 管理员账号
 */
public class Manager {
    private String name;
    private String password;

    public Manager(String name,String password){
        this.name=name;
        this.password=password;
    }

    public Manager(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
