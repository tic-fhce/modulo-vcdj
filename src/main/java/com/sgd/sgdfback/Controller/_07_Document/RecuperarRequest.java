package com.sgd.sgdfback.Controller._07_Document;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecuperarRequest {
    String nombre;
    String nrotramite;
    String tabla;
    String flujo;
}
