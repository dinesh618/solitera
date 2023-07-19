package com.solitera.assignment.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id;
    private String sub_category;

    private int role_id;

}
