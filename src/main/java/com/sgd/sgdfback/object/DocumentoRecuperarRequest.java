package com.sgd.sgdfback.object;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoRecuperarRequest {
    String nombre;
    String nrotramite;
    String tabla;
    String flujo;
}
