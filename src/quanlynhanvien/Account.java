package quanlynhanvien;

public class Account {
    private String user;
    private String passWord;
    private String role;



    public Account() {
    }

    public Account(String user, String passWord, String role) {
        this.user = user;
        this.passWord = passWord;
        this.role= role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String show(){
        return  this.user+","+ this.passWord+","+this.role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "user='" + user + '\'' +
                ", passWord='" + passWord + '\'' +
                ", role=' "+role+'\''+
                '}';
    }
}
