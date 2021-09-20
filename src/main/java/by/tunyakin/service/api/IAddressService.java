package by.tunyakin.service.api;

import by.tunyakin.model.Address;
import by.tunyakin.model.User;
import by.tunyakin.service.dto.AddressDto;

public interface IAddressService {

    Address createAddress(User user, AddressDto addressDto);
    Address updateAddress(User user, AddressDto addressDto);
    void deleteAddress(User user);
}
