package com.example.land.service;

import com.example.land.entity.Plot;
import java.util.List;

public interface PlotService {
    List<Plot> getAll();
    List<Plot> getAllPlot();
    Plot getPlot(Long id);
    Plot createPlot(Plot plot);
    Plot updatePlot(Plot plot, Long id);
    Boolean deletePlot(Long id);
}
