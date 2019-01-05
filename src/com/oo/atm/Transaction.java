package com.oo.atm;

import java.util.Date;

public abstract class Transaction {
    private int transactionId;
    private Date creationTime;
    private TransactionStatus status;

    public abstract boolean makeTransaction();

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
