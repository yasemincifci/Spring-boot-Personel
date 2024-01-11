package com.postgrebaglanti.deneme.service;

import com.postgrebaglanti.deneme.dao.IPersonelDAO;
import com.postgrebaglanti.deneme.dao.Personel;
import com.postgrebaglanti.deneme.dto.PersonelDTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;



@Service
public class PersonelService implements IPersonelService {

    private IPersonelDAO iPersonelDAO;
    private ModelMapper modelMapper;

    public PersonelService(IPersonelDAO iPersonelDAO, ModelMapper modelMapper) {
        this.iPersonelDAO = iPersonelDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PersonelDTO> getAllPersonel() {
        return StreamSupport.stream(iPersonelDAO.findAll().spliterator(), false)
                .map(personel -> modelMapper.map(personel, PersonelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PersonelDTO savePersonel(PersonelDTO personelDTO) {
        Personel personel = modelMapper.map(personelDTO, Personel.class);
        Personel savedPersonel = iPersonelDAO.save(personel);
        return modelMapper.map(savedPersonel,PersonelDTO.class);

    }

    @Override
    public void deletePersonel(Long id) {
        if (!iPersonelDAO.existsById(id)) {
            throw new IllegalArgumentException("Note not found with id: " + id);
        }
        iPersonelDAO.deleteById(id);
    }


}
