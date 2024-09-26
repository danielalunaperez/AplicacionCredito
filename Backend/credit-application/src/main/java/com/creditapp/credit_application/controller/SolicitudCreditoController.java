package com.creditapp.credit_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditapp.credit_application.model.SolicitudCredito;
import com.creditapp.credit_application.service.SolicitudCreditoService;

@RestController
@RequestMapping("/api/credit")
public class SolicitudCreditoController {

    @Autowired
    private SolicitudCreditoService solicitudCreditoService;

    // Endpoint para enviar una solicitud de crédito
    @PostMapping("/submit")
    public ResponseEntity<SolicitudCredito> submitSolicitud(@RequestBody SolicitudCredito solicitud) {
        SolicitudCredito resultado = solicitudCreditoService.procesarSolicitud(solicitud);
        return ResponseEntity.ok(resultado);
    }

    // Endpoint para simular varias solicitudes
    @PostMapping("/simulate")
    public ResponseEntity<List<SolicitudCredito>> simulateSolicitudes(@RequestBody List<SolicitudCredito> solicitudes) {
        List<SolicitudCredito> resultados = solicitudCreditoService.simularSolicitudes(solicitudes);
        return ResponseEntity.ok(resultados);
    }
}

