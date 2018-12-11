package com.ropalinda.ropalindamovil.Entities;

/**
 * Created by arnoldo on 2/07/18.
 */

public class Login {

    public static class Request {
        private String mail;
        private String pass;

        public Request() {
        }

        public Request(String mail, String pass) {
            this.mail = mail;
            this.pass = pass;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }
    }

    public static class Response {
        private Customer customer;
        private String token;

        public Response() {
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

}
