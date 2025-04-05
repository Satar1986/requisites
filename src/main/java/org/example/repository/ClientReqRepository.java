package org.example.repository;

import org.example.model.ClientReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientReqRepository extends JpaRepository<ClientReq, Integer> {
}
