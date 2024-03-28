import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        lib.clearConsole();
        Scanner input = new Scanner(System.in);
        
        File para = new File("params.txt");
        para.createNewFile();
        Scanner paraR = new Scanner(para);
        FileWriter paraW = new FileWriter(para, true);
        

        File rc = new File("rc.txt");
        rc.createNewFile();
        Scanner rcR = new Scanner(rc);
        FileWriter rcW = new FileWriter("rc.txt", true);

        File[] fileList = {para, rc};

        System.out.print("Initial Time: ");
        String t = input.nextLine();
        paraW.write(t + "\n");
        lib.clearConsole();

        System.out.print("Final Time: ");
        String t2 = input.nextLine();
        paraW.write(t2 + "\n");
        lib.clearConsole();

        System.out.print("V: ");
        String v = input.nextLine();
        paraW.write(v + "\n");
        lib.clearConsole();

        System.out.print("R: ");
        String r = input.nextLine();
        paraW.write(r + "\n");
        lib.clearConsole();

        System.out.print("C: ");
        String c = input.nextLine();
        paraW.write(c);
        lib.clearConsole();
        paraW.close();

        int par1 = Integer.valueOf(paraR.nextLine());
        int par2 = Integer.valueOf(paraR.nextLine());
        for (int i = par1; i < par2 + 1; i++) {
            
            paraR = new Scanner(para);
            paraR.nextLine();
            paraR.nextLine();
        
            rcW.write("Time: " + i + " -- " + Double.toString(equation(Double.valueOf(paraR.nextLine()), Double.valueOf(paraR.nextLine()), Double.valueOf(paraR.nextLine()), i)) + "\n");
           
        }
        
        rcW.close();
        while (rcR.hasNextLine()) {
            System.out.println(rcR.nextLine());
        }
        
        
        paraR.close();
        
        paraW.close();
        rcR.close();
        rcW.close();
        
        input.close();
        
        System.gc(); // fix for the params file not deleting found online
        for(File f : fileList){
            f.delete();
        }
        
       
        


    }

    public static double equation(double v,  double r, double c, int t) {
        return v * (1 - Math.exp(-t/(r*c))); //v(t) = B(1 - e-t/(RC))
    }
}