package quanlynhanvien;

public class NVFullTime extends NhanVien{
    private int dayOn;
    private int dayOff;
    private double overTime;

    public NVFullTime() {
    }

    public NVFullTime(String eCode, String name, int age, String gendor, int phone, String email, double salary, boolean status, int dayOn, int dayOff, double overTime) {
        super(eCode, name, age, gendor, phone, email, salary, status);
        this.dayOn = dayOn;
        this.dayOff = dayOff;
        this.overTime = overTime;
    }

    public int getDayOn() {
        return dayOn;
    }

    public void setDayOn(int dayOn) {
        this.dayOn = dayOn;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }

    public double getOverTime() {
        return overTime;
    }

    public void setOverTime(double overTime) {
        this.overTime = overTime;
    }

    public double salaryMonth(){
        return getSalary()*((this.dayOn- this.dayOff)*8)+ getSalary()*this.overTime;
    }
    @Override
    public String show(){
        return super.show()+ ","+ dayOn+","+dayOff+","+overTime;
    }
    @Override
    public String toString() {
        return " Info NVFullTime{ " + super.toString()+
                "dayOn=" + dayOn +
                ", dayOff=" + dayOff +
                ", overTime=" + overTime +
                '}';
    }
}
