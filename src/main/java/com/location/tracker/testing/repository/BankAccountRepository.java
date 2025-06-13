/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.location.tracker.testing.repository;

import com.location.tracker.testing.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BankAccountRepository Class.
 * <p>
 * </p>
 *
 * @author
 */

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity, Long> {
}
