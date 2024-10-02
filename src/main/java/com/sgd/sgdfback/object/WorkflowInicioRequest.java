package com.sgd.sgdfback.object;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkflowInicioRequest {
    String flujo;
    String formulario;
}
