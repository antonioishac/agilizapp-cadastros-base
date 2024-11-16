package br.com.agillizapp.cadastros.domain.services.dtos;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PageDTO<T> implements Serializable  {

    private int number;

    private int size;

    private int numberOfElements;

    private transient List<T> content;

    private boolean first;

    private boolean last;

    private int totalPages;

    private long totalElements;

    public PageDTO(List<T> content) {
        this.content = content;
    }
}