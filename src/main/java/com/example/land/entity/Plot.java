package com.example.land.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "plot")
public class Plot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String location;
    private Double area;
    private Double price;
    private String plotDisc;

   /* @OneToOne
    @JoinColumn(name = "document_id")
    private Document document;*/
    private Long documentId;
    private Long ownerId;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "for_sale",columnDefinition = "boolean default true")
    private Boolean forSale = true;
    @Column(name = "status", columnDefinition = "boolean default true")
    private Boolean status = true;
}
