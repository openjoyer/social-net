package org.tylerpants.postservice.util;

public interface DtoMapper<D, M> {
    D toDto(M model);

    M toModel(D dto);
}
