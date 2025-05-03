package ait.imagga.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ColorDto {
    private List<ColorInfo> background_colors;
    private List<ColorInfo> foreground_colors;
    private List<ColorInfo> image_colors;

}
