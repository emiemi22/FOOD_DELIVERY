package BusinessLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * The type Report generator.
 */
public class ReportGenerator {
    private PrintWriter pw ;
    private File file ;
    private static int index = 1 ;
    private static ReportGenerator instance ;
    private static Object obj = new Object();

    private ReportGenerator() throws FileNotFoundException {
        file = new File("raport.txt");
        pw = new PrintWriter(file);
    }

    /**
     * Gets instance.
     *
     * @return the instance
     * @throws FileNotFoundException the file not found exception
     */
    public static ReportGenerator getInstance() throws FileNotFoundException {
        if (instance == null){
            synchronized (obj){
                if (instance == null){
                    instance = new ReportGenerator();
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
        pw.println(textLine);
        index++;
    }

    /**
     * Close file.
     */
    public void closeFile(){
        pw.close();
    }
}
