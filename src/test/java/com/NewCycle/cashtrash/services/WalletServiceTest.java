package com.NewCycle.cashtrash.services;

import com.NewCycle.cashtrash.dtos.response.ResponseGetWallet;
import com.NewCycle.cashtrash.dtos.response.ResponseGetWalletBalance;
import com.NewCycle.cashtrash.model.User;
import com.NewCycle.cashtrash.model.Wallet;
import com.NewCycle.cashtrash.model.WalletNotFoundException;
import com.NewCycle.cashtrash.model.enums.TipoUser;
import com.NewCycle.cashtrash.repositories.UserRepository;
import com.NewCycle.cashtrash.repositories.WalletRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class WalletServiceTest {

    @Mock
    private WalletRepository walletRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private WalletService walletService;

    private User user;
    Wallet wallet;

    @BeforeEach
    void setUp(){
        user = new User();
        user.setId(1L);
        user.setName("Lucas Inacio");
        user.setEmail("lucas@hotmail.com");
        user.setPassword("123456");
        user.setType(TipoUser.CUSTOMER);
        user.setCfp("123456789");

        wallet = new Wallet(1L, user,BigDecimal.ZERO);

    }

    @Test
    void deveVerificarSeExisteUmaCarteiraECriar(){
        Long userId = 1L;

        BDDMockito.when(walletRepository.findByUserId(userId)).thenReturn(Optional.empty());

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        Wallet wallet = walletService.createWallet(userId);

        assertNotNull(wallet);
        assertEquals(user, wallet.getUser());
        assertEquals(BigDecimal.ZERO, wallet.getAmount());

        verify(walletRepository).findByUserId(userId);
        verify(userRepository).findById(userId);
        verify(walletRepository).save(wallet);
    }

    @Test
    void deveRetornaACarteiraDoUsuarioPeloId(){


        when(walletRepository.findById(1L)).thenReturn(Optional.of(wallet));


        ResponseGetWallet obj = walletService.findById(1L);

        assertNotNull(obj);
        assertEquals(wallet.getId().toString(),obj.idWallet());
        assertEquals(BigDecimal.ZERO.toString(), obj.amount());

        verify(walletRepository).findById(1L);
        verifyNoMoreInteractions(walletRepository);
    }

    @Test
    void deveRetornarWalletNotFoundException(){

        when(walletRepository.findById(1L)).thenReturn(Optional.empty());
        WalletNotFoundException exception = assertThrows(WalletNotFoundException.class,
                () -> walletService.findById(1L));

        verify(walletRepository).findById(1L);
        verifyNoMoreInteractions(walletRepository);
    }

    @Test
    void deveRetornarOBalancedeWallet(){

        when(walletRepository.findById(1L)).thenReturn(Optional.of(wallet));

        ResponseGetWalletBalance rpgwb = walletService.getWalletBalance(1L);

        assertNotNull(rpgwb);
        assertEquals(rpgwb.walletId(), wallet.getId().toString());
        assertEquals(rpgwb.amount(),wallet.getAmount().toString());

        verify(walletRepository).findById(1L);
        verifyNoMoreInteractions(walletRepository);
    }

    @Test
    void deveRetornarUmaWalletNotFoundException(){
        when(walletRepository.findById(1L)).thenReturn(Optional.empty());

        WalletNotFoundException exception = assertThrows(WalletNotFoundException.class,
                () -> walletService.getWalletBalance(1L));

        verify(walletRepository).findById(1L);
        verifyNoMoreInteractions(walletRepository);
    }
}