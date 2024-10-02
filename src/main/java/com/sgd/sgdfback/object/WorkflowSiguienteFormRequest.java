package com.sgd.sgdfback.object;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkflowSiguienteFormRequest {
    String flujo;
    String proceso;
    String tramiteId;
    String condicion;
    String comentario;
}
