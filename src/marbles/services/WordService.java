/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marbles.services;

/**
 *
 * @author Hp
 */
public class WordService {

    public boolean isPalindrome(String word) {
        // Time O(n) where n is the number of characters
        // Memory O(1) we use one more String to reverse the word
        String processedWord = groomingWord(word);
        StringBuilder reverseProcessedWord = new StringBuilder(processedWord);
        reverseProcessedWord.reverse();
        return processedWord.equals(reverseProcessedWord.toString());
    }

    public String groomingWord(String word) {
        // Time O(n) where n is the number of characters
        // Memory O(1) we use two more String variables
        String lowerCaseWord = word.toLowerCase();
        StringBuilder newWord = new StringBuilder();
        for (char character : lowerCaseWord.toCharArray()) {
            if (Character.isAlphabetic(character)) {
                newWord.append(character);
            }
        }
        return newWord.toString();
    }
    
}
