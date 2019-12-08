/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.matcher.All;
import statistics.matcher.Matcher;
import statistics.matcher.PlaysIn;

/**
 *
 * @author heisonja
 */
public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        Matcher toReturn = this.matcher;
        this.matcher = new All();
        return toReturn;
    }
    
    public QueryBuilder oneOf(Matcher matcher1, Matcher matcher2) {
        this.matcher = new Or(matcher1, matcher2);
        return this;
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(this.matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int amount, String category) {
        this.matcher = new And(this.matcher, new HasAtLeast(amount, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int amount, String category) {
        this.matcher = new And(this.matcher, new HasFewerThan(amount, category));
        return this;
    }

}
