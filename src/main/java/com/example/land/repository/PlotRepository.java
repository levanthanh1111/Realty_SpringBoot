package com.example.land.repository;


import com.example.land.entity.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {
    @Query("select  p from Plot p where p.id = :id")
    Plot getById(@Param("id") Long id);

    @Query("SELECT p FROM Plot p WHERE " +
            "p.location LIKE CONCAT('%', :query,'%')" +
            "Or p.plotDisc LIKE CONCAT('%', :query, '%')")
    List<Plot> searchPlot(String query);

    @Query("SELECT p from Plot p order by p.price desc ")
    List<Plot> sortPricePlot();

}
