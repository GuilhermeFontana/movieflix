package br.com.movieflix.controller;

import br.com.movieflix.service.StreamingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/streaming")
public class StreamingController {

    private final StreamingService service;

    public StreamingController(StreamingService service) {
        this.service = service;
    }





}
