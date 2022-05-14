package com.example.paintdroid.entities;



import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;

public class Figure {
    private FigureType figureType;
    private Color color;
    private int lineWeight;
    private Offset start;
    private Offset end;

    private Figure(FigureType figureType, Color color, int lineWeight, Offset start, Offset end) {
        this.figureType = figureType;
        this.color = color;
        this.lineWeight = lineWeight;
        this.start = start;
        this.end = end;
    }

    public static Figure getInstance(FigureType figureType, Color color, int lineWeight, Offset start, Offset end) {
        return new Figure(figureType, color, lineWeight, start, end);
    }

    public Color getColor() {
        return color;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public void setFigureType(FigureType figureType) {
        this.figureType = figureType;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getLineWeight() {
        return lineWeight;
    }

    public void setLineWeight(int lineWeight) {
        this.lineWeight = lineWeight;
    }

    public Offset getStart() {
        return start;
    }

    public void setStart(Offset start) {
        this.start = start;
    }

    public Offset getEnd() {
        return end;
    }

    public void setEnd(Offset end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "figureType=" + figureType.name() +
                ", color=" + color +
                ", lineWeight=" + lineWeight +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
