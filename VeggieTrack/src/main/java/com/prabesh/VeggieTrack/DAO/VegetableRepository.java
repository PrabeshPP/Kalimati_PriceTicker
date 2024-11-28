package com.prabesh.VeggieTrack.DAO;

import com.prabesh.VeggieTrack.model.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, UUID> {
}
