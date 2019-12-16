package com.github.haseoo.courier.exceptions.serviceexceptions;

import com.github.haseoo.courier.exceptions.BusinessLogicException;

import static com.github.haseoo.courier.exceptions.ExceptionMessages.MAGAZINE_DOES_NOT_EXIST_EXCEPTION_FORMAT;

public class MagazineDoesNotExist extends BusinessLogicException {
    public MagazineDoesNotExist(Long id) {
        super(String.format(MAGAZINE_DOES_NOT_EXIST_EXCEPTION_FORMAT, id));
    }
}
