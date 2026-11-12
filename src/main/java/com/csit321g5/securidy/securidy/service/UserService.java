package com.csit321g5.securidy.securidy.service;

import com.csit321g5.securidy.securidy.entity.User;
import com.csit321g5.securidy.securidy.exception.BadRequestException;
import com.csit321g5.securidy.securidy.exception.ResourceNotFoundException;
import com.csit321g5.securidy.securidy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) { this.repository = repository; }

    public List<User> getAll() { return repository.findAll(); }

    public User getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
    }

    public User create(User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()
                || user.getPassword() == null || user.getPassword().isBlank()) {
            throw new BadRequestException("Email and password are required.");
        }
        if (repository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email is already registered.");
        }
        user.setUserId(null);
        user.setCreatedAt(null);
        return repository.save(user);
    }

    public User update(Long id, User input) {
        User existing = getById(id);
        if (input.getEmail() != null && !input.getEmail().equals(existing.getEmail())
                && repository.existsByEmail(input.getEmail())) {
            throw new BadRequestException("Email is already registered.");
        }
        existing.setFirstName(input.getFirstName());
        existing.setLastName(input.getLastName());
        existing.setEmail(input.getEmail());
        if (input.getPassword() != null && !input.getPassword().isBlank()) existing.setPassword(input.getPassword());
        existing.setRole(input.getRole());
        return repository.save(existing);
    }

    public void delete(Long id) { repository.delete(getById(id)); }
}
