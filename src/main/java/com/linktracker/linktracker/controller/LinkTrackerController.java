package com.linktracker.linktracker.controller;

import com.linktracker.linktracker.dto.PasswordDTO;
import com.linktracker.linktracker.dto.SimpleLinkDTO;
import com.linktracker.linktracker.exception.LinkIdNotFoundException;
import com.linktracker.linktracker.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/")
public class LinkTrackerController {

    public LinkTrackerController(LinkService linkService) {
        this.linkService = linkService;
    }

    LinkService linkService;

    @PostMapping
    public ResponseEntity<Integer> createLink(@RequestBody SimpleLinkDTO simpleLinkDto) {
        return ResponseEntity.status(201).body(linkService.createLink(simpleLinkDto));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(LinkIdNotFoundException.class)
    public ResponseEntity<String> handleExceptions(LinkIdNotFoundException linkIdNotFoundException){
        return ResponseEntity.status(linkIdNotFoundException.getStatus()).body(linkIdNotFoundException.getMessage());
    }

    @PostMapping("/link/{linkId}")
    public ResponseEntity<Void> redirect(@PathVariable Integer linkId, @RequestBody PasswordDTO passwordDto) {
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(linkService.redirect(linkId, passwordDto))).build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Long> getMetrics(@PathVariable Integer linkId) {
        return ResponseEntity.status(200).body(linkService.getMetrics(linkId));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<Void> invalidateLink(@PathVariable Integer linkId) {
        linkService.invalidateLink(linkId);
        return ResponseEntity.status(204).build();
    }

}
