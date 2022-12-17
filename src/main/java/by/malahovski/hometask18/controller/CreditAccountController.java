package by.malahovski.hometask18.controller;


import by.malahovski.hometask18.model.CreditAccount;
import by.malahovski.hometask18.service.CreditAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@ResponseBody
@RequestMapping("/accounts")
public class CreditAccountController {

    private final CreditAccountService creditAccountService;

    @Autowired
    public CreditAccountController(CreditAccountService creditAccountService) {
        this.creditAccountService = creditAccountService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CreditAccount> getCreditAccount(@PathVariable Long id) {
        CreditAccount creditAccount = creditAccountService.getCreditAccountById(id);
        if (isNull(creditAccount)) {
            throw new ArithmeticException("Аккаунт с ID = " + id + " не найден.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(creditAccount);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteCarById(@PathVariable Long id) {
        Boolean isDeleted = creditAccountService.deleteCreditAccount(id);
        if (isDeleted) {
            return ResponseEntity.ok(isDeleted);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(isDeleted);
    }

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> getCarByCost(@RequestBody CreditAccount creditAccount) {

        return ResponseEntity.ok(creditAccountService.addCreditAccount(creditAccount));
    }
}
