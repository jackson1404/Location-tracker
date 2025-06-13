/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.location.tracker.testing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * BankAccountRequestDto Class.
 * <p>
 * </p>
 *
 * @author
 */
public class BankAccountRequestDto {

    @JsonProperty("bank_account_number")
    private String bankAccountNumber;

    @JsonProperty("bank_account_balance")
    private Double bankAccountBalance;

    @JsonProperty("bank_account_type")
    private String bankAccountType;

    @JsonProperty("user_account_id")
    private Long userAccountId;

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

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }
}
