package objectmodels;

import exceptionpackage.Invalid_ContainingDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by deepaksood619 on 25/5/16.
 */
public class MyFile {

    private String location;
    private String fileName;
    private String content;

    public MyFile(String location, String fileName, String content) {
        this.location = location;
        this.fileName = fileName;
        this.content = content;
    }

    public MyFile(String location) {
        this.location = location;
    }

    public void createFile() {
        File newFile = new File(location);
        FileWriter fileWriter;
        if(!newFile.exists()) {
            try {
                if(newFile.createNewFile()) {
                    fileWriter = new FileWriter(location);
                    fileWriter.write(content);
                    fileWriter.flush();
                    fileWriter.close();
                    System.out.println("File created successfully");
                }
                else {
                    System.out.println("File creation error");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createBlankFile() throws Invalid_ContainingDir, IOException {
        File newFile = new File(location);

        try {
            if(newFile.createNewFile()) {
                System.out.println("File created successfully");
            }
            else {
                throw (new Invalid_ContainingDir("No such file or directory"));
            }
        } catch (IOException | Invalid_ContainingDir e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteFile() {
        //for future implementation
    }

    public void modifyFile() {
        //for future implementation
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
