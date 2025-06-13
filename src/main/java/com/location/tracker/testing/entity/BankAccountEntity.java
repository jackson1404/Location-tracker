/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.location.tracker.testing.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

/**
 * BankAccountEntity Class.
 * <p>
 * </p>
 *
 * @author
 */
@Entity
@Table(name = "tbl_bank_account")
public class BankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankAccountId;

    private String bankAccountNumber;

    private Double bankAccountBalance;

    private String bankAccountType;

    @OneToOne
    @JoinColumn(name = "user_account_id", referencedColumnName = "userAccountId")
    private UserAccountEntity userAccount;

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public Double getBankAccountBalance() {
        return bankAccountBalance;
    }

    public void setBankAccountBalance(Double bankAccountBalance) {
        this.bankAccountBalance = bankAccountBalance;
    }

    public String getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public UserAccountEntity getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccountEntity userAccount) {
        this.userAccount = userAccount;
    }

    public BankAccountEntity(Long bankAccountId, String bankAccountNumber, Double bankAccountBalance, String bankAccountType, UserAccountEntity userAccount) {
        this.bankAccountId = bankAccountId;
        this.bankAccountNumber = bankAccountNumber;
        this.bankAccountBalance = bankAccountBalance;
        this.bankAccountType = bankAccountType;
        this.userAccount = userAccount;
    }

    public BankAccountEntity(){}

}
