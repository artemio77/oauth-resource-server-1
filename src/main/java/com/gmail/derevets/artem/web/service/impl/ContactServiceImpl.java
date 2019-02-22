package com.gmail.derevets.artem.web.service.impl;

import com.gmail.derevets.artem.web.dto.cassandra.Contact;
import com.gmail.derevets.artem.web.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService {
    @Override
    public void save(Contact contact) {

    }

    @Override
    public Contact get(Contact contact) {
        return null;
    }
}
