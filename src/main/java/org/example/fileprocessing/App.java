package org.example.fileprocessing;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Comparator;
import java.util.stream.Stream;

public class App {

    static void main(String[] args) {
        exampleReadResource();
        exampleNewBufferedReader();
        exampleWriteResourceLegacy();
        exampleWriteResource();
        exampleFolderOperations();
    }

    public static void exampleReadResource() {
        System.out.println("Example Read Resource File ------");

        // Path relative to the class package (requires resources/org/example/fileprocessing/data/cities.txt)
        String packageRelativePath = "data/fruits.txt";

        // Absolute path from the resources root (requires resources/data/cities.txt)
        String rootAbsolutePath = "/data/cities.txt";

        try (InputStream inputStream = App.class.getResourceAsStream(rootAbsolutePath)) {
            if (inputStream != null) {
                String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                System.out.println(content);
            } else {
                System.err.println("File not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exampleNewBufferedReader() {
        System.out.println("Example NewBufferedReader ------");

        String resourcePath = "/data/cities.txt"; // Search in resources

        try (InputStream inputStream = App.class.getResourceAsStream(resourcePath)) {

            if (inputStream == null) {
                System.err.println("Not found file!");
                return;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exampleWriteResourceLegacy() {
        System.out.println("Example Write Resource File ------");
        String[] lines = new String[]{"Good morning", "Good afternoon", "Good night"};
        String path = "out.txt"; // Create in root

        // true: append without delete existing file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Successfully wrote to " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exampleWriteResource() {
        String[] lines = new String[]{"Apple", "Banana", "Orange"};
        Path path = Paths.get("fruits.txt"); // Create in root

        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exampleFolderOperations() {
        System.out.println("--- Starting Folder Manipulation Test ---");

        Path baseDir = Paths.get("data", "logs", "2026");
        Path renamedDir = Paths.get("data", "archived_logs");

        try {
            // 1. Create parent directories and target folder automatically
            Files.createDirectories(baseDir);
            System.out.println("1. Directories created successfully: " + baseDir.toAbsolutePath());

            // 2. Check existence and verify if it's a directory
            if (Files.exists(baseDir) && Files.isDirectory(baseDir)) {
                System.out.println("2. Directory verified and confirmed!");
            }

            // Create dummy files to test listing and recursive deletion
            Files.createFile(baseDir.resolve("app.log"));
            Files.createFile(baseDir.resolve("error.log"));

            // 3. List top-level content inside "data/logs"
            System.out.println("3. Listing top-level contents of 'data/logs':");
            try (Stream<Path> stream = Files.list(Paths.get("data", "logs"))) {
                stream.forEach(path -> System.out.println("   - " + path.getFileName()));
            }

            // 4. Rename or move directory
            Files.move(Paths.get("data", "logs"), renamedDir, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("4. Moved 'data/logs' to: " + renamedDir);

            // 5. Delete directory recursively (deletes files first, then folders)
            System.out.println("5. Cleaning up and deleting root 'data' folder recursively...");
            Path rootFolder = Paths.get("data");

            if (Files.exists(rootFolder)) {
                try (Stream<Path> stream = Files.walk(rootFolder)) {
                    stream.sorted(Comparator.reverseOrder()) // Sort in reverse to delete children before parent
                            .map(Path::toFile)
                            .forEach(File::delete);
                }
                System.out.println("   Cleanup completed successfully!");
            }

        } catch (IOException e) {
            System.err.println("Error during folder manipulation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


// Difference between Paths.get() and getResourceAsStream():
//
// 1. Paths.get("data/in.txt"):
//    Looks for a physical file on the computer's hard drive starting from the project's
//    working directory (execution root, e.g., 'user.dir').
//
// 2. ClassName.class.getResourceAsStream("/data/in.txt"):
//    Looks for a file inside the compiled application's Classpath (e.g., target/classes, bin,
//    or packaged inside a final .jar file), independent of the physical file system path.

//        Path path = Paths.get("data", "in.txt");
//
//        try {
//            String content = Files.readString(path);
//            System.out.println(content);
//        } catch (IOException e) {
//            System.out.println("Error: " + e.getMessage());
//        }