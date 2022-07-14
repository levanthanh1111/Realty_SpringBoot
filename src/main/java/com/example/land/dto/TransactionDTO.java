package com.example.land.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    private Long id;
    private Long plotId;
    private Long ownerId;
    private Long buyerId;
    private Double commissionMoney;
  /*  private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean status;
*/
}
