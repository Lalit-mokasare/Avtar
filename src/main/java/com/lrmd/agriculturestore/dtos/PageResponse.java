package com.lrmd.agriculturestore.dtos;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponse <T> {



    private  List<T> content;

    private int pageNumber;

    private int pageSize;

    private long totalElements;

    private  int totalpages;

    private boolean lastpage;











}
