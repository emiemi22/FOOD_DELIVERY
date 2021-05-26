package BusinessLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BillGenerator {

    private PrintWriter[] pw ;
    private File file ;
    private static int index = 1 ;
    private static BillGenerator instance ;
    private static Object obj = new Object();

    private BillGenerator() throws FileNotFoundException {
        pw = new PrintWriter[10];
    }

    /**
     * Gets instance.
     *
     * @return the instance
     * @throws FileNotFoundException the file not found exception
     */
    public static BillGenerator getInstance() throws FileNotFoundException {
        if (instance == null){
            synchronized (obj){
                if (instance == null){
                    instance = new BillGenerator();
                }
            }
        }
        return instance;
    }

    /**
     * Write to file.
     *
     * @param textLine the text line
     * @throws FileNotFoundException the file not found exception
     */
    public void writeToFile(String textLine) throws FileNotFoundException {
        file = new File("bill"+index +".txt");
        pw[index] = new PrintWriter(file);
        pw[index].println(textLine);
        index++;

    }
    /**
     * Close file.
     */
    public void closeFile(){
        for(int i = 1 ; i < index; i++)
            pw[i].close();
    }
    
}
