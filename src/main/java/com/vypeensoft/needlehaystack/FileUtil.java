package com.vypeensoft.needlehaystack;

import java.io.*;
import java.util.*;

public class FileUtil {
    //=========================================================================================
    public static String readFileContentsAsString(String fileName) throws Exception {
        StringBuffer returnStringBuffer = new StringBuffer();
        InputStream instream = new FileInputStream(new File(fileName));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(instream));
        try {
            String line = null; // not declared within while loop
            while ((line = bufferedReader.readLine()) != null) {
                returnStringBuffer.append(line+"\n");
            }
        } finally {
            bufferedReader.close();
            instream.close();
        }
        return returnStringBuffer.toString();
    }
    //=========================================================================================
    public static List<String> readFileContentsAsStringList(String fileName) throws Exception {
        List<String> returnArray = new ArrayList<String>();
        InputStream instream = new FileInputStream(new File(fileName));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(instream));
        try {
            String line = null; // not declared within while loop
            while ((line = bufferedReader.readLine()) != null) {
                returnArray.add(line);
            }
        } finally {
            bufferedReader.close();
            instream.close();
        }
        return returnArray;
    }
    //=========================================================================================
    public static void writeStringToNewFile(String fileListLocation, String str) throws Exception {
       FileOutputStream fOut = new FileOutputStream(new File(fileListLocation));
       OutputStreamWriter osw = new OutputStreamWriter(fOut); 
       osw.write((str + System.getProperty("line.separator")));
       osw.flush();
       osw.close();
       fOut.close();
    }
    //=========================================================================================
    public static void appendStringToFile(String fileListLocation, String str) throws Exception {
       FileOutputStream fOut = new FileOutputStream(new File(fileListLocation), true);
       OutputStreamWriter osw = new OutputStreamWriter(fOut); 
       osw.write((str + System.getProperty("line.separator")));
       osw.flush();
       osw.close();
       fOut.close();
    }
    //=========================================================================================
	public static List<String> removeBlanks(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			String oneLine = list.get(i);
			if(oneLine.trim().equals("")) {
				list.remove(i);
				i--;
			}
		}
		return list;
	}
    //=========================================================================================
    //=========================================================================================
    //=========================================================================================
    //=========================================================================================
    //=========================================================================================
}
