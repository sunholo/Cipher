package caesar_cipher;

import java.util.ArrayList;
import java.util.List;

public class Decoder extends Cryptographer {

    public static void cipher(ArrayList<Character> characterArrayList, List<Character> ALPHABET, int cipher) {
        for (int i = 0; i < characterArrayList.size(); i++) {
            char letter = characterArrayList.get(i);
            if (ALPHABET.indexOf((Character.toLowerCase(letter))) >= 0) {                            //перевірка що елемент існує в абетці
                if (!ALPHABET.get(ALPHABET.indexOf(Character.toLowerCase(letter))).equals(letter)) { //перевірка на те що літера не велика
                    if ((ALPHABET.indexOf(Character.toLowerCase(letter)) - cipher) < 0) {            //перевірка чи виходить ключ за межи абетки
                        characterArrayList.set(i, Character.toUpperCase(ALPHABET.get((ALPHABET.size() + (ALPHABET.indexOf(Character.toLowerCase(letter)) - cipher)))));
                    } else {
                        characterArrayList.set(i, Character.toUpperCase(ALPHABET.get((ALPHABET.indexOf(Character.toLowerCase(letter)) - cipher))));
                    }
                } else {
                    if ((ALPHABET.indexOf(Character.toLowerCase(letter)) - cipher) < 0) {
                        characterArrayList.set(i, ALPHABET.get((ALPHABET.size() + (ALPHABET.indexOf(Character.toLowerCase(letter)) - cipher))));
                    } else {
                        characterArrayList.set(i, ALPHABET.get((ALPHABET.indexOf(Character.toLowerCase(letter)) - cipher)));
                    }
                }

            }
        }

    }



}
