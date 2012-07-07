package com.yourpackagename.commons.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This utility class provides methods for general file operations.
 * Methods can be used to append(prefix/suffix) a string to file, get
 * all contents of a file,etc.
 *
 * @author Y Kamesh Rao
 */
public class FileHandler {
    /**
     * Appends a string to the file specified depending upon
     * the flag parameter.
     *
     * @param fileName
     * @param aString
     * @param suffix   Flag indicating whether to append at end(true) or at the beginning(false).
     */
    public static void appendString(String fileName, String aString, Boolean suffix) {
        //prepare the string to start at a new line
        aString = aString + "\n";

        //initialise the file variable
        File file = new File(fileName);
        //check and create the file if it does not exist
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(file, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (suffix) {
            //append at the end
            if (dataOutputStream != null)
                try {
                    dataOutputStream.writeBytes(aString);
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        } else {
            //append at the beginning
            BufferedReader dataInputStream = null;
            try {
                dataInputStream = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            if (dataInputStream != null) {
                //create a temporary file
                DataOutputStream temp = null;
                File tempFile = new File("temp.bin");
                try {
                    temp = new DataOutputStream(new FileOutputStream(tempFile));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                //write the string as its first line
                try {
                    temp.writeBytes(aString);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    //read all the lines from specified file and write them to temp file
                    for (String line; (line = dataInputStream.readLine()) != null; ) {
                        temp.writeBytes(line + "\n");
                    }
                    //close the files
                    dataInputStream.close();
                    temp.close();
                    //rename temp file as our related file
                    Boolean rename = tempFile.renameTo(new File(fileName));

                    if (!rename) {
                        throw new IOException("Could not update file.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * Returns a list of all lines present in a file.
     * Returns null if the file is not found.*
     *
     * @param fileName
     * @return List of all the lines present in the file
     */
    public static List<String> getLines(String fileName) {
        List<String> lines = new ArrayList<String>();

        File file = new File(fileName);

        BufferedReader iFile;
        try {
            iFile = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            //return null if file was not found
            return null;
        }

        try {
            for (String line; (line = iFile.readLine()) != null; ) {
                //add each line to the list
                lines.add(line);
            }
        } catch (IOException e) {
            return lines;
        }

        return lines;
    }


    /**
     * Removes a file
     *
     * @param fileName
     */
    public static Boolean remove(String fileName) {
        BufferedWriter fileWriter = null;
        try {
            fileWriter = new BufferedWriter(new FileWriter(fileName, false));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        try {
            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        try {
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        try {
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }


    /**
     * Checks for the existence of a file
     *
     * @param fileName
     */
    public static Boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }
}
