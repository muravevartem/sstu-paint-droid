package com.example.paintdroid.entities;

import androidx.compose.ui.graphics.Color;

public class GeneralProps {
    private final Color color;
    private final float width;

    private GeneralProps(Color color, float width) {
        this.color = color;
        this.width = width;
    }

    public static GeneralProps getInstance(Color color, float width) {
        return new GeneralProps(color, width);
    }

    public Color getColor() {
        return color;
    }

    public float getWidth() {
        return width;
    }

    public GeneralProps setColor(Color color) {
        return new GeneralProps(color, this.width);
    }

    public GeneralProps setWidth(float width) {
        return new GeneralProps(this.color, width);
    }
}
