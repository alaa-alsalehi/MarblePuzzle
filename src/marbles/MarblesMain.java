/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marbles;

import marbles.model.Marble;
import marbles.services.MarbleService;
import marbles.services.WordService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import marbles.services.FilteringMarblesService;
import marbles.services.LabelizerService;
import marbles.services.LineupService;

/**
 *
 * @author Alaa Alsalehi
 */
public class MarblesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Check Word Service\n");
        WordService wordService = new WordService();
        System.out.println(wordService.isPalindrome("ALAA"));
        System.out.println(wordService.isPalindrome("Bob o’Bob"));
        System.out.println(wordService.isPalindrome("BOB"));
        System.out.println(wordService.isPalindrome("علاء"));
        System.out.println(wordService.isPalindrome("باب"));
        
        FilteringMarblesService filteringMarblesService=new FilteringMarblesService();
        LabelizerService labelizerService=new LabelizerService();
        LineupService lineupService=new LineupService();

        System.out.println("Check Marble Service\n");
        MarbleService marbleService = new MarbleService(wordService,filteringMarblesService,labelizerService,lineupService);

        System.out.println("Check Uncompleted Color List\n");
        ArrayList<Marble> marbles = new ArrayList<>();
        marbles = new ArrayList<>();
        marbles.add(new Marble(Marble.MarbleColor.blue, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.red, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.green, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.indigo, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.orange, "BOB", BigDecimal.ONE));
        marbleService.addMarbles(marbles);
        List<List<Marble>> processed = marbleService.process();
        for (List<Marble> list : processed) {
            System.out.println(Arrays.toString(list.toArray()) + "\n");
        }
        System.out.println("Check Regular Case Lineup\n");
        marbleService = new MarbleService(wordService,filteringMarblesService,labelizerService,lineupService);
        marbles.add(new Marble(Marble.MarbleColor.blue, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.red, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.green, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.indigo, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.orange, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.violet, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.yellow, "BOB", BigDecimal.ONE));
        marbleService.addMarbles(marbles);
        processed = marbleService.process();
        for (List<Marble> list : processed) {
            System.out.println(Arrays.toString(list.toArray()) + "\n");
        }

        System.out.println("Check Regular Case Filtering and Lineup\n");
        marbles = new ArrayList<>();
        marbles.add(new Marble(Marble.MarbleColor.blue, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.red, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.green, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.indigo, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.orange, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.violet, "BOBOB", BigDecimal.valueOf(0.5)));
        marbles.add(new Marble(Marble.MarbleColor.violet, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.yellow, "BOB", BigDecimal.ONE));
        marbles.add(new Marble(Marble.MarbleColor.yellow, "BOB", BigDecimal.valueOf(0.4)));
        marbles.add(new Marble(Marble.MarbleColor.violet, "BOBI", BigDecimal.ONE));
        marbleService.addMarbles(marbles);
        processed = marbleService.process();
        for (List<Marble> list : processed) {
            System.out.println(Arrays.toString(list.toArray()) + "\n");
        }

    }

}
