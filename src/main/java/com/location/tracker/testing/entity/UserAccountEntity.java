/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.location.tracker.testing.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * UserAccountEntity Class.
 * <p>
 * </p>
 *
 * @author
 */
@Entity
@Table(name = "tbl_user_account")
public class UserAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAccountId;

    private String userAccountNumber;

    private Double userAccountBalance;

    private String userAccountType;

    private String userPhoneNumber;

    private Double accountVersion;

    private LocalDateTime dob;

    @OneToOne(mappedBy = "userAccount")
    private BankAccountEntity bankAccount;

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getUserAccountNumber() {
        return userAccountNumber;
    }

    public void setUserAccountNumber(String userAccountNumber) {
        this.userAccountNumber = userAccountNumber;
    }

    public Double getUserAccountBalance() {
        return userAccountBalance;
    }

    public void setUserAccountBalance(Double userAccountBalance) {
        this.userAccountBalance = userAccountBalance;
    }

    public String getUserAccountType() {
        return userAccountType;
    }

    public void setUserAccountType(String userAccountType) {
        this.userAccountType = userAccountType;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Double getAccountVersion() {
        return accountVersion;
    }

    public void setAccountVersion(Double accountVersion) {
        this.accountVersion = accountVersion;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public UserAccountEntity(){}

    public UserAccountEntity(Long userAccountId, String userAccountNumber, Double userAccountBalance, String userAccountType, String userPhoneNumber, Double accountVersion, LocalDateTime dob) {
        this.userAccountId = userAccountId;
        this.userAccountNumber = userAccountNumber;
        this.userAccountBalance = userAccountBalance;
        this.userAccountType = userAccountType;
        this.userPhoneNumber = userPhoneNumber;
        this.accountVersion = accountVersion;
        this.dob = dob;
    }
}
