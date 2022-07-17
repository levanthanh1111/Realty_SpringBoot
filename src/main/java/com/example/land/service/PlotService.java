package com.example.land.service;

import com.example.land.entity.Plot;
import java.util.List;

public interface PlotService {
    List<Plot> getAll();
    Plot getPlot(Long id);
    Plot createPlot(Plot plot);
    Plot updatePlot(Plot plot, Long id);
    Boolean deletePlot(Long id);
    List<Plot> searchPlot(String string);
    List<Plot> sortDesc();
}
