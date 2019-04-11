package project;

/**
 * All the information for a debit/credit card
 */
public final class Card implements java.io.Serializable {

    /**
     * The main numbers on the front of the card
     */
    private String number;

    /**
     * The amount of money the card is allowed to spend
     */
    private double creditLimit;

    /**
     * Creates a new card
     *
     * @param number          the main numbers on the front of the card
     * @param creditLimit     the amount of money the card is allowed to spend
     */
    public Card(String number, int creditLimit) {
        this.number = number;
        this.creditLimit = creditLimit;
    }

    public void setNumber(String number) {
        number = number.replace(" ", "");
        this.number = number;
    }

    //TODO move card validation to inside card so card.isValid
    public boolean isValid() {
        if (number.length() != 16) {
            return false;
        } else if (number.matches("[^0-9]")) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Gets the last 4 digits of the card
     *
     * @return the last 4 digits of the card
     */
    public String getLastFourDigits() {
        return number.substring(number.length() - 4);
    }


    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}
