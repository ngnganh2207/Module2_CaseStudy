package quanlynhanvien;

public class NVPartTime extends NhanVien{
    private double timeWork;

    public NVPartTime() {
    }

    public NVPartTime(String eCode, String name, int age, String gendor, int phone, String email, double salary, boolean status, double timeWork) {
        super(eCode, name, age, gendor, phone, email, salary, status);
        this.timeWork = timeWork;
    }

    public double getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(double timeWork) {
        this.timeWork = timeWork;
    }

    public double salaryMonth() {
        return getSalary()*this.timeWork;
    }
    @Override
    public String show(){
        return super.show() + "," + this.timeWork;
    }

    @Override
    public String toString() {
        return " Info NVPartTime{" +super.toString()+
                "timeWork=" + this.timeWork +
                '}';
    }
}
