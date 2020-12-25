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
//            System.err.println("Có vấn đề đọc file");
        }
    }

    public void showMenu() {
        int choose = -1;
        while (choose != 0) {
            System.out.println("Menu");
            System.out.println("1. Xem danh sách học viên");
            System.out.println("2. Thêm học viên");
            System.out.println("3. Sửa thông tin học viên");
            System.out.println("4. Xoá học viên");
            System.out.println("5. Nhập/sửa TỪNG ĐIỂM học viên");
            System.out.println("6. Nhập/sửa TOÀN BỘ ĐIỂM học viên");
            System.out.println("7. Xếp loại học viên");
            System.out.println("0. Thoát chương trình");
            System.out.println("____________________________________________");
            choose = validateNumberGreaterThan0("Mời nhập:");
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
                    insertEditEachPoint();
                    break;
                case 6:
                    insertEditAllPoints();
                    break;
                case 7:
                    gradingStudents();
                    break;
                case 0:
                    System.out.println("Đang thoát...");
                    break;
                default:
                    System.err.println("Nhập sai, vui lòng nhập lại");
                    break;
            }
        }
    }

    private void insertEditAllPoints() {
        int id = validateID("Nhập ID học viên để nhập điểm, nhập 0 để trở về menu");
        if (id == 0) return;
        double point1 = validatePoints("Nhập điểm học viên lần thứ 1 (hệ số 1)");
        double point2 = validatePoints("2. Nhập điểm học viên lần thứ 2 (hệ số 1)");
        double point3 = validatePoints("3. Nhập điểm học viên lần thứ 3 (hệ số 2)");
        double point4 = validatePoints("4. Nhập điểm học viên lần thứ 4 (hệ số 3)");
        map.get(id).getPointFactor1().set(0, point1);
        map.get(id).getPointFactor1().set(1, point2);
        map.get(id).getPointFactor2().set(0, point3);
        map.get(id).getPointFactor3().set(0, point4);
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
                            System.out.format("%-10.1f| ", students.get(i).getPointFactor1().get(j));
                            System.out.format("%-10.1f| ", students.get(i).getPointFactor2().get(j));
                            System.out.format("%-10.1f| ", students.get(i).getPointFactor3().get(j));
                            System.out.format("%-10.1f || \n", students.get(i).getAveragePoint());
                        } else {
                            System.out.format("||%-3s | ", "");
                            System.out.format("%-25s | ", "");
                            try {
                                System.out.format("%-10.1f| ", students.get(i).getPointFactor1().get(j));
                            } catch (IndexOutOfBoundsException e) {
                                System.out.format("%-10s| ", " ");
                            }
                            try {
                                System.out.format("%-10.1f| ", students.get(i).getPointFactor2().get(j));
                            } catch (IndexOutOfBoundsException e) {
                                System.out.format("%-10s| ", " ");
                            }
                            try {
                                System.out.format("%-10.1f| ", students.get(i).getPointFactor3().get(j));
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
            String name = validateName("Nhập tên");
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
            name = name.toLowerCase();
            name = name.trim();
            ArrayList<String> arr = new ArrayList<>();
            for (int i = 0; i < name.length(); i++) {
                if (name.split("")[i].matches("[\\d]")) {
                    throw new Exception();
                } else {
                    arr.add(name.split("")[i]);
                }
            }
            // Del space
            String str = arr.get(0).toUpperCase();
            arr.remove(0);
            arr.add(0, str);
            for (int i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i).equals(" ") && arr.get(i + 1).equals(" ")) {
                    arr.remove(i + 1);
                    i--;
                }
                if (arr.get(i).equals(" ") && !arr.get(i + 1).equals(" ")) {
                    String result = arr.get(i + 1).toUpperCase();
                    arr.remove(i + 1);
                    arr.add(i + 1, result);
                }
            }
            StringBuilder listString = new StringBuilder();
            for (String s : arr) {
                listString.append(s);
            }
            if (listString.toString().length() > 25)
                throw new Exception();
            return listString.toString();
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

    public int validatePoints(String mess) {
        System.out.println(mess);
        try {
            int point = getInt();
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
        map.remove(id);
        addFile();
        done();
    }

    private void insertEditEachPoint() {
        int id = validateID("Nhập ID học viên để nhập điểm, nhập 0 để trở về menu");
        if (id == 0) return;
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
                    double point1 = validatePoints("Nhập điểm:");
                    map.get(id).getPointFactor1().set(0, point1);
                    done();
                    break;
                case 2:
                    double point2 = validatePoints("Nhập điểm:");
                    map.get(id).getPointFactor1().set(1, point2);
                    done();
                    break;
                case 3:
                    double point3 = validatePoints("Nhập điểm:");
                    map.get(id).getPointFactor2().set(0, point3);
                    done();
                    break;
                case 4:
                    double point4 = validatePoints("Nhập điểm:");
                    map.get(id).getPointFactor3().set(0, point4);
                    done();
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

    public int getInt() {
        return Integer.parseInt(sc.nextLine());
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
