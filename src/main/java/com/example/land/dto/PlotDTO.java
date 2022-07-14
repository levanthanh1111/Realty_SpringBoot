package com.example.land.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PlotDTO {
    private Long id;
    private Long ownerId;
    private Long documentId;
    private String location;
    private String plotDisc;
    private Double area;
    private Double price;
   /* private Boolean forSale;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private Boolean status;*/

}
