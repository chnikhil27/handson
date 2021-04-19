package com.cts.handson.ds;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SparseArrays {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        
        
         Map<Integer, List<String>> map = new HashMap<>();

        for(int i=0; i<strings.length; i++){
            List<String> str = map.get(strings[i].length());
            if (str == null){
                str = new ArrayList<>();
            }
            str.add(strings[i]);

            map.put(strings[i].length(), str);
        }

        int[] count = new int[queries.length];

        for(int j=0; j<queries.length; j++){
            List<String> s = map.get(queries[j].length());
            count[j] = s != null ? 
                       Collections.frequency(s, queries[j]) : 0;
        }

        return count;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
