import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class ManagementApp {
    public static final String DASH_DECORATION = "----------------------------------------------------------------------------------------------------------------------------------------------------------------";
    Scanner sc = new Scanner(System.in);
    static List<Contact> list = new ArrayList<>();
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final Pattern NAME_PATTERN = Pattern.compile("^[\\pL ]{2,30}$");
    private static final Pattern ADDRESS_PATTERN = Pattern.compile("^[\\pL\\d., /-]+$");
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\d{7,12}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^\\w+@\\w+\\.\\w+$");
    private static final String fileName = "data\\contacts.csv";

    static {
        new File("data/").mkdirs();
    }

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
            System.out.println("0. Thoát chương trình");
            System.out.println("____________________________________________");
            int choose = validateNumberGreaterThan0("Mời nhập:");
            switch (choose) {
                case 1:
                    showContactList(list);
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
                case 0:
                    System.out.println("Cảm ơn đã sử dụng, tạm biệt!");
                    return;
                default:
                    System.err.println("Nhập sai, vui lòng nhập lại");
                    break;
            }
        }
    }

    private void writeFile() {
        writeCSVFile(fileName);
    }

    public static void writeCSVFile(String fileName) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            for (Contact contact : list) {
                fileWriter.append(contact.getTelNumber());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(contact.getGroup());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(contact.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(contact.getGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(contact.getAddress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(contact.getDob());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(contact.getEmail());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("Ghi file thành công");
        } catch (Exception e) {
            System.err.println("Lỗi ghi file");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.err.println("Lỗi ghi file trong quá trình đóng/flush file");
                e.printStackTrace();
            }
        }
    }

    private void readFile() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                list.add(parseCsvLine(line));
            }
        } catch (IOException e) {
            System.err.println("Lỗi không tìm thấy file");
        } finally {
            try {
                if (br != null)
                    br.close();
                System.out.println("Đọc file thành công\n");
            } catch (IOException e) {
                System.err.println("Lỗi không tìm thấy file");
            }
        }
    }

    private Contact parseCsvLine(String csvLine) {
        String[] contactData = new String[7];
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                contactData[i] = splitData[i];
            }
        }
        return new Contact(contactData[0], contactData[1], contactData[2], contactData[3], contactData[4], contactData[5], contactData[6]);
    }

    private void searchContact() {
        while (true) {
            System.out.println("1. Tìm kiếm theo số điện thoại");
            System.out.println("2. Tìm kiếm theo Tên");
            System.out.println("0. Trở về menu");
            int choice = validateNumberGreaterThan0("Nhập lựa chọn");
            switch (choice) {
                case 1:
                    searchContactByTel();
                    break;
                case 2:
                    searchContactByName();
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Không có chức năng này");
            }
        }
    }

    private void searchContactByTel() {
        String tel = validateTel("Nhập số điện thoại");
        int count = 0;
        List<Contact> list1 = new ArrayList<>();
        for (Contact contact : list) {
            if (contact.getTelNumber().contains(tel)) {
                list1.add(contact);
                count++;
            }
        }
        showSearchList(count, list1);
    }

    private void searchContactByName() {
        String name = validateName("Nhập Tên");
        int count = 0;
        List<Contact> list1 = new ArrayList<>();
        for (Contact contact : list) {
            if (contact.getName().contains(name)) {
                list1.add(contact);
                count++;
            }
        }
        showSearchList(count, list1);
    }

    private void showSearchList(int count, List<Contact> list1) {
        if (count == 0) {
            System.out.println("Không tìm thấy");
        } else {
            printTitle();
            for (Contact contact : list1) {
                displayContactInfo(contact);
                System.out.println();
            }
            System.out.println(DASH_DECORATION);
        }
    }

    private void displayContactInfo(Contact contact) {
        System.out.format("|%-15s ", contact.getTelNumber());
        System.out.format("|%-20s ", contact.getGroup());
        System.out.format("|%-30s ", contact.getName());
        System.out.format("|%-10s ", contact.getGender());
        System.out.format("|%-30s ", contact.getAddress());
        System.out.format("|%-10s ", contact.getDob());
        System.out.format("|%-30s |", contact.getEmail());
    }

    private void deleteContact() {
        System.out.println("Mời nhập số điện thoại cần xóa");
        String telNum = sc.nextLine();
        if (telNum.equals("")) {
            return;
        }
        boolean check = checkExistTelNum(telNum);
        if (check) {
            System.out.println("Bạn có chắc chắn muốn xóa danh bạ này?");
            confirmDelete(telNum);
            System.out.println("Xóa file thành công");
        } else {
            System.err.println("Không có số điện thoại này trong danh bạ");
        }
    }

    private void confirmDelete(String telNum) {
        int choise = validateNumberGreaterThan0("1. Có\n2. Không");
        switch (choise) {
            case 1:
                list.remove(getContactByTel(telNum));
                break;
            case 2:
                return;
            default:
                System.err.println("Chỉ 'Có' hoặc 'Không'");
                confirmDelete(telNum);
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
            String dob = validateDoB("Nhập ngày sinh mới");
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

    public String validateDoB(String mess) {
        System.out.println(mess);
        try {
            int day = validateDay("Nhập ngày sinh:");
            int month = validateMonth("Nhập tháng:");
            int year = validateYear("Nhập năm sinh:");
            int dayLimit = validateDayMonth(month, year);
            if (day > dayLimit | day < 1)
                throw new Exception("Ngày phải trong khoảng [1 - " + dayLimit + "] (phụ thuộc vào tháng)");
            return day + "/" + month + "/" + year;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return validateDoB(mess);
        }
    }

    private int validateDay(String mess) {
        System.out.println(mess);
        try {
            int day = getInt();
            if (day < 1 | day > 31) throw new Exception();
            return day;
        } catch (Exception e) {
            System.err.println("Ngày sinh không hợp lệ");
            return validateDay(mess);
        }
    }

    private int validateMonth(String mess) {
        System.out.println(mess);
        try {
            int month = getInt();
            if (month < 1 | month > 12) throw new Exception();
            return month;
        } catch (Exception e) {
            System.err.println("Tháng không hợp lệ");
            return validateMonth(mess);
        }
    }

    private int validateYear(String mess) {
        System.out.println(mess);
        try {
            int year = getInt();
            if (limitYear(year)) {
                System.err.println("Năm sinh phải trong khoảng [1930 - 2019]");
                return validateYear(mess);
            }
            return year;
        } catch (Exception e) {
            System.err.println("Năm sinh không hợp lệ");
            return validateYear(mess);
        }
    }

    private int validateDayMonth(int month, int year) throws Exception {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (checkLeapYear(year))
                    return 29;
                else return 28;
            default:
                throw new Exception("Tháng phải trong khoảng [1 - 12]");
        }
    }


    private boolean checkLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 4 == 0 && year % 100 != 0)
            return true;
        return false;
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
        String dob = validateDoB("Nhập ngày tháng năm sinh");
        String email = validateEmail("Nhập email:");
        Contact contact = new Contact(telNum, group, name, gender, address, dob, email);
        list.add(contact);
    }

    private String validateGender() {
        System.out.println("Nhập giới tính");
        try {
            int choise = validateNumberGreaterThan0("1. Nam\n2. Nữ");
            switch (choise) {
                case 1:
                    return "Nam";
                case 2:
                    return "Nữ";
                default:
                    throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("Nhập sai giới tính");
            return validateGender();
        }
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

    private void showContactList(List<Contact> list) {
        printTitle();
        for (Contact contact : list) {
            displayContactInfo(contact);
            System.out.println();
        }
        System.out.println(DASH_DECORATION);
    }

    private void printTitle() {
        System.out.println(DASH_DECORATION);
        System.out.format("|%-15s ", "Số điện thoại");
        System.out.format("|%-20s ", "Nhóm");
        System.out.format("|%-30s ", "Tên");
        System.out.format("|%-10s ", "Giới tính");
        System.out.format("|%-30s ", "Địa chỉ");
        System.out.format("|%-10s ", "Ngày sinh");
        System.out.format("|%-30s |\n", "Email");
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

    public boolean limitYear(int year) {
        return year <= 1930 || year >= 2021;
    }

    public static void main(String[] args) {
        ManagementApp app = new ManagementApp();
        app.showMenu();
    }
}
