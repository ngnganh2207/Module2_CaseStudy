package quanlynhanvien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerAcc {
    List<Account> accList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    File account = new File("Account.csv");
    String tieude = "UserName, PassWord";
    static BufferedWriter bufferedWriter;
    static BufferedReader bufferedReader;

    public void addUser(Account account) {
        accList.add(account);
    }

    public Account creat() {
        System.out.println("Nhập User Name");
        String userName = scanner.nextLine();
        System.out.println("Nhập Pass Word");
        String passWord = scanner.nextLine();
        return new Account(userName, passWord);
    }

    public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter(account);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(tieude);
            for (Account account : accList) {
                bufferedWriter.newLine();
                bufferedWriter.write(account.show());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Account> readFile() {
        ArrayList<Account> accList = new ArrayList<>();
        if (!account.exists()){
            try {
                account.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileReader fileReader = new FileReader(account);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                accList.add(new Account(arr[0], arr[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return accList;
    }

    public void login() {
        while (true) {
            int select = -1;
            try {
                System.out.println("1. Đăng nhập");
                System.out.println("2. Thêm tài khoản mới");
                System.out.println("3.Show thông tin các Account đăng nhập");
                System.out.println("4. Xóa tài khoản đăng nhập");
                select = Integer.parseInt(scanner.nextLine());
                if (select != 1 && select != 2 && select!= 3 && select!=4) {
                    System.out.println("Lựa chọn " + select + " không nằm trong lựa chọn");
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại");
            }
            if (select == 1) {
                System.out.println("Nhập UserName");
                String userName = scanner.nextLine();
                System.out.println("Nhập Pass Word");
                String passWord = scanner.nextLine();
                accList = readFile();
                for (Account account : accList) {
                    if (account.getUser().equals(userName) && account.getPassWord().equals(passWord)) {
                        return;
                    }
                }
                System.out.println("Tài khoản không đúng hoặc bạn chưa đăng ký");
            }
            if(select==2){
                Account account1= creat();
                addUser(account1);
                writeFile();
                System.out.println("Bạn đã đăng ký thành công");
            }
            if(select==3){
                accList= readFile();
                for(Account account: accList){
                    System.out.println(account);
                }
            }
            if(select==4){
                System.out.println("Nhập tên tài khoản cần xóa->sẽ xóa hết các tk có tên này");
                String userName= scanner.nextLine();
                accList=readFile();
                for (int i=0;i<accList.size();i++){
                    if(accList.get(i).getUser().equals(userName)){
                        accList.remove(accList.get(i));
                        i--;
                    }
                }
                writeFile();
            }
        }
    }
}
