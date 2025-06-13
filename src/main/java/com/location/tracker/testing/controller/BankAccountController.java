/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.location.tracker.testing.controller;

import com.location.tracker.testing.dto.BankAccountRequestDto;
import com.location.tracker.testing.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * BankAccountController Class.
 * <p>
 * </p>
 *
 * @author
 */

@RestController
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/createBankAccount")
    public ResponseEntity<?> saveBankAccount(@RequestBody BankAccountRequestDto requestDto){
        System.out.println("The requestdto is {}" + requestDto);
        bankAccountService.saveBankAccount(requestDto);
        return ResponseEntity.ok("Bank account created successfully");
    }

    @PostMapping("/linkBankaccountWithUser")
    public ResponseEntity<?> linkBankaccount(){

        return ResponseEntity.ok("Bank account link successfully");
    }








}
