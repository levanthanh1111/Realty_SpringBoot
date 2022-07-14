package com.example.land.controller;


import com.example.land.dto.PlotDTO;
import com.example.land.entity.Plot;
import com.example.land.service.PlotService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/plot")
public class PlotController {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PlotService plotService;

    @GetMapping("")
    public List<PlotDTO> getAll(){
        return plotService.getAllPlot().stream().map(plot ->modelMapper.map(plot, PlotDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlotDTO> getPlot(@PathVariable("id") Long id){
        Plot plot = plotService.getPlot(id);
        PlotDTO plotDTO = modelMapper.map(plot,PlotDTO.class);
        return ResponseEntity.ok().body(plotDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<PlotDTO> createPlot(@RequestBody PlotDTO plotDTO){
        Plot plotRequest = modelMapper.map(plotDTO, Plot.class);
        Plot plot = plotService.createPlot(plotRequest);
        PlotDTO plotResponse = modelMapper.map(plot, PlotDTO.class);
        return new ResponseEntity<PlotDTO>(plotResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PlotDTO> updatePlot(@RequestBody PlotDTO plotDTO, @PathVariable("id") Long id){
        Plot plotRequest = modelMapper.map(plotDTO, Plot.class);
        Plot plot = plotService.updatePlot(plotRequest, id);
        PlotDTO plotResponse = modelMapper.map(plot, PlotDTO.class);
        return ResponseEntity.ok().body(plotResponse);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deletePlot(@PathVariable("id") Long id){
        return plotService.deletePlot(id);
    }
}
