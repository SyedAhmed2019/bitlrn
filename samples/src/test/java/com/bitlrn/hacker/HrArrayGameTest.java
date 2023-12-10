package com.bitlrn.hacker;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HrArrayGameTest {

    @Test
    public void canWin() throws IOException {
        File file = new File("./src/test/resources/HrArrayGameTestData.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int i =0;
        Integer leap = null;
        Integer arraySize;
        Integer count = 0;
        List<String> results = new ArrayList<>();
        while((line = br.readLine()) != null){
            String str;
            Integer query;
            if (i==0){
                query = Integer.valueOf(line.trim());
                i++;
            }else if (i%2 == 1){
                String input[] =  line.split(" ");
                arraySize = Integer.valueOf(input[0].trim());
                leap = Integer.valueOf(input[1].trim());
                i++;
            }else if ( i % 2 == 0){
                if (i == 2){
                    count = 1;
                }else{
                    ++count;
;                }
                String input[] = line.split(" ");
                int [] game = new int[input.length];
                int j=0;
                for (String item:input){
                    game[j++] = Integer.valueOf(item);
                }
                if(HrArrayGame.canWinMoveFwdFirst(leap,game)){
                   results.add("YES");
                }else{
                    results.add("NO");
                }
                i++;
            }
        }
        // here we will cover the results
        List<String> actual = new ArrayList<>();
        File resultsFile = new File("./src/test/resources/HrArrayGameTestDataResults.txt");
        BufferedReader brResults = new BufferedReader(new FileReader(resultsFile));
        String resultInput;
        while((resultInput = brResults.readLine()) != null){
            actual.add(resultInput.trim());
        }
        assert actual.size() == results.size();
        int k=0;
        for (String item: results){
            System.out.println("Expected item at k"+k +" is "+item);
            System.out.println("Actual item at k"+ k + " is "+ actual.get(k));
            assert actual.get(k++).equals(item);
        }
    }
    
    @Test
    void testFailed_input(){
        int a[] = {0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1,
                   0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0,
                   1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0};
        assert HrArrayGame.canWinMoveFwdFirst(14,a);
        //assert HrArrayGame.isSolvable(14,a,0);
    }

}