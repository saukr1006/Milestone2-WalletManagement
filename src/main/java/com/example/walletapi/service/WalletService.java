package com.example.walletapi.service;

import com.example.walletapi.entity.User;
import com.example.walletapi.entity.Wallet;
import com.example.walletapi.exception.UserAlreadyHasWalletException;
import com.example.walletapi.exception.UserNotFoundException;
import com.example.walletapi.repository.TransactionsRepository;
import com.example.walletapi.repository.UserRepository;
import com.example.walletapi.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WalletService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private WalletRepository walletRepo;

    @Autowired
    private TransactionsRepository transactionRepo;

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public List<User> listAll() {
        return userRepo.findAll();
    }

    public User find(String phNo) {
        return userRepo.findByPhoneNumber(phNo);
    }

    public void createWallet(String userPhNo) throws UserNotFoundException , UserAlreadyHasWalletException {

        boolean status = userRepo.existsById(userPhNo);
        if (!status) {
            throw new UserNotFoundException();
        }

        User user = userRepo.findByPhoneNumber(userPhNo);

        if(user.getWallet()!=null) {
            throw new UserAlreadyHasWalletException();
        }

        Wallet w = new Wallet();

        walletRepo.save(w);
        user.setWallet(w);
        userRepo.save(user);
    }
}
