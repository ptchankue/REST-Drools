package net.africanbank.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by patricktchankue on 5/13/16.
 */
@Entity
@Table(name="applicationQueue")
public class ApplicationQueue implements Serializable {
    private static final long serialVersionUID = 10L;
    @Id
    @GenericGenerator(name="auto_inc" , strategy="increment")
    @GeneratedValue(generator="auto_inc")
    @Column(name="id")
    long id;

    @NotNull
    @Column(name="ruleName")
    private String ruleName;

    @NotNull
    @Column(name="applicationType")
    private String applicationType;

    @NotNull
    @Column(name="queueName")
    private String queueName;

    @NotNull
    @Column(name="reasonCode")
    private String reasonCode;

    @NotNull
    @Column(name="result")
    private String result;

    public ApplicationQueue(){}

    public ApplicationQueue(String ruleName, String applicationType, String queueName, String reasonCode, String result) {
        //this.id = id;
        this.ruleName = ruleName;
        this.applicationType = applicationType;
        this.queueName = queueName;
        this.reasonCode = reasonCode;
        this.result = result;
    }

    public ApplicationQueue(int id, String ruleName, String applicationType, String queueName, String reasonCode, String result) {
        this.id = id;
        this.ruleName = ruleName;
        this.applicationType = applicationType;
        this.queueName = queueName;
        this.reasonCode = reasonCode;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ApplicationQueue{" +
                "id=" + id +
                ", ruleName='" + ruleName + '\'' +
                ", applicationType='" + applicationType + '\'' +
                ", queueName='" + queueName + '\'' +
                ", reasonCode='" + reasonCode + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
