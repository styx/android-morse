package styx.morse;

import java.util.HashMap;

public class Transcoder {
    public static String decode(String lang, String encoded) {
        HashMap code_table = CodeTables.Langs.get(lang);
        String[] tokens = encoded.split(" ");

        String result = "";
        for(String token : tokens) {
            String decoded = (String) code_table.get(token);

            if(decoded != null)
                result += decoded;
            else
                result += " ";
        }

        return result;
    }
}
