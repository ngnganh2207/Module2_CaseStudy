package quanlynhanvien;

public class NhanVien {
    private String eCode;
    private String name;
    private int age;
    private String gendor;
    private int phone;
    private String email;
    private double salary;
    private boolean status;

    public NhanVien() {
    }

    public NhanVien(String eCode, String name, int age, String gendor, int phone, String email, double salary, boolean status) {
        this.eCode = eCode;
        this.name = name;
        this.age = age;
        this.gendor = gendor;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.status = status;
    }

    public String geteCode() {
        return eCode;
    }

    public void seteCode(String eCode) {
        this.eCode = eCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGendor() {
        return gendor;
    }

    public void setGendor(String gendor) {
        this.gendor = gendor;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String show() {
        return eCode + "," + name +","+ age + "," + gendor + "," + phone +","+email +","+ salary +","+ status;
    }

    @Override
    public String toString() {
        return "Info nhân viên{:" +
                "eCode='" + eCode + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gendor='" + gendor + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }
}
