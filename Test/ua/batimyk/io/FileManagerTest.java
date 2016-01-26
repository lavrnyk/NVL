package ua.batimyk.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.StringJoiner;

import static org.junit.Assert.*;

/**
 * Created by N on 01/25/16.
 * NVL
 */
public class FileManagerTest {

    private static final String ROOT_TEST_PATH = System.getProperty("java.io.tmpdir") + "\\" + "io_test_dir";
    private static final byte MAX_PATH_DEPTH = 3;
    private static final int MAX_FILE_SIZE = 1024 * 1024;
    private static final int FILES_COUNT_PER_DIR = 5;

    private void deleteDir(String path) {
        deleteDir(new File(path));
    }

    private void deleteDir(File path) {
        if (path.exists()) {
            //noinspection ConstantConditions
            for (File f : path.listFiles()) {
                if (f.isDirectory()) {
                    deleteDir(f);
                }
                f.delete();
            }
            path.delete();
        }
    }

    private void prepareTestData(int maxPathDepth, int maxFilesCount, int maxFileSize) throws IOException {
        File f = new File(ROOT_TEST_PATH);

        deleteDir(f);
        f.mkdir();

        StringBuilder path = new StringBuilder(ROOT_TEST_PATH);
        for (int i = 0; i < maxPathDepth; i++) {
            path.append("\\tmp").append(i);
            new File(path.toString()).mkdir();
            for (int j = 0; j < maxFilesCount; j++) {
                StringBuilder filePath = new StringBuilder(path);
                Random r = new Random();
                filePath.append("\\file").append(j);
                File fp = new File(filePath.toString());
                try (FileOutputStream out = new FileOutputStream(fp)) {
                    byte[] buf = new byte[r.nextInt(maxFileSize) + 1];
                    out.write(buf);
                    System.out.println(filePath.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCalculateFiles() throws Exception {
        prepareTestData(0, 0, 0);
        Assert.assertEquals(0,FileManager.calculateFiles(ROOT_TEST_PATH));
        prepareTestData(1, 0, 0);
        Assert.assertEquals(0,FileManager.calculateFiles(ROOT_TEST_PATH));
        prepareTestData(1, 1, 1);
        Assert.assertEquals(1,FileManager.calculateFiles(ROOT_TEST_PATH));
        prepareTestData(MAX_PATH_DEPTH, FILES_COUNT_PER_DIR, MAX_FILE_SIZE);
        Assert.assertEquals(MAX_PATH_DEPTH * FILES_COUNT_PER_DIR,FileManager.calculateFiles(ROOT_TEST_PATH));

    }

    @Test
    public void testCalculateDirs() throws Exception {
        prepareTestData(0, 0, 0);
        Assert.assertEquals(0,FileManager.calculateDirs(ROOT_TEST_PATH));
        prepareTestData(1, 0, 0);
        Assert.assertEquals(1,FileManager.calculateDirs(ROOT_TEST_PATH));
        prepareTestData(2, 0, 0);
        Assert.assertEquals(2,FileManager.calculateDirs(ROOT_TEST_PATH));
        prepareTestData(MAX_PATH_DEPTH, FILES_COUNT_PER_DIR, MAX_FILE_SIZE);
        Assert.assertEquals(MAX_PATH_DEPTH ,FileManager.calculateDirs(ROOT_TEST_PATH));
    }

    @Test
    public void testCopy() throws Exception {
        String copyDir = ROOT_TEST_PATH + "_copy";
        System.out.println(copyDir);
        deleteDir(copyDir);
        prepareTestData(MAX_PATH_DEPTH, FILES_COUNT_PER_DIR, MAX_FILE_SIZE);
        Assert.assertTrue(FileManager.copy(ROOT_TEST_PATH,copyDir));
        Assert.assertEquals(FileManager.calculateDirs(ROOT_TEST_PATH),FileManager.calculateDirs(copyDir));
        Assert.assertEquals(FileManager.calculateFiles(ROOT_TEST_PATH),FileManager.calculateFiles(copyDir));
        deleteDir(copyDir);
        prepareTestData(MAX_PATH_DEPTH+1, FILES_COUNT_PER_DIR+1, MAX_FILE_SIZE);
        Assert.assertTrue(FileManager.copy(ROOT_TEST_PATH,copyDir));
        Assert.assertEquals(FileManager.calculateDirs(ROOT_TEST_PATH),FileManager.calculateDirs(copyDir));
        Assert.assertEquals(FileManager.calculateFiles(ROOT_TEST_PATH),FileManager.calculateFiles(copyDir));
    }

    @Test
    public void testMove() throws Exception {
        String copyDir = ROOT_TEST_PATH + "_copy";
        String moveDir = ROOT_TEST_PATH + "_move";
        deleteDir(copyDir);
        deleteDir(moveDir);
        prepareTestData(MAX_PATH_DEPTH, FILES_COUNT_PER_DIR, MAX_FILE_SIZE);
        FileManager.copy(ROOT_TEST_PATH,copyDir);
        int dirCount = FileManager.calculateDirs(copyDir);
        int fileCount = FileManager.calculateFiles(copyDir);
        Assert.assertTrue(FileManager.move(copyDir,moveDir));
        Assert.assertEquals(dirCount,FileManager.calculateDirs(moveDir));
        Assert.assertEquals(fileCount,FileManager.calculateFiles(moveDir));
        Assert.assertFalse(new File(copyDir).exists());
    }
}