import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        StringBuilder saveLog = new StringBuilder();
        File dirSource = new File("C:/GamesFilesHomeWork");

        File dirSrc = new File(dirSource, "src");
        File dirRes = new File(dirSource, "res");
        File dirSavegames = new File(dirSource, "savegames");
        File dirTemp = new File(dirSource, "temp");
        File dirMain = new File(dirSrc, "main");
        File dirTest = new File(dirSrc, "test");
        File fileMainJava = new File(dirMain, "Main.java");
        File fileUtilsJava = new File(dirMain, "Utils.java");
        File dirDrawables = new File(dirRes, "drawables");
        File dirVectors = new File(dirRes, "vectors");
        File dirIcons = new File(dirRes, "icons");
        File fileTempTxt = new File(dirTemp, "temp.txt");

        createNewDir(dirSrc, saveLog);
        createNewDir(dirRes, saveLog);
        createNewDir(dirSavegames, saveLog);
        createNewDir(dirTemp, saveLog);
        createNewDir(dirMain, saveLog);
        createNewDir(dirTest, saveLog);
        createNewFile(fileMainJava, saveLog);
        createNewFile(fileUtilsJava, saveLog);
        createNewDir(dirDrawables, saveLog);
        createNewDir(dirVectors, saveLog);
        createNewDir(dirIcons, saveLog);
        createNewFile(fileTempTxt, saveLog);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileTempTxt, true))) {
            String saveLogString = saveLog.toString();
            bufferedWriter.write(saveLogString);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createNewDir(File dir, StringBuilder saveLog) {
        if (dir.mkdir()) {
            saveLog.append("Директория " + dir.getName() + " создана\n");
        } else {
            saveLog.append("Директория " + dir.getName() + " не создана\n");
        }
    }
    public static void createNewFile(File file, StringBuilder saveLog) {
        try {
            if (file.createNewFile()) {
                saveLog.append("Файл " + file.getName() + " создан\n");
            } else {
                saveLog.append("Файл " + file.getName() + " не создан\n");
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}