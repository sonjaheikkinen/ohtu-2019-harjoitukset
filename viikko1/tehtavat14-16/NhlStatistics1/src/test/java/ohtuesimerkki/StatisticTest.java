/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author heisonja
 */
public class StatisticTest {
    
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    } 

    
    @Test
    public void searchFindsPlayer() {
        assertEquals(stats.search("Semenko").toString(), new Player("Semenko", "EDM", 4, 12).toString());
    }
    
    @Test
    public void searchReturnsNullIfPlayerDoesNotExist() {
        assertNull(stats.search("Name"));
    }
    
    @Test
    public void teamReturnsListOfCorrectLenght() {
        assertEquals(stats.team("EDM").size(), 3);
    }
    
    @Test
    public void topScorersWorks() {
        assertEquals(stats.topScorers(1).get(0).toString(), stats.search("Gretzky").toString());
    }
    
}
