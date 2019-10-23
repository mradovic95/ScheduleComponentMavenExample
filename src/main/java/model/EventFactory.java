package model;

/**
 * Factory for {@code Event}
 *
 * @author comex
 */
public class EventFactory {

    /**
     * @param eventType the typo of {@code Event}
     * @return object of {@code Event} class
     */
    public Event getEvent(String eventType) {

        if (eventType == null) {
            return null;
        }

        if (eventType.equalsIgnoreCase("WorkEvent")) {
            return new WorkEvent();
        }

        if (eventType.equalsIgnoreCase("FunEvent")) {
            return new FunEvent();
        }

        return null;
    }

}
