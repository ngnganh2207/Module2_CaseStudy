package quanlynhanvien;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainQLNV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QLNV qlnv = new QLNV();
        ManagerAcc managerAcc = new ManagerAcc();
        while (true) {
            managerAcc.login();

            while (true) {
                System.out.println("|-----------------------MENU-----------------------|");
                System.out.println("|0. Thoát Chương Trình-----------------------------|");
                System.out.println("|1. Thêm nhân viên---------------------------------|");
                System.out.println("|2. Tìm kiếm nhân viên theo name-------------------|");
                System.out.println("|3. Kiểm tra trạng thái nhân viên theo name--------|");
                System.out.println("|4. Sửa thông tin nhân viên------------------------|");
                System.out.println("|5. Xóa nhân viên khỏi hệ thống--------------------|");
                System.out.println("|6. Update lại trạng thái của nhân viên------------|");
                System.out.println("|7. Tính lương nhân viên theo part time, full time-|");
                System.out.println("|8. Hiện thị danh sách nhân viên theo trạng thái---|");
                System.out.println("|9. Hiển thị toàn bộ thông tin nhân viên-----------|");
                System.out.println("|10. Ghi file Text.txt-----------------------------|");
                System.out.println("|11. Đọc file Text.txt-----------------------------|");
                System.out.println("|12. Đăng xuất tài khoản---------------------------|");
                System.out.println("=>Chose: ");
                qlnv.list = qlnv.readFile();//Xem lại đoạn này
                int choice = -1;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Nhập lại lựa chọn");
                    continue;
                }
                if (choice == 12){
                    break;
                }

                switch (choice) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        while (true) {
                            int choice1 = getChoice1();
                            if (choice1 == 1) {
                                NhanVien nhanVien = qlnv.creat("full");
                                qlnv.add(nhanVien);
                                break;
                            } else if (choice1 == 2) {
                                NhanVien nhanVien = qlnv.creat("part");
                                qlnv.add(nhanVien);
                                break;
                            } else {
                                System.out.println("Lựa chọn " + choice1 + " không nằm trong list, vui lòng chọn lại!");
                            }
                        }
                        qlnv.writeFile();// xem lại đoạn này
                        break;
                    case 2:
                        System.out.println("Nhập tên cần tìm kiếm");
                        System.out.println("Nhập \\exit để về menu chính");
                        String name = scanner.nextLine();
                        if (name.equals("exit")) {
                            continue;
                        }
                        Pattern pattern = Pattern.compile("\\D{5,}");
                        Matcher matcher = pattern.matcher(name);
                        if (matcher.matches()) {
                            qlnv.find(name);
                        } else {
                            System.out.println("Tên không đúng định dạng");
                        }
                        break;
                    case 3:
                        System.out.println("Nhập tên cần kiểm tra trạng thái");
                        System.out.println("Nhập \\exit để về menu chính");
                        String name3 = scanner.nextLine();
                        if (name3.equals("exit")) {
                            continue;
                        }
                        Pattern pattern3 = Pattern.compile("\\D{5,}");
                        Matcher matcher3 = pattern3.matcher(name3);
                        if (matcher3.matches()) {
                            qlnv.findStatus(name3);
                        } else {
                            System.out.println("Tên không đúng định dạng");
                        }
                        break;
                    case 4:
                        System.out.println("Nhập mã nhân viên cần sửa thông tin(sẽ sửa toàn bộ thông tin)");
                        String eCode = null;
                        try {
                            eCode = scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("Mã không đúng định dạng");
                        }
                        qlnv.edit(eCode);
                        qlnv.writeFile();
                        break;
                    case 5:
                        System.out.println("Nhập tên cần xóa-Lưu ý sẽ xóa tất cả nhân viên có tên giống nhau");
                        String name5 = scanner.nextLine();
                        qlnv.delete(name5);
                        qlnv.writeFile();
                        break;
                    case 6:
                        System.out.println("Nhận mã nhân viên cần thay đổi trạng thái");
                        String eCode6 = scanner.nextLine();
                        System.out.println("Nhập trạng thái muốn chuyển sang");
                        boolean status6 = Boolean.parseBoolean(scanner.nextLine());
                        qlnv.updateStatus(eCode6, status6);
                        qlnv.writeFile();
                        break;
                    case 7:
                        for (NhanVien nv : qlnv.list) {
                            if (nv instanceof NVFullTime) {
                                System.out.println(nv + " Lương Tháng: " + ((NVFullTime) nv).salaryMonth());
                            } else if (nv instanceof NVPartTime) {
                                System.out.println(nv + " Lương Tháng: " + ((NVPartTime) nv).salaryMonth());
                            }
                        }
                        break;
                    case 8:
                        for (NhanVien nv : qlnv.list) {
                            System.out.println("Mã nhân viên: " + nv.geteCode() + ", Họ tên: " + nv.getName() + ", Status: " + nv.isStatus());
                        }
                        break;
                    case 9:
                        for (NhanVien nv : qlnv.list) {
                            System.out.println(nv);
                        }
                        break;
                    case 10:
                        qlnv.writeFile();
                        break;
                    case 11:
                        System.out.println("Hệ Thông Auto Read File");
                        qlnv.list = qlnv.readFile();
                        break;
                }
            }
        }
    }

    private static int getChoice1() {
        Scanner scanner= new Scanner(System.in);
        while (true){
            try{
                System.out.println("1. Thêm nhân viên FullTime");
                System.out.println("2. Thêm nhân viên PartTime");
                int choice1= Integer.parseInt(scanner.nextLine());
                return choice1;
            }catch (Exception e){
                System.out.println("Vui lòng chọn lại");
            }
        }
    }
}
