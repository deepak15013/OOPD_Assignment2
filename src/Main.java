import exceptionpackage.Invalid_ContainingDir;
import exceptionpackage.Invalid_Path;
import objectmodels.MyDir;
import objectmodels.MyFile;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Main {

    private static final String FILENAME = "FileStructure.txt";

    private static Scanner scanner;

    public static void main(String[] args) throws Invalid_ContainingDir, Invalid_Path, IOException {

        // for making FileStructure.txt (hardcoded)
        makeFile();

        // for reading FileStructure.txt and setting up the environment
        readFile();


        int option = 0;
        while(true) {
            scanner = new Scanner(System.in);

            inflateMenu();

            try {
                boolean nextInt = scanner.hasNextInt();

                if(nextInt) {
                    option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 1:
                            listAllFilesAndDir();
                            break;

                        case 2:
                            searchFile();
                            break;

                        case 3:
                            writeToFile();
                            break;

                        case 4:
                            readFromFile();
                            break;

                        case 5:
                            createFD();
                            break;

                        case 6:
                            copyFile();
                            break;

                        case 7:
                            System.exit(1);
                            break;

                        default:
                            System.out.println("Enter a valid number (0-7) : ");
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid option");
                scanner.close();
            }
        }
    }

    private static void makeFile() throws Invalid_ContainingDir{
        File file = new File(FILENAME);
        try {
            if(file.createNewFile()) {
                System.out.println("FileStructure.txt created successfully");
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("/home\n");
                fileWriter.write("/oopd\n");
                fileWriter.write("/home/sample\n");
                fileWriter.write("/home/sample/filename.txt\n");
                fileWriter.write("/home/filename1.csv\n");
                fileWriter.write("/oopd/assignment4\n");
                fileWriter.write("/oopd/assignment4/lab4\n");
                fileWriter.write("/oopd/assignment4/lab5\n");
                fileWriter.write("/oopd/assignment5\n");
                fileWriter.write("/oopd/assignment4/lab4/sample.txt\n");
                fileWriter.write("/oopd/assignment4/lab5/sample2.txt\n");
                fileWriter.write("/oopd/assignment5/file1.txt");
                fileWriter.flush();
                fileWriter.close();
                System.out.println("FileStructure.txt written");
            }
            else {
                System.out.println("Failed to create file");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing file");
        }
    }

    private static void readFile() {
        File file = new File(FILENAME);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                line = line.substring(1);
                System.out.println("create: "+line);
                File getLine = new File(line);
                if(line.contains(".txt")|| line.contains(".csv")) {
                    if(!getLine.exists()) {
                        if(getLine.createNewFile()) {
                            System.out.println("File created successfully");
                        }
                        else {
                            System.out.println("Error creating file");
                        }
                    }
                    else {
                        System.out.println("File exits");
                    }
                }
                else {
                    if(!getLine.exists()) {
                        if (getLine.mkdir()) {
                            System.out.println("Directory is created!");
                        } else {
                            System.out.println("Failed to create directory!");
                        }
                    }
                    else {
                        System.out.println("Directory exists");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void inflateMenu() {
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Menu for FileHandling");
        System.out.println("1. List all files and dir");
        System.out.println("2. Search for a file");
        System.out.println("3. Write a new file");
        System.out.println("4. Read from a file");
        System.out.println("5. Create a file/directory");
        System.out.println("6. Copy a file");
        System.out.println("7. Exit");
        System.out.println("Enter your choice - ");
    }

    private static void listAllFilesAndDir() throws Invalid_Path {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }

        System.out.println("Enter the path for displaying contents: ");
        String path = scanner.nextLine();

        File directory = new File(path);
        try {
            if(directory.exists()) {
                System.out.println("Path found");
                if(directory.isDirectory()) {
                    System.out.println("Its a directory");
                    String[] files = directory.list();
                    if(files.length == 0) {
                        System.out.println("Directory is empty");
                    }
                    else {
                        for(String file: files) {
                            System.out.print(file+"\t");
                        }
                        System.out.println();
                    }
                }
                if(directory.isFile()) {
                    System.out.println("Its a file");
                    System.out.println(directory.getName());
                }
            }
            else {
                throw(new Invalid_Path("Invalid path"));
            }
        } catch (Invalid_Path invalid_path) {
            System.out.println(invalid_path.getMessage());
        }
    }

    private static String fileName = "";
    private static List<String> result;
    private static void searchFile() throws Invalid_Path {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }

        System.out.println("Enter path to search for a file -");
        String searchPath = scanner.nextLine();

        File directory = new File(searchPath);

        try {
            if(directory.exists()) {
                System.out.println("Path found");
                System.out.println("Enter the filename to search -");
                fileName = scanner.nextLine();
                result = new ArrayList<>();
                search(directory);

                if(result.size()>0) {
                    System.out.println("File found");
                    for(String temp: result) {
                        System.out.println("path: "+temp);
                    }
                }
                else {
                    System.out.println("File not found");
                }

            }
            else {
                throw(new Invalid_Path("Invalid path"));
            }
        } catch (Invalid_Path invalid_path) {
            System.out.println(invalid_path.getMessage());
        }
    }

    private static void search(File file) {
        if(file.isDirectory()) {
            System.out.println("Searching directory ... " + file.getAbsoluteFile());
            for(File temp: file.listFiles()) {
                if(temp.isDirectory()) {
                    search(temp);
                }
                else {
                    if(fileName.equalsIgnoreCase(temp.getName())) {
                        result.add(temp.getAbsolutePath());
                    }
                }
            }
        }
    }

    private static void writeToFile() throws Invalid_ContainingDir {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }
        System.out.println("Enter path where file is to be created -");
        String path = scanner.nextLine();

        File file = new File(path);

        try {
            if(file.exists()) {
                System.out.println("path found");
                System.out.println("Enter new file name -");
                String fileName = scanner.nextLine();

                String fullPath = path.concat("/").concat(fileName);
                System.out.println("fullpath: "+fullPath);

                System.out.println("Enter contents of the file -");
                String temp = scanner.nextLine();
                String content = temp;

                while(!temp.equalsIgnoreCase("eof")) {
                    temp = scanner.nextLine();
                    if(!temp.equalsIgnoreCase("eof")) {
                        content = content.concat("\n").concat(temp);
                    }
                }
                System.out.println("Content: "+content);
                MyFile myFile = new MyFile(fullPath, fileName, content);
                myFile.createFile();

            }
            else {
                throw (new Invalid_ContainingDir("Directory not found"));
            }
        } catch (Invalid_ContainingDir invalid_containingDir) {
            System.out.println(invalid_containingDir.getMessage());
        }
    }

    private static void readFromFile() throws Invalid_Path {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }

        System.out.println("Enter the absolute path for file: ");
        String fileName = scanner.nextLine();
        File file = new File(fileName);

        try {
            if(file.exists() && file.isFile()) {
                System.out.println("File found");
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(file));
                    String line;
                    System.out.println("**************START*****************");
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    System.out.println("***************END******************");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("File not found");
                throw (new Invalid_Path("Invalid path"));
            }
        } catch (Invalid_Path invalid_path) {
            System.out.println(invalid_path.getMessage());
        }
    }

    private static void createFD() throws Invalid_ContainingDir, IOException {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }
        System.out.println("Enter the absolute path for file/directory -");
        String name = scanner.nextLine();

        File file = new File(name);

        //for making file
        if(name.contains(".")) {
            if(!file.exists()) {
                MyFile myFile = new MyFile(name);
                myFile.createBlankFile();
            }
            else {
                System.out.println("File already present");
            }
        }

        //for making directory
        else {
            if(!file.exists()) {
                MyDir myDir = new MyDir(name);
                myDir.createDir();
            }
            else
                System.out.println("Directory already present");
        }
    }

    private static void copyFile() throws Invalid_Path {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }
        System.out.println("Enter the source of file -");
        String srcFileName = scanner.nextLine();
        File srcFile = new File(srcFileName);

        try {
            if(srcFile.exists() && srcFile.isFile()) {
                System.out.println("File found");
                System.out.println("Enter the destination folder -");
                String desFolderName = scanner.nextLine();
                File desFolder = new File(desFolderName);

                if(desFolder.exists() && desFolder.isDirectory()) {
                    System.out.println("Destination found");

                    StringTokenizer stringTokenizer = new StringTokenizer(srcFileName, "/");

                    ArrayList<String> tokens = new ArrayList<>();
                    int i=0;
                    while (stringTokenizer.hasMoreTokens()) {
                        tokens.add(stringTokenizer.nextToken());
                    }

                    String destFullPath = desFolderName.concat("/").concat(tokens.get(tokens.size()-1));
                    System.out.println("New File Path - "+destFullPath);

                    File desNewFile = new File(destFullPath);
                    try {
                        Files.copy(srcFile.toPath(), desNewFile.toPath());
                        System.out.println("File copied successfully");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println("Destination does not exists or is a file");
                }
            }
            else {
                throw (new Invalid_Path("Invalid path"));
            }
        } catch (Invalid_Path invalid_path) {
            System.out.println(invalid_path.getMessage());
        }
    }
}
