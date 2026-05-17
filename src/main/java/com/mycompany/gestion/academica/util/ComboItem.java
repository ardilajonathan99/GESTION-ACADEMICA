package com.mycompany.gestion.academica.util;

/**
 * Elemento para JComboBox con id numérico y etiqueta visible.
 */
public class ComboItem {

    private final int id;
    private final String label;

    public ComboItem(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
