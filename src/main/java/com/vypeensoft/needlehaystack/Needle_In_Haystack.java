package com.vypeensoft.needlehaystack;

import java.util.ArrayList;
import java.util.List;

public class Needle_In_Haystack {
	public static String NEEDLE_MATCHED_FILENAME   = "";
	public static String NEEDLE_UNMATCHED_FILENAME = "";
	public static String HAYSTACK_MATCHED_FILENAME = "";
	public static String haystackFile = "";
	public static String needleFile   = "";

	public static List<String> haystackList = new ArrayList<String>();
	public static List<String> needleList   = new ArrayList<String>();
	public static List<Pair>   matchedList  = new ArrayList<Pair>();
	public static List<String> unmatchedNeedleList  =  new ArrayList<String>();

    public static void main(String[] args) throws Exception {
    	if(args == null) {
    		System.out.println("Usage : Needle_In_Haystack haystack.txt needle.txt");
    		System.exit(-1);
    	}
    	haystackFile = args[0];
    	needleFile   = args[1];
    	
    	haystackList = FileUtil.readFileContentsAsStringList(haystackFile);
    	needleList  =  FileUtil.readFileContentsAsStringList(needleFile);
    	boolean found = false;

    	for(int i=0;i<needleList.size();i++) {
    		String needleString = needleList.get(i); 
    		found = false;
        	for(int j=0;j<haystackList.size();j++) {
        		String haystackString = haystackList.get(j);
        		if(haystackString.indexOf(needleString) != -1) {
        			//needle found
        			//System.out.println("\""+needleString+"\" found in \""+haystackString+"\"");
        			Pair pair = new Pair();
        			pair.key=needleString;
        			pair.value=haystackString;
        			matchedList.add(pair);
        			found = true;
        		}
        	}
        	if(!found) {
        		unmatchedNeedleList.add(needleString);
        	}
    	}
    	System.out.println("----------------------------------------------------------------------------");
    	System.out.println("Matched Needle List = \n"+matchedList);
    	System.out.println("----------------------------------------------------------------------------");
    	System.out.println("Unmatched Needle List = \n"+unmatchedNeedleList);
    	System.out.println("----------------------------------------------------------------------------");
    }

}

class Pair {
	public String key;
	public String value;
	public String toString() {
		return "["+key+","+value+"]\n";
	}
}
