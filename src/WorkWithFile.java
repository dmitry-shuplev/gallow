import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WorkWithFile {
    public static final String PATHIN = "src\\1.txt";
    public static final String PATHOUT = "src\\2.txt";


    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(PATHIN));
             BufferedWriter writer = new BufferedWriter(new FileWriter(PATHOUT))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty() && line.length()>=4) { // Проверяем, что строка не пустая
                    writer.write(line); // Записываем строку в выходной файл
                    writer.newLine(); // Добавляем переход на новую строку
                }
            }
            System.out.println("Файл успешно переписан без пустых строк.");
        } catch (IOException e) {
            e.printStackTrace(); // Обработка исключений
        }
    }
        //end of WorkWithFile

}