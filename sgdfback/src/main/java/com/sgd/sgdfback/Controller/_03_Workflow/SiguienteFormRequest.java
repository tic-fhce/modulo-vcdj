package com.sgd.sgdfback.Controller._03_Workflow;

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
