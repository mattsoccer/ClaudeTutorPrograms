import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilePathExplorer {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // First, let's see where our program is actually running from
        System.out.println("\n--- Working Directory Information ---");
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        
        // Let's also see where the user's home directory is
        System.out.println("User Home Directory = " + System.getProperty("user.home"));
        
        // Let's create a test file in different locations and try to read them
        try {
            // Create a test file in the project root directory
            createTestFile("test.txt", "This is a test file in the root directory");
            
            // Create a test file in a subfolder
            new File("data").mkdir();  // Create a 'data' folder if it doesn't exist
            createTestFile("data/test.txt", "This is a test file in the data folder");
            
            // Now let's try to read these files using different path methods
            System.out.println("\n--- Reading Files Using Different Paths ---");
            
            // Method 1: Simple filename (relative to working directory)
            System.out.println("\nTrying to read from working directory:");
            readAndPrintFile("test.txt");
            
            // Method 2: Subfolder path
            System.out.println("\nTrying to read from data subfolder:");
            readAndPrintFile("data/test.txt");
            
            // Method 3: Absolute path (using working directory)
            String absolutePath = new File("test.txt").getAbsolutePath();
            System.out.println("\nTrying to read using absolute path:");
            System.out.println("Absolute path being used: " + absolutePath);
            readAndPrintFile(absolutePath);
            
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        
        // Let's also examine a file object to see all its path properties
        File fileObject = new File("test.txt");
        System.out.println("\n--- File Object Properties ---");
        System.out.println("Path as given = test.txt");
        System.out.println("Absolute path = " + fileObject.getAbsolutePath());
        System.out.println("Canonical path = " + tryGetCanonicalPath(fileObject));
        System.out.println("Parent folder = " + fileObject.getParent());
        System.out.println("Does file exist? = " + fileObject.exists());

                // Add these lines to our main method after the existing code
        System.out.println("\n--- Path Style Experiments ---");

        // Create a test file
        try {
            
            String filename = "pathtest.txt";
            createTestFile(filename, "Testing different path styles");

            // Try different ways to reference the same file
            File file1 = new File("./" + filename);           // Using current directory notation
            File file2 = new File(filename);                  // Just the filename
            File file3 = new File("." + File.separator + filename); // Using system-specific separator

            System.out.println("Style 1 (./file): " + file1.getCanonicalPath());
            System.out.println("Style 2 (just filename): " + file2.getCanonicalPath());
            System.out.println("Style 3 (system separator): " + file3.getCanonicalPath());
            }
            catch (IOException e) {
                System.out.println("An error occurred during path experiments: " + e.getMessage());
            }
        
            System.out.println("\n--- Different Directory Experiment ---");

            try {
                // Get path to Documents folder
                String documentsPath = System.getProperty("user.home") + File.separator + "Documents";
                
                // Create a file in Documents folder
                String remoteFilePath = documentsPath + File.separator + "remote_test.txt";
                createTestFile(remoteFilePath,"This file is outside our project directory!");
                
                // Try to read it using different approaches
                System.out.println("\nFile location details:");
                System.out.println("Original path: " + remoteFilePath);
                
                File remoteFile = new File(remoteFilePath);
                System.out.println("Exists? " + remoteFile.exists());
                System.out.println("Canonical path: " + tryGetCanonicalPath(remoteFile));
                System.out.println("Parent directory: " + remoteFile.getParent());
                
                // Read and display contents
                try (BufferedReader reader = new BufferedReader(new FileReader(remoteFilePath))) {
                    System.out.println("File contents: " + reader.readLine());
                }
        
            } catch (IOException e) {
                System.out.println("Error working with remote file: " + e.getMessage());
            }
        
    }
    
    // Helper method to create a test file
    private static void createTestFile(String path, String content) throws IOException {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(content);
        }
        System.out.println("Created test file: " + path);
    }
    
    // Helper method to read and print file contents
    private static void readAndPrintFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            System.out.println("Successfully read file: " + path);
            System.out.println("Contents: " + line);
        } catch (IOException e) {
            System.out.println("Failed to read file: " + path);
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // Helper method to safely get canonical path
    private static String tryGetCanonicalPath(File file) {
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            return "Could not determine canonical path";
        }
    }

}