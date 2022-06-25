package caesar_cipher;

import java.util.ArrayList;
import java.util.List;


public class Encoder extends Cryptographer {

    public static void cipher(ArrayList<Character> characterArrayList, List<Character> ALPHABET, int cipher) {
        for (int i = 0; i < characterArrayList.size(); i++) {
            char letter = characterArrayList.get(i);
            if (ALPHABET.indexOf(Character.toLowerCase(letter)) >= 0) {  //перевірка що елемент існує в абетці
                if (!ALPHABET.get(ALPHABET.indexOf(Character.toLowerCase(letter))).equals(letter)){ //перевірка на те що літера не велика
                    if ((ALPHABET.indexOf(Character.toLowerCase(letter)) + cipher) > ALPHABET.size() - 1) { //перевірка чи виходить ключ за межи абетки
                        characterArrayList.set(i, Character.toUpperCase(ALPHABET.get((ALPHABET.indexOf(Character.toLowerCase(letter)) + cipher) % ALPHABET.size())));
                    } else {
                        characterArrayList.set(i, Character.toUpperCase(ALPHABET.get((ALPHABET.indexOf(Character.toLowerCase(letter)) + cipher))));
                    }
                }
                else {
                    if ((ALPHABET.indexOf(letter) + cipher) > ALPHABET.size() - 1) {
                        characterArrayList.set(characterArrayList.indexOf(letter), ALPHABET.get((ALPHABET.indexOf(letter) + cipher) % ALPHABET.size()));
                    } else {
                        characterArrayList.set(i, ALPHABET.get((ALPHABET.indexOf(letter) + cipher)));
                    }
                }

            }
        }

    }



}
