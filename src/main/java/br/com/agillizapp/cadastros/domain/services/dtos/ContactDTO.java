package br.com.agillizapp.cadastros.domain.services.dtos;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactDTO {

    private Long id;

    private String name;

    private String email;

    private String observation;
}
