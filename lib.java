public class lib {   
    public static void sleep(int milliseconds){
        try {  
        Thread.sleep(milliseconds);   
        }
        catch(InterruptedException ex) {    
            ex.printStackTrace();
        }    
    }
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}