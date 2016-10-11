package net.africanbank.domain;

/**
 * Created by patricktchankue on 6/1/16.
 */
public class Credit {
    private String card_type;
    private boolean home_owner;
    private int num_credit_card;
    private long limit;

    public Credit() {
    }

    public Credit(String card_type, boolean home_owner, int num_credit_card, long limit) {
        this.card_type = card_type;
        this.home_owner = home_owner;
        this.num_credit_card = num_credit_card;
        this.limit = limit;
    }

    public Credit(String card_type, boolean home_owner, int num_credit_card) {
        this.card_type = card_type;
        this.home_owner = home_owner;
        this.num_credit_card = num_credit_card;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public boolean isHome_owner() {
        return home_owner;
    }

    public void setHome_owner(boolean home_owner) {
        this.home_owner = home_owner;
    }

    public int getNum_credit_card() {
        return num_credit_card;
    }

    public void setNum_credit_card(int num_credit_card) {
        this.num_credit_card = num_credit_card;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "card_type='" + card_type + '\'' +
                ", home_owner=" + home_owner +
                ", num_credit_card=" + num_credit_card +
                ", limit=" + limit +
                '}';
    }
}
