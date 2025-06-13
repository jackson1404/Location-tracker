/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.location.tracker.testing.service;

import com.location.tracker.testing.dto.BankAccountRequestDto;
import com.location.tracker.testing.entity.BankAccountEntity;
import com.location.tracker.testing.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BankAccountService Class.
 * <p>
 * </p>
 *
 * @author
 */
@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void saveBankAccount(BankAccountRequestDto requestDto){

        BankAccountEntity bankAccount = new BankAccountEntity();
        bankAccount.setBankAccountNumber(requestDto.getBankAccountNumber());
        System.out.println("THe request dot bank acocunt number {}" + requestDto.getBankAccountNumber());
        bankAccount.setBankAccountBalance(requestDto.getBankAccountBalance());
        bankAccount.setBankAccountType(requestDto.getBankAccountType());
        bankAccount.setUserAccount(null);

        bankAccountRepository.save(bankAccount);

    }



}
