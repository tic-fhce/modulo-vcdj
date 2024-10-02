package com.sgd.sgdfback.object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoLibreActColRequest {
    String colum;
    String param;
    String nrotramite;
}
