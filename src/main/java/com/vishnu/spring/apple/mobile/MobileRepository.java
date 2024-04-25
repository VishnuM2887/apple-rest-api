package com.vishnu.spring.apple.mobile;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {

    @Query("SELECT m FROM Mobile m WHERE m.sku = ?1")
    Optional<Mobile> findMobileBySKU(String sku);
}