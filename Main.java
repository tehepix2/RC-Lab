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
        FileWriter rcW = new FileWriter("rc.txt");

        
        System.out.print("V = ");
        String v = input.nextLine();
        paraW.write(v + "\n");
        lib.clearConsole();
        

        System.out.print("R = ");
        String r = input.nextLine();
        paraW.write(r + "\n");
        lib.clearConsole();

        System.out.print("C = ");
        String c = input.nextLine();
        paraW.write(c + "\n");
        lib.clearConsole();

        System.out.print("T = ");
        String t = input.nextLine();
        paraW.write(t);
        lib.clearConsole();
        paraW.close();

        System.out.println(equation(Double.valueOf(paraR.nextLine()), Double.valueOf(paraR.nextLine()), Double.valueOf(paraR.nextLine()), Integer.valueOf(paraR.nextLine())));
       
        paraR.close();
        rcR.close();
        rcW.close();
        input.close();
        para.delete();
        rc.delete();
        


    }

    public static double equation(double v,  double r, double c, int t) {
        return v * (1 - Math.exp(-t/(r*c))); //v(t) = B(1 - e-t/(RC))
    }
}