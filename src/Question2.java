import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.util.Collections.*;

public class Question2 {

    public static ArrayList<Integer>Sort(ArrayList<Integer>arrayList)
    {
        for (int i = 0;i<arrayList.size()-1;i++){
            for(int j=i+1;j<arrayList.size();j++){
                if(arrayList.get(i) >arrayList.get(j)) {
                    Collections.swap(arrayList,i,j);
                }
            }
        }
        return arrayList;
    }
    public static void main(String[] args){
        ArrayList<Integer>list = new ArrayList<Integer>();
        Random random = new Random();
        for(int i=0;i<1000;i++){
            int index = random.nextInt(1000);
            list.add(i,index);
        }
        Question2.Sort(list);
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}
