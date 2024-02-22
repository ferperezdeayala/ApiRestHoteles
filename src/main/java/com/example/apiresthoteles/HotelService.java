package com.example.apiresthoteles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHoteles() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    public List<Hotel> getHotelesByNombre(String nombre) {
        return hotelRepository.findByNombre(nombre);
    }

    public void addHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public void updateHotel(Long id, Hotel hotel) {
        if (hotelRepository.existsById(id)) {
            hotel.setId(id);
            hotelRepository.save(hotel);
        } else {
            // Lógica para manejar la creación de un nuevo hotel si no existe
            hotelRepository.save(hotel);
        }
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}

