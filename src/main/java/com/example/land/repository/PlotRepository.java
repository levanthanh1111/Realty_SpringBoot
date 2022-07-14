package com.example.land.repository;


import com.example.land.entity.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {
    @Query("select  p from Plot p where p.id = :id")
    Plot getById(@Param("id") Long id);

    @Query("select p,d from Plot p join Document d on p.id = d.id")
    Plot getAllPlot();
}
