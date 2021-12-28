package BankAccount;

import java.util.List;

public class Client {

    private Integer code;
    private String name;
    private String cpf;
    private String cnpj;
    private String id;

    public List<Address> addresses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
