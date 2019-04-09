package Project;

import java.util.ArrayList;

/**
 * A customer account for standard clients
 */
public class Customer extends Account implements java.io.Serializable {

    /**
     * The debit/credit card information for the customer
     */
    private Card card;

    /**
     * The 10 digit phone number of the customer
     */
    private String phoneNumber;

    /**
     * The address of the user (1234 Street Ln)
     */
    private String address;

    /**
     * The cart of items the user has selected
     */
    private ArrayList<Shipment> cart;

    /**
     * Creates a new customer account with only a username and password
     *
     * @param username
     * @param plainText
     */
    public Customer(String username, String plainText) {
        super(username, plainText);
        this.phoneNumber = null;
        this.address = null;
        this.card = null;
        this.cart = null;
    }

    /**
     * Creates a new customer account with an empty cart
     *
     * @param username  the username of the customer
     * @param plainText the plaintext password of the customer
     * @param phoneNumber the 10 digit phone number of the customer
     * @param address the address of the user (1234 Street Ln)
     * @param card      the card information of the customer
     */
    public Customer(String username, String plainText, String phoneNumber, String address, Card card) {
        super(username, plainText);
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.card = card;
        this.cart = null;
    }

    public Card getCard() {
        return card;
    }

    public ArrayList<Shipment> getCart() {
        return cart;
    }

    public void addToCart(Item item, int amount) {
        cart.add(new Shipment(item, amount));
    }

    public double getCartTotalCost() {
        double totalCost = 0;
        for (Shipment shipment : cart) {
            totalCost += (shipment.getItem().getPrice() * shipment.getAmount());
        }
        return totalCost;
    }
}
