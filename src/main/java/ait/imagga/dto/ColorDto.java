package ait.imagga.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ColorDto {
    private List<BackGroundColors> background_colors;
    private List<ForegroundColors> foreground_colors;
    private List<ImageColors> image_colors;

}
