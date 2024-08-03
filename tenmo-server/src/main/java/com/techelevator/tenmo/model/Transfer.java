package com.techelevator.tenmo.model;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

public class Transfer {
    private long transferId;
   // @Min(value = 1)
    private long accountFrom;
   // @Min(value = 1)
    private long accountTo;
    @Positive(message = "Amount to transfer must be greater than 0")
    private double amount;
    private long transferTypeId; //1 request //2 send
   // @Min(value = 1)
    private long transferStatusId =1; //1 pending //2 approved //3 rejected

    public Transfer(){}

    public Transfer(long transferId,long accountFrom, long accountTo, double amount, long transferTypeId,long transferStatusId)
{
        this.transferId = transferId;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
        this.transferTypeId = transferTypeId;
        this.transferStatusId = transferStatusId;
    }

//    public void setTransferTypeDescriptionById(Long transferTypeId) {
//        String description = "";
//        if (transferTypeId == 1) {
//            description = "Request";
//        } else if (transferTypeId == 2) {
//            description = "Send";
//        }
//        this.transferTypeDescription = description;
//    }



    public void setTransferId(long transferId) {
        this.transferId = transferId;
    }

    public long getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(long accountFrom) {
        this.accountFrom = accountFrom;
    }

    public long getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(long accountTo) {
        this.accountTo = accountTo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getTransferId() {
        return transferId;
    }

    public long getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(long transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public long getTransferStatusId() {
        return transferStatusId;
    }

    public void setTransferStatusId(long transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    //    public void setTransferStatusDescriptionById(Long transferStatusId) {
//        String description = "";
//        if (transferStatusId == 1) {
//            description = "Pending";
//        } else if (transferStatusId == 2) {
//            description = "Approved";
//        } else if (transferStatusId == 3) {
//            description = "Rejected";
//        }
//        this.transferTypeDescription = description;
//    }


}
