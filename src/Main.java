import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        String inputString;

        Path fileName
                = Path.of("C:\\Users\\VarolS\\IdeaProjects\\AdventOfCodeDay3\\day3.txt");
        try {
            inputString = Files.readString(fileName);
            System.out.println("the string is... " + inputString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int sum = 0;

        for (int i = 0; i < inputString.length(); i++) {

            if (inputString.charAt(i) == 'm' && inputString.charAt(i + 1) == 'u' && inputString.charAt(i + 2) == 'l' && inputString.charAt(i + 3) == '(') {
                int indexOfComma = 0;
                StringBuilder numberOne = new StringBuilder();
                StringBuilder numberTwo = new StringBuilder();
//                System.out.println("this is mul( ");
                for (int j = i + 4; j <= i + 7; j++) {
                    if ((int) inputString.charAt(j) >= 48 && (int) inputString.charAt(j) <= 57) {
                        if (indexOfComma != 0 && j > indexOfComma) {
                            break;
                        }
                        numberOne.append(inputString.charAt(j));
                    } else if ((int) inputString.charAt(j) == 44) {
                        indexOfComma = j;
                    }
                }

                int indexOfClosing = 0;
                for (int k = i + 6; k <= i + 11; k++) {
                    if(indexOfComma != 0 && k > indexOfComma) {
                        if ((int) inputString.charAt(k) >= 48 && (int) inputString.charAt(k) <= 57) {
                            numberTwo.append(inputString.charAt(k));
                        } else if ((int) inputString.charAt(k) == 41) {
                            indexOfClosing = k;
                            break;
                        }
                    }
                }
                if(indexOfClosing == 0) {
                    numberOne.setLength(0);
                    numberOne.append(0);
                    numberTwo.setLength(0);
                    numberTwo.append(0);
                }

                if(numberOne.toString().isEmpty()) {
                    numberOne.append(0);
                }
                if(numberTwo.toString().isEmpty()) {
                    numberTwo.append(0);
                }

                sum += Integer.parseInt(numberOne.toString()) * Integer.parseInt(numberTwo.toString());

//                System.out.println("index of comma is ... " + indexOfComma);
//                System.out.println("this is mul( nr1... " + numberOne + ", nr2... " + numberTwo);
            }
        }
        System.out.println("Sum is... " + sum);
    }
}