/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roland
 */
public class BuildsForTheToughtsExperimental {
    static String[] files = new String[]{
        "src/resources/queries.txt@qs@GQT",
        "src/resources/formq.txt@formQs@FQT",
        "src/resources/norefreshqueries.txt@noRefreshQs@NQT"
    };
    
    static String outputfile = "queries.js";
    static String replfile = "retntemplatesEx.js";
    static String outreplfile = "retntemplates.js";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 0;
        String text = "";
        String fileText = "";
        String repltext = "";
        try{
            repltext = Files.readString(Path.of("src/resources/"+replfile));
        } catch(IOException ex){
        
        }
        
        for(String filename : files){
            String[] v = filename.split("@");
            try {
                text = Files.readString(Path.of(v[0]));
            } catch (IOException ex) {
                Logger.getLogger(BuildsForTheToughtsExperimental.class.getName()).log(Level.SEVERE, null, ex);
            }
            //feldolgozás
            fileText += "export const "+ v[1] + " = [\n";
            i = 0;
            text = text.replaceAll("\\-", "\\\\-");
            for(String elem : text.split("X88")){
                String[] v3 = elem.split("X01");
                if(v3.length>2){
                    v3[1] = v3[1].replaceAll("[\\r\\n]", "");
                    fileText += "\t//\n\t// " + i + ". "+ v[2] + v3[0] + "\n" + "\t\"" + v3[1] + "\\x01\"";
                    for(String qrow : v3[2].split("[\\r\\n]")){
                        if(qrow.length() > 0) fileText += " +\n\t\"" + qrow + "\\n\"";
                    }
                    fileText += ",\n";
                    repltext = repltext.replaceAll("\\'\\!" + v[2] + v3[0] + "'", i+"");
                    repltext = repltext.replaceAll("\\'\\+" + v[2] + v3[0] + "'", String.format("%02X", i));
                    i++;
                }
            }
            fileText += "];\n\n";
        }
        try {
            Files.writeString(Path.of("src/output/" + outreplfile), repltext);
            Files.writeString(Path.of("src/output/" + outputfile), fileText);
            System.out.println("A fájlok kiírása sikeres: " + outreplfile + ", "+ outputfile);
        } catch (IOException e) {
            System.err.println("Nem sikerült a fájl kiírása!");
        }
    }
    
}