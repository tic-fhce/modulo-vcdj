package com.sgd.sgdfback.Controller._02_User;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    String username;
    String rol;
    String unidad;
    String cif;
}
