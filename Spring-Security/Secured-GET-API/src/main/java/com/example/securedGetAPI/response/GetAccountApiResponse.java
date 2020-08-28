package com.example.securedGetAPI.response;

import com.example.securedGetAPI.model.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAccountApiResponse {
    private String errorCode;
    private Account account;

    public GetAccountApiResponse(Account acc) {
        account = acc;
    }
}
