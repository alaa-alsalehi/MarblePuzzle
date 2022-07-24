/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marbles.services;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import marbles.model.Marble;

/**
 *
 * @author Alaa Alsalehi
 */
public class FilteringMarblesService {

    public Collection<Marble> filter(Collection<Marble> marbles, Predicate<Marble> predicate) {
        // Time O(n) where n is the number of marbles
        // Memory O(1) we use one more String to reverse the word
        return marbles.stream().filter(predicate).collect(Collectors.toList());
        // I keep the predicate out of this method because Johan may be decide to change the filtering coditions
    }
}
