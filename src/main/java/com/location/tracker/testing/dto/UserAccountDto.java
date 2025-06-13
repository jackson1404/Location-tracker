/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.location.tracker.testing.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
 * UserAccountDto Class.
 * <p>
 * </p>
 *
 * @author
 */
@Data
@RequiredArgsConstructor
public class UserAccountDto {

    private String userAccountNumber;

    private Double userAccountBalance;

    private String userAccountType;

    private String userPhoneNumber;

    private Double accountVersion;

    private LocalDateTime dob;


}
