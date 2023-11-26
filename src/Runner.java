import java.io.*;

class Triplet{
    boolean isTri(int a, int b, int c, int d){
        if((Math.pow(a,d)+Math.pow(b,d))==Math.pow(c,d)){
            return true;
        }
        return false;
    }
}

class Runner{
    public static void main(String[] args){
        BufferedWriter bw= null;
        try{
            bw= new BufferedWriter(new FileWriter("results.txt"));
        }catch(IOException e){
        }
        PrintWriter pw= new PrintWriter(System.out, true);
        Triplet t= new Triplet();
        for(int i=1;i<=Integer.MAX_VALUE; i++){
            pw.println("At "+i);
            boolean rt= true;
            for(int j=1; j<5; j++){
                if(t.isTri(i, i+1, i+2, j)){
                    rt= true;
                }else{
                    rt=false;
                    break;
                }
            }
            if(rt){
                try{
                    bw.write(Integer.toString(i));
                    bw.newLine();
                }catch(IOException e){}
            }
        }
        try{
            bw.close();
        }catch(Exception e){}
    }
}