package com.minhaempresa.petshop.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private String email;
    private String fullName;
    private String phoneNumber;
    private String birthDate;

    private User(UserBuilder userBuilder) {
        this.email = userBuilder.email;
        this.fullName = userBuilder.fullName;
        this.phoneNumber = userBuilder.phoneNumber;
        this.birthDate = userBuilder.birthDate;
    }

    public static class UserBuilder {

        private String email;
        private String fullName;
        private String phoneNumber;
        private String birthDate;

        public UserBuilder(String email) {
            this.email = email;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UserBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder setBirthdate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }



}
