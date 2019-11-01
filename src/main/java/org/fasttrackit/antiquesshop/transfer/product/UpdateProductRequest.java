package org.fasttrackit.antiquesshop.transfer.product;

import javax.validation.constraints.NotNull;

public class UpdateProductRequest {

    @NotNull
    private  String name;
    private int quantity;
    @NotNull
    private double price;
    private String description;
    private String imagePath;
}
