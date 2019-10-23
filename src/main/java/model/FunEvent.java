package model;


/**
 * Represents fun activity(for example going to party or football game)
 *
 * @author comex
 */

@Background
public class FunEvent extends Event {

    private Rating rating = Rating.OK;
    /**
     * Represents the impresion of the event
     */
    private String impressions;

    /**
     * Represents the cost of event
     */
    private int cost;

    public FunEvent() {

    }

    public FunEvent(Rating rating, String impressions, int cost) {
        super();
        this.rating = rating;
        this.impressions = impressions;
        this.cost = cost;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getImpressions() {
        return impressions;
    }

    public void setImpressions(String impressions) {
        this.impressions = impressions;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


}
