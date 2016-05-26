package objectmodels;

import exceptionpackage.Invalid_ContainingDir;

import java.io.File;

/**
 * Created by deepaksood619 on 25/5/16.
 */
public class MyDir {

    private String location;
    private String dirName;

    public MyDir(String location) {
        this.location = location;
    }

    public void createDir() {
        File file = new File(location);
        try {
            if(file.mkdirs()) {
                System.out.println("Directory created successfully");
            }
            else {
                System.out.println("Directory creation failed");
                throw new Invalid_ContainingDir("Directory creation failed");
            }
        } catch (Invalid_ContainingDir invalid_containingDir) {
            System.out.println(invalid_containingDir.getMessage());
        }
    }

    public void deleteDir() {
        //for future implementation
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }
}
