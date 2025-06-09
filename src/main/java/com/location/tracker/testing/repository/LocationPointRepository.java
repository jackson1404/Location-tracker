/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.location.tracker.testing.repository;

import com.location.tracker.testing.entity.LocationPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * LocationPointRepository Class.
 * <p>
 * </p>
 *
 * @author
 */

@Repository
public interface LocationPointRepository extends JpaRepository<LocationPointEntity, Long>{
}
