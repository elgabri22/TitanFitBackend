package com.titanfit.TitanFit.model;

import java.util.List;

public class Favoritos {
    private List<Food>comidas;

    public List<Food> getComidas() {
        return comidas;
    }

    public void setComidas(List<Food> comidas) {
        this.comidas = comidas;
    }

    public Favoritos(List<Food> comidas) {
        this.comidas = comidas;
    }
}
