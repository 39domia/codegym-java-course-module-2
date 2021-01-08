import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManagementApp {
    public static final String DASH_DECORATION = "----------------------------------------------------------------------------------------------------------------------------------------------------------------";
    Scanner sc = new Scanner(System.in);
    static List<Contact> list = new ArrayList<>();
    private static final Pattern NAME_PATTERN = Pattern.compile("^[\\pL ]{2,30}$");
    private static final Pattern ADDRESS_PATTERN = Pattern.compile("^[\\pL\\d., /-]+$");
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\d{7,12}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^\\w+@\\w+\\.\\w+$");

    public void showMenu() {
        while (true) {
            System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ---");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xoá");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát chương trình");
            System.out.println("____________________________________________");
            int choose = validateNumberGreaterThan0("Mời nhập:");
            switch (choose) {
                case 1:
                    showContactList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    readFile();
                    break;
                case 7:
                    writeFile();
                    break;
                case 8:
                    System.out.println("Cảm ơn đã sử dụng, tạm biệt!");
                    return;
                default:
                    System.err.println("Nhập sai, vui lòng nhập lại");
                    break;
            }
        }
    }

    private void writeFile() {
    }

    private void readFile() {
    }

    private void searchContact() {
        System.out.println("1. Tìm kiếm theo số điện thoại");
        System.out.println("2. Tìm kiếm theo Tên");
        int choise = validateNumberGreaterThan0("Nhập lựa chọn");
        switch (choise) {
            case 1:
                searchContactByTel();
                break;
            case 2:
                searchContactByName();
                break;
            default:
                System.out.println("Nhập sai");
        }
    }

    private void  searchContactByTel() {
        String tel = validateTel("Nhập số điện thoại");
        for (Contact contact : list) {
            if (contact.getTelNumber().contains(tel)){
                System.out.format("|%-15s ", contact.getTelNumber());
                System.out.format("|%-20s ", contact.getGroup());
                System.out.format("|%-30s ", contact.getName());
                System.out.format("|%-10s ", contact.getGender());
                System.out.format("|%-30s ", contact.getAddress());
                System.out.format("|%-10s ", contact.getDob());
                System.out.format("|%-30s |", contact.getEmail());
            }
        }
    }

    private void searchContactByName() {
        String name = validateName("Nhập Tên");
        for (Contact contact : list) {
            if (contact.getName().contains(name)){
                System.out.format("|%-15s ", contact.getTelNumber());
                System.out.format("|%-20s ", contact.getGroup());
                System.out.format("|%-30s ", contact.getName());
                System.out.format("|%-10s ", contact.getGender());
                System.out.format("|%-30s ", contact.getAddress());
                System.out.format("|%-10s ", contact.getDob());
                System.out.format("|%-30s |", contact.getEmail());
            }
        }
    }

    private void deleteContact() {
        System.out.println("Mời nhập số điện thoại cần xóa");
        String telNum = sc.nextLine();
        if (telNum.equals("")) {
            return;
        }
        boolean check = checkExistTelNum(telNum);
        if (check) {
            list.remove(getContactByTel(telNum));
        } else {
            System.err.println("Không có số điện thoại này trong danh bạ");
        }
    }

    public Contact getContactByTel(String telNum) {
        for (Contact contact : list
        ) {
            if (contact.getTelNumber().equals(telNum)) {
                return contact;
            }
        }
        return null;
    }

    private void updateContact() {
        System.out.println("Mời nhập số điện thoại cần sửa");
        String telNum = sc.nextLine();
        if (telNum.equals("")) {
            return;
        }
        boolean check = checkExistTelNum(telNum);
        if (check) {
            String group = validateGroup("Nhập nhóm danh bạ mới:");
            String name = validateName("Nhập tên mới:");
            String gender = validateGender();
            String address = validateAddress("Nhập địa chỉ mới:");
            String dob = validateDoB("Nhập ngày sinh mới:");
            String email = validateEmail("Nhập email mới:");
            for (Contact contact : list) {
                if (contact.getTelNumber().equals(telNum)) {
                    contact.setGroup(group);
                    contact.setName(name);
                    contact.setGender(gender);
                    contact.setAddress(address);
                    contact.setDob(dob);
                    contact.setEmail(email);
                }
            }
        } else {
            System.err.println("Không có số điện thoại này trong danh bạ");
        }
    }

    private boolean checkExistTelNum(String telNum) {
        for (Contact contact : list) {
            if (contact.getTelNumber().equals(telNum)) {
                return true;
            }
        }
        return false;
    }

    private void addContact() {
        String telNum = validateTel("Nhập số điện thoại");
        String group = validateGroup("Nhập nhóm danh bạ");
        String name = validateName("Nhập tên:");
        String gender = validateGender();
        String address = validateAddress("Nhập địa chỉ");
        String dob = validateDoB("Nhập ngày sinh:");
        String email = validateEmail("Nhập email:");
        Contact contact = new Contact(telNum, group, name, gender, address, dob, email);
        list.add(contact);
        System.out.println(name);
        System.out.println(email);

    }

    private String validateDoB(String mess) {
        System.out.println(mess);
        try {
            String dob = sc.nextLine();
//            if (NAME_PATTERN.matcher(dob).matches()) {
//                return dob;
//            } else {
//                throw new Exception();
//            }
            return dob;

        } catch (Exception e) {
            System.err.println("Ngày sinh sai định dạng");
            return validateDoB(mess);
        }
    }

    private String validateGender() {
        System.out.println("Nhập giới tính");
        int choise = validateNumberGreaterThan0("1. Nam\n2. Nữ");
        switch (choise) {
            case 1:
                return "Nam";
            case 2:
                return "Nữ";
            default:
                System.out.println("Nhập sai giới tính");
        }
        return "";
    }

    private String validateTel(String mess) {
        System.out.println(mess);
        try {
            String tel = sc.nextLine();
            if (PHONE_NUMBER_PATTERN.matcher(tel).matches()) {
                return tel;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("Số điện thoại sai định dạng");
            return validateTel(mess);
        }
    }

    private String validateAddress(String mess) {
        System.out.println(mess);
        try {
            String address = sc.nextLine();
            if (ADDRESS_PATTERN.matcher(address).matches()) {
                return address;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("Địa chỉ sai định dạng");
            return validateAddress(mess);
        }
    }

    private String validateGroup(String mess) {
        System.out.println(mess);
        try {
            String group = sc.nextLine();
//            if (NAME_PATTERN.matcher(group).matches()) {
//                return group;
//            } else {
//                throw new Exception();
//            }
            return group;

        } catch (Exception e) {
            System.err.println("Nhóm sai định dạng");
            return validateGroup(mess);
        }
    }


    private String validateEmail(String mess) {
        System.out.println(mess);
        try {
            String email = sc.nextLine();
            if (EMAIL_PATTERN.matcher(email).matches()) {
                return email;
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            System.err.println("Email sai định dạng");
            return validateEmail(mess);
        }
    }

    private String validateName(String mess) {
        System.out.println(mess);
        try {
            String name = sc.nextLine();
            if (!NAME_PATTERN.matcher(name).matches()) {
                throw new Exception();
            }
            name = name.toLowerCase();
            name = name.trim();
            while (name.contains("  ")) {
                name = name.replace("  ", " ");
            }
            String[] str = name.split("");
            str[0] = str[0].toUpperCase();
            StringBuilder nameBuilder = new StringBuilder(str[0]);
            for (int i = 1; i < str.length; i++) {
                if (str[i].equals(" ")) {
                    str[i + 1] = str[i + 1].toUpperCase();
                }
                nameBuilder.append(str[i]);
            }
            return nameBuilder.toString();
        } catch (Exception e) {
            System.err.println("Tên không được có số, để trống hoặc quá dài (30)");
            return validateName(mess);
        }
    }

    private void showContactList() {
        System.out.println(DASH_DECORATION);
        System.out.format("|%-15s ", "Số điện thoại");
        System.out.format("|%-20s ", "Nhóm");
        System.out.format("|%-30s ", "Tên");
        System.out.format("|%-10s ", "Giới tính");
        System.out.format("|%-30s ", "Địa chỉ");
        System.out.format("|%-10s ", "Ngày sinh");
        System.out.format("|%-30s |\n", "Email");
        System.out.println(DASH_DECORATION);
        for (Contact contact : list) {
            System.out.format("|%-15s ", contact.getTelNumber());
            System.out.format("|%-20s ", contact.getGroup());
            System.out.format("|%-30s ", contact.getName());
            System.out.format("|%-10s ", contact.getGender());
            System.out.format("|%-30s ", contact.getAddress());
            System.out.format("|%-10s ", contact.getDob());
            System.out.format("|%-30s |\n", contact.getEmail());
        }
        System.out.println(DASH_DECORATION);
    }

    public int validateNumberGreaterThan0(String mess) {
        System.out.println(mess);
        try {
            int num = getInt();
            if (num > -1) {
                return num;
            }
            throw new Exception();
        } catch (Exception e) {
            System.err.println("Nhập vào định dạng sai, mời nhập lại:");
            return validateNumberGreaterThan0(mess);
        }
    }

    public int getInt() {
        return Integer.parseInt(sc.nextLine());
    }


    public static void main(String[] args) {
        ManagementApp app = new ManagementApp();
        Contact c1 = new Contact("000000001", "Code Gym", "Hoai Son", "Nam", "Hue", "1/1/1990", "hoaison@gmail.com");
        Contact c2 = new Contact("000000002", "Dai hoc", "Nguyen Van A", "Nam", "HCM", "1/1/1990", "hoaison@gmail.com");
        Contact c3 = new Contact("000000003", "Dai hoc", "Nguyen Van A", "Nam", "HCM", "1/1/1990", "hoaison@gmail.com");
        list.add(c3);
        list.add(c2);
        list.add(c1);
        app.showMenu();
    }
}
