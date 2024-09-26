package com.creditapp.credit_application.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditapp.credit_application.model.SolicitudCredito;
import com.creditapp.credit_application.repository.ClienteRepository;
import com.creditapp.credit_application.repository.SolicitudCreditoRepository;

@Service
public class SolicitudCreditoService {

    @Autowired
    private SolicitudCreditoRepository solicitudCreditoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para procesar la solicitud de crédito
    public SolicitudCredito procesarSolicitud(SolicitudCredito solicitud) {
        // Simular lógica de aprobación de crédito (por ejemplo, si el monto es mayor que X, rechazar)
        if (solicitud.getMonto() > 10000) {
            solicitud.setEstadoAprobacion("RECHAZADO");
        } else {
            solicitud.setEstadoAprobacion("APROBADO");
        }

        solicitud.setFechaSolicitud(LocalDate.now());
        return solicitudCreditoRepository.save(solicitud);
    }

    // Método para simular varias solicitudes
    public List<SolicitudCredito> simularSolicitudes(List<SolicitudCredito> solicitudes) {
        return solicitudes.stream()
                .map(this::procesarSolicitud)
                .collect(Collectors.toList());
    }

	public ClienteRepository getClienteRepository() {
		return clienteRepository;
	}

	public void setClienteRepository(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
}

