package com.backend.developertrialtask.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "subscriptions")
public class Subscriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Price cannot be empty")
    private double price;

    @NotEmpty(message = "Tier cannot be empty")
    private String tier; // Use valid string values: Starter/Pro/Enterprise

    @NotEmpty(message = "Status cannot be empty")
    private String status; // Use valid string values: Active/Expired

    @NotNull(message = "Start date cannot be null")
    private LocalDateTime startDate;
    
    private int branchCount;

 	@NotNull(message = "End date cannot be null")
    private LocalDateTime endDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @ManyToOne(optional = false) // Indicates a foreign key relationship
    @JoinColumn(name = "business_id", referencedColumnName = "id", nullable = false) // Foreign key column in DB
    private Business business; // Maps to Business entity

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    
    public int getBranchCount() {
		return branchCount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setBranch_count(int branchCount) {
		this.branchCount = branchCount;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
