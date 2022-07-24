/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marbles.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import marbles.model.Marble;

/**
 *
 * @author Alaa Alsalehi
 */
public class LineupService {

    List<List<Marble>> lineup(HashMap<Marble.MarbleColor, Queue<Marble>> marblesBasedonColor, Collection<Marble> marbles) {
        // Time O(n*m) where n is the number of marbles and where m is the number of colors if m is constant then O(n)
        // Memory O(n) where n is the number of marbles

        List<List<Marble>> listOfLineupMarbles = new ArrayList<>();
        while (true) {
            List<Marble> lineupMarbles = new ArrayList<>();
            for (Marble.MarbleColor color : marblesBasedonColor.keySet()) {
                final Marble polledMarble = marblesBasedonColor.get(color).poll();
                if (polledMarble != null) {
                    lineupMarbles.add(polledMarble);
                } else {
                    // if we receive the marbles on batches we will push unlinup marbles again to queues
                    LabelizerService labelizerService = new LabelizerService();
                    labelizerService.labelizeBasedonColor(marblesBasedonColor, lineupMarbles);
                    break;
                }

            }
            if (lineupMarbles.size() == Marble.MarbleColor.values().length) {
                listOfLineupMarbles.add(lineupMarbles);
            } else {
                break;
            }
        }
        return listOfLineupMarbles;
    }
}
