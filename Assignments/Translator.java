

// Program to Translate the English words to French words
// for given Text word document

import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

public class Translator {
    public static void main(String[] args) throws Exception {
         String sourcePath = "D:\\Programming Files and Workspaces\\Testing\\Assignments\\t8.shakespeare.txt";
         String dictionaryPath = "D:\\Programming Files and Workspaces\\Testing\\Assignments\\french_dictionary.csv";
         String findWordsPath = "D:\\Programming Files and Workspaces\\Testing\\Assignments\\find_words.txt";

         Map<String,String> dictionary = new HashMap<>();
         dictionary = populateDictionary(dictionaryPath);
         translateFile(dictionary,findWordsPath,sourcePath);

    }

    // Method to populate the Translation dictionary from CSV file
    public static Map<String,String> populateDictionary(String path) throws Exception {
        Map<String,String> dictionary = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while((line = reader.readLine()) != null) {
            String[] words = line.split(",");
            String englishWord = words[0];
            String frenchWord = words[1];

            dictionary.put(englishWord, frenchWord);
        }
        return dictionary;
    }

    // Method to translate the text file using dictionary to french
    public static void translateFile(Map<String,String> dictionary, String findWordsPath,String sourceFilePath) throws Exception{
        BufferedReader source = new BufferedReader(new FileReader(sourceFilePath));
        BufferedReader findWord = new BufferedReader(new FileReader(findWordsPath));
        String outputPath= "D:\\Programming Files and Workspaces\\Testing\\Assignments\\Assignment output\\output.txt";
        FileWriter writer = new FileWriter(outputPath);

        String line;
        while((line = source.readLine()) != null){
            String[] words = line.split(" ");

            for(int i = 0; i < words.length; i++){
                if(dictionary.containsKey(words[i]))
                    words[i] = dictionary.get(words[i]);
            }

            String translated = String.join(" ", words);
            writer.write(translated);
            writer.write(System.lineSeparator());
        }
        writer.flush();
        writer.close();
    }
}
