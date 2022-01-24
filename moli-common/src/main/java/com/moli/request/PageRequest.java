package com.moli.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class PageRequest  implements Serializable {

    private static final long serialVersionUID = 6661324818675718891L;

    private int pageSize;

    private int pageNumber;

}
