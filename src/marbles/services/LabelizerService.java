/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marbles.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Queue;
import marbles.model.Marble;

/**
 *
 * @author Alaa Alsalehi
 */
public class LabelizerService {

    HashMap<Marble.MarbleColor, Queue<Marble>> labelizeBasedonColor(HashMap<Marble.MarbleColor, Queue<Marble>> marblesBasedonColor,Collection<Marble> marbles1) {
        // Time O(n) where n is the number of marbles
        // Memory O(n) we use one more String to reverse the word 
        for (Marble marble : marbles1) {
            Queue<Marble> list = marblesBasedonColor.get(marble.getColor());
            list.add(marble);
        }
        
        return marblesBasedonColor;
    }
}
