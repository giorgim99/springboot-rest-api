package ge.mais.api.repositories;

import ge.mais.api.entities.Customer;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("From Customer where active = :active and concat(firstName, concat(' ', lastName)) like :searchString")
    Page<Customer> search(@Param("active") Integer active, @Param("searchString") String searchValue, Pageable pageable);
    @Query(value = "select * from customer where active = :active and " + "concat(first_name, concat(' ', last_name)) like :searchValue",
            countQuery = "select count(*) from customer where active = :active and " + "concat(first_name, concat(' ', last_name)) like :searchValue",
            nativeQuery = true)
    Page<Customer> searchWithNative(@Param("active") Integer active, @Param("searchValue") String searchValue, Pageable pageable);

}

