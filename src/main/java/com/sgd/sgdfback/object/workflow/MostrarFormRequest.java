package com.sgd.sgdfback.object.workflow;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MostrarFormRequest {
    String flujo;
    String proceso;
}
