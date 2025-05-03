package ait.imagga;

import ait.imagga.dto.TagsResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class ImaggaTagsAppl {
    public static void main(String[] args) throws URISyntaxException {
        String imgUrl = "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg";
        int overallColors = 1;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWNjXzdjOTUwMmYyZTNkODUzNToxMjlmNTI4YzAyZTlhN2Q0OWVkYjQxOWU5OWVhN2U2NA==");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://api.imagga.com/v2/colors")
                .queryParam("image_url", imgUrl )
                .queryParam("extract_overall_colors ",overallColors );
//        URI uri = new URI("https://api.imagga.com/v2/colors?image_url=https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg");
        URI uri = builder.build().toUri();
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<TagsResponseDto> response = restTemplate.exchange(request, TagsResponseDto.class);
        response.getBody().getResult().getColors().getBackground_colors().forEach(System.out::println);
        response.getBody().getResult().getColors().getForeground_colors().forEach(System.out::println);
        response.getBody().getResult().getColors().getImage_colors().forEach(System.out::println);

    }
}
