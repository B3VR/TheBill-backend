package com.example.thebillbackend.receipts.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/receipts")
public class ReceiptsController {

    @GetMapping
    public ResponseEntity<String> getAllReceipts() {
        return ResponseEntity.ok("haloo");
    }
}
