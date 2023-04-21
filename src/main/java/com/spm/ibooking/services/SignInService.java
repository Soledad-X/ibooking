package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.PO.SignIn;
import com.spm.ibooking.repositories.SignInRepository;

@Service
public class SignInService {

    @Autowired
    private SignInRepository signInRepository;

    public SignIn getSignInById(Integer id) {
        return signInRepository.findById(id).orElse(null);
    }

    public List<SignIn> getAllSignIns() {
        return signInRepository.findAll();
    }

    public SignIn createSignIn(SignIn signIn) {
        return signInRepository.save(signIn);
    }

    public SignIn updateSignIn(Integer id, SignIn signIn) {
        Optional<SignIn> optionalSignIn = signInRepository.findById(id);
        if (optionalSignIn.isPresent()) {
            SignIn existingSignIn = optionalSignIn.get();
            existingSignIn.setReservation(signIn.getReservation());
            existingSignIn.setSignInTime(signIn.getSignInTime());
            existingSignIn.setSignOutTime(signIn.getSignOutTime());
            existingSignIn.setStartTime(signIn.getStartTime());
            existingSignIn.setStatus(signIn.getStatus());
            return signInRepository.save(existingSignIn);
        }
        throw new ResourceNotFoundException("SignIn not found with id " + id);
    }

    public void deleteSignIn(Integer id) {
        Optional<SignIn> optionalSignIn = signInRepository.findById(id);
        if (optionalSignIn.isPresent()) {
            signInRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("SignIn not found with id " + id);
        }
    }
}

