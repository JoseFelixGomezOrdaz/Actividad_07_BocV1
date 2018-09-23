package models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author Jose Felix
 */
public class ModelBlocV1 {
    private String path="C:\\archivos\\archivo.txt";
    private String message="";
    private String row;
    /**
     * permite leer archivos
     * @param path almacena la ubicacion de los archivos
     */
    public void readFile (String path) {
        try {
            try (FileReader archivo = new FileReader(path)) {
                BufferedReader bufferedreader = new BufferedReader(archivo);
                while ((row = bufferedreader.readLine()) != null ) {
                    message = message + row + "\n";;
                    
                }
            }
        }
        catch (FileNotFoundException err) { 
            System.err.println("Archivo no encontrado: " + err.getMessage());
        }
        catch (IOException err) { 
            System.err.println("Error en operación I/O: " + err.getMessage());
        }
        
    };
    
    /**
     * permite escribir y guardar el archivo en el archivo
     * @param path almacena la ubicacion del archivo
     * @param message almacena lo que se va a guardar en el archivo
     */
    public void writeFile (String path, String message) {
        try {
            File archivo = new File(path); 
            FileWriter filewriter = new FileWriter(archivo, false); 
            
            try (PrintWriter printwriter = new PrintWriter(filewriter) ) { 
                printwriter.println(message);
                printwriter.close();
            }
        }
        catch (FileNotFoundException err) { 
            System.err.println("Archivo no encontrado: " + err.getMessage());
        }
        catch (IOException err) { 
            System.err.println("Error en operación I/O: " + err.getMessage());
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
