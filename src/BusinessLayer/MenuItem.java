package BusinessLayer;

import java.io.Serializable;

/**
 * The interface Menu item.
 */
public interface MenuItem  {
    /**
     * Compute price int.
     *
     * @return the int
     */
    int computePrice();

    /**
     * Gets title.
     *
     * @return the title
     */
    String getTitle();

    /**
     * Gets rating.
     *
     * @return the rating
     */
    float getRating() ;

    /**
     * Gets calories.
     *
     * @return the calories
     */
    int getCalories();

    /**
     * Gets protein.
     *
     * @return the protein
     */
    int getProtein() ;

    /**
     * Gets fat.
     *
     * @return the fat
     */
    int getFat() ;

    /**
     * Gets sodium.
     *
     * @return the sodium
     */
    int getSodium();

    /**
     * Gets price.
     *
     * @return the price
     */
    int getPrice() ;

    /**
     * Gets time selected.
     *
     * @return the time selected
     */
    int getTimeSelected();

    /**
     * Increment time selected.
     */
    void incrementTimeSelected();
}
