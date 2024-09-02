package com.sgd.sgdfback.Controller._03_Workflow;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MostrarFormRequest {
    String flujo;
    String proceso;
}
