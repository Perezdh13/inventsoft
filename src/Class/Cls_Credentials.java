package Class;

public class Cls_Credentials {
    private String user = "PEPE";
    private String password = "1234";

    public Cls_Credentials() {
        this.user = user;
        this.password = password;
    }

    private boolean pass;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }
}
