
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class IOHandler {
    private static final String fileName = "data/contacts.cvs";

    static {
        new File("data/").mkdirs();
    }

    public static void writeCVS(List<Contact> list) {
        try (PrintWriter fileWriter = new PrintWriter(fileName)) {
            for (Contact contact : list) {
//                fileWriter.println(contact.getCVS());
            }
            System.out.println("Luu CVS thanh cong");
        } catch (IOException e) {
            System.out.println("Luu CVS that bai: " + e.getMessage());
        }
    }

    public static List<Contact> readCVS() {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            List<Contact> map = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                String phoneNumber = parseField(fields[0]);
                String group = parseField(fields[1]);
                String fullName = parseField(fields[2]);
                String gender = parseField(fields[3]);
                String address = parseField(fields[4]);
                String dob = parseField(fields[6]);
                String email = parseField(fields[5]);
                Contact contact = new Contact(phoneNumber, group, fullName, gender, address, dob, email);
                map.add(contact);
            }
            return map;
        } catch (FileNotFoundException e) {
            System.out.println("Doc CVS that bai: " + e.getMessage());
            return null;
        }
    }

    private static String parseField(String field) {
        return field.substring(1, field.length() - 1);
    }
}