import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Navonil Mandal
 * @version 1.1
 */

/**
 * The Triplet class checks if a given set of numbers forms a triplet according to a specific
 * mathematical condition.
 */
class Triplet{
    boolean isTri(int a, int b, int c, int d){
        return(Math.pow(a,d)+Math.pow(b,d))==Math.pow(c,d)?true:false;
        }
}

/**
 * The Runner class generates numbers and checks if they form a triplet, writing the valid numbers to a
 * file.
 */
class Runner{
    public static void main(String[] args){
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out, true);
        Triplet t= new Triplet();
        for(;;){
            int k=0;
            ArrayList<ArrayList<Integer>> results= new ArrayList<ArrayList<Integer>>();
            int found=0;
            pw.println("Pls enter the depth of the triplets and the search length.");
            String in="";
            try{
                in+= br.readLine();
                if(in.equalsIgnoreCase("End")){
                    break;
                }
            }catch(IOException e){
                pw.println(e);
            }
            String[] tran= in.split(",");
            try{
                for(int i=1;i<=Integer.parseInt(tran[1].replaceAll("\\s","")); i++){
                    boolean rt= true;
                    for(int j=2; j<=Integer.parseInt(tran[0].replaceAll("\\s", "")); j++){
                        if(t.isTri(i, i+1, i+2, j)){
                            rt= true;
                        }else{
                            rt=false;
                            break;
                        }
                    }
                    if(rt){
                        results.add(new ArrayList<Integer>());
                        results.get(k).add(i);
                        results.get(k).add(i+1);
                        results.get(k).add(i+2);
                        k++;
                        found++;
                    }
                }
                pw.println("Completed...");
                pw.println("Found: "+found);
                pw.println(results);
            }catch(NumberFormatException e){
                pw.println("Invalid search length.");
            }
        }
    }
}