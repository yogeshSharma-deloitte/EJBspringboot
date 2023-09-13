package com.hashedin.migration.services;

import com.hashedin.migration.entity.User;
import com.hashedin.migration.entity.Product;
import com.hashedin.migration.repository.UserRepository;
import com.hashedin.migration.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void getAllUsersTest() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(new User()));
        assertEquals(1, userService.getAllUsers().size());
    }

    @Test
    public void saveUserTest() {
        User user = new User();
        user.setEmail("test@gmail.com");
        when(userRepository.save(user)).thenReturn(user);
        assertNotNull(userService.saveUser(user));
    }

    @Test
    public void editUserTest() {
        User user = new User();
        user.setId(1L);
        user.setUsername("test");
        user.setPassword("password");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);
        assertNotNull(userService.editUser(1L, user));
    }

    @Test
    public void deleteUserTest() {
        doNothing().when(userRepository).deleteById(1L);
        userService.deleteUser(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    public void getProductCountTest() {
        when(productRepository.count()).thenReturn(1L);
        assertEquals(1L, userService.getProductCount());
    }
}