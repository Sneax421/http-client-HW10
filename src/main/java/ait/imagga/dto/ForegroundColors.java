package ait.imagga.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ForegroundColors {
    private String closest_palette_color;
    private String closest_palette_color_parent;
    private double percent;
}
