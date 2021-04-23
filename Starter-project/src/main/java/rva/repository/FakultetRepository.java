package rva.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.jpa.Fakultet;

public interface FakultetRepository extends JpaRepository<Fakultet, Integer>{

	Collection<Fakultet> findByNazivContainingIgnoreCase(String naziv);
}
