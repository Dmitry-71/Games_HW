import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games"),
                new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games\\temp"),
                new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games\\src"),
                new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games\\res"),
                new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games\\savegames"),
                new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games\\src\\main"),
                new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games\\src\\test"),
                new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games\\res\\drawables"),
                new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games\\res\\vectors"),
                new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games\\res\\icons")
        );
        List<File> fileList = Arrays.asList(
                new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games\\src\\main\\Main.java"),
                new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games\\src\\main\\Utils.java"),
                new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games\\temp\\temp.txt")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append("Каталог " + folder + " создан\n");
            else sb.append("Каталог " + folder + " не создан\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter log = new FileWriter("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games\\temp\\temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\OneDrive\\Рабочий стол\\Работа\\Тест\\Учеба\\Games\\temp\\temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}