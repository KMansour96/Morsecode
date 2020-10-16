import java.util.Scanner;

public class MorseCode {

    public static void main(String[] args) {
        char[] code = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
        '0','1','2','3','4','5','6','7','8','9'}; //Initialize an array with the letters and the digits
        String[] cCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
                ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
                "-....", "--...", "---..", "----.", "-----"}; // Initialize array with the character codes


        Scanner in = new Scanner(System.in); // Scanner to input a string

            System.out.println("Enter Sentence : ");
            String str = in.nextLine();
            String converSion = AlphaToMorse(str, cCode, code);//calling the method that translates to morse code
            System.out.println(converSion);

            System.out.println("Enter Morse Code :  ");
            String str1 = in.nextLine();
            String convert1 = MorseToAlpha(str1, cCode, code); // calling the method that translates to alphabet
            System.out.println(convert1);


    }

    public static String AlphaToMorse(String str, String[] cCode, char[] code) { //Methode to convert to Morse

        StringBuilder res = new StringBuilder();
        str = str.toUpperCase(); // making all letters uppercase to fit with the array characters in code[]
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                for (int j = 0; j < 36; j++) {
                    if (str.charAt(i) == code[j]) {
                        res.append(cCode[j]).append("   "); // appending the character that matches in cCode to res then
                        //appending another 3 spaces to make it easier to read
                    }
//nested for loop to check each letter from the string given and match it to the letters, and if one of them matches to
// the letter, then the index of it is equal to the index of the code in cCode
                }

            }
        }
        return res.toString(); // changing res to a string and returning it
    }

    public static String MorseToAlpha(String str, String[] cCode, char[] code) {
        StringBuilder res = new StringBuilder("");
        String[] k = str.split(" "); //splitting the string by 1 space to make the code easier to read and decode
        for (String s : k) { // for loop to check the chars and match them

            for (int j = 0; j < 36; j++) {


                 if (cCode[j].equals(s)) {
                    res.append(code[j]); //append the letter in the array code to res to make it whole
                }


            }
           res.append(" ");// too make the 3 spaces possible
        }

        return res.toString(); // return res as a string to the main method
    }
}
