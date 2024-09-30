package com.sgd.sgdfback.object.workflow;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InicioRequest {
    String flujo;
    String formulario;
}
