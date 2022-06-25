package caesar_cipher;

import java.io.*;
import java.util.*;

public abstract class Cryptographer {
    private static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '"', '\'', ':', '!', '?', ' ');
    public static List<Character> getALPHABET(){
        return ALPHABET;
    }

    //читає файл у масив елементів
    public static void readFileInArray(String link, ArrayList<Character> characterArrayList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(link))) {
            int x;
            while ((x = reader.read()) > 0) {
                characterArrayList.add((char) x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //записує масив елементів у файл
    public static  void writeInFile(String link, ArrayList<Character> characterArrayList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(link))) {
            for (Character x : characterArrayList) {
                writer.write(x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //повертає мапу заповнену елементами з абетки
    public static Map<Character,Integer> alphabetMap(List<Character> ALPHABET){
        Map<Character,Integer> alphabetMap = new HashMap<>();
        for (Character x : ALPHABET ) {
            alphabetMap.put(x,0);
        }
        return alphabetMap;
    }

    //поертає мапу заповнену елементами з абетки і їх кількості в тексті переданим за посиланням
    public static Map<Character,Integer> amountOfRepetitionInMap(String link){
        Map<Character,Integer> alphabetMap = Cryptographer.alphabetMap(Cryptographer.getALPHABET());
        ArrayList<Character> text = new ArrayList<>();
        Cryptographer.readFileInArray(link,text);
        for (Character element :  text) {
            if (alphabetMap.containsKey(element)){
                Integer newElementValue = alphabetMap.get(element) + 1 ;
                alphabetMap.replace(element,newElementValue);
            }
        }
        return alphabetMap;
    }

    //повинен повернути масив десятьох найбільш вживаних символів з  тексту за переданим посиланням
    public static ArrayList<Character> amountOfElements(String link) {
        Map<Character, Integer> alphabetMap = Cryptographer.amountOfRepetitionInMap(link);

        ArrayList<Character> arrayElements = new ArrayList<>();
        arrayElements.add(0, 'а');
        arrayElements.add(1, 'б');
        arrayElements.add(2, 'в');
        arrayElements.add(3, 'г');
        arrayElements.add(4, 'д');
        arrayElements.add(4, 'е');
        arrayElements.add(4, 'ё');
        arrayElements.add(4, 'ж');
        arrayElements.add(4, 'з');
        arrayElements.add(4, 'и');
        Character minValueElement = arrayElements.get(0);
        //заповнює масив найбільш вживанішими елементами
        for (Map.Entry<Character, Integer> x : alphabetMap.entrySet()) {
            for (Character element : arrayElements) {
                if (alphabetMap.get(element) <= alphabetMap.get(minValueElement)) {
                    minValueElement = element;
                }
            }
            if (x.getValue() >= alphabetMap.get(minValueElement) && !arrayElements.contains(x.getKey())) {
                arrayElements.set(arrayElements.indexOf(minValueElement), x.getKey());
                minValueElement = x.getKey();
            }
        }

        return arrayElements;
    }

    //Метод повертає вітсоток збіжностей найбільш вживаніших елементів в двох посиланнях
    public static int comparisonTopElements(String firstLink ,String secondLink){
        ArrayList<Character> topElementsLinkFirst = Cryptographer.amountOfElements(firstLink);
        ArrayList<Character> topElementsLinkSecond = Cryptographer.amountOfElements(secondLink);
        int count = 0;
        for (int i = 0; i < topElementsLinkFirst.size(); i++) {
            for (int j = 0; j < topElementsLinkSecond.size(); j++) {
                if (topElementsLinkFirst.get(i).equals(topElementsLinkSecond.get(j))){
                    count++;
                }
            }
        }
        int percent = ((count*100)/10);
//
//        System.out.println("Найбільш вживанні символи з абетки за першим посиланням " + topElementsLinkFirst);
//        System.out.println("Найбільш вживанні символи з абетки за другим посиланням " + topElementsLinkSecond);
//        System.out.println("Процент співпадіння = " + percent + "%");
        return percent;
    }

}
