package com.example.land.service.Impl;

import com.example.land.entity.Plot;
import com.example.land.repository.PlotRepository;
import com.example.land.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlotServiceImpl implements PlotService {
    @Autowired
    PlotRepository plotRepository;

    @Override
    public List<Plot> getAll() {
        return plotRepository.findAll();
    }

    @Override
    public List<Plot> getAllPlot() {
        return (List<Plot>) plotRepository.getAllPlot();
    }

    @Override
    public Plot getPlot(Long id) {
        return plotRepository.getById(id);
    }

    @Override
    public Plot createPlot(Plot plot) {
        return plotRepository.save(plot);
    }

    @Override
    public Plot updatePlot(Plot plot, Long id) {
        Plot p = plotRepository.getById(id);

        p.setArea(plot.getArea());
        p.setDocumentId(plot.getDocumentId());
        p.setPlotDisc(plot.getPlotDisc());
        p.setLocation(plot.getLocation());
        p.setPrice(plot.getPrice());
        p.setOwnerId(plot.getOwnerId());

        return plotRepository.save(p);
    }

    @Override
    public Boolean deletePlot(Long id) {
        plotRepository.deleteById(id);
        return true;
    }
}
