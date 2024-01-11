package com.postgrebaglanti.deneme.service;

import com.postgrebaglanti.deneme.dto.PersonelDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPersonelService {
    List<PersonelDTO> getAllPersonel();

    //Optional<PersonelDTO> getNoteById(Long id);

    PersonelDTO savePersonel(PersonelDTO personelDTO);

    //PersonelDTO update(PersonelDTO personelDTO);

    void deletePersonel(Long id);
}
