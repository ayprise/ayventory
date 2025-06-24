package com.ayprise.inventory.repository;

import com.ayprise.inventory.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {

    Optional<PurchaseEntity> findById(long id);
}
