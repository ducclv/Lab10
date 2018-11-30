package lab10;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lab10 {
    public static List<String> list = new ArrayList<>();
    public static List<String> getAllFuntions(File Path) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(Path));
        String line;
        while((line = br.readLine()) != null){
            if(line.contains("/*")){
                while(!line.contains("*/")){
                    line = br.readLine();
                }
            }
            if(line.contains("public static") && line.endsWith("{")){
                int count = 0;
                String s = "";
                s += line + "\n";
                while((line = br.readLine()) != null){
                    s += (line + "\n");
                    if(line.endsWith("{")){
                        count +=1;
                    }
                    if(line.endsWith("}")){
                        count -=1;
                        if(count == 0){
                            break;
                        }
                    }
                }
                list.add(s);
            }
        }
        return list;
    }
    public static String findFuntionByName(String name) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("D:\\Lab9\\src\\com\\company\\Utils.java"));
        String line;
        String s = "";
        while((line = br.readLine()) != null){
            if(line.contains(name) && line.endsWith("{")){
                int count = 0;
                s += (line + "\n");
                while((line = br.readLine()) != null){
                    s += (line + "\n");
                    if(line.endsWith("{")){
                        count +=1;
                    }
                    if(line.endsWith("}")){
                        count -=1;
                        if(count == 0){
                            break;
                        }
                    }
                }
            }
        }
        return s;
    }
    public static void main(String[] args) throws IOException {
        File f = new File("D:\\Lab9\\src\\com\\company\\Utils.java");
        getAllFuntions(f);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
       // System.out.println(findFuntionByName("args"));
    }

}