



package cardgame;

/*
 * ========================
 * DO NOT MODIFY THIS FILE.
 * ========================
 */

import java.util.Objects;

/**
 * Represents an player's action on their turn: either they drew a card or they played a card.
 */
public class PlayerTurn {

    /**
     * The ID of the player that this action corresponds to
     */
    public int playerId;

    /**
     * If the player drew a card on their turn
     */
    public boolean drewACard;

    /**
     * The card the player played on their turn, or null if the player didn't play a card.
     */
    public Card playedCard;

  
    public Card.Suit declaredSuit;

    // Convenience methods; you might or might not need these.
    

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerTurn that = (PlayerTurn) o;
        return playerId == that.playerId &&
            drewACard == that.drewACard &&
            Objects.equals(playedCard, that.playedCard) &&
            declaredSuit == that.declaredSuit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, drewACard, playedCard, declaredSuit);
    }
}
