package com.github.haseoo.courier.services.adapters;

import com.github.haseoo.courier.exceptions.serviceexceptions.userexceptions.UserNotFoundException;
import com.github.haseoo.courier.exceptions.serviceexceptions.userexceptions.UsernameIsTaken;
import com.github.haseoo.courier.models.UserModel;
import com.github.haseoo.courier.repositories.ports.UserRepository;
import com.github.haseoo.courier.servicedata.users.UserData;
import com.github.haseoo.courier.services.ports.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserData> getList() {
        return userRepository
                .getList()
                .stream()
                .map(UserData::of)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public UserData setAsInactive(Long id) {
        UserModel userModel = userRepository.getById(id).orElseThrow(() -> new UserNotFoundException(id));
        userModel.setActive(false);
        return UserData.of(userRepository.saveAndFlush(userModel));
    }

    @Transactional
    @Override
    public UserData setAsActive(Long id) {
        UserModel userModel = userRepository.getById(id).orElseThrow(() -> new UserNotFoundException(id));
        userModel.setActive(true);
        return UserData.of(userRepository.saveAndFlush(userModel));
    }

    @Override
    public void checkUsername(String username) {
        userRepository.getByUsername(username).ifPresent(userModel -> {
            throw new UsernameIsTaken(userModel.getUserName());
        });
    }
}
