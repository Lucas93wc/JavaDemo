package com.lucas.file;

import java.io.File;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-08-21 16:35
 */
public class FileTest {
  public static void main(String[] args) {
    FileTest fileTest = new FileTest();
    fileTest.test01();
    System.out.println("done");
  }


  private void test01() {
    String filename = "E:" + File.separator +
        "download" + File.separator + "20230821" + File.separator +"1.pdf";
    System.out.println(filename);
    File file = new File(filename);

    String parent = file.getParent();
    System.out.println("parent: "+ parent);

    File parentFile = file.getParentFile();
    System.out.println("parentFile: " + parentFile.getAbsolutePath());

    if ( !parentFile.exists())
      parentFile.mkdirs();

    deleteOtherFiles(parentFile);
  }

  public void deleteOtherFiles(File filepath) {
    if (filepath == null) {
      return;
    }

    File parentDir = filepath.getParentFile();
    if (parentDir == null || !parentDir.isDirectory()) {
      return;
    }

    File[] files = parentDir.listFiles();
    if (files == null) {
      return;
    }

    for (File file : files) {
      if (!file.equals(filepath)) {
        if (file.isDirectory()) {
          deleteDirectory(file);
        } else {
          file.delete();
        }
      }
    }
  }

  private void deleteDirectory(File directory) {
    if (directory == null || !directory.isDirectory()) {
      return;
    }

    File[] files = directory.listFiles();
    if (files == null) {
      return;
    }

    for (File file : files) {
      if (file.isDirectory()) {
        deleteDirectory(file);
      } else {
        file.delete();
      }
    }

    directory.delete();
  }
}
