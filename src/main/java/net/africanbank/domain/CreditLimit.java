package net.africanbank.domain;

import net.africanbank.utils.Operation;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by patricktchankue on 6/1/16.
 */

@Entity
public class CreditLimit {

    @Id
    @GenericGenerator(name="auto_inc" , strategy="increment")
    @GeneratedValue(generator="auto_inc")
    @Column(name="id")
    long id;

    @NotNull
    @Column(name="card_type")
    String card_type;

    @NotNull
    @Column(name="num_credit_card")
    String num_credit_card;

    @NotNull
    @Column(name="home_owner")
    String home_owner;

    @NotNull
    @Column(name="result")
    String result;

    public CreditLimit(){}

    public CreditLimit(String card_type, String num_credit_card, String home_owner) {
        this.card_type = card_type;
        this.num_credit_card = num_credit_card;
        this.home_owner = home_owner;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNum_credit_card() {
        return num_credit_card;
    }

    public void setNum_credit_card(String num_credit_card) {
        this.num_credit_card = num_credit_card;
    }

    public String getHome_owner() {
        return home_owner;
    }

    public void setHome_owner(String home_owner) {
        this.home_owner = home_owner;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }





    @Override
    public String toString() {
        return "CreditLimit{" +
                "id=" + id +
                ", card_type='" + card_type + '\'' +
                ", num_credit_card='" + num_credit_card + '\'' +
                ", home_owner='" + home_owner + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    /*

        data: input coming from the user

     */
    public boolean match(CreditLimit data){
        Operation op;
        op = new Operation();
        boolean result = false;
        if (this.card_type.equalsIgnoreCase(data.card_type)){

            // Checking if an operator is contains in the rule to be matched
            if(op.containsExpression(this.num_credit_card)){
                System.out.println(">>> Contains expression: "+ this.num_credit_card + " "+ this.toString());
                if (this.num_credit_card.contains("<=")){
                    int num_credit_card = Integer.parseInt(data.num_credit_card.replace("<=", ""));
                    if ( num_credit_card <= op.getOperand()){
                        System.out.println("input " + num_credit_card + " is <= " + op.getOperand());
                        return true;
                    }
                }

                if (this.num_credit_card.contains(">")){
                    int num_credit_card = Integer.parseInt(data.num_credit_card);
                    if ( num_credit_card > op.getOperand()){
                        System.out.println("input " + num_credit_card + " is > " + op.getOperand());
                        return true;
                    }
                }

//                switch(op.getOperator()){
//                    case 1:
//                        System.out.println("match >");
//                        break;
//                    case 5:
//                        System.out.println("match <");
//                        break;
//                    case 6:
//                        System.out.println("match >");
//                        break;
//                }
            } else {
                if(this.num_credit_card.equalsIgnoreCase(data.num_credit_card)){
                    if(this.home_owner.equalsIgnoreCase("x")){
                        result= true;
                    }
                } else {
                    result = false;
                }
            }

        } else {
            result = false;
        }

        return result;
    }

}
