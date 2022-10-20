package com.cybertronicaoeltda.services.dto;

import javax.validation.constraints.NotBlank;

public class FirmaDto {

    @NotBlank
    private String firma;

    public FirmaDto(String firma) {
        this.firma = firma;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }
}
