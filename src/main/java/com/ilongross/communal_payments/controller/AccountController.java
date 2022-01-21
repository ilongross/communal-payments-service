package com.ilongross.communal_payments.controller;


import com.ilongross.communal_payments.model.dto.AccountCreateDto;
import com.ilongross.communal_payments.model.dto.AccountDebtDto;
import com.ilongross.communal_payments.model.dto.AccountDto;
import com.ilongross.communal_payments.model.dto.MeterDto;
import com.ilongross.communal_payments.service.AccountService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/communal/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Integer id) {
        return ResponseEntity
                .ok()
                .body(accountService.getAccountById(id));
    }

    @GetMapping("/debt/{id}")
    public ResponseEntity<AccountDebtDto> getAccountDebtByAccountId(@PathVariable Integer id) {
        return ResponseEntity
                .ok()
                .body(accountService.getAccountDebtByAccountId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<AccountDto> createNewAccount(@NotNull @RequestBody AccountDto dto) {
        return ResponseEntity
                .ok()
                .body(accountService.createNewAccount(dto));
    }

    @PostMapping("/send_meter")
    public ResponseEntity<MeterDto> sendAccountMeter(@NotNull @RequestBody MeterDto dto) {
        return ResponseEntity
                .ok()
                .body(accountService.sendAccountMeter(dto));
    }


}