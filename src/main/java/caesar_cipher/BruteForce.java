package caesar_cipher;

import java.util.ArrayList;

public class BruteForce extends Cryptographer {

    //Повертає вірогідний ключ ,з двох текстів зашифрованого і тексту цього автору
    //firstLink файл зі зашифрованним текстом, secondLink файл для шифру тексту, thirdLink файл з допоміжним тестом того ж автору
    public static int MoreLikelyKey(String firstLink , String secondLink, String thirdLink){
        ArrayList<Character> characterArrayList = new ArrayList<>();
        int moreLikelyKey = 0;
        int percent = 0;
        for (int i = 1; i < 41 ; i++) {
            readFileInArray(firstLink, characterArrayList);
            Decoder.cipher(characterArrayList, getALPHABET(), i);
            writeInFile(secondLink, characterArrayList);
            characterArrayList.clear();
           if (comparisonTopElements(secondLink,thirdLink) >= percent ){
               percent = comparisonTopElements(secondLink,thirdLink);
               moreLikelyKey = i;
           }

        }
        System.out.println("більш вірогідний ключ " + moreLikelyKey);
        System.out.println("% " + percent);
        return moreLikelyKey;
    }

    //firstLink файл зі зашифрованним текстом, secondLink файл для шифру тексту, thirdLink файл з допоміжним тестом того ж автору
    //Записує декодований текст в файл
    public static void BrutForceWriteInFile(String firstLink , String secondLink , String thirdLink ){
        ArrayList<Character> characterArrayList = new ArrayList<>();
                readFileInArray(firstLink, characterArrayList);
       Decoder.cipher(characterArrayList, getALPHABET(), BruteForce.MoreLikelyKey(firstLink,secondLink,thirdLink) );
       writeInFile(secondLink, characterArrayList);
       characterArrayList.clear();
    }

}


