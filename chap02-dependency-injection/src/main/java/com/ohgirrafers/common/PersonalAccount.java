package com.ohgirrafers.common;



public class PersonalAccount implements Account {

    private final int banckCode; // 은행코드

    private final String accNo; // 계좌번호

    private int balance; //잔액

    public PersonalAccount(int banckCode, String accNo) {
        this.banckCode = banckCode;
        this.accNo = accNo;
    }

    public int getBanckCode() {
        return banckCode;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    @Override
    public String getBalance() {
        return this.accNo + "계좌의 현재 잔액은 "+this.balance +"원 입니다";
    }

    @Override
    public String deposit(int money) {
        String str = "";
        if (money >0){
            this.balance += money;
            str = money +" 원이 입금 되었습니다";
        }else {
            str = "금액이 잘못 입금 되었습니다";
        }
        return str;
    }

    @Override
    public String withdraw(int money) {
        String str = "";
        if (this.balance >= money){
            this.balance -= money;
            str = money +"원이 출금 되었습니다";
        }else {
            str = "현재 잔액은 " +this.balance  +"원 입니다" +money + "원 보다 적습니다";

        }

        return str;
    }

    @Override
    public String toString() {
        return "PersonalAccount{" +
                "banckCode=" + banckCode +
                ", accNo='" + accNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}
