package com.solitera.assignment.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class AddSubCategory {
    private List<String> subCategory = new ArrayList<>();

}
