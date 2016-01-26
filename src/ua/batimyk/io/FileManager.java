package ua.batimyk.io;

/**
 * Created by N on 01/21/16.
 * NVL
 */

import java.io.*;

public class FileManager {

    final private static int COPY_BUFFER_SIZE = 1024;

    public static int calculateFiles(String path) {
        return calculateFiles(path, 0);
    }

    private static int calculateFiles(String path, int count) {
        File p = new File(path);
        if (p.exists()) {
            //noinspection ConstantConditions
            for (File f : p.listFiles()) {
                if (f.isFile()) {
                    count++;
                } else if (f.isDirectory()) {
                    count = calculateFiles(f.toString(), count);
                }
            }
            return count;
        }
        return 0;
    }

    public static int calculateDirs(String path) {
        return calculateDirs(path, 0);
    }

    private static int calculateDirs(String path, int count) {
        File p = new File(path);
        if (p.exists()) {
            //noinspection ConstantConditions
            for (File f : p.listFiles()) {
                if (f.isDirectory()) {
                    count++;
                    count = calculateDirs(f.toString(), count);
                }
            }
            return count;
        }
        return 0;
    }

    public static boolean copy(String from, String to) throws IOException {
        File pathFrom = new File(from);

        if (pathFrom.isFile()) {
            File pathTo = new File(to + "\\" + pathFrom.getName());
            copyFile(pathFrom, pathTo);
        } else if (pathFrom.isDirectory()) {

            //noinspection ConstantConditions
            for (File f : pathFrom.listFiles()) {
                StringBuilder path = new StringBuilder(to);
                if (f.isDirectory()) {
                    path.append("\\");
                    path.append(f.getName());
                    File pathTo = new File(path.toString());
                    pathTo.getParentFile().mkdir();
                }
                copy(f.toString(), path.toString());
            }
        } else {
            System.out.println("Incorrect input directory found: " + pathFrom);
            return false;
        }
        return true;
    }

    public static boolean move(String from, String to) throws IOException {
        File pathFrom = new File(from);

        if (pathFrom.isFile()) {
            File pathTo = new File(to + "\\" + pathFrom.getName());
            copyFile(pathFrom, pathTo);
            pathFrom.delete();

        } else if (pathFrom.isDirectory()) {
            //noinspection ConstantConditions
            for (File f : pathFrom.listFiles()) {
                StringBuilder path = new StringBuilder(to);
                if (f.isDirectory()) {
                    path.append("\\");
                    path.append(f.getName());
                    File pathTo = new File(path.toString());
                    pathTo.getParentFile().mkdir();
                }
                move(f.toString(), path.toString());

            }
            pathFrom.delete();
        } else {
            System.out.println("Incorrect input directory found: " + pathFrom);
            return false;
        }
        return true;
    }

    private static void copyFile(File from, File to) throws IOException {

        to.getParentFile().mkdir();

        try (InputStream in = new FileInputStream(from); OutputStream out = new FileOutputStream(to)) {
            byte[] buf = new byte[COPY_BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = in.read(buf)) > 0) {
                out.write(buf, 0, bytesRead);
            }
        }
    }
}
