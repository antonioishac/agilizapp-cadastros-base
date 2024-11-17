package br.com.agillizapp.cadastros.api.request.people;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ContactRequest {

    private String name;

    private String email;

    private String observation;
}
