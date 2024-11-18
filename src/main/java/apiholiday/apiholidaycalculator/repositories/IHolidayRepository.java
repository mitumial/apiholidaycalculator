package apiholiday.apiholidaycalculator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiholiday.apiholidaycalculator.entities.Holiday;

@Repository
public interface IHolidayRepository extends JpaRepository<Holiday, Integer>{
//     @Query("SELECT s FROM Seleccion s WHERE s.nombre LIKE '%' || ?1 || '%'")
//     public List<Seleccion> buscar(String nombre);
}
