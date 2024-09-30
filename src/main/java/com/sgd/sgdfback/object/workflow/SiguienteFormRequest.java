package com.sgd.sgdfback.object.workflow;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiguienteFormRequest {
    String flujo;
    String proceso;
    String tramiteId;
    String condicion;
    String comentario;
}
