package com.sgd.sgdfback.object.document;

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
