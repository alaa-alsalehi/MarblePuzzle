/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marbles.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import marbles.model.Marble;

/**
 *
 * @author Alaa Alsalehi
 */
public class MarbleService {

    private WordService wordService;
    private FilteringMarblesService filteringMarblesService;
    private LabelizerService labelizerService;
    private LineupService lineupService;
    // Deploy Note: I will replace this with a database to fetch data from
    private Collection<Marble> marblesStore = new ArrayList<>();
    //Deploy Note: I will replace this with Redis List
    private HashMap<Marble.MarbleColor, Queue<Marble>> marblesBasedonColorStore;
    //Deploy Note: I will replace this with Permenanat Storage
    private List<List<Marble>> linedupMarblesStore = new ArrayList<>();

    public MarbleService(WordService wordService, FilteringMarblesService filteringMarblesService, LabelizerService labelizerService, LineupService lineupService) {
        this.wordService = wordService;
        this.filteringMarblesService = filteringMarblesService;
        this.labelizerService = labelizerService;
        this.lineupService = lineupService;
        intializeQueues();
    }

    public void addMarbles(Collection<Marble> marbles) {
        this.marblesStore.addAll(marbles);
    }

    public List<List<Marble>> process() {
        // Time O(n) where n is the number of marbles
        // Memory O(1) we use one more String to reverse the word
        Collection<Marble> filteredMarbles = filteringMarblesService.filter(marblesStore, marble
                -> marble.getWeight().compareTo(new BigDecimal("0.5")) != -1 //Marble execlude if it is less than 0.5 
                && wordService.isPalindrome(marble.getName()));
        marblesStore.clear();
        labelizerService.labelizeBasedonColor(marblesBasedonColorStore, filteredMarbles);
        linedupMarblesStore.addAll(lineupService.lineup(marblesBasedonColorStore, filteredMarbles));
        return linedupMarblesStore;
    }

    private void intializeQueues() {
        marblesBasedonColorStore = new HashMap<>();
        for (Marble.MarbleColor color : Marble.MarbleColor.values()) {
            LinkedList<Marble> list = new LinkedList<>();
            marblesBasedonColorStore.put(color, list);
        }
    }
}
