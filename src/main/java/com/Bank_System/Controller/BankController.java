package com.Bank_System.Controller;

import com.Bank_System.Model.Bank;
import com.Bank_System.Model.ClosedAccount;
import com.Bank_System.Service.BankService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Greeting", description = "Endpoints for greeting messages")
@RequestMapping("Bank")
public class BankController {

    @Autowired
    BankService bankService;
    @PostMapping("/open")
    public List<Bank> openingAccount(@RequestBody List<Bank> list){
        return bankService.openingAccount(list);
    }

    @PostMapping("/deposite")
    public String depositeAmount(@RequestParam String accountNumber, Double amount){
        return bankService.findByAccountNumberforDeposite(accountNumber,amount);
    }

    @PostMapping("/withdraw")
    public String withdrawAmount(@RequestParam String accountNumber, Double amount){
        return bankService.findByAccountNumberforWithdraw(accountNumber,amount);
    }

    @PostMapping("/transfer")
    public String transferAmount(@RequestParam String senderAccount,@RequestParam String receiverAccount,@RequestParam Double amount) throws Exception {
        return bankService.transferAmount(senderAccount,receiverAccount,amount);
    }

    @GetMapping("/checkBalance")
    public String checkalance(@RequestParam String accountNumber){
        return bankService.checkalance(accountNumber);
    }

    @DeleteMapping("/close")
    public ClosedAccount closeAccount(@RequestParam String accountNumber){
        return bankService.closeAccount(accountNumber);
    }
}
