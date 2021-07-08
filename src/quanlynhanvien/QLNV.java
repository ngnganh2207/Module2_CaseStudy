package quanlynhanvien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QLNV {
    List<NhanVien> list= new ArrayList<>();
    Scanner scanner= new Scanner(System.in);
    final String NV_Full_Time= "full";
    final String NV_Part_Time="part";
    File nhanVien= new File("NhanVien.txt");
    File nhanVienFull= new File("NhanVienFullTime.txt");
    File nhanVienPart= new File("NhanVienPartTime.txt");
    String tieuDeNV="eCode, name, age, gendor, phone, email, salary, status";
    String tieuDeNVFT="eCode, name, age, gendor, phone, email, salary, status, dayOn, dayOff, overTime";
    String tieuDeNVPT= "eCode, name, age, gendor, phone, email, salary, status, timeWork";
    static BufferedWriter bufferedWriter1;
    static BufferedReader bufferedReader1;
    static BufferedWriter bufferedWriter2;
    static BufferedReader bufferedReader2;

    public void add(NhanVien nhanVien){
        list.add(nhanVien);
    }

    public NhanVien creat(String kieuNV){
        //String eCode, String name, int age, String gendor, int phone, String email, double salary, boolean status

        String eCode = getString();
        String name = getString2();
        int age = getAge();
        System.out.println("Nhập giới tính");
        String gendor= scanner.nextLine();
        int phone = getPhone();
        String email = getString1();
        double salary = getSalary();
        boolean status = isaBoolean();
        if(kieuNV.equals(NV_Full_Time)){
            ////String eCode, String name, int age, String gendor, int phone, String email, double salary, boolean status
            System.out.println("Nhập số ngày làm việc");
            int dayOn= Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập số ngày nghỉ");
            int dayOff= Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập số giờ OT");
            double overTime= Double.parseDouble(scanner.nextLine());
            return new NVFullTime(eCode,name,age,gendor,phone,email,salary,status,dayOn,dayOff,overTime);
        }else {
            System.out.println("Nhập tổng thời gian làm việc theo giờ");
            double timeWork= Double.parseDouble(scanner.nextLine());
            return new NVPartTime(eCode,name,age,gendor,phone,email,salary,status,timeWork);
        }
    }

    private String getString2() {
        while (true){
            String name = getString3();
            if(name!= null){
                return name;
            }else {
                System.out.println("Nhập lại");
            }
        }
    }

    private String getString3() {
        while (true){
            System.out.println("Nhập họ tên");
            String name= scanner.nextLine();
            Pattern pattern= Pattern.compile("\\D{5,}");
            Matcher matcher=pattern.matcher(name);
            if(matcher.matches()){
                return name;
            }else {
                System.out.println("Nhập lại name");
            }
        }
    }

    private boolean isaBoolean() {
        while (true){
            try{
                System.out.println("Nhập trạng thái nhân viên-\\true: đang làm, \\false: đã nghỉ!");
                boolean status=Boolean.parseBoolean(scanner.nextLine());
                return status;
            }catch (Exception e){
                System.out.println("Vui lòng nhập \\true hoặc \\false!");
            }

        }
    }

    private double getSalary() {
        while (true){
            try{
                System.out.println("Nhập lương theo giờ");
                double salary= Double.parseDouble(scanner.nextLine());
                return salary;
            }catch (Exception e){
                System.out.println("Vui lòng nhập lại lương kiểu thập phân");
            }
        }

    }

    private String getString1() {
        while (true){
            System.out.println("Nhập Email Nhân Viên- Theo Định dạng: abc@gmail.com");
            String email= scanner.nextLine();
            Pattern pattern= Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
            Matcher matcher= pattern.matcher(email);
            if(matcher.matches()){
                return email;
            }else {
                System.out.println(email+" không hợp lệ!");
                System.out.println("Vui lòng nhập lại email");
            }
        }

    }

    private int getPhone() {
        while (true){
            int phone = getPhone1();
            Pattern pattern=Pattern.compile("^[0-9]+$");
            Matcher matcher= pattern.matcher(String.valueOf(phone));
            if(matcher.matches()){
                return phone;
            }else {
                System.out.println("Vui long nhập lại sđt!");
            }

        }

    }

    private int getPhone1() {
        while(true){
            try{
                System.out.println("Nhập số điện thoại (10 hoặc 11 số) của nhân viên-VD: 09xxxxxxxx");
                int phone= Integer.parseInt(scanner.nextLine());
                return phone;
            }catch (Exception e){
                System.out.println("Nhập lại phone kiểu số!");
            }
        }
    }

    private String getString() {
        while (true){
            System.out.println("Nhập Mã Nhân Viên- Theo Định dạng: CGMD123456");
            String eCode= scanner.nextLine();
            Pattern pattern= Pattern.compile("^CGMD\\d{6}$");
            Matcher matcher= pattern.matcher(eCode);
            if(matcher.matches()){
                return eCode;
            }else {
                System.out.println("Vui lòng nhập lại mã- CGMD là bắt buộc");
            }
        }

    }

    private int getAge() {
        while (true){
            try{
                System.out.println("Nhập tuổi nhân viên");
                int age= Integer.parseInt(scanner.nextLine());
                return age;
            }catch (Exception e){
                System.out.println("Vui lòng nhập lại tuổi kiểu số!");
            }
        }
    }

    public void find(String name){
        boolean temp=false;
        for(int i=0; i<list.size();i++){
            if(list.get(i).getName().equals(name)){
                System.out.println(list.get(i).toString());
                temp= true;
            }
        }
        if(!temp){
            System.out.println("Không tìm thấy tên");
        }
    }

    public void findStatus(String name){
        boolean check=false;
        for (int i=0;i< list.size();i++){
            if(list.get(i).getName().equals(name)){
                System.out.println("Trạng thái nhân viên "+ list.get(i).getName()+" là: "+ list.get(i).isStatus());
                check=true;
            }
        }
        if(!check){
            System.out.println("Không tìm thấy tên nhân viên");
        }
    }

    public void edit(String eCode){
        for(int i=0;i< list.size();i++){
            if(list.get(i).geteCode().equals(eCode)){
                if(list.get(i) instanceof NVFullTime){
                    list.set(i,creat("full"));
                }else {
                    list.set(i,creat("part"));
                }
            }else {
                System.out.println("Không tìm thấy mã nhân viên");
            }
            break;
        }
    }

    public void delete(String name){
        for(int i=0; i<list.size();i++){
            if(list.get(i).getName().equals(name)){
                list.remove(list.get(i));
                i--;
            }
        }
    }

    public void updateStatus(String eCode,boolean status){
        for(NhanVien nv: list){
            if(nv.geteCode().equals(eCode)){
                nv.setStatus(status);
            }
        }
    }

    public void writeFile(){
        try {
            FileWriter fileWriter1=new FileWriter(nhanVienFull);
            bufferedWriter1= new BufferedWriter(fileWriter1);
            bufferedWriter1.write(tieuDeNVFT);
            for(NhanVien nv: list){
                if(nv instanceof NVFullTime){
                    bufferedWriter1.newLine();
                    bufferedWriter1.write(nv.show());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedWriter1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter fileWriter2=new FileWriter(nhanVienPart);
            bufferedWriter2= new BufferedWriter(fileWriter2);
            bufferedWriter2.write(tieuDeNVPT);
            for(NhanVien nv: list){
                if(nv instanceof NVPartTime){
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(nv.show());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedWriter2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<NhanVien> readFile(){
        ArrayList<NhanVien> list= new ArrayList<>();
        try {
            FileReader fileReader1= new FileReader(nhanVienFull);
            bufferedReader1= new BufferedReader(fileReader1);
            String line1= bufferedReader1.readLine();
            while ((line1=bufferedReader1.readLine())!=null){
                //String eCode, String name, int age, String gendor, int phone, String email, double salary, boolean status, int dayOn, int dayOff, double overTime
                String[] arrStr1=line1.split(",");
                list.add(new NVFullTime(arrStr1[0],arrStr1[1],Integer.parseInt(arrStr1[2]),arrStr1[3],Integer.parseInt(arrStr1[4]),arrStr1[5],Double.parseDouble(arrStr1[6]),Boolean.parseBoolean(arrStr1[7]),Integer.parseInt(arrStr1[8]),Integer.parseInt(arrStr1[9]),Double.parseDouble(arrStr1[10])));
                //System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader2= new FileReader(nhanVienPart);
            bufferedReader2= new BufferedReader(fileReader2);
            String line2= bufferedReader2.readLine();
            while ((line2=bufferedReader2.readLine())!=null){
                //String eCode, String name, int age, String gendor, int phone, String email, double salary, boolean status, double timeWork;
                String[] arrStr2=line2.split(",");
                list.add(new NVPartTime(arrStr2[0],arrStr2[1],Integer.parseInt(arrStr2[2]),arrStr2[3],Integer.parseInt(arrStr2[4]),arrStr2[5],Double.parseDouble(arrStr2[6]),Boolean.parseBoolean(arrStr2[7]),Double.parseDouble(arrStr2[8])));
                //System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}
