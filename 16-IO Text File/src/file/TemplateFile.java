package file;

import java.io.File;

public class TemplateFile {
    public static void main(String[] args) {
        File f = new File("foo.txt");
        File dir = new File("Books");
        dir.mkdir();
        if (dir.isDirectory()) {
            String[] dirContents = dir.list();
            for (int i = 0; i < dirContents.length; i++) {
                System.out.println(dirContents[i]);

            }
        }
        System.out.println(dir.getAbsolutePath());
        boolean isDeleted = f.delete();
        System.out.println(isDeleted);
    }
}
