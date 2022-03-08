package com.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.entities.PaymentInfo;

public interface PaymentInfoRepo  extends JpaRepository<PaymentInfo,Long> {

}
