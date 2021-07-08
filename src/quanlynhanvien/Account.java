package quanlynhanvien;

public class Account {
    private String user;
    private String passWord;

    public Account() {
    }

    public Account(String user, String passWord) {
        this.user = user;
        this.passWord = passWord;
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
        return  this.user+","+ this.passWord;
    }

    @Override
    public String toString() {
        return "Account{" +
                "user='" + user + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
