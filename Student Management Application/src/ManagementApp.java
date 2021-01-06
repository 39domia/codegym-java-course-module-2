import java.io.*;
import java.util.*;

public class ManagementApp {
    Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Student> map = new HashMap<>();

    static {
        try {
            FileInputStream fileIn = new FileInputStream("data.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            map = (HashMap<Integer, Student>) in.readObject();
            Student.setAutoId(map.get(map.size()).getId());
        } catch (Exception e) {
            System.out.print("");
        }
    }

    public void showMenu() {
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Xem danh sách học viên");
            System.out.println("2. Thêm học viên");
            System.out.println("3. Sửa thông tin học viên");
            System.out.println("4. Xoá học viên");
            System.out.println("5. Nhập điểm học viên");
            System.out.println("6. Sửa điểm học viên");
            System.out.println("7. Xếp loại học viên");
            System.out.println("0. Thoát chương trình");
            System.out.println("____________________________________________");
            int choose = validateNumberGreaterThan0("Mời nhập:");
            switch (choose) {
                case 1:
                    showStudentList();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    editStudentInfo();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    insertPoint();
                    break;
                case 6:
                    editPoints();
                    break;
                case 7:
                    gradingStudents();
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

    private void editPoints() {
        while (true) {
            System.out.println("Menu Sửa điểm");
            System.out.println("1. Sửa TỪNG điểm cho một học viên");
            System.out.println("2. Sửa TOÀN BỘ điểm cho một học viên");
            System.out.println("3. Sửa TOÀN BỘ điểm cho TOÀN BỘ học viên");
            System.out.println("0. Trở về menu chính");
            int choose = validateNumberGreaterThan0("Mời nhập:");
            switch (choose) {
                case 1:
                    editEachPoint();
                    break;
                case 2:
                    editAllPoint();
                    break;
                case 3:
                    editAllPointAllStudent();
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Nhập sai, vui lòng nhập lại");
                    break;
            }
        }
    }

    private void editAllPointAllStudent() {
        System.out.println("Lưu ý, chức năng này chỉ cho phép sửa những điểm số đã được nhập!\nNhững điểm chưa được nhập sẽ bị bỏ qua!");
        for (Student student : map.values()) {
            editAllPointNeedID(student.getId());
        }
    }

    private void editAllPoint() {
        System.out.println("Lưu ý, chức năng này chỉ cho phép sửa những điểm số đã được nhập!\nNhững điểm chưa được nhập sẽ bị bỏ qua!");
        int id = validateID("Nhập ID học viên để sửa điểm, nhập 0 để trở về menu");
        if (id == 0) return;
        editAllPointNeedID(id);
    }

    private void editAllPointNeedID(int id) {
        displayStudentInfo(id);
        if (!checkInsert(map.get(id).getPointFactor1().get(0))) {
            System.out.println("Điểm học viên lần thứ 1 (hệ số 1) chưa được nhập, không thể sửa!");

        } else {
            double point1 = validatePoints("Nhập điểm học viên lần thứ 1 (hệ số 1)");
            map.get(id).getPointFactor1().set(0, point1);
        }
        if (!checkInsert(map.get(id).getPointFactor1().get(1))) {
            System.out.println("Điểm học viên lần thứ 2 (hệ số 1) chưa được nhập, không thể sửa!");
        } else {
            double point2 = validatePoints("Nhập điểm học viên lần thứ 2 (hệ số 1)");
            map.get(id).getPointFactor1().set(1, point2);
        }
        if (!checkInsert(map.get(id).getPointFactor2().get(0))) {
            System.out.println("Điểm học viên lần thứ 3 (hệ số 2) chưa được nhập, không thể sửa!");
        } else {
            double point3 = validatePoints("Nhập điểm học viên lần thứ 3 (hệ số 2)");
            map.get(id).getPointFactor2().set(0, point3);
        }
        if (!checkInsert(map.get(id).getPointFactor3().get(0))) {
            System.out.println("Điểm học viên lần thứ 4 (hệ số 3) chưa được nhập, không thể sửa!");
        } else {
            double point4 = validatePoints("Nhập điểm học viên lần thứ 4 (hệ số 3)");
            map.get(id).getPointFactor3().set(0, point4);
        }
        displayStudentInfo(id);
        map.get(id).setAveragePoint();
        addFile();
        done();

    }

    private void editEachPoint() {
        int id = validateID("Nhập ID học viên để sửa điểm, nhập 0 để trở về menu");
        if (id == 0) return;
        displayStudentInfo(id);
        int choise = -1;
        while (choise != 0) {
            System.out.println("1. Sửa điểm học viên lần thứ 1 (hệ số 1)");
            System.out.println("2. Sửa điểm học viên lần thứ 2 (hệ số 1)");
            System.out.println("3. Sửa điểm học viên lần thứ 3 (hệ số 2)");
            System.out.println("4. Sửa điểm học viên lần thứ 4 (hệ số 3)");
            System.out.println("0. Trở về menu");
            choise = validateNumberGreaterThan0("Mời nhập:");
            switch (choise) {
                case 1:
                    if (!checkInsert(map.get(id).getPointFactor1().get(0))) {
                        System.err.println("Điểm chưa được nhập, hãy nhập điểm trước!");
                        break;
                    } else {
                        double point = validatePoints("Nhập điểm:");
                        map.get(id).getPointFactor1().set(0, point);
                        done();
                        displayStudentInfo(id);
                    }
                    break;
                case 2:
                    if (!checkInsert(map.get(id).getPointFactor1().get(1))) {
                        System.err.println("Điểm chưa được nhập, hãy nhập điểm trước!");
                        break;
                    } else {
                        double point = validatePoints("Nhập điểm:");
                        map.get(id).getPointFactor1().set(1, point);
                        done();
                        displayStudentInfo(id);
                    }
                    break;
                case 3:
                    if (!checkInsert(map.get(id).getPointFactor2().get(0))) {
                        System.err.println("Điểm chưa được nhập, hãy nhập điểm trước!");
                        break;
                    } else {
                        double point = validatePoints("Nhập điểm:");
                        map.get(id).getPointFactor2().set(0, point);
                        done();
                        displayStudentInfo(id);
                    }
                    break;
                case 4:
                    if (!checkInsert(map.get(id).getPointFactor3().get(0))) {
                        System.err.println("Điểm chưa được nhập, hãy nhập điểm trước!");
                        break;
                    } else {
                        double point1 = validatePoints("Nhập điểm:");
                        map.get(id).getPointFactor3().set(0, point1);
                        done();
                        displayStudentInfo(id);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Nhập sai, mời nhập lại");
                    break;
            }
        }
        map.get(id).setAveragePoint();
        addFile();
        done();

    }

    private void insertPoint() {
        while (true) {
            System.out.println("Menu Nhập điểm");
            System.out.println("1. Nhập TỪNG điểm cho một học viên");
            System.out.println("2. Nhập TOÀN BỘ điểm cho một học viên");
            System.out.println("3. Nhập TOÀN BỘ điểm cho TOÀN BỘ học viên");
            System.out.println("0. Trở về menu chính");
            int choose = validateNumberGreaterThan0("Mời nhập:");
            switch (choose) {
                case 1:
                    insertEachPoint();
                    break;
                case 2:
                    insertAllPoint();
                    break;
                case 3:
                    insertAllPointAllStudent();
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Nhập sai, vui lòng nhập lại");
                    break;
            }
        }
    }

    private void insertAllPointAllStudent() {
        System.out.println("Lưu ý, chức năng này chỉ cho phép nhập những điểm số chưa được nhập!\nNhững điểm đã được nhập sẽ bị bỏ qua!");
        for (Student student : map.values()) {
            insertAllPointNeedID(student.getId());
        }
    }

    private void insertAllPoint() {
        System.out.println("Lưu ý, chức năng này chỉ cho phép nhập những điểm số chưa được nhập!\nNhững điểm đã được nhập sẽ bị bỏ qua!");
        int id = validateID("Nhập ID học viên để nhập điểm, nhập 0 để trở về menu");
        if (id == 0) return;
        insertAllPointNeedID(id);
    }

    private void insertAllPointNeedID(int id) {
        displayStudentInfo(id);
        if (checkInsert(map.get(id).getPointFactor1().get(0))) {
            System.out.println("Điểm học viên lần thứ 1 (hệ số 1) đã được nhập, không thể nhập thêm!");

        } else {
            double point1 = validatePoints("Nhập điểm học viên lần thứ 1 (hệ số 1)");
            map.get(id).getPointFactor1().set(0, point1);
        }
        if (checkInsert(map.get(id).getPointFactor1().get(1))) {
            System.out.println("Điểm học viên lần thứ 2 (hệ số 1) đã được nhập, không thể nhập thêm!");
        } else {
            double point2 = validatePoints("Nhập điểm học viên lần thứ 2 (hệ số 1)");
            map.get(id).getPointFactor1().set(1, point2);
        }
        if (checkInsert(map.get(id).getPointFactor2().get(0))) {
            System.out.println("Điểm học viên lần thứ 3 (hệ số 2) đã được nhập, không thể nhập thêm!");
        } else {
            double point3 = validatePoints("Nhập điểm học viên lần thứ 3 (hệ số 2)");
            map.get(id).getPointFactor2().set(0, point3);
        }
        if (checkInsert(map.get(id).getPointFactor3().get(0))) {
            System.out.println("Điểm học viên lần thứ 4 (hệ số 3) đã được nhập, không thể nhập thêm!");
        } else {
            double point4 = validatePoints("Nhập điểm học viên lần thứ 4 (hệ số 3)");
            map.get(id).getPointFactor3().set(0, point4);
        }
        displayStudentInfo(id);
        map.get(id).setAveragePoint();
        addFile();
        done();
    }

    private void gradingStudents() {
        List<Student> listStudentSort = new ArrayList<>(map.values());
        Collections.sort(listStudentSort);
        done();
        showStudent(listStudentSort, listStudentSort.size());
    }

    private void showStudent(List<Student> students, int size) {
        System.out.format("||%-3s | ", "ID");
        System.out.format("%-25s | ", "Tên");
        System.out.format("%-10s| ", "Điểm hs1");
        System.out.format("%-9s | ", "Điểm hs2");
        System.out.format("%-9s | ", "Điểm hs3");
        System.out.format("%-10s || \n", "Điểm TB");
        System.out.println("-----------------------------------------------------------------------------------------");
        try {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < findMaxNumberOfPoint(); j++) {
                    if (students.get(i) != null) {
                        if (j == 0) {
                            System.out.format("||%-3d | ", students.get(i).getId());
                            System.out.format("%-25s | ", students.get(i).getName());
                            System.out.format("%-10s| ", displayPointFactor1List(students, i, j));
                            System.out.format("%-10s| ", displayPointFactor2List(students, i, j));
                            System.out.format("%-10s| ", displayPointFactor3List(students, i, j));
                            System.out.format("%-10.2f || \n", students.get(i).getAveragePoint());
                        } else {
                            System.out.format("||%-3s | ", "");
                            System.out.format("%-25s | ", "");
                            try {
                                System.out.format("%-10s| ", displayPointFactor1List(students, i, j));
                            } catch (IndexOutOfBoundsException e) {
                                System.out.format("%-10s| ", " ");
                            }
                            try {
                                System.out.format("%-10s| ", displayPointFactor2List(students, i, j));
                            } catch (IndexOutOfBoundsException e) {
                                System.out.format("%-10s| ", " ");
                            }
                            try {
                                System.out.format("%-10s| ", displayPointFactor3List(students, i, j));
                            } catch (IndexOutOfBoundsException e) {
                                System.out.format("%-10s| ", " ");
                            }
                            System.out.format("%-10s || \n", "");
                        }
                    } else {
                        System.out.print("");
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.print("");
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    private String displayPointFactor1List(List<Student> students, int i, int j) {
        if (students.get(i).getPointFactor1().get(j) < 0 | students.get(i).getPointFactor1().get(j) > 10) {
            return "Chưa nhập";
        } else {
            String result = "" + students.get(i).getPointFactor1().get(j);
            return result;
        }
    }


    private String displayPointFactor2List(List<Student> students, int i, int j) {
        if (students.get(i).getPointFactor2().get(j) < 0 | students.get(i).getPointFactor2().get(j) > 10) {
            return "Chưa nhập";
        } else {
            return "" + students.get(i).getPointFactor2().get(j);
        }
    }

    private String displayPointFactor3List(List<Student> students, int i, int j) {
        if (students.get(i).getPointFactor3().get(j) < 0 | students.get(i).getPointFactor3().get(j) > 10) {
            return "Chưa nhập";
        } else {
            return "" + students.get(i).getPointFactor3().get(j);
        }
    }

    private String displayPointFactor1Map(HashMap<Integer, Student> map, int id, int i) {
        if (map.get(id).getPointFactor1().get(i) < 0 | map.get(id).getPointFactor1().get(i) > 10) {
            return "Chưa nhập";
        } else {
            return "" + map.get(id).getPointFactor1().get(i);
        }
    }

    private String displayPointFactor2Map(HashMap<Integer, Student> map, int id, int i) {
        if (map.get(id).getPointFactor2().get(i) < 0 | map.get(id).getPointFactor2().get(i) > 10) {
            return "Chưa nhập";
        } else {
            return "" + map.get(id).getPointFactor2().get(i);
        }
    }

    private String displayPointFactor3Map(HashMap<Integer, Student> map, int id, int i) {
        if (map.get(id).getPointFactor3().get(i) < 0 | map.get(id).getPointFactor3().get(i) > 10) {
            return "Chưa nhập";
        } else {
            return "" + map.get(id).getPointFactor3().get(i);
        }
    }

    private void showStudentList() {
        List<Student> listStudent = new ArrayList<>(map.values());

        showStudent(listStudent, Student.getAutoId());
    }

    public int findMaxNumberOfPoint() {
        int max = 0;
        for (Student item : map.values()) {
            if (item.getPointFactor1().size() > max) {
                max = item.getPointFactor1().size();
            }
        }
        return max;
    }

    private void addStudent() {
        int number = validateNumberGreaterThan0("Nhập số lượng học viên cần thêm: ");
        for (int i = 0; i < number; i++) {
            String name = validateName("Nhập tên:");
            Student student = new Student(name);
            map.put(student.getId(), student);
        }
        addFile();
    }

    private void addFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("data.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(map);
        } catch (IOException e) {
            System.err.println("Có vấn đề ghi file");
        }
    }

    private String validateName(String mess) {
        System.out.println(mess);
        try {
            String name = sc.nextLine();
            if (name.length() > 25) throw new Exception();
            for (int i = 0; i < name.length(); i++) {
                String str = name.charAt(i) + "";
                if (!str.matches("[a-zA-Z ]")) {
                    throw new Exception();
                }
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
            System.err.println("Trong tên không được có số hoặc quá dài");
            return validateName(mess);
        }
    }

    public int validateID(String mess) {
        System.out.println(mess);
        try {
            int id = getInt();
            if (id == 0) return 0;
            if (id > 0) {
                for (Student student : map.values()) {
                    if (student.getId() == id) {
                        return id;
                    }
                }
            }
            throw new Exception();
        } catch (Exception e) {
            System.err.println("ID không hợp lệ hoặc không tồn tại học viên này!");
            return validateID(mess);
        }
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

    public double validatePoints(String mess) {
        System.out.println(mess);
        try {
            double point = getDouble();
            if (point > 10 || point < 0) {
                throw new Exception();
            } else {
                return point;
            }
        } catch (Exception e) {
            System.err.println("Điểm phải trong khoảng [0 - 10]");
            return validatePoints(mess);
        }
    }

    public void done() {
        System.out.println("Thực hiện thành công!");
        System.out.println("____________________________________________");
    }

    private void editStudentInfo() {
        int id = validateID("Nhập ID để sửa, nhập 0 để trở về menu ");
        if (id == 0) return;
        String name = validateName("Nhập tên mới:");
        map.get(id).setName(name);
        addFile();
        done();
    }

    private void deleteStudent() {
        int id = validateID("Nhập ID để xóa, nhập 0 để trở về menu");
        if (id == 0) return;
        displayStudentInfo(id);
        if (confirmMenu()) {
            map.remove(id);
            addFile();
            done();
        }
    }

    private boolean confirmMenu() {
        while (true) {
            int choise = validateNumberGreaterThan0("Bạn chắc chắn muốn xóa học viên này?\n1. Có\n2. Không");
            switch (choise) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.err.println("Chỉ 'Có' hoặc 'Không'!");
            }
        }
    }

    private void insertEachPoint() {
        int id = validateID("Nhập ID học viên để nhập điểm, nhập 0 để trở về menu");
        if (id == 0) return;
        displayStudentInfo(id);
        int choise = -1;
        while (choise != 0) {
            System.out.println("1. Nhập điểm học viên lần thứ 1 (hệ số 1)");
            System.out.println("2. Nhập điểm học viên lần thứ 2 (hệ số 1)");
            System.out.println("3. Nhập điểm học viên lần thứ 3 (hệ số 2)");
            System.out.println("4. Nhập điểm học viên lần thứ 4 (hệ số 3)");
            System.out.println("0. Trở về menu");
            choise = validateNumberGreaterThan0("Mời nhập:");
            switch (choise) {
                case 1:
                    if (checkInsert(map.get(id).getPointFactor1().get(0))) {
                        System.err.println("Điểm đã được nhập, không thể nhập thêm!");
                        break;
                    } else {
                        double point = validatePoints("Nhập điểm:");
                        map.get(id).getPointFactor1().set(0, point);
                        done();
                        displayStudentInfo(id);
                    }
                    break;
                case 2:
                    if (checkInsert(map.get(id).getPointFactor1().get(1))) {
                        System.err.println("Điểm đã được nhập, không thể nhập thêm!");
                        break;
                    } else {
                        double point = validatePoints("Nhập điểm:");
                        map.get(id).getPointFactor1().set(1, point);
                        done();
                        displayStudentInfo(id);
                    }
                    break;
                case 3:
                    if (checkInsert(map.get(id).getPointFactor2().get(0))) {
                        System.err.println("Điểm đã được nhập, không thể nhập thêm!");
                        break;
                    } else {
                        double point = validatePoints("Nhập điểm:");
                        map.get(id).getPointFactor2().set(0, point);
                        done();
                        displayStudentInfo(id);
                    }
                    break;
                case 4:
                    if (checkInsert(map.get(id).getPointFactor3().get(0))) {
                        System.err.println("Điểm đã được nhập, không thể nhập thêm!");
                        break;
                    } else {
                        double point1 = validatePoints("Nhập điểm:");
                        map.get(id).getPointFactor3().set(0, point1);
                        done();
                        displayStudentInfo(id);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Nhập sai, mời nhập lại");
                    break;
            }
        }
        map.get(id).setAveragePoint();
        addFile();
        done();
    }

    private boolean checkInsert(Double point) {
        return !(point < 0 | point > 10);
    }

    private void displayStudentInfo(int id) {
        String name = map.get(id).getName();
        System.out.println("Học sinh: " + name + "\t");
        System.out.print("Điểm hệ 1: ");
        for (int i = 0; i < map.get(id).getPointFactor1().size(); i++) {
            System.out.print(displayPointFactor1Map(map, id, i));
            System.out.print("\t|");
        }
        System.out.print("Điểm hệ 2: ");
        for (int i = 0; i < map.get(id).getPointFactor2().size(); i++) {
            System.out.print(displayPointFactor2Map(map, id, i));
            System.out.print("\t|");
        }
        System.out.print("Điểm hệ 3: ");
        for (int i = 0; i < map.get(id).getPointFactor3().size(); i++) {
            System.out.print(displayPointFactor3Map(map, id, i));
        }
        System.out.println();
    }

    public int getInt() {
        return Integer.parseInt(sc.nextLine());
    }

    public double getDouble() {
        return Double.parseDouble(sc.nextLine());
    }

    @Override
    public String toString() {
        return "ManagementApp{" +
                "map=" + map +
                '}';
    }

    public static void main(String[] args) {
        ManagementApp app = new ManagementApp();
        app.showMenu();
    }
}
