package br.com.company.control;

import java.io.*;

public class ReadingFile {

    private BufferedReader file;
    private String content;

    public ReadingFile(String file) throws FileNotFoundException {
        try {
            this.file = new BufferedReader(new FileReader(file));
            content = "";
        } catch (FileNotFoundException ex){
            throw ex;
        }
    }

    public String reading() throws IOException {
        while (file.ready()) {
            content += file.readLine();
            if (file.ready()){
                content += "\n";
            }
        }
        file.close();
        char [] single = {'\3'};
        return content + new String(single);
    }
}
